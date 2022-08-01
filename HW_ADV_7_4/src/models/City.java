package models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class City {
    private String city;
    private String size;
    private String street;
    private int building;

    public City() {

    }

    public City(String city, String size, String street, int building) {
        this.city = city;
        this.size = size;
        this.street = street;
        this.building = building;
    }

    @XmlElement(name = "town")
    public void setCity(String city) {
        this.city = city;
    }

    @XmlAttribute
    public void setSize(String size) {
        this.size = size;
    }

    @XmlElement
    public void setStreet(String street) {
        this.street = street;
    }

    @XmlElement
    public void setBuilding(int building) {
        this.building = building;
    }

    public String getCity() {
        return city;
    }

    public String getSize() {
        return size;
    }

    public String getStreet() {
        return street;
    }

    public int getBuilding() {
        return building;
    }

    @Override
    public String toString() {
        return "{city= " + city + ", size= " + size + ", street= " + street + ", building= " + building + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return building == city1.building && Objects.equals(city, city1.city) && Objects.equals(size, city1.size) && Objects.equals(street, city1.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, size, street, building);
    }
}