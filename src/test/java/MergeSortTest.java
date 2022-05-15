import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class MergeSortTest {
    MergeSort mergeSort = new MergeSort();

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
        MergeSort mockMergeSort = mock(MergeSort.class);
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
        MergeSort mockMergeSort = mock(MergeSort.class);
        InOrder inOrder = inOrder(mockMergeSort);
        doCallRealMethod().when(mockMergeSort).setArrayToSort(any());
        doCallRealMethod().when(mockMergeSort).getArrayToSort();
        doCallRealMethod().when(mockMergeSort).mergeSort(anyInt(),anyInt());



        mockMergeSort.setArrayToSort(new int[]{3,1,2,5,4});
        inOrder.verify(mockMergeSort).setArrayToSort(any());

        mockMergeSort.mergeSort(0,5);
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

}
