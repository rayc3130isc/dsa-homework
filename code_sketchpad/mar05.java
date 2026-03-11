package HW2_ArrayLists_Generics.code_sketchpad;
// Remove or rename package if folder structure doesn't match

import java.util.*; // imports List, ArrayList, etc
import java.util.function.Predicate; // imports Predicate functional interface

public class mar05 {

    public static void main(String[] args) {

        // Local class (class defined inside main for quick testing)
        class Pirate{
            String name, role;
            int bounty;

            // Constructor: initializes Pirate object fields
            public Pirate(String name, String role, int bounty) {
                this.name = name;
                this.role = role;
                this.bounty = bounty;
            }
        }

        // List.of() creates an immutable list (cannot add/remove elements)
        List<Pirate> pirates = List.of(
                new Pirate("CPT0", "Captain", 10000),
                new Pirate("QMS0", "Quartermaster", 5000),
                new Pirate("CAN0", "Cannoneer", 2500),
                new Pirate("CRP0", "Carpenter", 2500),
                new Pirate("CRW0", "Crew", 1000)
        );

        // Predicate<T> is a functional interface representing a function
        // // - T -> boolean; Used commonly for filtering collections
        Predicate<Pirate> highBounty = pirate -> pirate.bounty >= 2000;

        // pirates.stream() - Converts the list into a Stream pipeline for functional operations

        // filter(highBounty) - Keeps only elements where predicate returns true

        // toList()
        // Collects stream results into a new List
        List<Pirate> highPriority = pirates.stream()
                .filter(highBounty)
                .toList();

        // forEach() - Iterates over each element of the list
        // Lambda expression prints pirate info
        highPriority.forEach(pirate ->
                System.out.println("<< " + pirate.name + " >> - Bounty >> " + pirate.bounty));

        // Task - Remove low Bounty Pirates:
        Predicate<Pirate> lowBounty = pirate -> pirate.bounty < 2000;
    }
}