import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(System.getenv("PATH"));
        System.out.println(System.getenv("HOME"));

        //Creación del driver
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);

        //Variables
        List<String> listOfLinks = new ArrayList<>();
        List<String> goodLinks;
        Personajes personajes = new Personajes();
        Objetos objetos = new Objetos();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Acceso a la página principal
        driver.get("https://bindingofisaac.fandom.com/es/wiki/The_Binding_of_Isaac_Wiki");

        //Aceptar Cookies
        driver.findElement(By.className("NN0_TB_DIsNmMHgJWgT7U")).click();

        //Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        //Recogida i filtrado de los links a utilizar
        driver.findElements(By.className("wds-dropdown")).stream()
                .distinct()
                .forEach(listElement -> listOfLinks.add(listElement.findElement(By.tagName("a")).getAttribute("href")));
        goodLinks = listOfLinks.stream()
                .filter(s -> s.contains("es/wiki/") && !s.contains("The_Binding"))
                .distinct()
                .toList();
        //goodLinks.forEach(System.out::println);
        //driver.quit();

        //Insertar i mostrar personajes
        //personajes.getPersonajes(driver, wait, goodLinks);
        //personajes.lista.forEach(System.out::println);

        //Insertar i mostrar objetos
        //objetos.getObjetos(driver, wait, goodLinks);
        //objetos.lista.forEach(System.out::println);

        //Insertar i mostrar Enemigos (Monstruos i Jefes)
        //Enemigo.getMonstruos(driver, wait, goodLinks);
        Enemigo.getJefes(driver, wait, goodLinks);

        //Enemigo.monstruos.forEach(System.out::println);
        Enemigo.jefes.forEach(System.out::println);

      //Cerrar el navegador
      driver.quit();
    }
}