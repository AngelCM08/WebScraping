
# WebScraping Project DAM2A

Proyecto que scrapea la web que contiene la wiki del videojuego [The Binding Of 
Isaac Afterbirth+](https://bindingofisaac.fandom.com/es/wiki/The_Binding_of_Isaac:_Afterbirth%2B) (TBOIA+), 
en la búsqueda de obtener los datos necesarios para rellenar 
una base de datos basada en el [diagrama UML](https://github.com/AngelCM08/WebScraping/blob/main/DiagramaTBOIR-Inicial.png) 
presente en el proyecto. 

## Ejecución
Descarga el proyecto, ábrelo dentro de tu IDE de Java (Maven) favorito y 
ejecútalo!

NOTA: "El driver funciona a través de Firefox, si es la versión Snap NO va 
a funcionar."

## Tecnología utilizada

- [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/)
- [OpenCSV](https://www.baeldung.com/opencsv)
- [JAXB](https://javaee.github.io/jaxb-v2/)

## Metodología empleada
El programa abre la página principal de la wiki de TBOIA+, recoge los links del 
menú principal y los almacena, posteriormente accede a las diferentes páginas 
de las que recogerá datos, específicamente en Objetos, Personajes y Enemigos. 
Dentro de cada página, en función de como está distribuida la información se 
deben aplicar una serie de funciones que búsquen, encuentren y almacenen los 
datos, no sin antes filtrarlos para tener la información lo más limpia posible.

Una vez se han obtenido todos los datos se formatean a CSV y XML generando 6 
archivos, 2 por cada Entidad del diagrama UML que se ha conseguido recoger 
información.


## Authors

- [@AngelCM08](https://github.com/AngelCM08)
