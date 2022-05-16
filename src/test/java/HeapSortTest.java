import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HeapSortTest {
    HeapSort heapSort = new HeapSort();
    @Test
    public void getKeysComparisonsNumberSorterStateTest(){
        SorterState heapSortSorterState = heapSort;
        assertThat(heapSortSorterState.getKeysComparisonsNumber()).isEqualTo(0);
    }

    @Test
    public void setAndGetArrayToSortTest(){
        heapSort.setArrayToSort(new int[]{3,2});

        assertThat(Arrays.toString(heapSort.getArray())).isEqualTo("[3, 2]");
    }

    @Test
    public void nullArrayToHeapifyTest(){
        heapSort.setArrayToSort(null);

        heapSort.heapify(0);

        assertThat(Arrays.toString(heapSort.getArray())).isEqualTo("null");
    }

    @Test
    public void TwoElementsArrayToHeapifyTest(){
        heapSort.setArrayToSort(new int[]{2,3});

        heapSort.heapify(heapSort.getArray().length);

        assertThat(Arrays.toString(heapSort.getArray())).isEqualTo("[3, 2]");
    }

    @Test
    public void threeElementsArrayToHeapifyTest(){
        heapSort.setArrayToSort(new int[]{2,3,6});

        heapSort.heapify(heapSort.getArray().length);

        assertThat(Arrays.toString(heapSort.getArray())).isEqualTo("[6, 3, 2]");
    }
}
