import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Personajes {

    List<Personaje> lista = new ArrayList<>();

    public void getPersonajes(WebDriver driver, WebDriverWait wait, List<String> goodLinks){
        List<WebElement> aux = new ArrayList<>();
        AtomicInteger id = new AtomicInteger(1);

        goodLinks.forEach(l -> {
            if (l.contains("Personajes")) {
                driver.navigate().to(l);
                wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("wikitable"))));
                for(int i=0, j=0; i<7500; j=i, i+=30){
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo("+j+", "+i+")");
                }
                List<WebElement> tablas = driver.findElements(By.className("wikitable"));
                tablas.forEach(tabla -> {
                    tabla.findElements(By.tagName("tr")).remove(0);
                    tabla.findElements(By.tagName("tr")).remove(1);

                    tabla.findElements(By.tagName("tr")).forEach(fila -> {
                        aux.addAll(fila.findElements(By.tagName("td")));
                        if(aux.size() != 0) {
                            lista.add(new Personaje(id.getAndIncrement(), aux));
                        }
                        aux.clear();
                    });
                });
            }
        });
    }
}
