import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

//        String matchesPath="src/matches.csv";
        String deliveriesPath="src/CSVFiles/deliveries.csv";
        FetchData data=new FetchData();
        String matchFilePath="src/CSVFiles/matches.csv";

        Map<Integer,HashMap<String,String>> matchesData=data.getData(matchFilePath);
        Map<Integer,HashMap<String,String>> deliveriesData=data.getData(deliveriesPath);




//        long numData=0;
//        for(Map.Entry<Integer,HashMap<String,String>>matchData:matchesData.entrySet()){
//            int key=matchData.getKey();
//            HashMap<String,String> dataValue=matchData.getValue();
//            System.out.print("Key:-"+ key+" ");
//            for(Map.Entry<String,String> d:dataValue.entrySet()){
//                System.out.print(d.getKey()+ ":-"+ d.getValue()+" ");
//            }
//            System.out.println();
//        }
//        System.out.println(numData);


//        MatchPlayed matchPlayed=new MatchPlayed();
//        matchPlayed.print();



    }
}