package showroom.utils;
import java.io.*;
import java.util.*;

import showroom.models.Car;

public class FileManager {
    private static final String FILE = "cars.txt";

    public static void save(ArrayList<Car> cars) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            for (Car c : cars) {
                pw.println(c.getType() + " | Name: " + c.getName() +
                        " | Capacity: " + c.getCapacity() +
                        " | HP: " + c.getHp() +
                        " | Color: " + c.getColor() +
                        " | Plate: " + c.getNumberPlate() +
                        " | VIN: " + c.getVin());
            }
            System.out.println("Data saved.");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}


