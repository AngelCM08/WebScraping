import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Objetos {

    List<Objeto> lista = new ArrayList<>();

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
}