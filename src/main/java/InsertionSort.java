import java.util.Arrays;

public class InsertionSort implements SorterState {

    private long keysComparisonsNumber;

    @Override
    public int[] sort(int[] array) {
        keysComparisonsNumber=0;
        int[] arrayToSort = array;
        if( array!=null && array.length>1 ) {
            arrayToSort = Arrays.copyOf(array, array.length);
            for (int i = 1; i < arrayToSort.length; i++) {
                int elementToOrder = arrayToSort[i];
                int j = i - 1;
                keysComparisonsNumber++;
                while (j >= 0 && arrayToSort[j] > elementToOrder) {
                    keysComparisonsNumber++;
                    arrayToSort[j + 1] = arrayToSort[j];
                    j--;
                }
                if(j<0)
                    keysComparisonsNumber--;
                arrayToSort[j + 1] = elementToOrder;
            }
        }
        return arrayToSort;
    }

    @Override
    public long getKeysComparisonsNumber() {
        return keysComparisonsNumber;
    }
}
