import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
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

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getDaño() {
        return daño;
    }

    public void setDaño(String daño) {
        this.daño = daño;
    }

    public String getCadencia() {
        return cadencia;
    }

    public void setCadencia(String cadencia) {
        this.cadencia = cadencia;
    }

    public String getVel_proyectil() {
        return vel_proyectil;
    }

    public void setVel_proyectil(String vel_proyectil) {
        this.vel_proyectil = vel_proyectil;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getSuerte() {
        return suerte;
    }

    public void setSuerte(String suerte) {
        this.suerte = suerte;
    }

    @Override
    public String toString() {
        return "id,icono,nombre,vida,daño,cadencia,vel_proyectil,rango,velocidad,suerte-" +
                id + ',' + icono + ',' + nombre + ',' + vida + ',' + daño + ',' + cadencia +
                ',' + vel_proyectil + ',' + rango + ',' + velocidad + ',' + suerte ;
    }
}