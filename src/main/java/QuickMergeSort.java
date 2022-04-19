public class QuickMergeSort {
    private int[] arraytoSort;
    public QuickMergeSort(int[] arrayToSort) {
        this.arraytoSort=arrayToSort;
    }

    public int[] sort() {
        if ( (arraytoSort!=null) && (arraytoSort.length>1) ) {
            int pointerLeft=0;
            int pivot=arraytoSort[pointerLeft];
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
                    int temp = arraytoSort[pointerLeft];
                    arraytoSort[pointerLeft] = arraytoSort[pointerRight];
                    arraytoSort[pointerRight] = temp;
                }
            }
            /* l'ultimo elemento puntato dal puntatore destro sarà l'ultimo inferiore o uguale al perno.
            Lo scambio con questo in modo da avere un array con tutti gli elemnti inferiori o uguali al perno a sinistra di questo e tutti quelli maggiori alla sua destra */
            arraytoSort[0] = arraytoSort[pointerRight];
            arraytoSort[pointerRight] = pivot;
        }
        return arraytoSort;
    }

    public void setArrayToSort(int[] newArrayToSort) {
        this.arraytoSort=newArrayToSort;
    }
}
