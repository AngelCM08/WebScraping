import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal, define los objetos de las clases principales donde se almacenarán los datos.
 *
 * @author Ángel Castro Merino
 */
public class Main {
    static Personajes personajes = new Personajes();
    static Objetos objetos = new Objetos();
    static Enemigos enemigos = new Enemigos();

    /**
     * Función principal del programa, define el objeto que navegará a través de la web para recoger los datos y
     * llama al resto de funciones de la clase para recoger e insertarlos.
     */
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

    /**
     * Función que obtiene todos los links del menú principal de la web y los filtra para obtener los útiles.
     *
     * @param driver Navegador de la web.
     * @return       Lista de los links útiles filtrados.
     */
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

    /**
     * Función que llama a las funciones específicas que obtienen los datos
     * de las clases principales y los almacena en éstos.
     *
     * @param driver    Navegador de la web.
     * @param wait      Objeto que permite detener temporalmente al navegador para cargar la página.
     * @param goodLinks Lista de los links útiles filtrados.
     */
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

    /**
     * Función que llama a las funciones que formatean toda la información almacenada en
     * las clases y las escribe en formato CSV en los archivos de las rutas indicadas.
     *
     * @param entidadesFormateadas Objeto de la clase FormatObjectsToList, la cual permite formatear los objetos
     *                             de las clases principales a uno necesario para obtener el CSV correctamente.
     */
    private static void getCSV(FormatObjectsToList entidadesFormateadas) {
        entidadesFormateadas.FormatPersonajeToList(personajes.lista);
        entidadesFormateadas.FormatObjectToList(objetos.lista);
        entidadesFormateadas.FormatMonstruoToList(enemigos.monstruos);

        WriteToCSV.writeAllLines(entidadesFormateadas.formated_personajes_list, "src/main/java/Output/Personajes.csv");
        WriteToCSV.writeAllLines(entidadesFormateadas.formated_objetos_list, "src/main/java/Output/Objetos.csv");
        WriteToCSV.writeAllLines(entidadesFormateadas.formated_monstruos_list, "src/main/java/Output/Montruos.csv");
    }

    /**
     * Función que escribe las clases principales a formato XML en los archivos de las rutas indicadas.
     */
    private static void getXML() {
        GenerateXML.generatePersonajesXML(personajes, "src/main/java/Output/Personajes.xml");
        GenerateXML.generateObjetosXML(objetos, "src/main/java/Output/Objetos.xml");
        GenerateXML.generateMonstruosXML(enemigos, "src/main/java/Output/Montruos.xml");
    }
}