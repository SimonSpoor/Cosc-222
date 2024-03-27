import java.util.Arrays;

/**
 * Note that an array of integers is expected
 * Remember to site sources if you use code from online!
 */
public class IntSort {

    //you may use this to check that your test cases are correct
    public static int[] sort(int[] arr) {
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);
        return arrCopy;
    }

    public static int[] InsertionSort(int[] orgArr) {
    	int[] arr = orgArr.clone();
    	// SORT HERE //

        //referenced from https://www.geeksforgeeks.org/insertion-sort/
        int key, j, i;
        for (i = 1; i < orgArr.length; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    	// return arr sorted
        return arr;
    }
    
    // assumes values in array range from [0,numBuckets]
    public static int[] CountingSort(int[] array, int numBuckets){
        //Referenced from https://www.geeksforgeeks.org/java-program-for-counting-sort-2/?ref=gcse
        int[] output = new int[numBuckets];
        int[] count = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;
        for (int j : array) ++count[j];
        for (int i = 1; i <= 255; ++i)
            count[i] += count[i-1];
        for (int j : array) {
            try {
                output[count[j] - 1] = j;
                --count[j];
            } catch (Exception ignored) {}
        }
        // Ensure not to alter the original array
    	return output;
    }
    //Data structure and sorting algorithms are visualized at https://cmps-people.ok.ubc.ca/ylucet/DS/Algorithms.html
	//in particular see insertion and counting sort

}
