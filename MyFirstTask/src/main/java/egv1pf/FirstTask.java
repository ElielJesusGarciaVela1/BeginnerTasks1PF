/*
 * Eliel Jesus Garcia Vela
 *
 *
 * Copyright
 */

package egv1pf;

import java.util.*;

public class FirstTask {
    public static void main(String[] args) {


        ArrayList<Integer> arrayNumbers = new ArrayList<>();
        arrayNumbers.add(23);
        arrayNumbers.add(51);
        arrayNumbers.add(-19);

        Scanner userInput = new Scanner(System.in);

        label:
        while (true) {
            System.out.printf("%n1. Print array , 2. Add a number to the array, 3. Find the largest number%n%n4. Find the smallest number, 5. Remove a number from the array, 6. Delete the array%n%n7. Exit the program%n%n");
            System.out.print("\nWhat do you wish to do? (Enter a number): ");
            String inputNumber = userInput.nextLine();

            switch (inputNumber) {
                case "1":
                    System.out.println("Array contents: " + arrayNumbers);
                    break;
                case "2":
                    System.out.print("Enter the number you wish to add to the array: ");
                    int numtobeAdded = userInput.nextInt();
                    userInput.nextLine(); // Clear the buffer

                    arrayNumbers.add(numtobeAdded);
                    System.out.println("Number " + numtobeAdded + " added successfully!");
                    break;
                case "3":
                    int max = Collections.max(arrayNumbers);
                    System.out.println("The largest number is: " + max);
                    break;
                case "4":
                    int min = Collections.min(arrayNumbers);
                    System.out.println("The smallest number is: " + min);
                    break;
                case "5":
                    System.out.print("Enter the number you wish to remove: ");
                    int numtobeRemoved = userInput.nextInt();
                    userInput.nextLine(); // Clear the buffer

                    if (arrayNumbers.remove(Integer.valueOf(numtobeRemoved))) {
                        System.out.println("Number " + numtobeRemoved + " removed successfully!");
                    } else {
                        System.out.println("Number " + numtobeRemoved + " not found in the array.");
                    }
                    break;
                case "6":
                    arrayNumbers.clear();
                    System.out.println("Array deleted.");
                    break;
                case "7":
                    System.out.println("Exiting program. See you next time.");
                    break label; // Exit the loop and end the program
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
        userInput.close(); // Close the scanner after loop ends
    }
}