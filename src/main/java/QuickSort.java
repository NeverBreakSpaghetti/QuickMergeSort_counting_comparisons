public class QuickSort implements SorterState {
    private int[] arrayToSort;
    private int keysComparisonsNumber;
    public QuickSort(int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    public QuickSort() {
    }

    public int[] sort() {
        if(arrayToSort!= null)
            quickSort(0,arrayToSort.length);
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
                do {
                    righPointer--;
                    keysComparisonsNumber++;
                }while ( arrayToSort[righPointer] > pivot );
                do {
                    leftPointer++;
                    keysComparisonsNumber++;
                }while ( (leftPointer < end) && (arrayToSort[leftPointer] <= pivot) );
                if (leftPointer>=end) // sottraggo una comparazione nel caso in cui non vennga effettuata cioè quando il puntatore sinistro sfora il l'index bound dell'array
                    keysComparisonsNumber--;
                if ( leftPointer < righPointer ) {
                    swap(leftPointer,righPointer);
                }
            }
            swap(pivotPosition,righPointer);
            pivotPosition = righPointer;
        }
        return pivotPosition;
    }

    public void quickSort(int begin, int end) {
        while ( end-begin > 1 ){
            int pivotPosition = partition(begin,end);
            if( pivotPosition-begin < end-pivotPosition ){
                quickSort(begin,pivotPosition);
                begin = pivotPosition+1;
            }else{
                quickSort(pivotPosition+1,end);
                end=pivotPosition;
            }
        }
    }

    public int getKeysComparisonsNumber() {
        return keysComparisonsNumber;
    }

    @Override
    public int[] sort(int[] ints) {
        return null;
    }
}
