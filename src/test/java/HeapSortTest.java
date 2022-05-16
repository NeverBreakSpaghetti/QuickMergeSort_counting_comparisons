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

    @Test
    public void fourElementsArrayToHeapifyTest(){
        heapSort.setArrayToSort(new int[]{3,1,5,9});

        heapSort.heapify(heapSort.getArray().length);

        assertThat(Arrays.toString(heapSort.getArray())).isEqualTo("[9, 3, 5, 1]");
    }

    @Test
    public void fourElementsMultiFixArrayToHeapifyTest(){
        heapSort.setArrayToSort(new int[]{3,7,5,9});

        heapSort.heapify(heapSort.getArray().length);

        assertThat(Arrays.toString(heapSort.getArray())).isEqualTo("[9, 7, 5, 3]");
    }

    @Test
    public void multiElementsArrayToHeapifyTest(){
        heapSort.setArrayToSort(new int[] {15,7,9,23,31,12,1,8,13});

        heapSort.heapify(heapSort.getArray().length);

        assertThat(Arrays.toString(heapSort.getArray())).isEqualTo("[31, 23, 12, 15, 7, 9, 1, 8, 13]");
    }

    @Test
    public void nullArrayHeapSortTest(){
        heapSort.setArrayToSort(null);

        heapSort.heapSort();

        assertThat(Arrays.toString(heapSort.getArray())).isEqualTo("null");
    }
}
