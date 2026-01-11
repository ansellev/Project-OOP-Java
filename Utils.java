package showroom.utils;

class Utils {
    public static String generatePlate() {
        return "B " + (int)(Math.random()*9000 + 1000);
    }

    public static String generateVIN() {
        return "VIN" + (int)(Math.random()*100000);
    }
}

