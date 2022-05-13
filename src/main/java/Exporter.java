import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class Exporter {

    public static String SEPARATOR = ";";

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

    public void export(String filename, List<SorterState> sortingAlgorithmList, int[][] comparisonsArray) {
        if(filename!=null && sortingAlgorithmList!=null && comparisonsArray!=null) {
            try {
                PrintWriter printWriter = new PrintWriter(filename);
            } catch (FileNotFoundException e) {
                System.err.println("FileNotFoundException was thrown");
            }
        }
    }

    public void setSeparator(String separator) {
        SEPARATOR=separator;
    }
}
