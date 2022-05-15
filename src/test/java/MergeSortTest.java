import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class MergeSortTest {
    SorterState mergeSort = new MergeSort();

    @Test
    public void emptyArraySortTest(){
        assertThat(Arrays.toString(mergeSort.sort(new int[]{}))).isEqualTo("[]");
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
        MergeSort mergeSort2 = new MergeSort();
        mergeSort2.setArrayToSort(new int[]{3,2});

        assertThat(Arrays.toString(mergeSort2.getArrayToSort())).isEqualTo("[3, 2]");
    }

}
