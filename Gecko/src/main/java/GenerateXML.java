import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Clase que permite formatear los objetos de las clases principales a XML.
 *
 * @author Ángel Castro Merino
 */
public class GenerateXML {
    /**
     * Función que formatea a XML la lista de objetos de Personajes.
     *
     * @param personajes    Objeto de la clase Personajes.
     * @param path          Ruta al archivo en el cual se van a almacenar los datos.
     */
    public static void generatePersonajesXML(Personajes personajes, String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(Personajes.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(personajes, new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Función que formatea a XML la lista de objetos de Personajes.
     *
     * @param objetos   Objeto de la clase Objetos.
     * @param path      Ruta al archivo en el cual se van a almacenar los datos.
     */
    public static void generateObjetosXML(Objetos objetos, String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(Objetos.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(objetos, new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * Función que formatea a XML la lista de objetos de Personajes.
     *
     * @param monstruos Objeto de la clase Enemigos.
     * @param path      Ruta al archivo en el cual se van a almacenar los datos.
     */
    public static void generateMonstruosXML(Enemigos monstruos, String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(Enemigos.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(monstruos, new File(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}