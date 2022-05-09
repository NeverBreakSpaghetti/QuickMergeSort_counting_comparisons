import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QuickSortTest {

    @Test
    public void nullArraySortTest(){
        QuickSort quickSort = new QuickSort(null);
        assertThat(Arrays.toString(quickSort.sort())).isEqualTo("null");
    }
}
