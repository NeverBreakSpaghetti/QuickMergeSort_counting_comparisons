import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HeapSortTest {
    @Test
    public void getKeysComparisonsNumberSorterStateTest(){
        SorterState heapSortSorterState = new HeapSort();
        assertThat(heapSortSorterState.getKeysComparisonsNumber()).isEqualTo(0);
    }
}
