import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InsertionSortTest {

    @Test
    public void getKeysComparisonsNumberSorterStateTest(){
        SorterState insertionSort = new InsertionSort();

        assertThat(insertionSort.getKeysComparisonsNumber()).isEqualTo(0);
    }

    @Test
    public void emptyArraySortTest(){
        SorterState insertionSort = new InsertionSort();

        assertThat(Arrays.toString(insertionSort.sort(new int[]{}))).isEqualTo("[]");
    }

    @Test
    public void nullArraySortTest(){
        SorterState insertionSort = new InsertionSort();

        assertThat(insertionSort.sort(null)).isEqualTo(null);
    }

    @Test
    public void oneElementArraySortTest(){
        SorterState insertionSort = new InsertionSort();

        assertThat(Arrays.toString(insertionSort.sort(new int[]{1}))).isEqualTo("[1]");
    }

    @Test
    public void twoElementsArraySortTest(){
        SorterState insertionSort = new InsertionSort();

        assertThat(Arrays.toString(insertionSort.sort(new int[]{2,1}))).isEqualTo("[1, 2]");
    }

    @Test
    public void threeElementsArraySortTest(){
        SorterState insertionSort = new InsertionSort();

        assertThat(Arrays.toString(insertionSort.sort(new int[]{2,3,1}))).isEqualTo("[1, 2, 3]");
    }
}
