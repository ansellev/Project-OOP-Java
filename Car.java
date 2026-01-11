package showroom.models;

import java.util.Random;

public abstract class Car {

    private String name;
    private int capacity;
    private int hp;
    private String numberPlate;
    private String vin;
    private String color;

    private static final String[] COLORS = {
        "Black", "White", "Red", "Blue", "Silver", "Gray"
    };

    public Car(String name, int capacity, int minHp, int maxHp) {
        this.name = name;
        this.capacity = capacity;
        this.hp = generateHp(minHp, maxHp);
        this.color = generateColor();
        this.numberPlate = generateNumberPlate();
        this.vin = generateVin();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getHp() {
        return hp;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public String getVin() {
        return vin;
    }

    public String getColor() {
        return color;
    }

    public abstract String getType();

    protected int generateHp(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    protected String generateColor() {
        return COLORS[new Random().nextInt(COLORS.length)];
    }

    protected String generateNumberPlate() {
        return "B " + (int)(Math.random() * 9000 + 1000);
    }

    protected String generateVin() {
        return "MH1" + (int)(Math.random() * 1_000_000);
    }

    public void showInfo() {
        System.out.println(
            getType() +
            " | Name: " + name +
            " | Capacity: " + capacity +
            " | HP: " + hp +
            " | Color: " + color +
            " | Plate: " + numberPlate +
            " | VIN: " + vin
        );
    }
}
