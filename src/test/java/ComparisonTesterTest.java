import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComparisonTesterTest {

    ComparisonTester comparisonTester = new ComparisonTester(0);
    @Test
    public void comparisonsZeroElementsArraySortTest(){
        assertThat(comparisonTester.countComparisonsSort()[0]).isEqualTo(0);
    }

    @Test
    public void comparisonsOneElementArraySortTest(){
        comparisonTester.setNElements(1);
        assertThat(comparisonTester.countComparisonsSort()[0]).isEqualTo(0);
    }

    @Test
    public void comparisonsTwoElementsArraySortTest(){
        comparisonTester.setNElements(2);
        assertThat(comparisonTester.countComparisonsSort()[0]).isEqualTo(3);
    }

    @Test
    public void comparisonsNegativeNumberElementsArraySortTest(){
        assertThrows(IllegalArgumentException.class, () -> new ComparisonTester(-3));
        assertThrows(IllegalArgumentException.class, () -> comparisonTester.setNElements(-5));
    }

    @Test
    public void comparisonsMultiElementsArraySortTest(){
        int nElements=10000;
        comparisonTester.setNElements(nElements);
        int[] resultComparison = comparisonTester.countComparisonsSort();
        assertEquals(resultComparison.length, 1);
        assertThat(resultComparison[0]).isGreaterThan(nElements);
    }

    @Test
    public void comparisonsTwoArraysSortTest(){
        int nElements=10000;
        int nArrays = 2;
        comparisonTester.setNElements(nElements);
        comparisonTester.setNArrays(nArrays);

        int[] resultComparison = comparisonTester.countComparisonsSort();
        assertEquals(resultComparison.length, 2);

        for (int i=0; i<nArrays; i++)
            assertThat(resultComparison[i]).isGreaterThan(nElements);

    }
}
