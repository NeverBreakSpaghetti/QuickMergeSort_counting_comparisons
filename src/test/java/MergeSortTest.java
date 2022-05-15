import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MergeSortTest {

    @Test
    public void emptyArraySortTest(){
        SorterState mergeSort = new MergeSort();
        assertThat(Arrays.toString(mergeSort.sort(new int[]{}))).isEqualTo("[]");
    }

}
