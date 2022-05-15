public class MergeSort implements SorterState {
    private int[] arrayToSort;
    private int[] auxiliaryArray;
    @Override
    public int[] sort(int[] arrayToSort) {
        return arrayToSort;
    }

    @Override
    public int getKeysComparisonsNumber() {
        return -1;
    }

    public void setArrayToSort(int[] arrayToSort) {
        this.arrayToSort=arrayToSort;
        if ( arrayToSort != null )
            auxiliaryArray = new int[arrayToSort.length];
    }

    public int[] getArrayToSort() {
        return arrayToSort;
    }


    public int[] getAuxiliaryArray() {
        return auxiliaryArray;
    }

    public void merge(int i1, int i2, int n) {
    }
}
