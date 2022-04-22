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
    public void mergingSortedContiguousShortPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{8,3,9});
        quickMergeSort.merge(0,1,1,3);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[3, 8, 9]");
    }

    @Test
    public void mergingSortedNonContiguousShortPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{8,2,3,9});
        quickMergeSort.merge(0,1,2,4);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[3, 2, 8, 9]");
    }

    @Test
    public void mergingSortedContiguousPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{6,3,8,9});
        quickMergeSort.merge(0,1,1,4);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[3, 6, 8, 9]");
    }

    @Test
    public void mergingSortedContiguousPartitionsOrderMixedTest(){
        quickMergeSort.setArrayToSort(new int[]{8,3,6,9});
        quickMergeSort.merge(0,1,1,4);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[3, 6, 8, 9]");
    }

    @Test
    public void mergingSortedContiguousPartitionsOrderInverseTest(){
        quickMergeSort.setArrayToSort(new int[]{9,3,6,8});
        quickMergeSort.merge(0,1,1,4);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[3, 6, 8, 9]");
    }

    @Test
    public void mergingSortedContiguousMultiElementsPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{8,9,3,4,5,7});
        quickMergeSort.merge(0,2,2,6);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[4, 3, 5, 7, 8, 9]");
    }

    @Test
    public void mergingSortedNonContiguousMultiElementsPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{8,9,0,3,4,5,7});
        quickMergeSort.merge(0,2,3,7);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[4, 3, 0, 5, 7, 8, 9]");
    }

    @Test
    public void mergingSortedNonContiguousDifferentNumberOfElementsPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{6,8,9,0,1,3,4,5,7});
        quickMergeSort.merge(0,3,4,9);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[4, 3, 1, 0, 5, 6, 7, 8, 9]");
    }

    @Test
    public void mergingSortedNonContiguousDifferentNumberOfElements2PartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{6,8,0,1,3,4,5,7,9});
        quickMergeSort.merge(0,2,4,9);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[4, 3, 0, 1, 5, 6, 7, 8, 9]");
    }
}
