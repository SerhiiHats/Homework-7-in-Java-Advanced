package models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "country")
public class Book {
    @XmlElement(name = "city")
    public final List<City> cities = new ArrayList<>();

    public Book() {

    }

    public City get(int i) {
        return cities.get(i);
    }

    public void add(City citi) {
        cities.add(citi);
    }

    @Override
    public String toString() {
        return "{cities= " + cities + '}';
    }
}
