import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Personaje {
    private int id;
    private String icono;
    private String nombre;
    private int vida;
    private String daño;
    private String cadencia;
    private String vel_proyectil;
    private String rango;
    private String velocidad;
    private String suerte;

    public Personaje(int id, List<WebElement> atributos) {
        List<String> aux = new ArrayList<>();
        atributos.forEach(text -> aux.add(text.getText().split("\n")[0]));

        this.id = id;
        icono = atributos.get(0).findElement(By.tagName("img")).getAttribute("src");
        nombre = aux.get(1);
        vida = atributos.get(2).findElements(By.tagName("img")).size();
        daño = aux.get(3);
        cadencia = aux.get(4);
        vel_proyectil = aux.get(5);
        rango = aux.get(6);
        velocidad = aux.get(7);
        suerte = aux.get(8);
    }

    public int getId() { return id; }

    @Override
    public String toString() {
        return "id-icono-nombre-vida-daño-cadencia-vel_proyectil-rango-velocidad-suerte---" +
                id + "--" + icono + "--" + nombre + "--" + vida + "--" + daño + "--" + cadencia +
                "--" + vel_proyectil + "--" + rango + "--" + velocidad + "--" + suerte ;
    }
}