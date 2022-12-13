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

@XmlRootElement(name="Enemigos")
public class Enemigos {
    int id;
    String icono;
    String nombre;
    int vida;
    String descripcion;

    List<Monstruo> monstruos = new ArrayList<>();
    List<Jefe> jefes = new ArrayList<>();

    public Enemigos(){}

    public Enemigos(int id, String icono, String nombre, int vida, String descripcion) {
        this.id = id;
        this.icono = icono;
        this.nombre = nombre;
        this.vida = vida;
        this.descripcion = descripcion;
    }

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
                    monstruos.add(new Monstruo(id.getAndIncrement(), aux));
                }
                aux.clear();
            });
        });
    }*/

    public List<Monstruo> getMonstruos() {
        return monstruos;
    }

    @XmlElement(name="Monstruo")
    public void setMonstruos(List<Monstruo> monstruos) {
        this.monstruos = monstruos;
    }

    @XmlElement(name="Id")
    public int getId() {
        return id;
    }

    @XmlElement(name="Icono")
    public String getIcono() {
        return icono;
    }

    @XmlElement(name="Nombre")
    public String getNombre() {
        return nombre;
    }

    @XmlElement(name="Vida")
    public int getVida() {
        return vida;
    }

    @XmlElement(name="Descripcion")
    public String getDescripcion() {
        return descripcion;
    }
}