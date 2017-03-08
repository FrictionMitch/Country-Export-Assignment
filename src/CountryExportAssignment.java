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
        String none = "NONE FOUND";
        int exportCount = 0;
        for(CSVRecord record : parser) {
            String country = record.get("Country");
            String export = record.get("Exports");
            if(export.contains(export1) && export.contains(export2)) {
                System.out.println(country);
                exportCount = 1;
            }
        }
            if(exportCount == 0) {
                System.out.println(none);
            }
    }

    public int numberOfExporters(CSVParser parser, String exportItem) {
        int numberOfCountries = 0;
        for(CSVRecord record : parser) {
            String export = record.get("Exports");
            if(export.contains(exportItem)) {
                numberOfCountries++;
            }
        }
        return numberOfCountries;
    }

    public void bigExporters(CSVParser parser, String amount) {
        for(CSVRecord record : parser) {
            String value = record.get("Value (dollars)");
            String country = record.get("Country");
            if(value.length() > amount.length()) {
                System.out.println(country + " " + value);
            }
        }
    }

    public void tester() {
        FileResource fileResource = new FileResource("files/exportdata.csv");
        CSVParser parser = fileResource.getCSVParser();
        System.out.println(countryInfo(parser, "Nauru"));
        System.out.println();

        parser = fileResource.getCSVParser();
        String export1 = "cotton";
        String export2 = "flowers";
        System.out.printf("%nCountries with %s and %s are: %n", export1, export2);
        listExportersTwoProducts(parser, export1, export2);

        parser = fileResource.getCSVParser();
        String export = "cocoa";
        System.out.println("Number of countries which export " + export + " is: " + numberOfExporters(parser, export));

        parser = fileResource.getCSVParser();
        String val = "$999,999,999,999";
        System.out.println("Countries with exports greater than " + val + " are: ");
        bigExporters(parser, val);
    }
}
