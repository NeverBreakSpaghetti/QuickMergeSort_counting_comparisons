import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ExporterTest {

    @Test
    public void emptyArrayConvertToCSVRow(){
        Exporter exporter = new Exporter();
        String stringToConvert = Arrays.toString(new int[]{});

        assertThat(exporter.convertToCSVRow(stringToConvert)).isEqualTo("");
    }

    @Test
    public void singleElementArrayConvertToCSVRow(){
        Exporter exporter = new Exporter();
        String stringToConvert = Arrays.toString(new int[]{1});

        assertThat(exporter.convertToCSVRow(stringToConvert)).isEqualTo("1");
    }

    @Test
    public void twoElementArrayConvertToCSVRow(){
        Exporter exporter = new Exporter();
        String stringToConvert = Arrays.toString(new int[]{1,2});

        assertThat(exporter.convertToCSVRow(stringToConvert)).isEqualTo("1;2");
    }

    @Test
    public void threeElementArrayConvertToCSVRow(){
        Exporter exporter = new Exporter();
        String stringToConvert = Arrays.toString(new int[]{1,2,3});

        assertThat(exporter.convertToCSVRow(stringToConvert)).isEqualTo("1;2;3");
    }

    @Test
    public void comparisonsOneSortingAlgorithmConvertToCSVRowTo(){
        Exporter exporter = new Exporter();
        int[][] comparisonsArray = new int[][]{{3,4,9}};

        List<SorterState> sortingAlgorithmList = new ArrayList<>();
        sortingAlgorithmList.add(new QuickMergeSort());

        assertThat(exporter.convertComparisonsBySortingAlgorithm(sortingAlgorithmList,comparisonsArray)).isEqualTo("\"QuickMergeSort\";3;4;9");
    }
}
