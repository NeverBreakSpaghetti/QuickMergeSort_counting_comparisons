public class QuickMergeSort {
    private int[] arrayToSort;
    public QuickMergeSort(int[] arrayToSort) {
        this.arrayToSort =arrayToSort;
    }

    public int[] sort() {
        if (arrayToSort != null) {
            int begin = 0;
            int end = arrayToSort.length;
            while (begin < end) {
                int pivotPosition = partition(begin, end);
                int nElements = end - begin;
                if (pivotPosition < nElements/2) {
                    firstStep(begin, pivotPosition, pivotPosition+1);
                    begin = pivotPosition + 1;
                } else {
                    firstStep(pivotPosition+1, end, begin);
                    end = pivotPosition;
                }
            }
        }
        return arrayToSort;
    }

    int partition(int begin, int end) {
        int pivotPosition = begin;
        int nElements = end - begin;
        if ( (arrayToSort != null) && (nElements > 1) ) {
            int pivot= arrayToSort[pivotPosition];
            int pointerLeft = pivotPosition;
            int pointerRight = end;;
            while ( pointerLeft < pointerRight ) {
                /* scorro l'array da destra in cerca di un elemento inferiore o uguale al pivot  */
                do {
                    pointerRight--;
                } while ( arrayToSort[pointerRight] > pivot );
                /* scorro l'array da sinistra in cerca di un elemento maggiore del pivot  */
                do {
                    pointerLeft++;
                } while ( (pointerLeft < end) && (arrayToSort[pointerLeft] <= pivot) );
                /* se non ho controllato tutti gli elementi, scambia quelli puntati dai due puntatori */
                if ( pointerLeft < pointerRight ) {
                    swap(pointerLeft, pointerRight);
                }
            }
            /* l'ultimo elemento puntato dal puntatore destro sarà l'ultimo inferiore o uguale al perno.
            Lo scambio con questo in modo da avere un array con tutti gli elemnti inferiori o uguali al perno a sinistra di questo e tutti quelli maggiori alla sua destra */
            swap(pivotPosition, pointerRight);
            pivotPosition = pointerRight;
        }
        return pivotPosition;
    }

    private void swap(int position1, int position2) {
        int temp = arrayToSort[position1];
        arrayToSort[position1] = arrayToSort[position2];
        arrayToSort[position2] = temp;
    }

    public void setArrayToSort(int[] newArrayToSort) {
        this.arrayToSort = newArrayToSort;
    }

    public int[] getArray() {
        return arrayToSort;
    }

    /* Il puntatore alla fine di ogni partizione punta alla posizione successiva dell'ultimo elemento */
    public void merge(int begin1, int end1, int beginTarget, int endTarget) {
        int i1 = begin1;
        int nElementi1 = end1 - begin1;
        int i2 = beginTarget + nElementi1;
        int positionResult = beginTarget;
        /* salvo il primo elemento puntato dal puntatore delle posizioni definitive */
        int temp = arrayToSort[positionResult];
        while ( (i1 != end1) && (i2 != endTarget) ) {
            int positionToPlace;
            if ( arrayToSort[i1] < arrayToSort[i2] ) {
                positionToPlace = i1;
                i1++;
            } else {
                positionToPlace = i2;
                i2++;
            }
            /* copio l'elemento minore tra le due partizioni nella sua posizione definitiva e salvo l'elemento nella posizione definitiva successiva
             * copiandolo nella posizione precendete dell'elemento posizionato definitivamente */
            arrayToSort[positionResult] = arrayToSort[positionToPlace];
            positionResult++;
            arrayToSort[positionToPlace] = arrayToSort[positionResult];
        }
        /* se non ho terminato di scorrere la partizione target non devo fare nulla perchè è quella corrispondente alle posizioni definitive ed è già ordinata.
         * se, invece, non ho terminato di scorrere la partizione 1 allora devo copiare tutti gli elementi rimasti di seguito agli altri nelle posizioni definitive */
        while ( i1 < end1 ) {
            arrayToSort[positionResult] = arrayToSort[i1];
            positionResult++;
            if ( positionResult<arrayToSort.length )
                /* come prima copio l'elemento nella sua posizione definitiva e salvo il successivo nella posizione precedente */
                arrayToSort[i1] = arrayToSort[positionResult];
            i1++;
        }
        /* ripristino il primo elemento puntato dal puntatore delle posizioni definitive salvato inizialmente in temp */
        arrayToSort[i1-1] = temp;
    }

    public void mergeSort(int begin, int end, int target) {
        int nElements = end - begin;
        if( nElements == 1 )
            swap(begin,target);
        else{
            int halfNElements = nElements/2;
            mergeSort(begin + halfNElements,end,target + halfNElements);
            mergeSort(begin,begin + halfNElements,begin + halfNElements);
            int end1 = begin + nElements;
            if( nElements%2 == 1 )
                end1 = end1-1;
            merge(begin + halfNElements, end1, target, target + nElements);
        }
    }

    public void firstStep(int begin, int end, int target) {
        int nElements = end - begin;
        if ( nElements > 1 ) {
            int leftHalfElements = nElements/2;
            int rightHalfElements = nElements - leftHalfElements;
            mergeSort(begin + leftHalfElements, end, target);
            mergeSort(begin, begin + leftHalfElements, begin + rightHalfElements);
            merge(target,target + rightHalfElements, begin, end);
        }
    }
}
