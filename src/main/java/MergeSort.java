import java.util.Arrays;

public class MergeSort implements SorterState {
    private int[] arrayToSort;
    private int[] auxiliaryArray;
    private long keysComparisonsNumber;
    @Override
    public int[] sort(int[] arrayToSort) {
        setArrayToSort(arrayToSort);
        if ( arrayToSort != null )
            mergeSort(0,this.arrayToSort.length);
        return this.arrayToSort;
    }

    @Override
    public long getKeysComparisonsNumber() {
        return keysComparisonsNumber;
    }

    public void setArrayToSort(int[] arrayToSort) {
        keysComparisonsNumber=0;
        if ( arrayToSort != null ) {
            this.arrayToSort= Arrays.copyOf(arrayToSort,arrayToSort.length);
            auxiliaryArray = new int[this.arrayToSort.length];
        }
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
                keysComparisonsNumber++;
                auxiliaryArray[auxiliarI] = arrayToSort[i1];
                i1++;
            }else{
                keysComparisonsNumber++;
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
        for ( int j=0; j<end-begin1; j++)
            arrayToSort[begin1+j]=auxiliaryArray[j];
    }

    public void mergeSort(int begin, int end) {
        if ( end-begin > 1 ) {
            int half = (begin + end) / 2;
            mergeSort(begin, half);
            mergeSort(half, end);
            merge(begin,half,end);
        }
    }
}
