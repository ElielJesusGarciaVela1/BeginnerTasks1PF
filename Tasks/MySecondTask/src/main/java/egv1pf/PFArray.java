/**
 * Eliel Jesus Garcia Vela
 *
 * Copyright
 */
package egv1pf;

import java.util.*;

/**
 * The class below provides a skeleton array and all its functions in one object
 */

public class PFArray {
    private int[] array;

    /**
     * Constructor to create an empty array of a given size
     */

    public PFArray(int size) {
        array = new int[size];
    }

    // Method to create an array with random values between a specified range
    public void createRandomArray(int min, int max) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
    }

    // Method to manually fill the array with given values
    public void createManualArray(int[] inputArray) {
        if (inputArray.length == array.length) {
            System.arraycopy(inputArray, 0, array, 0, array.length);
        } else {
            System.out.println("Array size mismatch!");
        }
    }

    // Method to print the array
    public void printArray() {
        System.out.println(Arrays.toString(array));
    }

    // Method to return the array
    public int[] getArray() {
        return array;
    }

    // Method to add a number to the array (expands the array)
    public void addNumber(int number) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = number;
    }

    // Method to find the largest number in the array
    public int findLargest() {
        int largest = array[0];
        for (int num : array) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }

    // Method to find the smallest number in the array
    public int findSmallest() {
        int smallest = array[0];
        for (int num : array) {
            if (num < smallest) {
                smallest = num;
            }
        }
        return smallest;
    }

    // Method to calculate the sum of all elements in the array
    public int sumOfElements() {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    // Method to remove a number from the array
    public void removeNumber(int number) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array = Arrays.copyOf(array, array.length - 1);
            System.out.println("Number removed successfully!");
        } else {
            System.out.println("Number not found in the array.");
        }
    }

    // Method to delete the entire array
    public void deleteArray() {
        array = new int[0];
    }

    // Method to regenerate the array with random numbers
    public void regenerateArray(int min, int max) {
        createRandomArray(min, max);
    }

    // Method to display the menu and interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<PFArray> arrays = new ArrayList<>();
        int choice;

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create a new array");
            System.out.println("2. Select an existing array");
            System.out.println("3. Find the array with the largest sum");
            System.out.println("4. Find the array with the smallest sum");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the size of the new array: ");
                    int size = scanner.nextInt();
                    PFArray newArray = new PFArray(size);
                    arrays.add(newArray);
                    System.out.println("New array created. You can now perform operations on it.");
                    break;

                case 2:
                    if (arrays.isEmpty()) {
                        System.out.println("No arrays created yet.");
                        break;
                    }
                    System.out.println("Select an array to work with:");
                    for (int i = 0; i < arrays.size(); i++) {
                        System.out.println((i + 1) + ". Array " + (i + 1));
                    }
                    System.out.print("Enter your choice: ");
                    int arrayIndex = scanner.nextInt() - 1;
                    if (arrayIndex >= 0 && arrayIndex < arrays.size()) {
                        PFArray selectedArray = arrays.get(arrayIndex);
                        performOperationsOnArray(scanner, selectedArray);
                    } else {
                        System.out.println("Invalid array selection.");
                    }
                    break;

                case 3:
                    findLargestSumArray(arrays);
                    break;

                case 4:
                    findSmallestSumArray(arrays);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Find the array with the largest sum
    private static void findLargestSumArray(List<PFArray> arrays) {
        if (arrays.isEmpty()) {
            System.out.println("No arrays created yet.");
            return;
        }

        PFArray largestSumArray = arrays.getFirst();
        int largestSum = largestSumArray.sumOfElements();

        for (PFArray array : arrays) {
            int sum = array.sumOfElements();
            if (sum > largestSum) {
                largestSum = sum;
                largestSumArray = array;
            }
        }

        System.out.println("Array with largest sum: " + Arrays.toString(largestSumArray.getArray()) + " (Sum = " + largestSum + ")");
    }

    // Find the array with the smallest sum
    private static void findSmallestSumArray(List<PFArray> arrays) {
        if (arrays.isEmpty()) {
            System.out.println("No arrays created yet.");
            return;
        }

        PFArray smallestSumArray = arrays.getFirst();
        int smallestSum = smallestSumArray.sumOfElements();

        for (PFArray array : arrays) {
            int sum = array.sumOfElements();
            if (sum < smallestSum) {
                smallestSum = sum;
                smallestSumArray = array;
            }
        }

        System.out.println("Array with smallest sum: " + Arrays.toString(smallestSumArray.getArray()) + " (Sum = " + smallestSum + ")");
    }

    // Perform operations on a selected array
    private static void performOperationsOnArray(Scanner scanner, PFArray array) {
        int choice;
        do {
            System.out.println("\nOperations Menu:");
            System.out.println("1. Create a random array");
            System.out.println("2. Create a manual array");
            System.out.println("3. Print the array");
            System.out.println("4. Add a number to the array");
            System.out.println("5. Find the largest number in the array");
            System.out.println("6. Find the smallest number in the array");
            System.out.println("7. Calculate the sum of elements");
            System.out.println("8. Remove a number from the array");
            System.out.println("9. Delete the array");
            System.out.println("10. Regenerate the array with random numbers");
            System.out.println("11. Back to main menu");
            System.out.print("Enter your choice (1-11): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the min and max values (hit enter after the first): ");
                    array.createRandomArray(scanner.nextInt(), scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Enter the array values:");
                    int[] inputArray = new int[array.getArray().length];
                    for (int i = 0; i < inputArray.length; i++) {
                        inputArray[i] = scanner.nextInt();
                    }
                    array.createManualArray(inputArray);
                    break;
                case 3:
                    array.printArray();
                    break;
                case 4:
                    System.out.print("Enter a number: ");
                    array.addNumber(scanner.nextInt());
                    break;
                case 5:
                    System.out.println("Largest: " + array.findLargest());
                    break;
                case 6:
                    System.out.println("Smallest: " + array.findSmallest());
                    break;
                case 7:
                    System.out.println("Sum: " + array.sumOfElements());
                    break;
                case 8:
                    System.out.print("Enter a number: ");
                    array.removeNumber(scanner.nextInt());
                    break;
                case 9:
                    array.deleteArray();
                    System.out.println("Deleted. Please return to main menu.");
                    break;
                case 10:
                    System.out.print("Enter the min and max values: ");
                    array.regenerateArray(scanner.nextInt(), scanner.nextInt());
                    break;
            }
        } while (choice != 11);
    }
}