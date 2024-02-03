import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class FetchData {
    Map<Integer,HashMap<String,String>> getData(String csvFilePath) {
        Map<Integer,HashMap<String,String>> dataSheet=new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            int row=1;
            String[] columnsName=null;
            while ((line =bufferedReader.readLine()) != null) {
                String[] dataFields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                HashMap<String,String> rowDataSheet=new HashMap<>();
                if(columnsName==null){
                    columnsName=dataFields;
                    continue;
                }
                for(int i=0;i<dataFields.length && i<columnsName.length;i++){
                    rowDataSheet.put(columnsName[i],dataFields[i]);
                }
                dataSheet.put(row++,rowDataSheet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataSheet;
    }
}
