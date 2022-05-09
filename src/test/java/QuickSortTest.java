import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
}
