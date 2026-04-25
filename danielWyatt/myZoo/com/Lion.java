package danielWyatt.myZoo.com;

public class Lion extends Animal {
    private static int numOfLions = 0; // Shared across all Lions

    public Lion(String name, int age, String sex, String birthDate, String color, String weight, String origin) {
        // Call the parent constructor
        super(name, age, "Lion", sex, birthDate, color, weight, origin);
        numOfLions++;
        // This creates "Li01", "Li02", etc.
        this.setAnimalID("Li" + String.format("%02d", numOfLions));
    }
}
