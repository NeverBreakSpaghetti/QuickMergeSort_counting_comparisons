import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InsertionSortTest {
    SorterState insertionSort = new InsertionSort();

    @Test
    public void getKeysComparisonsNumberSorterStateTest(){
        assertThat(insertionSort.getKeysComparisonsNumber()).isEqualTo(0);
    }

    @Test
    public void emptyArraySortTest(){
        assertThat(Arrays.toString(insertionSort.sort(new int[]{}))).isEqualTo("[]");
    }

    @Test
    public void nullArraySortTest(){
        assertThat(insertionSort.sort(null)).isEqualTo(null);
    }

    @Test
    public void oneElementArraySortTest(){
        assertThat(Arrays.toString(insertionSort.sort(new int[]{1}))).isEqualTo("[1]");
    }

    @Test
    public void twoElementsArraySortTest(){
        assertThat(Arrays.toString(insertionSort.sort(new int[]{2,1}))).isEqualTo("[1, 2]");
    }

    @Test
    public void threeElementsArraySortTest(){
        assertThat(Arrays.toString(insertionSort.sort(new int[]{2,3,1}))).isEqualTo("[1, 2, 3]");
    }

    @Test
    public void multiElementsArraySortTest(){
        assertThat(Arrays.toString(insertionSort.sort(new int[]{2,7,5,4,3,6,8,1,9}))).isEqualTo("[1, 2, 3, 4, 5, 6, 7, 8, 9]");
    }

    @Test
    public void notEditInputArrayTest(){
        int[] inputArray = new int[]{6,8,7};

        assertThat(Arrays.toString(insertionSort.sort(inputArray))).isEqualTo("[6, 7, 8]");

        assertThat(Arrays.toString(inputArray)).isEqualTo("[6, 8, 7]");
    }

    @Test
    public void contComparisonsNullArrayTest(){
        insertionSort.sort(null);

        assertThat(insertionSort.getKeysComparisonsNumber()).isEqualTo(0);
    }

    @Test
    public void contComparisonsEmptyArrayTest(){
        insertionSort.sort(new int[]{});

        assertThat(insertionSort.getKeysComparisonsNumber()).isEqualTo(0);
    }

    @Test
    public void contComparisonsOneElementArrayTest(){
        insertionSort.sort(new int[]{1});

        assertThat(insertionSort.getKeysComparisonsNumber()).isEqualTo(0);
    }

    @Test
    public void contComparisonsTwoElementArrayTest(){
        insertionSort.sort(new int[]{3,2});

        assertThat(insertionSort.getKeysComparisonsNumber()).isEqualTo(1);
    }
}
