import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class QuickMergeSortTest {
    QuickMergeSort quickMergeSort = new QuickMergeSort(null);
    QuickMergeSort mockQuickMergeSort = mock(QuickMergeSort.class);

    @Test
    public void singleElementArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{1});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1]");
    }

    @Test
    public void twoElementsSortedArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{1,2});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2]");
    }

    @Test
    public void twoElementsArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{2,1});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2]");
    }
    @Test
    public void nullArraySortTest(){
        quickMergeSort.setArrayToSort(null);
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("null");
    }

    @Test
    public void emptyArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[]");
    }

    @Test
    public void threeElementsArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{2,3,1});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2, 3]");
    }

    @Test
    public void fourElementsArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{2,3,1,4});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2, 3, 4]");
    }

    @Test
    public void repetitionElementsArraySortTest(){
        quickMergeSort.setArrayToSort(new int[]{2,3,1,2});
        assertThat(Arrays.toString(quickMergeSort.sort())).isEqualTo("[1, 2, 2, 3]");
    }

    @Test
    public void positionPivotArrayPartitionTest(){
        quickMergeSort.setArrayToSort(new int[]{2,3,1,2});
        assertThat(quickMergeSort.partition(0,quickMergeSort.getArray().length)).isEqualTo(2);
    }

    @Test
    public void arrayPartitionTest(){
        quickMergeSort.setArrayToSort(new int[]{2,3,1,5,2});
        quickMergeSort.partition(0,quickMergeSort.getArray().length);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[1, 2, 2, 5, 3]");
    }

    @Test
    public void mergingSortedContiguousShortPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{8,3,9});
        quickMergeSort.merge(0,1,1,3);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[3, 8, 9]");
    }

    @Test
    public void mergingSortedNonContiguousShortPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{8,2,3,9});
        quickMergeSort.merge(0,1,2,4);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[3, 2, 8, 9]");
    }

    @Test
    public void mergingSortedContiguousPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{6,3,8,9});
        quickMergeSort.merge(0,1,1,4);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[3, 6, 8, 9]");
    }

    @Test
    public void mergingSortedContiguousPartitionsOrderMixedTest(){
        quickMergeSort.setArrayToSort(new int[]{8,3,6,9});
        quickMergeSort.merge(0,1,1,4);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[3, 6, 8, 9]");
    }

    @Test
    public void mergingSortedContiguousPartitionsOrderInverseTest(){
        quickMergeSort.setArrayToSort(new int[]{9,3,6,8});
        quickMergeSort.merge(0,1,1,4);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[3, 6, 8, 9]");
    }

    @Test
    public void mergingSortedContiguousMultiElementsPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{8,9,3,4,5,7});
        quickMergeSort.merge(0,2,2,6);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[4, 3, 5, 7, 8, 9]");
    }

    @Test
    public void mergingSortedNonContiguousMultiElementsPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{8,9,0,3,4,5,7});
        quickMergeSort.merge(0,2,3,7);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[4, 3, 0, 5, 7, 8, 9]");
    }

    @Test
    public void mergingSortedNonContiguousDifferentNumberOfElementsPartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{6,8,9,0,1,3,4,5,7});
        quickMergeSort.merge(0,3,4,9);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[4, 3, 1, 0, 5, 6, 7, 8, 9]");
    }

    @Test
    public void mergingSortedNonContiguousDifferentNumberOfElements2PartitionsTest(){
        quickMergeSort.setArrayToSort(new int[]{6,8,0,1,3,4,5,7,9});
        quickMergeSort.merge(0,2,4,9);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[4, 3, 0, 1, 5, 6, 7, 8, 9]");
    }

    @Test
    public void mergeSortLeafTest(){
        quickMergeSort.setArrayToSort(new int[]{0,1,2});
        quickMergeSort.mergeSort(0,1,2);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[2, 1, 0]");
    }

    @Test
    public void mergeSortCallTest(){
        doCallRealMethod().when(mockQuickMergeSort).setArrayToSort(any());
        doCallRealMethod().when(mockQuickMergeSort).mergeSort(anyInt(),anyInt(),anyInt());

        mockQuickMergeSort.setArrayToSort(new int[]{0,1,2,4});

        mockQuickMergeSort.mergeSort(0,2,2);
        verify(mockQuickMergeSort).mergeSort(1,2,3);
        verify(mockQuickMergeSort).mergeSort(0,1,1);
    }

    @Test
    public void mergeSortNumberOfCallsTest(){
        doCallRealMethod().when(mockQuickMergeSort).setArrayToSort(any());
        doCallRealMethod().when(mockQuickMergeSort).mergeSort(anyInt(),anyInt(),anyInt());

        mockQuickMergeSort.setArrayToSort(new int[]{0,1,2,3,4,5,6,7,8,9});

        mockQuickMergeSort.mergeSort(5,10,0);
        verify(mockQuickMergeSort, times(9)).mergeSort(anyInt(),anyInt(),anyInt());
    }

    @Test
    public void mergeSortOrderOfCallsTest(){
        doCallRealMethod().when(mockQuickMergeSort).setArrayToSort(any());
        doCallRealMethod().when(mockQuickMergeSort).mergeSort(anyInt(),anyInt(),anyInt());

        InOrder inOrder = inOrder(mockQuickMergeSort);

        mockQuickMergeSort.setArrayToSort(new int[]{0,1,2,3,4,5,6,7,8,9});
        inOrder.verify(mockQuickMergeSort).setArrayToSort(any());

        mockQuickMergeSort.mergeSort(5,10,0);
        inOrder.verify(mockQuickMergeSort).mergeSort(5,10,0);
        inOrder.verify(mockQuickMergeSort).mergeSort(7,10,2);
        inOrder.verify(mockQuickMergeSort).mergeSort(8,10,3);
        inOrder.verify(mockQuickMergeSort).mergeSort(9,10,4);
        inOrder.verify(mockQuickMergeSort).mergeSort(8,9,9);
        inOrder.verify(mockQuickMergeSort).mergeSort(7,8,8);
        inOrder.verify(mockQuickMergeSort).mergeSort(5,7,7);
        inOrder.verify(mockQuickMergeSort).mergeSort(6,7,8);
        inOrder.verify(mockQuickMergeSort).mergeSort(5,6,6);
    }

    @Test
    public void firstStepMergeSortTest(){
        doCallRealMethod().when(mockQuickMergeSort).setArrayToSort(any());
        doCallRealMethod().when(mockQuickMergeSort).firstStep(anyInt(),anyInt(),anyInt());

        mockQuickMergeSort.setArrayToSort(new int[]{0,1,2,3,4,5,6,7,8});

        mockQuickMergeSort.firstStep(5,9,0);
        verify(mockQuickMergeSort).mergeSort(7,9,0);
        verify(mockQuickMergeSort).mergeSort(5,7,7);
    }

    @Test
    public void firstStepMergeSortOnOneElementTest(){
        doCallRealMethod().when(mockQuickMergeSort).setArrayToSort(any());
        doCallRealMethod().when(mockQuickMergeSort).firstStep(anyInt(),anyInt(),anyInt());

        mockQuickMergeSort.setArrayToSort(new int[]{0,1,2});

        mockQuickMergeSort.firstStep(2,3,0);
        verify(mockQuickMergeSort,never()).mergeSort(anyInt(),anyInt(),anyInt());
    }

    @Test
    public void firstStepMergeSortNumberOfRecursionTest(){
        doCallRealMethod().when(mockQuickMergeSort).setArrayToSort(any());
        doCallRealMethod().when(mockQuickMergeSort).mergeSort(anyInt(),anyInt(),anyInt());
        doCallRealMethod().when(mockQuickMergeSort).firstStep(anyInt(),anyInt(),anyInt());

        mockQuickMergeSort.setArrayToSort(new int[]{0,1,2,3,4,5,6,7,8});
        mockQuickMergeSort.firstStep(5,9,0);
        verify(mockQuickMergeSort, times(6)).mergeSort(anyInt(),anyInt(),anyInt());
    }

    @Test
    public void mergeAfterFirstStepTest(){
        doCallRealMethod().when(mockQuickMergeSort).setArrayToSort(any());
        doCallRealMethod().when(mockQuickMergeSort).mergeSort(anyInt(),anyInt(),anyInt());
        doCallRealMethod().when(mockQuickMergeSort).firstStep(anyInt(),anyInt(),anyInt());
        doCallRealMethod().when(mockQuickMergeSort).merge(anyInt(),anyInt(),anyInt(),anyInt());

        mockQuickMergeSort.setArrayToSort(new int[]{0,1,9,8});
        mockQuickMergeSort.firstStep(2,4,0);
        verify(mockQuickMergeSort).merge(0,1,2,4);
    }

    @Test
    public void mergeAfterFirstStepOrderArrayTest(){
        quickMergeSort.setArrayToSort(new int[]{0,1,9,8});
        quickMergeSort.firstStep(2,4,0);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[0, 1, 8, 9]");
    }

    @Test
    public void mergeAfterFirstStepOrderThreeElementsArrayTest(){
        quickMergeSort.setArrayToSort(new int[]{0,1,2,9,7,8});
        quickMergeSort.firstStep(3,6,0);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[1, 0, 2, 7, 8, 9]");
    }

    @Test
    public void mergeAfterFirstStepOrderFourElementsArrayTest(){
        quickMergeSort.setArrayToSort(new int[]{0,1,2,3,4,9,6,8,7});
        quickMergeSort.firstStep(5,9,0);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[1, 0, 2, 3, 4, 6, 7, 8, 9]");
    }

    @Test
    public void mergeAfterFirstStepOrderFiveElementsArrayTest(){
        quickMergeSort.setArrayToSort(new int[]{0,1,2,3,4,5,9,6,8,7,10});
        quickMergeSort.firstStep(6,11,0);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[2, 0, 1, 3, 4, 5, 6, 7, 8, 9, 10]");
    }

    @Test
    public void mergeAfterFirstStepOrderMultiElementsArrayTest(){
        quickMergeSort.setArrayToSort(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,21,20,22,19,18,23,25,24,26,28,27,30,29});
        quickMergeSort.firstStep(17,31,0);
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[3, 5, 6, 4, 1, 0, 2, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]");
    }

    @Test
    public void baseCompleteSortingTest(){
        quickMergeSort.setArrayToSort(new int[]{2,0,1,9,8});
        quickMergeSort.sort();
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[0, 1, 2, 8, 9]");
    }

    @Test
    public void LongArrayCompleteSortingTest(){
        quickMergeSort.setArrayToSort(new int[]{16,0,20,32,2,18,14,3,23,6,9,27,30,10,17,13,11,21,1,31,22,15,19,7,8,12,4,25,24,26,28,29,5});
        quickMergeSort.sort();
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32]");
    }

    @Test
    public void LongArrayWithRepetitionsCompleteSortingTest(){
        quickMergeSort.setArrayToSort(new int[]{16,0,11,32,2,18,14,3,23,11,10,0,30,10,17,13,11,21,1,31,22,15,19,7,8,30,4,25,24,26,1,29,5});
        quickMergeSort.sort();
        assertThat(Arrays.toString(quickMergeSort.getArray())).isEqualTo("[0, 0, 1, 1, 2, 3, 4, 5, 7, 8, 10, 10, 11, 11, 11, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 29, 30, 30, 31, 32]");
    }
}
