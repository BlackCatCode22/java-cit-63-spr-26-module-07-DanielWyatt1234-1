package danielWyatt.myZoo.com;

public class Tiger extends Animal{
    private static int numOfTigers = 0; // Shared across all Hyenas

    public Tiger(String name, int age, String sex, String birthDate, String color, String weight, String origin) {
        // Call the parent constructor
        super(name, age, "Tiger", sex, birthDate,  color, weight, origin);
        numOfTigers++;
        // This creates "Ti01", "Ti02", etc.
        this.setAnimalID("Ti" + String.format("%02d", numOfTigers));
    }
}
