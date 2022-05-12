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
}
