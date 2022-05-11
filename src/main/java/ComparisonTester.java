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
        int[] array = new int[nElements];
        Random random = new Random();

        for (int j=0; j<nArrays; j++) {
            for (int i = 0; i < nElements; i++)
                array[i] = random.nextInt();
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
}
