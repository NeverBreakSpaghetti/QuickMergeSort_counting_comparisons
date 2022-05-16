public class HeapSort implements SorterState {

    private int[] arrayToSort;

    @Override
    public int[] sort(int[] ints) {
        return new int[0];
    }

    @Override
    public int getKeysComparisonsNumber() {
        return 0;
    }

    public void setArrayToSort(int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    public int[] getArray() {
        return arrayToSort;
    }

    public void heapify(int end) {
        if( arrayToSort != null ) {
            int nodePosition = end / 2 - 1;
            int leftChildPosition = nodePosition + 1;

            if (arrayToSort[nodePosition] <= arrayToSort[leftChildPosition]) {
                int temp = arrayToSort[nodePosition];
                arrayToSort[nodePosition] = arrayToSort[leftChildPosition];
                arrayToSort[leftChildPosition] = temp;
            }
        }
    }
}
