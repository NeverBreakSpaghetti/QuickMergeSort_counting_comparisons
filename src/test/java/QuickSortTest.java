import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class QuickSortTest {
    QuickSort quickSort = new QuickSort(null);

    @Test
    public void nullArraySortTest(){
        assertThat(Arrays.toString(quickSort.sort())).isEqualTo("null");
    }

    @Test
    public void EmptyArraySortTest(){
        quickSort.setArrayToSort(new int[] {});
        assertThat(Arrays.toString(quickSort.sort())).isEqualTo("[]");
    }

    @Test
    public void oneElementArraySortTest(){
        quickSort.setArrayToSort(new int[] {1});
        assertThat(Arrays.toString(quickSort.sort())).isEqualTo("[1]");
    }

    @Test
    public void twoElementArraySortedSortTest(){
        quickSort.setArrayToSort(new int[] {1,2});
        assertThat(Arrays.toString(quickSort.sort())).isEqualTo("[1, 2]");
    }

    @Test
    public void twoElementArraySortTest(){
        quickSort.setArrayToSort(new int[] {2,1});
        assertThat(Arrays.toString(quickSort.sort())).isEqualTo("[1, 2]");
    }

    @Test
    public void nullArrayPartitionTest(){
        quickSort.setArrayToSort(null);
        assertThat(quickSort.partition(0,2)).isEqualTo(0);
        assertThat(quickSort.getArray()).isNull();
    }

    @Test
    public void oneElementArrayPartitionTest(){
        quickSort.setArrayToSort(new int[] {1});
        assertThat(quickSort.partition(0,quickSort.getArray().length)).isEqualTo(0);
        assertThat(Arrays.toString(quickSort.getArray())).isEqualTo("[1]");
    }

    @Test
    public void twoElementsArrayPartitionTest(){
        quickSort.setArrayToSort(new int[] {2,1});
        assertThat(quickSort.partition(0,quickSort.getArray().length)).isEqualTo(1);
        assertThat(Arrays.toString(quickSort.getArray())).isEqualTo("[1, 2]");
    }

    @Test
    public void threeElementsArrayPartitionTest(){
        quickSort.setArrayToSort(new int[] {3,1,2});
        assertThat(quickSort.partition(0,quickSort.getArray().length)).isEqualTo(2);
        assertThat(Arrays.toString(quickSort.getArray())).isEqualTo("[2, 1, 3]");
    }

    @Test
    public void manyElementsArrayPartitionTest(){
        quickSort.setArrayToSort(new int[] {2,3,1,9,5,6,2});
        assertThat(quickSort.partition(0,quickSort.getArray().length)).isEqualTo(2);
        assertThat(Arrays.toString(quickSort.getArray())).isEqualTo("[1, 2, 2, 9, 5, 6, 3]");
    }

    @Test
    public void threeElementsArraySortTest(){
        quickSort.setArrayToSort(new int[] {2,3,1});
        quickSort.sort();
        assertThat(Arrays.toString(quickSort.getArray())).isEqualTo("[1, 2, 3]");
    }

    @Test
    public void quickSortCallTest(){
        QuickSort mockQuickSort = mock(QuickSort.class);
        doCallRealMethod().when(mockQuickSort).setArrayToSort(any());
        doCallRealMethod().when(mockQuickSort).sort();
        doCallRealMethod().when(mockQuickSort).quickSort(anyInt(),anyInt());
        doCallRealMethod().when(mockQuickSort).partition(anyInt(),anyInt());

        mockQuickSort.setArrayToSort(new int[]{2,1,4,0,5});

        mockQuickSort.sort();
        verify(mockQuickSort).quickSort(0,5);
        verify(mockQuickSort).quickSort(0,2);
        verify(mockQuickSort).quickSort(0,0);
        verify(mockQuickSort).quickSort(3,3);
    }

    @Test
    public void fiveElementsArrayQuickSortTest(){
        quickSort.setArrayToSort(new int[]{2,1,4,0,5});
        quickSort.sort();
        assertThat(Arrays.toString(quickSort.getArray())).isEqualTo("[0, 1, 2, 4, 5]");
    }

    @Test
    public void manyElementsArrayQuickSortTest(){
        quickSort.setArrayToSort(new int[]{16,0,20,32,2,18,14,3,23,6,9,27,30,10,17,13,11,21,1,31,22,15,19,7,8,12,4,25,24,26,28,29,5});
        quickSort.sort();
        assertThat(Arrays.toString(quickSort.getArray())).isEqualTo("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32]");
    }


    @Test
    public void manyElementsArrayWithRepetitionsQuickSortTest(){
        quickSort.setArrayToSort(new int[]{16,0,11,32,2,18,14,3,23,11,10,0,30,10,17,13,11,21,1,31,22,15,19,7,8,30,4,25,24,26,1,29,5});
        quickSort.sort();
        assertThat(Arrays.toString(quickSort.getArray())).isEqualTo("[0, 0, 1, 1, 2, 3, 4, 5, 7, 8, 10, 10, 11, 11, 11, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 29, 30, 30, 31, 32]");
    }

    @Test
    public void contComparisonsNullArrayTest(){
        quickSort.setArrayToSort(null);
        quickSort.sort();
        assertThat(quickSort.getKeysComparisonsNumber()).isEqualTo(0);
    }

    @Test
    public void contComparisonsEmptyArrayTest(){
        quickSort.setArrayToSort(new int[] {});
        quickSort.sort();
        assertThat(quickSort.getKeysComparisonsNumber()).isEqualTo(0);
    }

    @Test
    public void countComparisonsTest(){
        quickSort.setArrayToSort(new int[]{7,2,3,9,8});
        quickSort.sort();
        assertThat(quickSort.getKeysComparisonsNumber()).isEqualTo(10);
    }

    @Test
    public void SorterStateSortTest(){
        SorterState sorterState = new QuickSort();
        assertThat(Arrays.toString(sorterState.sort(new int[]{3,2,1}))).isEqualTo("[1, 2, 3]");
    }

    @Test
    public void SorterStateGetKeysComparisonsNumberTest(){
        SorterState sorterState = new QuickSort();
        sorterState.sort(new int[]{7,2,3,9,8});
        assertThat(sorterState.getKeysComparisonsNumber()).isEqualTo(10);
    }
}
