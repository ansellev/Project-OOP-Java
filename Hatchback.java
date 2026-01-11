package showroom.models;

public class Hatchback extends Car {

    public Hatchback(String name) {
        super(name, 5, 80, 750);
    }

    @Override
    public String getType() {
        return "Hatchback";
    }
}
