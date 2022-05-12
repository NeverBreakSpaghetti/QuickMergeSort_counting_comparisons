import java.util.List;
import java.util.Random;

public class ComparisonTester {

    public static final String NEGATIVE_NUMBER_ELEMENT_EXCEPTION = "Negative number of elements not allowed";
    private int nElements = 0;
    private int nArrays = 1;
    private SorterState sorterState;
    public ComparisonTester(SorterState sorterState, int nElements) {
        if (nElements < 0)
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ELEMENT_EXCEPTION);
        else
            this.nElements = nElements;
        this.sorterState=sorterState;
    }


    public int[] countComparisonsSort() {
        int[] resultNumbersComparisons = new int[nArrays];
        int[] array;

        for (int j=0; j<nArrays; j++) {
            array = createRandomArray(nElements);
            sorterState.sort(array);
            resultNumbersComparisons[j] = sorterState.getKeysComparisonsNumber();
        }
        return resultNumbersComparisons;
    }

    public void setNElements(int nElements) {
        if (nElements < 0)
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ELEMENT_EXCEPTION);
        else
            this.nElements=nElements;
    }

    public void setNArrays(int nArrays) {
        this.nArrays=nArrays;
    }

    public void setState(SorterState sorterState) {
        this.sorterState = sorterState;
    }

    public SorterState getState() {
        return sorterState;
    }

    public int[][] countComparisons(List<SorterState> sortingAlgorithmList) {
        int[][] resultComparisonsNumberBySorter =  null;
        int[] array;

        if ( sortingAlgorithmList != null ) {
            resultComparisonsNumberBySorter = new int[sortingAlgorithmList.size()][nArrays];
            if ( sortingAlgorithmList.size() > 0 ) {
                for (int i = 0; i < nArrays; i++) {
                    array = createRandomArray(nElements);
                    for (int a = 0; a < sortingAlgorithmList.size(); a++ ) {
                        sortingAlgorithmList.get(a).sort(array);
                        resultComparisonsNumberBySorter[a][i] = sortingAlgorithmList.get(0).getKeysComparisonsNumber();
                    }
                }
            }
        }
        return resultComparisonsNumberBySorter;
    }

    private int[] createRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++)
            array[i] = random.nextInt();
        return array;
    }
}
