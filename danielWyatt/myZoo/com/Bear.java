package danielWyatt.myZoo.com;

public class Bear extends Animal {
    private static int numOfBears = 0; // Shared across all Bears

    public Bear(String name, int age, String sex, String birthDate, String color, String weight, String origin) {
        // Call the parent constructor
        super(name, age, "Bear", sex, birthDate,  color, weight, origin);
        numOfBears++;
        // This creates "Be01", "Be02", etc.
        this.setAnimalID("Be" + String.format("%02d", numOfBears));
    }
}
