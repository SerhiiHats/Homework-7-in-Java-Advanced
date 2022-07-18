import models.Animal;

import java.io.*;

/**Домашнее задание 7
 Задание 2
 Необходимо осуществить десериализацию с файла предыдущего проекта(Animal) и вывести на экран содержимое.

 Для подготовки к этому заданию: в package models был создан класс Animal
 в этом же пакете был создан исполняющий клас SerializAnimal в котором был создан объект Animal
 и произведена его сериализация в файл: "info_animal.bin"

 Для десериализации использован исполняющий класс DeSerializAnimal который читает подготовленый файл "info_animal.bin"
 и выводит содержимое на экран.
 */
public class DeSerializAnimal {
    public static void main(String[] args) {
        File file = new File("info_animal.bin");
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))){
            Animal deserializAnimal = (Animal) input.readObject();
            System.out.println("1-option: " + deserializAnimal);
            System.out.println("2-option: животное: " + deserializAnimal.getName() + ", вес: " + deserializAnimal.getWeight() + "кг., возраст: " + deserializAnimal.getAge() + "лет");

        } catch (FileNotFoundException e) {
            System.out.println("файл \"info_animal.bin\" для чтения во время десериализации не найден!");;
        } catch (IOException e) {
            System.out.println("что-то пошло не так!");
        } catch (ClassNotFoundException e) {
            System.out.println("класс Animal не был найден");
        }

    }
}
