import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MatchPlayed {

      public void printMatchPlayed()throws IOException {
          String filePath="src/matches.csv";
          FetchData data=new FetchData();
          Map<Integer,HashMap<String,String>> matchesData=data.getData(filePath);
          int countMatch=0;
          String prevYear="";
          for(Map.Entry<Integer, HashMap<String,String>>matchData:matchesData.entrySet()){
              HashMap<String,String>fields=matchData.getValue();
              for(Map.Entry<String,String> iterator:fields.entrySet()){
                  if(iterator.getKey().equals("season")) {
                      if (prevYear.equals("")) {
                          prevYear = iterator.getValue();
                          countMatch++;
                      } else if (prevYear.equals(iterator.getValue())){
                          countMatch++;
                      }else{
                          System.out.println("Number of Matches Played in "+prevYear+" is :- "+countMatch+"." );
                          prevYear=iterator.getValue();
                          countMatch=1;
                      }
                  }
              }
          }
          System.out.println("Number of Matches Played in "+prevYear+" is :- "+countMatch+"." );
      }
}
