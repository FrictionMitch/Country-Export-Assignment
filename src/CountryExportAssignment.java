import org.apache.commons.csv.*;
import edu.duke.*;

public class CountryExportAssignment {

    public String countryInfo(CSVParser parser, String countryInput) {

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
        for(CSVRecord record : parser) {
            String country = record.get("Country");
            String export = record.get("Exports");
            if(export.contains(export1) && export.contains(export2)) {
                System.out.println(country);
            }
        }
    }

    public void tester() {
        FileResource fileResource = new FileResource("exportdata.csv");
        CSVParser parser = fileResource.getCSVParser();
        System.out.println(countryInfo(parser, "Canada"));

        parser = fileResource.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
    }
}
