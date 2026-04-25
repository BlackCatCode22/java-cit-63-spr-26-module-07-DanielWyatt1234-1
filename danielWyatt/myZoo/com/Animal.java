package danielWyatt.myZoo.com;

public class Animal {

    // Animal Class attributes
    private String name;
    private int age;
    private String species;
    private String sex;
    private String animalID;
    private String birthDate;
    private String color;
    private String weight;
    private String origin;


    //Create a static attribute that belongs to the Animal class.
    public static int numOfAnimals = 0;

    //Animal Class constructors
    public Animal(String name, int age, String species, String sex, String birthDate, String color, String weight, String origin) {
        
        // Create initial values for the class attributes.
        this.name = name;
        this.species = species;
        this.age = age;
        this.sex = sex;
        this.birthDate = birthDate;
        this.color = color;
        this.weight = weight;
        this.origin = origin;
        numOfAnimals++;
    }
    
    public Animal() {
        numOfAnimals++;
    }
    
    // Getters and Setters for each attribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() { return sex; }

    public void setSex(String sex) { this.sex = sex; }

    public String getAnimalID() { return animalID; }

    public void setAnimalID(String animalID) { this.animalID = animalID; }

    public String getBirthDate() { return birthDate; }

    public void setBirthDate(String birthDate) { this.birthDate = birthDate; }

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }

    public String getWeight() { return weight; }

    public void setWeight(String weight) { this.weight = weight; }

    public String getOrigin() { return origin; }

    public void setOrigin(String origin) { this.origin = origin; }
}

