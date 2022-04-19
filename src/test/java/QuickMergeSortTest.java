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
    public void TwoElementsArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{1,2});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2]");
    }

}
