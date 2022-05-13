public class InsertionSort implements SorterState {
    @Override
    public int[] sort(int[] array) {
        if( array!=null && array.length>1 )
            for (int i=1; i<array.length; i++){
                int elementToOrder = array[i];
                int j = i-1;
                while ( j>=0 && array[j]>elementToOrder ){
                    array[j+1] = array[j];
                    j--;
                }
                array[j+1] = elementToOrder;
            }
        return array;
    }

    @Override
    public int getKeysComparisonsNumber() {
        return 0;
    }
}
