import model.City;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Домашнее задание 7
 * Задание 3
 * Создайте класс, используя SAXParser, в котором опишите иерархию XML файла.
 * Необходимо, чтобы проект создавал XML файл и строил дерево (город, название улицы, дом).
 * В городе используйте аттрибут(например, <city size=”big>Kiev</city>).
 */

public class Main {
    public static void main(String[] args) {
        List<City> listCity = new ArrayList<>();
        listCity.add(new City("Kiev", "big", "Sich shooters", 77));
        listCity.add(new City("Kiev", "big", "Architect Horodetskyi", 15));
        listCity.add(new City("Odessa", "middle", "Velika Arnautska", 37));
        listCity.add(new City("Odessa", "middle", "Ekaterininskaya", 67));
        listCity.add(new City("Izmail", "little", "Bazarnaya", 22));

        File file = new File("src/address_book_build_with_sax.xml");
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream(file));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("country");

            for (City c : listCity) {
                writer.writeStartElement("town");
                writer.writeStartElement("city");
                writer.writeAttribute("size", c.getSize());
                writer.writeCharacters(c.getCity());
                writer.writeEndElement();
                writer.writeStartElement("street");
                writer.writeCharacters(c.getStreet());
                writer.writeEndElement();
                writer.writeStartElement("building");
                writer.writeCharacters(String.valueOf(c.getBuilding()));
                writer.writeEndElement();
                writer.writeEndElement();
            }

            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();

        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
