import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HeapSortTest {
    @Test
    public void getKeysComparisonsNumberSorterStateTest(){
        SorterState heapSortSorterState = new HeapSort();
        assertThat(heapSortSorterState.getKeysComparisonsNumber()).isEqualTo(0);
    }

    @Test
    public void setAndGetArrayToSortTest(){
        HeapSort heapSort = new HeapSort();
        heapSort.setArrayToSort(new int[]{3,2});
        assertThat(Arrays.toString(heapSort.getArray())).isEqualTo("[3, 2]");
    }
}
