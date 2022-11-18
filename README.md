# QuickMergesort
[![coverage](https://img.shields.io/badge/coverage-100%25-brightgreen)](src/test/java)
[![license](https://img.shields.io/badge/license-MIT-blue)](LICENSE)

Questo lavoro si concentra sull'**implementazione** dell'algortimo di ordinamento **QuickMergesort** e il suo **confronto** in termini di _numero di confronti_ con altri algoritmi quali: Quicksort, Mergesort, Heapsort ed Insertionsort.

L'algoritmo di ordinamento QuickMergesort è stato presentato nei paper:
- "[Quickmergesort: Practically efficient constant-factor optimal sorting](https://arxiv.org/abs/1804.10062)" di Stefan Edelkamp e Armin Weiß (2018).
- "[QuickXsort: A Fast Sorting Scheme in Theory and Practice](https://link.springer.com/article/10.1007/s00453-019-00634-0)" di Stefan Edelkamp, Armin Weiß e Sebastian Wild (2019).

### Funzionamento di base

Il suddetto algoritmo è derivato dalla combinazione degli algoritmi Quicksort e Mergesort.
L’idea alla base del suo funzionamento è che:
1. viene applicato il **partizionamento** del Quicksort alla sequenza da ordinare. Si
ottiene la divisione della sequenza iniziale in **due sottosequenza**;
2. una sottosequenza viene ordinata tramite l’algoritmo **Mergesort**;
3. l’altra viene ordinata ricorsivamente applicando **ricorsivamente** l’algoritmo **QuickMergesort**.

Il vantaggio di questa tecnica è che consente di ordinare _**in place**_ nonostante l'utilizzo del Mergesort.
Questo è possibile perchè mentre viene ordinata una porzione tramite il Mergesort l'altra può essere utilizzata come spazio di memoria temporano.
Anziché collocare il risultato del *merge* su uno spazio di memoria extra, lo si colloca nella
porzione adibita a memoria temporanea scambiando gli elementi di posizione.

### Struttura

Il progetto è composto dalle implementazioni degli algoritmi di ordinamento:
- [QuickMergesort](src/main/java/QuickMergeSort.java)
- [Quicksort](src/main/java/QuickSort.java)
- [Mergesort](src/main/java/MergeSort.java)
- [Heapsort](src/main/java/HeapSort.java)
- [Insertionsort](src/main/java/InsertionSort.java)

Un'interfaccia comune implementata da tutti gli algoritmi di ordinamento ed utilizzata per lo [*strategy pattern*](https://refactoring.guru/design-patterns/strategy):
- [SorterState](src/main/java/SorterState.java)

Una classe adibita ad effettuare la sperimentazione e che aggreghi i SorterState.
La sperimentazione corrisponde alla generazione di array di interi randomici e l'ordinamento dei medesimi array tramite i vari algoritmi di ordinamento in modo da ottenere i relativi numeri di confronti.
- [ComparisonTester](src/main/java/ComparisonTester.java)

Una classe per l'esportazione dei risultati in formato *csv*:
- [Exporter](src/main/java/Exporter.java)

### Utilizzo

Per l'utilizzo è necesario:
- la lista degli algoritmi di ordinamento di cui si vuole comparare il numero di comparazioni
- il numero di array da ordinare
- il numero di elementi casuali di ciascun array
- istanziare un oggetto ComparisonTester
- settare il numero di array da far generare all'oggetto ComparisonTester
- istanzare un oggetto Exporter per esportare i risultati in csv
```Java
public class Client {  
    public static void main (String[] args){  
        List<SorterState> sorterStateList = new ArrayList<>();  
        sorterStateList.add(new QuickMergeSort());  
        sorterStateList.add(new QuickSort());  
        sorterStateList.add(new MergeSort());  
        sorterStateList.add(new HeapSort());  
        
        int nArray = 10000; 
        int nElements = 10000;  
          
        ComparisonTester comparisonTester = new ComparisonTester(new QuickMergeSort(),nElements);  
        comparisonTester.setNArrays(nArray);  
        long[][]comparisonsResults = comparisonTester.countComparisons(sorterStateList);
        
        String filename = nArray + "ArrayOf" + nkElements + "Elements.csv";  
        Exporter exporter = new Exporter();  
        exporter.export(filename,sorterStateList,comparisonsResults);  
    }  
}
```

### Miglioramenti da apportare

- Modificare il costruttore di ComparisonTester in modo da non accettare parametri in input ed esplicitare le assegnazioni dei paramentri tramite dei metodi _set_.
```java
int nArray = 10000;
int nElements = 10000;    
  
ComparisonTester comparisonTester = new ComparisonTester();  
comparisonTester.setNArrays(nArray);
comparisonTester.setNElements(nElements);

List<SorterState> sorterStateList = new ArrayList<>();  
sorterStateList.add(new QuickMergeSort());

long[][]comparisonsResults = comparisonTester.countComparisons(sorterStateList);  
```

- Rifattorizzare introducendo gli _early returnament_ in modo da rispettare la regola "_Don’t use the ELSE keyword_" e ridurre il livello di indentazione in modo da avvicinarsi alla regola "_Use One Level of Indentation per Method_" entrambe relative all'_**Object Calisthenics**_ presentato da _Jeff Bay_ in "_The Thoughtworks Anthology: Essays on Software Technology and Innovation_" (2008).

Esempio da:
```Java
public void export(String filename, List<SorterState> sortingAlgorithmList, long[][] comparisonsArray) {
	if(filename!=null && sortingAlgorithmList!=null && comparisonsArray!=null) {
		try {
			PrintWriter printWriter = new PrintWriter(filename);
			printWriter.write(...);	
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException was thrown");
		}
	}
}
```
a
```Java
public void export(String filename, List<SorterState> sortingAlgorithmList, long[][] comparisonsArray) {
	if(filename==null || sortingAlgorithmList==null || comparisonsArray==null)
		return;
	try {
		PrintWriter printWriter = new PrintWriter(filename);
		printWriter.write(...);	
		printWriter.close();
	} catch (FileNotFoundException e) {
		System.err.println("FileNotFoundException was thrown");
	}
}
```

Oppure da:
```Java
public long[][] countComparisons(List<SorterState> sortingAlgorithmList) {
	long[][] resultComparisonsNumberBySorter = null;
	int[] array;
	
	if ( sortingAlgorithmList != null ) {
		resultComparisonsNumberBySorter = new long[sortingAlgorithmList.size()][nArrays];
		if ( sortingAlgorithmList.size() > 0 ) {
			for (int i = 0; i < nArrays; i++) {
				array = createRandomArray(nElements);
				for (int a = 0; a < sortingAlgorithmList.size(); a++ ) {
					sortingAlgorithmList.get(a).sort(array);
					resultComparisonsNumberBySorter[a][i] = sortingAlgorithmList.get(a).getKeysComparisonsNumber();
				}
			}
		}
	}
	return resultComparisonsNumberBySorter;
}
```
a:
```Java
public long[][] countComparisons(List<SorterState> sortingAlgorithmList) {
	long[][] resultComparisonsNumberBySorter = null;
	int[] array;
	
	if ( sortingAlgorithmList == null || sortingAlgorithmList.size() == 0)
		return null;
		
	resultComparisonsNumberBySorter = new long[sortingAlgorithmList.size()][nArrays];
	for (int i = 0; i < nArrays; i++) {
		array = createRandomArray(nElements);
		for (int a = 0; a < sortingAlgorithmList.size(); a++ ) {
			sortingAlgorithmList.get(a).sort(array);
			resultComparisonsNumberBySorter[a][i] = sortingAlgorithmList.get(a).getKeysComparisonsNumber();
		}
	}
	return resultComparisonsNumberBySorter;
}
```

- Estrarre dalle funzioni degli algoritmi di ordinamento il confronto tra chiavi in modo da avere un unico punto dove aumentare il conteggio dei confronti e ridurre le ripetizioni (_DRY principle_).
- Rifattorizzazione per ridurre il numero di parametri in input dalle varie funzioni.
- Aggiungere una classe astratta che reappresenti gli algoritmi di ordinamento che venga estesa dalle varie classi concrete già presenti.
  Sarà la classe altratta ad implementare l'interfaccia SorterState.
- Renaming dell'interfaccia SorterState in SorterStrategy.
