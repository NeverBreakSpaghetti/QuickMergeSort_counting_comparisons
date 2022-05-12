import java.util.Arrays;
import java.util.List;

public class Exporter {

    public static final String SEPARATOR = ";";

    public String convertToCSVRow(String stringToConvert) {
        String resultRow = stringToConvert;
        if ( resultRow != null && ( resultRow.contains("[") || resultRow.contains("]") || resultRow.contains(",") ) ) {
            resultRow=resultRow.replaceAll("\\[", "");
            resultRow=resultRow.replaceAll("\\]", "");
            resultRow=resultRow.replaceAll(",", SEPARATOR);
            resultRow=resultRow.replaceAll(" ","");
        }
        return resultRow;
    }

    public String convertComparisonsBySortingAlgorithm(List<SorterState> sortingAlgorithmList, int[][] comparisonsArray) {
        String returnString="";
        for (int i=0; i<sortingAlgorithmList.size(); i++) {
            String row;
            row = "\"" + sortingAlgorithmList.get(i).getClass().getName() + "\";";
            row = row + convertToCSVRow(Arrays.toString(comparisonsArray[i])) + "\n";
            returnString += row;
        }
        return returnString.substring(0,returnString.length()-1);
    }
}
