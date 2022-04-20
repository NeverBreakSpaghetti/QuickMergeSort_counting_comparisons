import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QuickMergeSortTest {

    int[] arrayToSort;
    QuickMergeSort quickMergeSort = new QuickMergeSort(null);

    @Test
    public void singleElementArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{1});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1]");
    }

    @Test
    public void twoElementsSortedArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{1,2});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2]");
    }

    @Test
    public void twoElementsArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{2,1});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2]");
    }
    @Test
    public void nullArraySortTest(){
        quickMergeSort.setArrayToSort(null);
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("null");
    }

    @Test
    public void emptyArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[]");
    }

    @Test
    public void threeElementsArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{2,3,1});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2, 3]");
    }

    @Test
    public void fourElementsArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{2,3,1,4});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2, 3, 4]");
    }

    @Test
    public void repetitionElementsArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{2,3,1,2});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2, 2, 3]");
    }

    @Test
    public void positionPivotArrayPartitionTest(){
        quickMergeSort.setArrayToSort(new int[]{2,3,1,2});
        assertThat(quickMergeSort.partition()).isEqualTo(2);
    }

    @Test
    public void arrayPartitionTest(){
        quickMergeSort.setArrayToSort(new int[]{2,3,1,5,2});
        quickMergeSort.partition();
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[1, 2, 2, 5, 3]");
    }

    @Test
    public void mergingSortedPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{8,3,9});
        quickMergeSort.merge(0,1,1,3);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[3, 8, 9]");
    }

    @Test
    public void mergingSortedNonContiguousPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{8,2,3,9});
        quickMergeSort.merge(0,1,2,4);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[3, 2, 8, 9]");
    }
}
