public class HeapSort implements SorterState {

    private int[] arrayToSort;

    @Override
    public int[] sort(int[] arrayToSort) {
        setArrayToSort(arrayToSort);
        heapSort();
        return getArray();
    }

    @Override
    public int getKeysComparisonsNumber() {
        return 0;
    }

    public void setArrayToSort(int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    public int[] getArray() {
        return arrayToSort;
    }

    public void heapify(int end) {
        if( arrayToSort != null ) {
            int nodePosition = end / 2 - 1;

            while ( nodePosition >= 0 ) {
                fixHeap(nodePosition,end);
                nodePosition--;
            }
        }
    }

    private void fixHeap(int nodePosition, int end) {
        boolean toPlace=true;
        int maxChildPosition = -1;

        do {
            maxChildPosition=getMaxChildPosition(nodePosition, end);
            if(maxChildPosition==-1)
                toPlace=false;
            else{
                if(arrayToSort[maxChildPosition]>arrayToSort[nodePosition]) {
                    swap(maxChildPosition, nodePosition);
                    nodePosition=maxChildPosition;
                }else
                    toPlace=false;
            }
        }while(toPlace);
    }

    private int getMaxChildPosition(int nodePosition, int end) {
        int leftChildPosition = 2*nodePosition+1;
        int rightChildPosition = 2*nodePosition+2;
        int maxChildPosition = -1;

        if (leftChildPosition < end) {
            maxChildPosition = leftChildPosition;
            if (rightChildPosition < end)
                if (arrayToSort[rightChildPosition] > arrayToSort[leftChildPosition])
                    maxChildPosition = rightChildPosition;
        }
        return maxChildPosition;
    }

    private void swap(int nodePosition, int maxChildPosition) {
        int temp = arrayToSort[nodePosition];
        arrayToSort[nodePosition] = arrayToSort[maxChildPosition];
        arrayToSort[maxChildPosition] = temp;
    }

    public void heapSort() {
        if ( arrayToSort!=null && arrayToSort.length>1 )
            for(int j=arrayToSort.length-1;j>=0;j--){
                swap(0,j);
                heapify(j);
            }
    }
}
