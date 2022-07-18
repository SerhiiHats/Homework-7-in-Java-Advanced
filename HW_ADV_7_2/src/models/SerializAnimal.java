package models;

import java.io.*;

public class SerializAnimal {
    public static void main(String[] args) {
        Animal obj = new Animal("Horse", 450.45, 7);
        File file = new File("info_animal.bin");
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))) {  // try-catch-resurse закроет поток
            output.writeObject(obj);

        } catch (FileNotFoundException e) {
            System.out.println("файл \"info_animal.bin\" для записи во время сериализации не найден!");
        } catch (IOException e) {
            System.out.println("что-то пошло не так!");
        }
    }
}
