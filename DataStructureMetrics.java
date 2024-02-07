public class DataStructureMetrics {

    public static void main(String[] args) throws Exception{
        String file1Min = args[0];
        String file50Min = args[1];

        int bigIndex = 900000;
        int smallIndex = 9;

        System.out.println("Output for 1 million integers:\n----------------------------------------\n");
        ArrayOperations.arrayOperations(file1Min, bigIndex, smallIndex);
        LinkedListOperations.linkedListOperations(file1Min, bigIndex, smallIndex);
        DynamicArrayOperations.dynamicArrayOperations(file1Min, bigIndex, smallIndex);
        
        //changing the bigIndex for checking the new given index in 50 million sized array
        bigIndex = 45000000;

        System.out.println("\nOutput for 50 million integers:\n----------------------------------------\n");
        ArrayOperations.arrayOperations(file50Min, bigIndex, smallIndex);
        LinkedListOperations.linkedListOperations(file50Min, bigIndex, smallIndex);
        DynamicArrayOperations.dynamicArrayOperations(file50Min, bigIndex, smallIndex);
    }
}