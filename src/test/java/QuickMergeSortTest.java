import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QuickMergeSortTest {

    @Test
    public void singleElementArraySortTest(){
        int[] arrayToSort = new int[]{1};
        QuickMergeSort quickMergeSort = new QuickMergeSort(arrayToSort);
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1]");
    }

}
