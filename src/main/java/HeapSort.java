public class HeapSort implements SorterState {

    private int[] arrayToSort;

    @Override
    public int[] sort(int[] ints) {
        return new int[0];
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
            int maxChildPosition = -1;
            int nodeToChackPosition;
            boolean toPlace=true;

            while ( nodePosition >= 0 ) {
                toPlace=true;
                nodeToChackPosition=nodePosition;
                do {
                    maxChildPosition=getMaxChildPosition(nodeToChackPosition, end);
                    if(maxChildPosition==-1)
                        toPlace=false;
                    else{
                        if(arrayToSort[maxChildPosition]>arrayToSort[nodeToChackPosition]) {
                            swap(maxChildPosition, nodeToChackPosition);
                            nodeToChackPosition=maxChildPosition;
                        }else
                            toPlace=false;
                    }
                }while(toPlace);
                nodePosition--;
            }
        }
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
}
