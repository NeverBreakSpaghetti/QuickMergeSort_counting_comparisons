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
        StringBuilder returnString = new StringBuilder();
        String prefix = "";
        for (int i=0; i<sortingAlgorithmList.size(); i++) {
            returnString.append(prefix);
            prefix="\n";
            returnString.append("\"");
            returnString.append(sortingAlgorithmList.get(i).getClass().getName());
            returnString.append("\"");
            returnString.append(SEPARATOR);
            returnString.append( convertToCSVRow(Arrays.toString(comparisonsArray[i])) );
        }
        return returnString.toString();
    }
}
