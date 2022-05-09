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

    public int partition(int i, int i1) {
        int pivot=i;
        int temp;
        if(arrayToSort!= null && arrayToSort.length>1 && arrayToSort[pivot]>arrayToSort[1]) {
            temp = arrayToSort[pivot];
            arrayToSort[pivot] = arrayToSort[1];
            arrayToSort[1] = temp;
            pivot=1;
        }

        return pivot;
    }
}
