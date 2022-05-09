public class QuickSort {
    private int[] arrayToSort;
    public QuickSort(int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    public int[] sort() {
        int temp;
        if(arrayToSort!= null && arrayToSort.length>1 && arrayToSort[0]>arrayToSort[1]) {
            temp = arrayToSort[0];
            arrayToSort[0] = arrayToSort[1];
            arrayToSort[1] = temp;
        }
        return arrayToSort;
    }

    public void setArrayToSort(int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    public int[] getArray() {
        return arrayToSort;
    }

    private void swap(int position1, int position2) {
        int temp = arrayToSort[position1];
        arrayToSort[position1] = arrayToSort[position2];
        arrayToSort[position2] = temp;
    }

    public int partition(int begin, int end) {
        int pivotPosition=begin;
        int pivot=0;
        int temp;
        if(arrayToSort!= null && arrayToSort.length>1) {
            pivot= arrayToSort[pivotPosition];
            int leftPointer = pivotPosition;
            int righPointer = end;
            while ( leftPointer < righPointer ) {
                do
                    righPointer--;
                while ( arrayToSort[righPointer] > pivot );
                do
                    leftPointer++;
                while ( (leftPointer < end) && (arrayToSort[leftPointer] <= pivot) );
                if ( leftPointer < righPointer ) {
                    swap(leftPointer,righPointer);
                }
            }
            swap(pivotPosition,righPointer);
            pivotPosition = righPointer;
        }
        return pivotPosition;
    }
}
