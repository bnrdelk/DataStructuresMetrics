import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

class DynamicArray {
    private int[] dynamicArray;
    private int size;

    public DynamicArray() {
        dynamicArray = new int[0];
        size = 0;
    }

    //Adding an element into the array
    public void add(int element) {
        //If the array is full, resize the array
        if (size == dynamicArray.length) {
            resizeArray();
        }
        dynamicArray[size++] = element;
    }

    //Method for resizing the array
    private void resizeArray() {
        int newCapacity;

        //If the array is full, double the capacity
        if (dynamicArray.length == 0)
            newCapacity = 1;
        else
            newCapacity = dynamicArray.length * 2;

        int[] newArray = new int[newCapacity];

        dynamicArrayCopyHelper(dynamicArray, 0, newArray, 0, size);
        dynamicArray = newArray;
    }

    private void dynamicArrayCopyHelper(int[] dynamicArray, int startIndex, int[] newArray, int endIndex, int length) {
        for (int i = 0; i < length; i++) {
            newArray[endIndex + i] = dynamicArray[startIndex + i];
        }
    }

    //Used to insert an integer into the first index of the array
    public void insertFirst(int newInt) {
        LocalTime insertFirstStart = LocalTime.now();
        if (size == dynamicArray.length) {
            resizeArray();
        }

        for (int i = size; i > 0; i--) {
            dynamicArray[i] = dynamicArray[i - 1];
        }
        dynamicArray[0] = newInt;
        size++;

        LocalTime insertFirstEnd = LocalTime.now();
        Duration insertFirstDuration = Duration.between(insertFirstStart, insertFirstEnd);
        System.out.println("3b) An integer is inserted into the first index of the dynamic array in " + insertFirstDuration.toMillis() + " milliseconds.");
    }

    //Used to insert an integer into the last index of the array
    public void insertLast(int newInt) {
        LocalTime insertLastStart = LocalTime.now();
        if (size == dynamicArray.length) {
            resizeArray();
        }
        dynamicArray[size] = newInt;
        size++;

        LocalTime insertLastEnd = LocalTime.now();
        Duration insertLastDuration = Duration.between(insertLastStart, insertLastEnd);
        System.out.println("3c) An integer is inserted into the last index of the dynamic array in " + insertLastDuration.toMillis() + " milliseconds.");
    }

    // getters
    public int getSize() {
        return size;
    }

    public int get_at(int index) {
        LocalTime readStart = LocalTime.now();

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        int the_value = dynamicArray[index + 1];

        LocalTime readEnd = LocalTime.now();
        Duration readDuration = Duration.between(readStart, readEnd);
        if (index == 900000 || index == 45000000)
            System.out.println("3d) An integer, which is " + the_value + ", is read from the index " + index + " of the integer array in " + readDuration.toMillis() + " milliseconds.");
        else if (index == 9)
            System.out.println("3e) An integer, which is " + the_value + ", is read from the index " + index + " of the integer array in " + readDuration.toMillis() + " milliseconds.");
        else
            System.out.println("An integer, which is " + the_value + ", is read from the index " + index + " of the integer array in " + readDuration.toMillis() + " milliseconds.");

        return the_value;
    }
}

public class DynamicArrayOperations {

    static void dynamicArrayOperations(String fileName, int bigIndex, int smallIndex) {
        DynamicArray array = new DynamicArray();

        array = buildDynamicArray(array, fileName);
        array.insertFirst(777);
        array.insertLast(777);
        array.get_at(bigIndex);
        array.get_at(smallIndex);
    }

    //Method for building the Dynamic array
    static DynamicArray buildDynamicArray(DynamicArray array, String fileName) {
        LocalTime dynamicArrayBuildStart = LocalTime.now();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int value = Integer.parseInt(line);
                    array.add(value);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalTime dynamicArrayBuildEnd = LocalTime.now();
        Duration dynamicArrayBuildDuration = Duration.between(dynamicArrayBuildStart, dynamicArrayBuildEnd);
        System.out.println("\n3a) The integer dynamic array structure is built in " + dynamicArrayBuildDuration.toMillis() + " milliseconds.");

        return array;
    }
}