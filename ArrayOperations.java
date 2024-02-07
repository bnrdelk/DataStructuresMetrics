import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

public class ArrayOperations {

    public static void arrayOperations(String fileName, int bigIndex, int smallIndex) {
        // Load integers from the file into an array
        int arraySize;

        //Checking the input file for rearranging the size of the array
        if(fileName.equals("1Mint.txt"))
            arraySize = 1000000;
        else
            arraySize = 50000000;

        int[] array = buildArray(fileName, arraySize);

        insertToFirstIndex(array);
        insertToLastIndex(array);
        readIndex(array, bigIndex);
        readIndex(array, smallIndex);
    }

    //Method for building the array
    public static int[] buildArray(String fileName, int arraySize) {
        LocalTime fileBuildStart = LocalTime.now();
        int[] intArr = new int[arraySize];

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            int i = 0;
            String newLine;

            while ((newLine = bufferedReader.readLine()) != null && i < intArr.length) {
                intArr[i] = Integer.parseInt(newLine);
                i++;
            }

            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LocalTime fileBuildEnd = LocalTime.now();
        Duration fileBuildDuration = Duration.between(fileBuildStart, fileBuildEnd);
        System.out.println("1a) The integer array structure is built in " + fileBuildDuration.toMillis() + " milliseconds.");

        return intArr;
    }

    //Reading the number from given index
    private static void readIndex(int[] array, int index) {
        LocalTime readStart = LocalTime.now();
        int the_value = array[index];

        LocalTime readEnd = LocalTime.now();

        Duration readDuration = Duration.between(readStart,readEnd);
        if(index == 900000 || index == 45000000)
            System.out.println("1d) An integer, which is " + the_value +", is read from the index "+ index + " of the integer array in " + readDuration.toMillis() + " milliseconds.");
        else if(index == 9)
            System.out.println("1e) An integer, which is " + the_value +", is read from the index "+ index + " of the integer array in " + readDuration.toMillis() + " milliseconds.");
        else
            System.out.println("An integer, which is " + the_value +", is read from the index "+ index + " of the integer array in " + readDuration.toMillis() + " milliseconds.");
    }

    //Used to insert an integer to last index of the array
    private static void insertToLastIndex(int[] array) {
        LocalTime insertLastStart = LocalTime.now();

        array[array.length-1] = 888;

        LocalTime insertLastEnd = LocalTime.now();

        Duration insertLastDuration = Duration.between(insertLastStart,insertLastEnd);
        System.out.println("1c) An integer is inserted into the last index of the integer array in " + insertLastDuration.toMillis() + " milliseconds.");
    }

    //Used to insert an integer to first index of the array
    private static void insertToFirstIndex(int[] array) {
        LocalTime insertFirstStart = LocalTime.now();

        int[] newArray = new int[array.length+1];

        for(int k = array.length; k > 0; k--) {
            newArray[k] = array[k-1];
        }

        newArray[0] = 777;

        LocalTime insertFirstEnd = LocalTime.now();

        Duration insertFirstDuration = Duration.between(insertFirstStart,insertFirstEnd);
        System.out.println("1b) An integer is inserted into the first index of the integer array in " + insertFirstDuration.toMillis() + " milliseconds.");
    }
}
