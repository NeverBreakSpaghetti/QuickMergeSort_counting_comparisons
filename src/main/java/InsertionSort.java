public class InsertionSort implements SorterState {
    @Override
    public int[] sort(int[] array) {
        if( array!=null && array.length>1 )
            if(array[0]>array[1]) {
                int temp = array[0];
                array[0] = array[1];
                array[1] = temp;
            }
        return array;
    }

    @Override
    public int getKeysComparisonsNumber() {
        return 0;
    }
}
