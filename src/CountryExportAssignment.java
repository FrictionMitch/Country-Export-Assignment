import org.apache.commons.csv.*;
import edu.duke.*;

public class CountryExportAssignment {

    public String countryInfo(CSVParser parser, String countryInput) {

        int countryCheck = 0;
        String answer = "NOT FOUND";
        for (CSVRecord record : parser) {
            String country = record.get("Country");
            if (country.contains(countryInput)) {
                String export = record.get("Exports");
                String value = record.get("Value (dollars)");
                answer = country + ": " + export + ": " + value;
            }
        }
        return answer;
    }

    public void listExportersTwoProducts(CSVParser parser, String export1, String export2){

    }

    public void tester() {
        FileResource fileResource = new FileResource("exportdata.csv");
        CSVParser parser = fileResource.getCSVParser();
        System.out.println(countryInfo(parser, "Canada"));
    }
}
