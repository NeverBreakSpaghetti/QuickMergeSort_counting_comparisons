import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ComparisonTesterTest {

    ComparisonTester comparisonTester = new ComparisonTester(new QuickMergeSort(),0);
    int nElements;
    int nArrays;
    SorterState sorterState;
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
        nElements=10000;
        comparisonTester.setNElements(nElements);
        int[] resultComparison = comparisonTester.countComparisonsSort();
        assertEquals(resultComparison.length, 1);
        assertThat(resultComparison[0]).isGreaterThan(nElements);
    }

    @Test
    public void comparisonsTwoArraysSortTest(){
        nElements=10000;
        nArrays = 2;
        comparisonTester.setNElements(nElements);
        comparisonTester.setNArrays(nArrays);

        int[] resultComparison = comparisonTester.countComparisonsSort();
        assertEquals(resultComparison.length, 2);

        for (int i=0; i<nArrays; i++)
            assertThat(resultComparison[i]).isGreaterThan(nElements);
    }

    @Test
    public void comparisonsMultiArraysSortTest(){
        nElements = 10000;
        nArrays = 1000;
        comparisonTester.setNElements(nElements);
        comparisonTester.setNArrays(nArrays);

        int[] resultComparison = comparisonTester.countComparisonsSort();
        assertEquals(resultComparison.length, nArrays);

        for (int i=0; i<nArrays; i++)
            assertThat(resultComparison[i]).isGreaterThan(nElements);
    }

    @Test
    public void setQuickMergeSortAsSorterStateTest(){
        sorterState = new QuickMergeSort();
        comparisonTester.setState(sorterState);
        assertThat(comparisonTester.getState()).isInstanceOf(QuickMergeSort.class);
    }

    @Test
    public void setQuickSortAsSorterStateTest(){
        sorterState = new QuickSort();
        comparisonTester.setState(sorterState);
        assertThat(comparisonTester.getState()).isInstanceOf(QuickSort.class);
    }

    @Test
    public void resetKeyComparisonsNumberEveryIterationQuickMergeSortTest(){
        nElements = 2;
        nArrays = 2;
        comparisonTester.setNElements(nElements);
        comparisonTester.setNArrays(nArrays);

        sorterState = new QuickMergeSort();
        comparisonTester.setState(sorterState);

        int[] comparisonsNumberArray = comparisonTester.countComparisonsSort();
        assertThat(comparisonsNumberArray[0]).isIn(2,3);
        assertThat(comparisonsNumberArray[1]).isIn(2,3);
    }

    @Test
    public void resetKeyComparisonsNumberEveryIterationQuickSortTest(){
        nElements = 2;
        nArrays = 2;
        comparisonTester.setNElements(nElements);
        comparisonTester.setNArrays(nArrays);

        sorterState = new QuickSort();
        comparisonTester.setState(sorterState);

        int[] comparisonsNumberArray = comparisonTester.countComparisonsSort();
        assertThat(comparisonsNumberArray[0]).isIn(2,3);
        assertThat(comparisonsNumberArray[1]).isIn(2,3);
    }

    @Test
    public void comparisonsSortingAlgorithmsNullListTest(){
        List<SorterState> sortingAlgorithmList = null;

        assertThat(comparisonTester.countComparisons(sortingAlgorithmList)).isNull();
    }
    @Test
    public void comparisonsSortingAlgorithmsEmptyListTest(){
        List<SorterState> sortingAlgorithmList = new ArrayList<>();

        int[][] comparisonsNumberArray = comparisonTester.countComparisons(sortingAlgorithmList);
        assertThat(comparisonsNumberArray.length).isEqualTo(0);
    }

    @Test
    public void comparisonsSortingAlgorithmsOneElementListTest(){
        nElements = 2;
        nArrays = 2;
        comparisonTester.setNElements(nElements);
        comparisonTester.setNArrays(nArrays);

        List<SorterState> sortingAlgorithmList = new ArrayList<>();
        sortingAlgorithmList.add(new QuickMergeSort());

        int[][] comparisonsNumberArray = comparisonTester.countComparisons(sortingAlgorithmList);

        assertThat(comparisonsNumberArray[0].length).isEqualTo(nArrays);
        assertThat(comparisonsNumberArray[0][0]).isIn(2,3);
        assertThat(comparisonsNumberArray[0][1]).isIn(2,3);
    }

    @Test
    public void comparisonsSortingAlgorithmsMultiElementsListTest(){
        nElements = 2;
        nArrays = 1;
        comparisonTester.setNElements(nElements);
        comparisonTester.setNArrays(nArrays);

        SorterState quickMergeSort = new QuickMergeSort();
        SorterState quickSort = new QuickSort();
        List<SorterState> sortingAlgorithmList = new ArrayList<>();
        sortingAlgorithmList.add(quickMergeSort);
        sortingAlgorithmList.add(quickSort);

        int[][] comparisonsNumberArray = comparisonTester.countComparisons(sortingAlgorithmList);

        assertThat(comparisonsNumberArray[0][0]).isIn(2,3);
        assertThat(comparisonsNumberArray[1][0]).isIn(2,3);
    }

    @Test
    public void comparisonsManySortingAlgorithmsMultiElementsListTest(){
        nElements = 5;
        nArrays = 20;
        comparisonTester.setNElements(nElements);
        comparisonTester.setNArrays(nArrays);
        boolean equalComparisonsNumber = true;

        List<SorterState> sortingAlgorithmList = new ArrayList<>();
        sortingAlgorithmList.add(new QuickMergeSort());
        sortingAlgorithmList.add(new QuickSort());
        sortingAlgorithmList.add(new MergeSort());
        sortingAlgorithmList.add(new HeapSort());
        sortingAlgorithmList.add(new InsertionSort());

        int[][] comparisonsNumberArray = comparisonTester.countComparisons(sortingAlgorithmList);

        int column = 1;
        int algorithmRow = 1;
        while( equalComparisonsNumber && column<nArrays ){
            while( equalComparisonsNumber && algorithmRow<sortingAlgorithmList.size() ){
                if( comparisonsNumberArray[algorithmRow-1][column] != comparisonsNumberArray[algorithmRow][column] )
                    equalComparisonsNumber=false;
                algorithmRow++;
            }
            column++;
        }

        assertFalse(equalComparisonsNumber);
    }
}
