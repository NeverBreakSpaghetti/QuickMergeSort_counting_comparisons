import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InsertionSortTest {

    @Test
    public void getKeysComparisonsNumberSorterStateTest(){
        SorterState insertionSort = new InsertionSort();

        assertThat(insertionSort.getKeysComparisonsNumber()).isEqualTo(0);
    }

}
