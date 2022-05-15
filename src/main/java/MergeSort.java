public class MergeSort implements SorterState {
    private int[] arrayToSort;
    private int[] auxiliaryArray;
    @Override
    public int[] sort(int[] arrayToSort) {
        return arrayToSort;
    }

    @Override
    public int getKeysComparisonsNumber() {
        return -1;
    }

    public void setArrayToSort(int[] arrayToSort) {
        this.arrayToSort=arrayToSort;
        if ( arrayToSort != null )
            auxiliaryArray = new int[arrayToSort.length];
    }

    public int[] getArrayToSort() {
        return arrayToSort;
    }


    public int[] getAuxiliaryArray() {
        return auxiliaryArray;
    }

    public void merge(int begin1, int begin2, int end) {
        int i1 = begin1;
        int i2 = begin2;
        int auxiliarI = 0;
        while ( i1<begin2 && i2<end ){
            if( arrayToSort[i1] <= arrayToSort[i2] ){
                auxiliaryArray[auxiliarI] = arrayToSort[i1];
                i1++;
            }else{
                auxiliaryArray[auxiliarI] = arrayToSort[i2];
                i2++;
            }
            auxiliarI++;
        }
        if ( i1<begin2 )
            while ( i1 < begin2 ) {
                auxiliaryArray[auxiliarI] = arrayToSort[i1];
                i1++;
                auxiliarI++;
            }
        else
            while ( i2 < end ) {
                auxiliaryArray[auxiliarI] = arrayToSort[i2];
                i2++;
                auxiliarI++;
            }
    }
}
