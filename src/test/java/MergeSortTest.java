import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MergeSortTest {
    SorterState mergeSort = new MergeSort();

    @Test
    public void emptyArraySortTest(){
        assertThat(Arrays.toString(mergeSort.sort(new int[]{}))).isEqualTo("[]");
    }

    @Test
    public void nullArraySortTest(){
        assertThat(mergeSort.sort(null)).isEqualTo(null);
    }

}
