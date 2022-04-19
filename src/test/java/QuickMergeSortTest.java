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
    public void TwoElementsSortedArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{1,2});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2]");
    }

    @Test
    public void TwoElementsArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{2,1});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2]");
    }
    @Test
    public void NullArraySortTest(){
        quickMergeSort.setArrayToSort(null);
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("null");
    }

    @Test
    public void EmptyArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[]");
    }

    @Test
    public void ThreeElementsArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{2,3,1});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2, 3]");
    }

    @Test
    public void FourElementsArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{2,3,1,4});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2, 3, 4]");
    }

    @Test
    public void RepetitionElementsArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{2,3,1,2});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2, 2, 3]");
    }
}
