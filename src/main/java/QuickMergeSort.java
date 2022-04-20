public class QuickMergeSort {
    private int[] arraytoSort;
    public QuickMergeSort(int[] arrayToSort) {
        this.arraytoSort=arrayToSort;
    }

    public int[] sort() {
        partition();
        return arraytoSort;
    }

    private int partition() {
        int pivotPosition=0;
        if ( (arraytoSort!=null) && (arraytoSort.length>1) ) {
            int pivot=arraytoSort[pivotPosition];
            int pointerLeft=pivotPosition;
            int pointerRight= arraytoSort.length;;
            while (pointerLeft<pointerRight) {
                /* scorro l'array da destra in cerca di un elemento inferiore o uguale al pivot  */
                do {
                    pointerRight--;
                } while (arraytoSort[pointerRight] > pivot);
                /* scorro l'array da sinistra in cerca di un elemento maggiore del pivot  */
                do {
                    pointerLeft++;
                } while ( (pointerLeft<arraytoSort.length) && (arraytoSort[pointerLeft] <= pivot) );
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
        int temp = arraytoSort[pointer1];
        arraytoSort[pointer1] = arraytoSort[pointer2];
        arraytoSort[pointer2] = temp;
    }

    public void setArrayToSort(int[] newArrayToSort) {
        this.arraytoSort=newArrayToSort;
    }
}
