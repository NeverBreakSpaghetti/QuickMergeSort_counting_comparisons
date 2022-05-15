import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

}
