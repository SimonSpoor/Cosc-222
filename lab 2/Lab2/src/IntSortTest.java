import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntSortTest {
    //Possible edge cases:
    //      -empty array
    //      -single value array
    //      -array with duplicate elements
    //      -reverse sorted data
    int[] arrayWithDuplicateElements = new int[]{8,1,1,3,4,5,5,6};
    int[] singleElementArray = new int[]{1};
    int[] reverseSortedArray = new int[]{5,4,3,2,1};

    @Test
    //Test empty array
    public void insertionSortTest1() {
        assertArrayEquals(IntSort.InsertionSort(new int[0]), new int[0]);
    }
    @Test
    //Test large array
    public void insertionSortTest2() {
        int[] i = new int[100000];
        for (int j = 0; j < 100000; j++){i[j] = (int) (Math.random() * 100);
        }
        assertArrayEquals(IntSort.InsertionSort(i), IntSort.sort(i));
    }
    @Test
    //Test duplicate elements
    public void insertionSortTest3() {
        assertArrayEquals(IntSort.InsertionSort(arrayWithDuplicateElements), new int[]{1,1,3,4,5,5,6,8});
    }
    @Test
    //Test single element array
    public void insertionSortTest4(){
        assertArrayEquals(IntSort.InsertionSort(singleElementArray), new int[]{1});
    }
    @Test
    //Test reverse sorted data
    public void insertionSortTest5(){
        assertArrayEquals(IntSort.InsertionSort(reverseSortedArray), new int[]{1,2,3,4,5});
    }


    @Test
    //Test empty array
    public void countingSortTest1() {
        assertArrayEquals(IntSort.CountingSort(new int[0], 0), new int[0]);
    }
    @Test
    //Test large array
    public void countingSortTest2() {
        int[] i = new int[1000000];
        for (int j = 0; j < 1000000; j++){i[j] = (int) (Math.random() * 100);
        }
        assertArrayEquals(IntSort.CountingSort(i, i.length), IntSort.sort(i));
    }
    @Test
    //Test duplicate elements
    public void countingSortTest3() {
        assertArrayEquals(IntSort.CountingSort(arrayWithDuplicateElements, arrayWithDuplicateElements.length), new int[]{1,1,3,4,5,5,6,8});
    }
    @Test
    //Test single element array
    public void countingSortTest4(){
        assertArrayEquals(IntSort.CountingSort(singleElementArray,1), new int[]{1});
    }
    @Test
    //Test reverse sorted data
    public void countingSortTest5(){
        assertArrayEquals(IntSort.CountingSort(reverseSortedArray, reverseSortedArray.length), new int[]{1,2,3,4,5});
    }
}