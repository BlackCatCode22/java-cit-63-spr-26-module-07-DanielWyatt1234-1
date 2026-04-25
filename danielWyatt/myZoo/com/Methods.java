package danielWyatt.myZoo.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Methods {
    public static Map<String, ArrayList<String>> loadAllNames(String fileName) {
        Map<String, ArrayList<String>> nameBank = new HashMap<>();

        try (Scanner sc = new Scanner(new File(fileName))) {
            String currentSpecies = "";

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();

                // Look for any species header (e.g., "Lion Names:")
                if (line.endsWith("Names:")) {
                    currentSpecies = line.split(" ")[0]; // Gets "Lion" from "Lion Names:"
                    nameBank.put(currentSpecies, new ArrayList<>());
                }
                // If the line isn't empty, and we have a species set, it's a name line
                else if (!line.isEmpty() && !currentSpecies.isEmpty()) {
                    String[] namesArray = line.split(",");
                    for (String name : namesArray) {
                        nameBank.get(currentSpecies).add(name.trim());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return nameBank;
    }

    public static String genBirthDay (int age, String season) {
        int birthYear = 2026 - age;
        String monthDay = "01-01"; // Default

        if (season.contains("spring")) monthDay = "03-21";
        else if (season.contains("summer")) monthDay = "06-21";
        else if (season.contains("fall")) monthDay = "09-21";
        else if (season.contains("winter")) monthDay = "12-21";

        return birthYear + "-" + monthDay;
    }

    public static String getTodayDate() {
        // Obtains the current date from the system clock
        LocalDate today = LocalDate.now();

        // Formats it as YYYY-MM-DD
        return today.toString();
    }
    public static void createReport(Map<String, Habitat> zooHabitats) {
        String arrivalDate = getTodayDate();
        try (PrintWriter pw = new PrintWriter(new File("C:/Users/wyatt/Spring Semester 26/CIT-63/Notes/zooPopulation.txt"))) {
            pw.println("Zookeeper's Challenge: Zoo Population Report");
            pw.println("========================\n");

            for (Habitat habitat : zooHabitats.values()) {
                pw.println(habitat.getHabitatName() + ":");
                pw.println("--------------------");

                int count = 0;
                for (Animal a : habitat.getResidents()) {
                    pw.println(a.getAnimalID() + "; " + a.getName() + "; birth date: " + a.getBirthDate() + "; " + a.getColor() + "; " + a.getSex() + "; " + a.getWeight() + "; " + a.getOrigin() + "; arrived " + arrivalDate);
                        count++;
                    }
                pw.println("Total Residents: " + habitat.getResidents().size() + "\n");
                }
        } catch (FileNotFoundException e) {
            System.out.println("Error creating report file.");
        }
    }
}
