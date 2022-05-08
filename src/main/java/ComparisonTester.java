import java.util.Random;

public class ComparisonTester {

    private int nElements=0;
    public ComparisonTester(int nElements) {
        this.nElements = nElements;
    }


    public int countComparisonsSort() {
        int[] array = new int[nElements];
        QuickMergeSort quickMergeSort=new QuickMergeSort(null);
        Random random = new Random();

        for (int i=0; i<nElements;i++) {
            array[i] = random.nextInt();
        }
        quickMergeSort.setArrayToSort(array);
        quickMergeSort.sort();
        return quickMergeSort.getKeysComparisonsNumber();
    }

    public void setNElements(int nElements) {
        this.nElements=nElements;
    }
}
