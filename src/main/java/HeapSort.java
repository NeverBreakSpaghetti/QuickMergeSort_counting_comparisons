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
            int rightChildPosition = nodePosition + 2;
            int maxChildPosition = -1;

            if (leftChildPosition < end) {
                maxChildPosition = leftChildPosition;
                if (rightChildPosition < end)
                    if (arrayToSort[rightChildPosition] > arrayToSort[leftChildPosition])
                        maxChildPosition = rightChildPosition;
            }
            if (arrayToSort[nodePosition] <= arrayToSort[maxChildPosition]) {
                int temp = arrayToSort[nodePosition];
                arrayToSort[nodePosition] = arrayToSort[maxChildPosition];
                arrayToSort[maxChildPosition] = temp;
            }
        }
    }
}
