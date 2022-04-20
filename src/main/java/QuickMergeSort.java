public class QuickMergeSort {
    private int[] arrayToSort;
    public QuickMergeSort(int[] arrayToSort) {
        this.arrayToSort =arrayToSort;
    }

    public int[] sort() {
        partition();
        return arrayToSort;
    }

    int partition() {
        int pivotPosition=0;
        if ( (arrayToSort !=null) && (arrayToSort.length>1) ) {
            int pivot= arrayToSort[pivotPosition];
            int pointerLeft=pivotPosition;
            int pointerRight= arrayToSort.length;;
            while (pointerLeft<pointerRight) {
                /* scorro l'array da destra in cerca di un elemento inferiore o uguale al pivot  */
                do {
                    pointerRight--;
                } while (arrayToSort[pointerRight] > pivot);
                /* scorro l'array da sinistra in cerca di un elemento maggiore del pivot  */
                do {
                    pointerLeft++;
                } while ( (pointerLeft< arrayToSort.length) && (arrayToSort[pointerLeft] <= pivot) );
                /* se non ho controllato tutti gli elementi, scambia quelli puntati dai due puntatori */
                if (pointerLeft < pointerRight) {
                    swap(pointerLeft, pointerRight);
                }
            }
            /* l'ultimo elemento puntato dal puntatore destro sarà l'ultimo inferiore o uguale al perno.
            Lo scambio con questo in modo da avere un array con tutti gli elemnti inferiori o uguali al perno a sinistra di questo e tutti quelli maggiori alla sua destra */
            swap(pivotPosition,pointerRight);
            pivotPosition=pointerRight;
        }
        return pivotPosition;
    }

    private void swap(int pointer1, int pointer2) {
        int temp = arrayToSort[pointer1];
        arrayToSort[pointer1] = arrayToSort[pointer2];
        arrayToSort[pointer2] = temp;
    }

    public void setArrayToSort(int[] newArrayToSort) {
        this.arrayToSort =newArrayToSort;
    }

    public int[] getArray() {
        return arrayToSort;
    }

    public void merge(int begin1, int end1, int beginTarget, int endTarget) {
    }
}
