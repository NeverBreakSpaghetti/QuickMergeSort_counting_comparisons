public class QuickMergeSort {
    private int[] arraytoSort;
    public QuickMergeSort(int[] arrayToSort) {
        this.arraytoSort=arrayToSort;
    }

    public int[] sort() {
        return arraytoSort;
    }

    public void setArrayToSort(int[] newArrayToSort) {
        this.arraytoSort=newArrayToSort;
    }
}
