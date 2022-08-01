import models.Book;
import models.City;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


/**
 * Домашнее задание 7
 * Задание 4
 * Создайте класс, используя JAXB, в котором опишите иерархию XML файла.
 * Необходимо, чтобы проект создавал XML файл и строил дерево (город, название улицы, дом).
 * В городе используйте аттрибут(например, <city size=”big>Kiev</city>).
 */

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.add(new City("Kiev", "big", "Student's", 27));
        book.add(new City("Kiev", "big", "Lower shaft", 34));
        book.add(new City("Odessa", "middle", "Szeged", 57));
        book.add(new City("Odessa", "middle", "Chernyakhovsky", 21));
        book.add(new City("Izmail", "little", "Osypenka", 14));

        // Маршалинг
        try {
            File file = new File("src/address_book_build_with_jaxb.xml");
            JAXBContext context = JAXBContext.newInstance(Book.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(book, file);
            marshaller.marshal(book, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        // Демаршалинг
        try {
            File file2 = new File("src/address_book_build_with_jaxb.xml");
            JAXBContext context2 = JAXBContext.newInstance(Book.class);
            Unmarshaller unmarshaller = context2.createUnmarshaller();
            Book bookUnmarsh = (Book) unmarshaller.unmarshal(file2);
            System.out.println("\nДемаршалинг объекта \"book\" их файла: \"address_book_build_with_jaxb.xml\" :");
            for (int i = 0; i < bookUnmarsh.cities.size(); i++) {
                System.out.println(bookUnmarsh.get(i));
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
