import java.util.Arrays;

public class InsertionSort implements SorterState {
    @Override
    public int[] sort(int[] array) {
        int[] arrayToSort = array;
        if( array!=null && array.length>1 ) {
            arrayToSort = Arrays.copyOf(array, array.length);
            for (int i = 1; i < arrayToSort.length; i++) {
                int elementToOrder = arrayToSort[i];
                int j = i - 1;
                while (j >= 0 && arrayToSort[j] > elementToOrder) {
                    arrayToSort[j + 1] = arrayToSort[j];
                    j--;
                }
                arrayToSort[j + 1] = elementToOrder;
            }
        }
        return arrayToSort;
    }

    @Override
    public int getKeysComparisonsNumber() {
        return 0;
    }
}
