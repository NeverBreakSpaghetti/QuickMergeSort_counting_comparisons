import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExporterTest {
    Exporter exporter = new Exporter();

    @Test
    public void emptyArrayConvertToCSVRowTest(){
        String stringToConvert = Arrays.toString(new int[]{});

        assertThat(exporter.convertToCSVRow(stringToConvert)).isEqualTo("");
    }

    @Test
    public void singleElementArrayConvertToCSVRowTest(){
        String stringToConvert = Arrays.toString(new int[]{1});

        assertThat(exporter.convertToCSVRow(stringToConvert)).isEqualTo("1");
    }

    @Test
    public void twoElementArrayConvertToCSVRowTest(){
        String stringToConvert = Arrays.toString(new int[]{1,2});

        assertThat(exporter.convertToCSVRow(stringToConvert)).isEqualTo("1,2");
    }

    @Test
    public void threeElementArrayConvertToCSVRowTest(){
        String stringToConvert = Arrays.toString(new int[]{1,2,3});

        assertThat(exporter.convertToCSVRow(stringToConvert)).isEqualTo("1,2,3");
    }

    @Test
    public void comparisonsOneSortingAlgorithmConvertToCSVRowToTest(){
        long[][] comparisonsArray = new long[][]{{3,4,9}};
        List<SorterState> sortingAlgorithmList = new ArrayList<>();
        sortingAlgorithmList.add(new QuickMergeSort());

        assertThat(exporter.convertComparisonsBySortingAlgorithm(sortingAlgorithmList,comparisonsArray)).isEqualTo("\"QuickMergeSort\",3,4,9");
    }

    @Test
    public void comparisonsSortingAlgorithmsConvertToCSVRowToTest(){
        long[][] comparisonsArray = new long[][]{{3,4,9},{7,3,5}};
        List<SorterState> sortingAlgorithmList = new ArrayList<>();
        sortingAlgorithmList.add(new QuickMergeSort());
        sortingAlgorithmList.add(new QuickSort());

        assertThat(exporter.convertComparisonsBySortingAlgorithm(sortingAlgorithmList,comparisonsArray)).isEqualTo("\"QuickMergeSort\",3,4,9\n\"QuickSort\",7,3,5");
    }

    @Test
    public void createEmptyCSVTest(){
        long[][] comparisonsArray= new long[][]{};
        List<SorterState> sortingAlgorithmList = new ArrayList<>();

        String fileName = "test.csv";
        File fileCSV = new File(fileName);
        exporter.export(fileName,sortingAlgorithmList,comparisonsArray);

        assertTrue(fileCSV.exists());
        fileCSV.delete();
    }

    @Test
    public void createNullCSVTest(){
        String fileName = "test2.csv";
        File fileCSV = new File(fileName);

        exporter.export(fileName,null,null);

        assertTrue(!fileCSV.exists());
    }

    @Test
    public void changeSeparatorTest(){
        long[][] comparisonsArray = new long[][]{{3,4,9}};
        List<SorterState> sortingAlgorithmList = new ArrayList<>();
        sortingAlgorithmList.add(new QuickMergeSort());

        exporter.setSeparator(";");

        assertThat(exporter.convertComparisonsBySortingAlgorithm(sortingAlgorithmList,comparisonsArray)).isEqualTo("\"QuickMergeSort\";3;4;9");
        exporter.setSeparator(",");
    }@Test
    public void createNotEmptyCSVTest() {
        String fileName = "test3.csv";
        List<SorterState> sortingAlgorithmList = new ArrayList<>();
        sortingAlgorithmList.add(new QuickMergeSort());
        sortingAlgorithmList.add(new QuickSort());
        long[][] dummyComparisonsNumberArray = new long[][]{{2,6},{8,1}};

        exporter.export(fileName,sortingAlgorithmList,dummyComparisonsNumberArray);

        List<List<String>> records = new ArrayList<List<String>>();
        try {
            CSVReader csvReader = new CSVReader(new FileReader(fileName));
            String[] values = null;
            while ((values = csvReader.readNext()) != null)
                records.add(Arrays.asList(values));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        assertThat(records.get(0).get(0)).isEqualTo("QuickMergeSort");
        assertThat(records.get(0).get(1)).isEqualTo("2");
        assertThat(records.get(0).get(2)).isEqualTo("6");
        assertThat(records.get(1).get(0)).isEqualTo("QuickSort");
        assertThat(records.get(1).get(1)).isEqualTo("8");
        assertThat(records.get(1).get(2)).isEqualTo("1");
        new File(fileName).delete();
    }
}
