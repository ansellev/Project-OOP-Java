package showroom.models;

public class SUV extends Car {

    public SUV(String name) {
        super(name, 7, 150, 800);
    }

    @Override
    public String getType() {
        return "SUV";
    }
}

