public class MergeSort implements SorterState {
    private int[] arrayToSort;
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
    }

    public int[] getArrayToSort() {
        return arrayToSort;
    }


}
