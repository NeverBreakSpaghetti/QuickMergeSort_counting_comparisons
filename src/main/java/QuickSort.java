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
                    temp = arrayToSort[leftPointer];
                    arrayToSort[leftPointer] = arrayToSort[righPointer];
                    arrayToSort[righPointer] = temp;
                }
            }
            temp = arrayToSort[pivotPosition];
            arrayToSort[pivotPosition] = arrayToSort[righPointer];
            arrayToSort[righPointer] = temp;
            pivotPosition = righPointer;
        }
        return pivotPosition;
    }
}
