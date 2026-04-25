package danielWyatt.myZoo.com;

public class Hyena extends Animal{
    private static int numOfHyenas = 0; // Shared across all Hyenas

    public Hyena(String name, int age, String sex, String birthDate, String color, String weight, String origin) {
        // Call the parent constructor
        super(name, age, "Hyena", sex, birthDate, color, weight, origin);
        numOfHyenas++;
        // This creates "Hy01", "Hy02", etc.
        this.setAnimalID("Hy" + String.format("%02d", numOfHyenas));
    }
}
