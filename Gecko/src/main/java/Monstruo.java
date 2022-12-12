import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Monstruo extends Enemigo{
    public Monstruo(int id, List<WebElement> atributos) {
        super(id,
                atributos.get(0).findElement(By.tagName("img")).getAttribute("src"), //icono
                AskName(atributos.get(0)),  //nombre
                AskVida(atributos.get(1).getText()),  //vida
                atributos.get(2).getText()); //descripción
    }

    private static int AskVida(String atributoVida) {
        int NumVida;
        try{
            NumVida = Integer.parseInt(atributoVida);
        }catch (NumberFormatException e){
            NumVida = 9999;
        }
        return NumVida;
    }

    private static String AskName(WebElement atributoName) {
        String name;
        try{
            name = atributoName.findElements(By.tagName("a")).get(1).getText();
        }catch (IndexOutOfBoundsException e){
            name = atributoName.findElement(By.tagName("span")).getText();
        }
        return name;
    }

    @Override
    public String toString() {
        return "id-icono-nombre-vida-descripcion---" +
                id + "--" + icono + "--" + nombre + "--" + vida + "--" + descripcion;
    }
}