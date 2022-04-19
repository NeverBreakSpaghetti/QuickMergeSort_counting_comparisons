public class QuickMergeSort {
    private int[] arraytoSort;
    public QuickMergeSort(int[] arrayToSort) {
        this.arraytoSort=arrayToSort;
    }

    public int[] sort() {
        int temp=0;
        if ( (arraytoSort!=null) && (arraytoSort.length>1) && (arraytoSort[0]>arraytoSort[1]) ) {
            temp = arraytoSort[0];
            arraytoSort[0] = arraytoSort[1];
            arraytoSort[1] = temp;
        }
        return arraytoSort;
    }

    public void setArrayToSort(int[] newArrayToSort) {
        this.arraytoSort=newArrayToSort;
    }
}
