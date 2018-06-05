package guru.springframework.converters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ganta on 05-Jun-18.
 */
public class ExcelUtil {

    public static void main(String[] args) {

        String csvFile = "D:\\workspace\\TMRnD\\csv_files\\csv_files\\team.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("Country [code= " + country[0] + " , name=" + country[0] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
