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
}
