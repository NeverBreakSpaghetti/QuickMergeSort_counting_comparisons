import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ComparisonTesterTest {

    ComparisonTester comparisonTester = new ComparisonTester(new QuickMergeSort(),0);
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
        assertThat(comparisonTester.countComparisonsSort()[0]).isIn(2,3);
    }

    @Test
    public void comparisonsNegativeNumberElementsArraySortTest(){
        assertThrows(IllegalArgumentException.class, () -> new ComparisonTester(new QuickMergeSort(), -3));
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

    @Test
    public void comparisonsMultiArraysSortTest(){
        int nElements = 10000;
        int nArrays = 1000;
        comparisonTester.setNElements(nElements);
        comparisonTester.setNArrays(nArrays);

        int[] resultComparison = comparisonTester.countComparisonsSort();
        assertEquals(resultComparison.length, nArrays);

        for (int i=0; i<nArrays; i++)
            assertThat(resultComparison[i]).isGreaterThan(nElements);
    }

    @Test
    public void setQuickMergeSortAsSorterStateTest(){
        SorterState sorterState = new QuickMergeSort();
        comparisonTester.setState(sorterState);
        assertThat(comparisonTester.getState()).isInstanceOf(QuickMergeSort.class);
    }

    @Test
    public void setQuickSortAsSorterStateTest(){
        SorterState sorterState = new QuickSort();
        comparisonTester.setState(sorterState);
        assertThat(comparisonTester.getState()).isInstanceOf(QuickSort.class);
    }

    @Test
    public void resetKeyComparisonsNumberEveryIterationTest(){
        int nElements = 2;
        int nArrays = 2;
        comparisonTester.setNElements(nElements);
        comparisonTester.setNArrays(nArrays);

        SorterState sorterState = new QuickMergeSort();
        comparisonTester.setState(sorterState);

        int[] comparisonsNumberArray = comparisonTester.countComparisonsSort();
        assertThat(comparisonsNumberArray[0]).isIn(2,3);
        assertThat(comparisonsNumberArray[1]).isIn(2,3);
    }

    @Test
    public void resetKeyComparisonsNumberEveryIterationQuickSortTest(){
        int nElements = 2;
        int nArrays = 2;
        comparisonTester.setNElements(nElements);
        comparisonTester.setNArrays(nArrays);

        SorterState sorterState = new QuickSort();
        comparisonTester.setState(sorterState);

        int[] comparisonsNumberArray = comparisonTester.countComparisonsSort();
        assertThat(comparisonsNumberArray[0]).isIn(2,3);
        assertThat(comparisonsNumberArray[1]).isIn(2,3);
    }
}
