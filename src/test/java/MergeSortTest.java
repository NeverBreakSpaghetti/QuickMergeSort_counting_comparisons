import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class MergeSortTest {
    MergeSort mergeSort = new MergeSort();
    MergeSort mockMergeSort = mock(MergeSort.class);

    @Test
    public void emptyArraySortTest(){
        assertThat(Arrays.toString(((SorterState)mergeSort).sort(new int[]{}))).isEqualTo("[]");
    }

    @Test
    public void nullArraySortTest(){
        assertThat(mergeSort.sort(null)).isEqualTo(null);
    }

    @Test
    public void oneElementArraySortTest(){
        assertThat(Arrays.toString(mergeSort.sort(new int[]{1}))).isEqualTo("[1]");
    }

    @Test
    public void setAndGetArrayToSortTest(){
        mergeSort.setArrayToSort(new int[]{3,2});

        assertThat(Arrays.toString(mergeSort.getArrayToSort())).isEqualTo("[3, 2]");
    }

    @Test
    public void GetAuxiliaryArrayTest(){
        mergeSort.setArrayToSort(new int[]{3,2});

        assertThat(mergeSort.getAuxiliaryArray().length).isEqualTo(2);
        assertThat(Arrays.toString(mergeSort.getAuxiliaryArray())).isEqualTo("[0, 0]");
    }

    @Test
    public void GetAuxiliaryArrayNullArrayToSortTest(){
        mergeSort.setArrayToSort(null);

        assertThat(Arrays.toString(mergeSort.getAuxiliaryArray())).isEqualTo("null");
    }

    @Test
    public void singleElementsMergeTest(){
        mergeSort.setArrayToSort(new int[]{3,2});

        mergeSort.merge(0,1,mergeSort.getArrayToSort().length);

        assertThat(Arrays.toString(mergeSort.getAuxiliaryArray())).isEqualTo("[2, 3]");
    }

    @Test
    public void TwoElementsMergeTest(){
        mergeSort.setArrayToSort(new int[]{2,5,3,4});

        mergeSort.merge(0,2,mergeSort.getArrayToSort().length);

        assertThat(Arrays.toString(mergeSort.getAuxiliaryArray())).isEqualTo("[2, 3, 4, 5]");
    }

    @Test
    public void TwoElementsMergeWithOneLessTest(){
        mergeSort.setArrayToSort(new int[]{2,3,5,7});

        mergeSort.merge(0,2,mergeSort.getArrayToSort().length);

        assertThat(Arrays.toString(mergeSort.getAuxiliaryArray())).isEqualTo("[2, 3, 5, 7]");
    }

    @Test
    public void mergeCopyAuxiliaryArrayInArrayToSortTest(){
        mergeSort.setArrayToSort(new int[]{2,3,5,4,6,7});

        mergeSort.merge(0,3,mergeSort.getArrayToSort().length);

        assertThat(Arrays.toString(mergeSort.getAuxiliaryArray())).isEqualTo("[2, 3, 4, 5, 6, 7]");
        assertThat(Arrays.toString(mergeSort.getArrayToSort())).isEqualTo("[2, 3, 4, 5, 6, 7]");
    }

    @Test
    public void mergeSortNumberOfCallsTest(){
        doCallRealMethod().when(mockMergeSort).setArrayToSort(any());
        doCallRealMethod().when(mockMergeSort).getArrayToSort();
        doCallRealMethod().when(mockMergeSort).mergeSort(anyInt(),anyInt());

        mockMergeSort.setArrayToSort(new int[]{3,2});
        mockMergeSort.mergeSort(0,mockMergeSort.getArrayToSort().length);

        verify(mockMergeSort).mergeSort(0,1);
        verify(mockMergeSort).mergeSort(1,2);
    }

    @Test
    public void mergeSortOrderOfCallsTest(){
        InOrder inOrder = inOrder(mockMergeSort);
        doCallRealMethod().when(mockMergeSort).setArrayToSort(any());
        doCallRealMethod().when(mockMergeSort).getArrayToSort();
        doCallRealMethod().when(mockMergeSort).mergeSort(anyInt(),anyInt());



        mockMergeSort.setArrayToSort(new int[]{3,1,2,5,4});
        inOrder.verify(mockMergeSort).setArrayToSort(any());

        mockMergeSort.mergeSort(0,mockMergeSort.getArrayToSort().length);
        inOrder.verify(mockMergeSort).mergeSort(0,5);
        inOrder.verify(mockMergeSort).mergeSort(0,2);
        inOrder.verify(mockMergeSort).mergeSort(0,1);
        inOrder.verify(mockMergeSort).mergeSort(1,2);
        inOrder.verify(mockMergeSort).mergeSort(2,5);
        inOrder.verify(mockMergeSort).mergeSort(2,3);
        inOrder.verify(mockMergeSort).mergeSort(3,5);
        inOrder.verify(mockMergeSort).mergeSort(3,4);
        inOrder.verify(mockMergeSort).mergeSort(4,5);
    }

    @Test
    public void mergeCallInMergeSortTest(){
        doCallRealMethod().when(mockMergeSort).setArrayToSort(any());
        doCallRealMethod().when(mockMergeSort).getArrayToSort();
        doCallRealMethod().when(mockMergeSort).mergeSort(anyInt(),anyInt());

        mockMergeSort.setArrayToSort(new int[]{3,2});
        mockMergeSort.mergeSort(0,mockMergeSort.getArrayToSort().length);

        verify(mockMergeSort).merge(0,1,2);
    }

    @Test
    public void mergeSortOrderTest(){
        mergeSort.setArrayToSort(new int[]{8,2,6,3,4,7,5,1,9,10});
        mergeSort.mergeSort(0,mergeSort.getArrayToSort().length);

        assertThat(Arrays.toString(mergeSort.getArrayToSort())).isEqualTo("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
    }

    @Test
    public void mergeSortOrderLargeArrayTest(){
        mergeSort.setArrayToSort(new int[]{16,0,20,32,2,18,14,3,23,6,9,27,30,10,17,13,11,21,1,31,22,15,19,7,8,12,4,25,24,26,28,29,5});
        mergeSort.mergeSort(0,mergeSort.getArrayToSort().length);

        assertThat(Arrays.toString(mergeSort.getArrayToSort())).isEqualTo("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32]");
    }

    @Test
    public void mergeSortOrderLargeArrayWithRepetitionTest(){
        mergeSort.setArrayToSort(new int[]{16,0,11,32,2,18,14,3,23,11,10,0,30,10,17,13,11,21,1,31,22,15,19,7,8,30,4,25,24,26,1,29,5});
        mergeSort.mergeSort(0,mergeSort.getArrayToSort().length);

        assertThat(Arrays.toString(mergeSort.getArrayToSort())).isEqualTo("[0, 0, 1, 1, 2, 3, 4, 5, 7, 8, 10, 10, 11, 11, 11, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 29, 30, 30, 31, 32]");
    }

    @Test
    public void sortCallMergeSortTest(){
        assertThat(Arrays.toString(mergeSort.sort(new int[]{8,2,6,3,4,7,5,1,9,10}))).isEqualTo("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
    }

    @Test
    public void notEditInputArrayTest(){
        int[] inputArray = new int[]{6,8,7};

        assertThat(Arrays.toString(mergeSort.sort(inputArray))).isEqualTo("[6, 7, 8]");

        assertThat(Arrays.toString(inputArray)).isEqualTo("[6, 8, 7]");
    }

    @Test
    public void contComparisonsNullArrayTest(){
        mergeSort.sort(null);

        assertThat(mergeSort.getKeysComparisonsNumber()).isEqualTo(0);
    }

    @Test
    public void contComparisonsEmptyArrayTest(){
        mergeSort.sort(new int[]{});

        assertThat(mergeSort.getKeysComparisonsNumber()).isEqualTo(0);
    }

    @Test
    public void contComparisonsOneElementArrayTest(){
        mergeSort.sort(new int[]{1});

        assertThat(mergeSort.getKeysComparisonsNumber()).isEqualTo(0);
    }

    @Test
    public void contComparisonsTwoElementArrayTest(){
        mergeSort.sort(new int[]{3,2});

        assertThat(mergeSort.getKeysComparisonsNumber()).isEqualTo(1);
    }

    @Test
    public void contComparisonsThreeElementArrayTest(){
        mergeSort.sort(new int[]{3,2,5});

        assertThat(mergeSort.getKeysComparisonsNumber()).isEqualTo(3);
    }
}
