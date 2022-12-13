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
 * Clase que almacena la entidad del UML Enemigo.
 * Agrupa todos los objetos de la clase Monstruo en una
 * lista(debería recoger también de la clase Jeje y Campeon),
 * contiene la función necesaria para poder recoger dentro de
 * la página específica de la web, todos los monstruos que
 * existen en ella. (ídem para Jefes y Campeones)
 *
 * @author Ángel Castro Merino
 */
@XmlRootElement(name="Enemigos")
public class Enemigos {
    int id;
    String icono;
    String nombre;
    int vida;
    String descripcion;

    List<Monstruo> monstruos = new ArrayList<>();
    //List<Jefe> jefes = new ArrayList<>();
    //List<Campeon> campeones = new ArrayList<>();

    /**
     * Constructor simple de la Clase.
     */
    public Enemigos(){}

    /**
     * Constructor utilizado por la clase Personajes para crear
     * todos los objetos Personaje encontrados en la página web.
     * Cabe destacar que se filtran algunos de los atributos utilizando
     * una lista auxiliar para obtener información más limpia.
     *
     * @param id            Identificador del objeto.
     * @param icono         Atributo que indica la dirección de la imagen recogida en la web.
     * @param nombre        Atributo que indica el nombre recogido en la web.
     * @param vida          Atributo que indica la vida recogida en la web.
     * @param descripcion   Atributo que indica la descripción recogida en la web.
     */
    public Enemigos(int id, String icono, String nombre, int vida, String descripcion) {
        this.id = id;
        this.icono = icono;
        this.nombre = nombre;
        this.vida = vida;
        this.descripcion = descripcion;
    }

    /**
     * Función que navega a la URL de la web donde se encuentran los personajes, navega a través de ella
     * para cargar todas las imagenes de éstos y finalmente los recoge y almacena en la Lista de la clase.
     *
     * @param driver    Navegador de la web.
     * @param wait      Objeto que permite detener temporalmente al navegador para cargar la página.
     * @param goodLinks Lista de los links útiles filtrados.
     */
    public void getMonstruos(WebDriver driver, WebDriverWait wait, List<String> goodLinks){
        List<WebElement> aux = new ArrayList<>();
        AtomicInteger id = new AtomicInteger(1);

        goodLinks.forEach(l -> {
            if (l.contains("Enemigos")) {
                driver.navigate().to("https://bindingofisaac.fandom.com/es/wiki/Monstruos/Rebirth");
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("wikitable"))));
                for(int i=0, j=0; i<30000; j=i, i+=30){
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo("+j+", "+i+")");
                }
                List<WebElement> tablas = driver.findElements(By.className("wikitable"));
                tablas.forEach(tabla -> {
                    tabla.findElements(By.tagName("tr")).remove(0);
                    tabla.findElements(By.tagName("tr")).forEach(fila -> {
                        aux.addAll(fila.findElements(By.tagName("td")));
                        if(aux.size() != 0) {
                            monstruos.add(new Monstruo(id.getAndIncrement(), aux));
                        }
                        aux.clear();
                    });
                });
            }
        });
    }

    /**
     * Devuelve el objeto tipo List<Monstruo> de la clase.
     *
     * @return El objeto tipo List<Monstruo> de la clase.
     */
    public List<Monstruo> getMonstruos() {
        return monstruos;
    }

    /**
     * Asigna un valor al objeto tipo List<Monstruo> de la clase.
     */
    @XmlElement(name="Monstruo")
    public void setMonstruos(List<Monstruo> monstruos) {
        this.monstruos = monstruos;
    }

    /**
     * Devuelve el atributo id de la clase.
     *
     * @return Atributo id de la clase.
     */
    @XmlElement(name="Id")
    public int getId() {
        return id;
    }

    /**
     * Devuelve el atributo icono de la clase.
     *
     * @return Atributo icono de la clase.
     */
    @XmlElement(name="Icono")
    public String getIcono() {
        return icono;
    }

    /**
     * Devuelve el atributo nombre de la clase.
     *
     * @return Atributo nombre de la clase.
     */
    @XmlElement(name="Nombre")
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el atributo vida de la clase.
     *
     * @return Atributo vida de la clase.
     */
    @XmlElement(name="Vida")
    public int getVida() {
        return vida;
    }

    /**
     * Devuelve el atributo descripcion de la clase.
     *
     * @return Atributo descripcion de la clase.
     */
    @XmlElement(name="Descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    /*public void getJefes(WebDriver driver, WebDriverWait wait, List<String> goodLinks){
        List<String> linksJefes = new ArrayList<>();
        List<WebElement> aux = new ArrayList<>();
        AtomicInteger id = new AtomicInteger(1);

        goodLinks.forEach(l -> {
            if (l.contains("Jefes")) {
                driver.navigate().to(l);
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("mw-parser-output"))));
                for(int i=0, j=0; i<25000; j=i, i+=60){
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo("+j+", "+i+")");
                }
                List<WebElement> tablas = driver.findElements(By.className("mw-parser-output"));
                tablas.remove(tablas.size()-4);
                tablas.remove(tablas.size()-5);
                tablas.remove(tablas.size()-6);
                tablas.remove(tablas.size()-7);

                tablas.forEach(tabla -> {
                    List<WebElement> filas = tabla.findElements(By.tagName("tr"));
                    for(int i=1; i<filas.size(); i+=2){
                        linksJefes.add(filas.get(i).findElement(By.tagName("a")).getAttribute("href"));
                    }
                    linksJefes.forEach(link -> {
                        driver.navigate().to(link);
                        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("lazyloaded"))));
                        aux.add(driver.findElement(By.className("lazyloaded"))); //icono
                        aux.add(driver.findElement(By.tagName("p"))); //nombre
                        aux.add(AskLife(driver.findElement(By.className("mw-parser-output")))); //vida

                        jefes.add(new Jefe(id.getAndIncrement(), aux));
                        aux.clear();
                    });
                });
            }
        });
    }

    private static WebElement AskLife(WebElement element) {
        try {
            return element.findElement(By.cssSelector("div[data-source='vida']")).findElement(By.tagName("div"));
        }catch (org.openqa.selenium.NoSuchElementException e){
            return null;
        }
    }*/

    /*public void getCampeones(WebDriver driver, WebDriverWait wait, List<String> goodLinks){
        List<WebElement> aux = new ArrayList<>();
        AtomicInteger id = new AtomicInteger(1);

        driver.navigate().to("https://bindingofisaac.fandom.com/es/wiki/Campeones");
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("wikitable"))));
        for(int i=0, j=0; i<30000; j=i, i+=30){
            ((JavascriptExecutor) driver).executeScript("window.scrollTo("+j+", "+i+")");
        }
        List<WebElement> tablas = driver.findElements(By.className("wikitable"));
        tablas.forEach(tabla -> {
            tabla.findElements(By.tagName("tr")).remove(0);
            tabla.findElements(By.tagName("tr")).forEach(fila -> {
                aux.addAll(fila.findElements(By.tagName("td")));
                if(aux.size() != 0) {
                    campeones.add(new Campeon(id.getAndIncrement(), aux));
                }
                aux.clear();
            });
        });
    }*/
}