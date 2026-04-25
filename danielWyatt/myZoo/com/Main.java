package danielWyatt.myZoo.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Load all names into the map
        String path1 = "C:/Users/wyatt/Spring Semester 26/CIT-63/Notes/animalNames.txt";
        Map<String, ArrayList<String>> nameBank = Methods.loadAllNames(path1);
        
        String path2 = "C:/Users/wyatt/Spring Semester 26/CIT-63/Notes/arrivingAnimals.txt";
        File file1 = new File(path2);

        // Create a map where the key is the species and the value is the Habitat object
        Map<String, Habitat> zooHabitats = new HashMap<>();

        zooHabitats.put("Hyena", new Habitat("Hyena Habitat"));
        zooHabitats.put("Lion", new Habitat("Lion Habitat"));
        zooHabitats.put("Tiger", new Habitat("Tiger Habitat"));
        zooHabitats.put("Bear", new Habitat("Bear Habitat"));

        try (Scanner sc = new Scanner(file1)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.isEmpty()) continue; // Skip blank lines

                String[] parts = line.split(", ");
                if (parts.length >= 1) {
                    String ageAndSpecies = parts[0]; // "4-year-old female hyena"
                    String[] theParts = ageAndSpecies.split(" ");
                    // Extract age (index 0), sex (index 3), and species (index 4)
                    int age = Integer.parseInt(theParts[0]);
                    String sex = theParts[3]; // Gets "female" or "male"
                    String species = theParts[4].toLowerCase(); // e.g., "hyena"
                    String birthSeason = parts[1];  // "born in spring"
                    String birthDate = Methods.genBirthDay(age, birthSeason);
                    String color = parts[2];        // "tan color"
                    String weight = parts[3];       // "70 pounds"
                    String origin = "";             // "from Friguia Park, Tunisia"
                    for (int i = 4; i < parts.length; i++) {
                        origin += parts[i] + (i == parts.length - 1 ? "" : ", ");
                    }

                    // 1. Format the species to match the Map keys (e.g., "hyena" -> "Hyena")
                    String speciesKey = species.substring(0, 1).toUpperCase() + species.substring(1).toLowerCase();

                    AnimalType type;
                    try {
                        // Converts "HYENA" string to AnimalType.HYENA
                        type = AnimalType.valueOf(speciesKey.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        type = AnimalType.UNKNOWN;
                    }
                    // 2. Safely pull a name from the nameBank
                    String name = "Unknown Name";
                    if (nameBank.containsKey(speciesKey) && !nameBank.get(speciesKey).isEmpty()) {
                        // Get the ArrayList for this species, then remove the first name
                        name = nameBank.get(speciesKey).remove(0);
                    }

                    // 3. Create the specific object (Polymorphism)
                    Animal myAnimal;
                    switch (type) {
                        case HYENA:
                            myAnimal = new Hyena(name, age, sex, birthDate, color, weight, origin);
                            break;
                        case LION:
                            myAnimal = new Lion(name, age, sex, birthDate, color, weight, origin);
                            break;
                        case TIGER:
                            myAnimal = new Tiger(name, age, sex, birthDate, color, weight, origin);
                            break;
                        case BEAR:
                            myAnimal = new Bear(name, age, sex, birthDate, color, weight, origin);
                            break;
                        default:
                            myAnimal = new Animal(name, age, species, sex, birthDate, color, weight, origin);
                            System.out.println("Warning: Unknown species encountered:." + speciesKey);
                    }
                    if (zooHabitats.containsKey(speciesKey)) {
                        zooHabitats.get(speciesKey).addAnimal(myAnimal);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Animal file not found: " + path2);
        }
        Methods.createReport(zooHabitats);
    }
}