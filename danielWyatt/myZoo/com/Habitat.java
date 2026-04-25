package danielWyatt.myZoo.com;

import java.util.ArrayList;

public class Habitat {
    private String habitatName;
    private ArrayList<Animal> residents;

    public Habitat(String name) {
        this.habitatName = name;
        this.residents = new ArrayList<>();
    }

    // Method to add an animal to this specific habitat
    public void addAnimal(Animal animal) {
        residents.add(animal);
    }

    // Getters
    public String getHabitatName() {
        return habitatName;
    }
    public ArrayList<Animal> getResidents() {
        return residents;
    }
}
