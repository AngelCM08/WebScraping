import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Clase que agrupa todos los objetos de la clase Objeto en una lista, contiene la función necesaria para
 * poder recoger dentro de la página específica de la web, todos los objetos que existen en ella.
 *
 * @author Ángel Castro Merino
 */
@XmlRootElement(name="Objetos")
public class Objetos {
    List<Objeto> lista = new ArrayList<>();

    /**
     * Función que navega a la URL de la web donde se encuentran los objetos, navega a través de ella
     * para cargar todas las imagenes de éstos y finalmente los recoge y almacena en la Lista de la clase.
     *
     * @param driver    Navegador de la web.
     * @param wait      Objeto que permite detener temporalmente al navegador para cargar la página.
     * @param goodLinks Lista de los links útiles filtrados.
     */
    public void getObjetos(WebDriver driver, WebDriverWait wait, List<String> goodLinks){
        List<WebElement> aux = new ArrayList<>();
        AtomicInteger id = new AtomicInteger(1); //Necesita ser un AtomicInteger para poder funcionar dentro de las lambdas, el int normal hace cosas raras.

        goodLinks.forEach(l -> {
            if (l.contains("Objetos")) {
                driver.navigate().to(l);
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("wikitable"))));
                for(int i=0, j=0; i<77500; j=i, i+=20){
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo("+j+", "+i+")");
                }
                List<WebElement> tablas = driver.findElements(By.className("wikitable"));
                tablas.forEach(tabla -> {
                    tabla.findElements(By.tagName("tbody")).forEach(section ->
                        section.findElements(By.tagName("tr")).forEach(fila -> {
                            aux.addAll(fila.findElements(By.tagName("td")));
                            if (aux.size() != 0) {
                                lista.add(new Objeto(id.getAndIncrement(),aux));
                            }
                            aux.clear();
                        })
                    );
                });
            }
        });
    }

    /**
     * Devuelve el objeto tipo List<Objeto> de la clase.
     *
     * @return El objeto tipo List<Objeto> de la clase.
     */
    public List<Objeto> getLista() {
        return lista;
    }

    /**
     * Asigna un valor al objeto tipo List<Objeto> de la clase.
     */
    @XmlElement(name="Objeto")
    public void setLista(List<Objeto> lista) {
        this.lista = lista;
    }
}