package showroom.models;

public class Sedan extends Car {

    public Sedan(String name) {
        super(name, 5, 100, 700);
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
