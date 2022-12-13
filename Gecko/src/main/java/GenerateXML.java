import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class GenerateXML {
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