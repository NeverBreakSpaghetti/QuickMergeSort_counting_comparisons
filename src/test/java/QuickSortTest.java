import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QuickSortTest {

    @Test
    public void nullArraySortTest(){
        QuickSort quickSort = new QuickSort(null);
        assertThat(Arrays.toString(quickSort.sort())).isEqualTo("null");
    }

    @Test
    public void EmptyArraySortTest(){
        QuickSort quickSort = new QuickSort(new int[] {});
        assertThat(Arrays.toString(quickSort.sort())).isEqualTo("[]");
    }

    @Test
    public void oneElementArraySortTest(){
        QuickSort quickSort = new QuickSort(new int[] {1});
        assertThat(Arrays.toString(quickSort.sort())).isEqualTo("[1]");
    }
}
