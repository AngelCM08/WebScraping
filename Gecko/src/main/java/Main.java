import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Personajes personajes = new Personajes();
    static Objetos objetos = new Objetos();
    static Enemigos enemigos = new Enemigos();

    public static void main(String[] args) {
        //Creación del driver y waiter
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Variable de links a las páginas útiles
        List<String> goodLinks;

        //Acceso a la página principal
        driver.get("https://bindingofisaac.fandom.com/es/wiki/The_Binding_of_Isaac_Wiki");
        //Aceptar Cookies
        driver.findElement(By.className("NN0_TB_DIsNmMHgJWgT7U")).click();
        //Wait para cargar la página
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        //Recogida i filtrado de los links a utilizar
        goodLinks = getLinks(driver);

        //Insertar elementos en sus clases (personajes, objetos, enemigos(monstruos))
        insertElements(driver, wait, goodLinks);

        //Generación de CSV
        getCSV(new FormatObjectsToList());

        //Generación de XML
        getXML();

        //Cerrar el navegador
        driver.quit();
    }

    private static List<String> getLinks(WebDriver driver) {
        List<String> listOfLinks = new ArrayList<>();

        driver.findElements(By.className("wds-dropdown")).stream()
                .distinct()
                .forEach(listElement -> listOfLinks.add(listElement.findElement(By.tagName("a")).getAttribute("href")));
        return listOfLinks.stream()
                .filter(s -> s.contains("es/wiki/") && !s.contains("The_Binding"))
                .distinct()
                .toList();
    }

    private static void insertElements(WebDriver driver, WebDriverWait wait, List<String> goodLinks) {
        //Insertar i mostrar personajes
        personajes.getPersonajes(driver, wait, goodLinks);
        //personajes.lista.forEach(System.out::println);

        //Insertar i mostrar objetos
        objetos.getObjetos(driver, wait, goodLinks);
        //objetos.lista.forEach(System.out::println);

        //Insertar i mostrar Enemigos (Monstruos i Jefes)
        enemigos.getMonstruos(driver, wait, goodLinks);
        //enemigos.getJefes(driver, wait, goodLinks);

        //enemigos.monstruos.forEach(System.out::println);
        //enemigos.jefes.forEach(System.out::println);
    }

    private static void getCSV(FormatObjectsToList entidadesFormateadas) {
        entidadesFormateadas.FormatPersonajeToList(personajes.lista);
        entidadesFormateadas.FormatObjectToList(objetos.lista);
        entidadesFormateadas.FormatMonstruoToList(enemigos.monstruos);

        WriteToCSV.writeAllLines(entidadesFormateadas.formated_personajes_list, "src/main/java/Output/Personajes.csv");
        WriteToCSV.writeAllLines(entidadesFormateadas.formated_objetos_list, "src/main/java/Output/Objetos.csv");
        WriteToCSV.writeAllLines(entidadesFormateadas.formated_monstruos_list, "src/main/java/Output/Montruos.csv");
    }

    private static void getXML() {
        GenerateXML.generatePersonajesXML(personajes, "src/main/java/Output/Personajes.xml");
        GenerateXML.generateObjetosXML(objetos, "src/main/java/Output/Objetos.xml");
        GenerateXML.generateMonstruosXML(enemigos, "src/main/java/Output/Montruos.xml");
    }
}