import java.util.HashMap;
import java.util.Map;

public class MatchWon {
    private final HashMap<String,Integer>winnerTeams=new HashMap<>();
   public void countMatchWon()  {
       String filePath="src/CSVFiles/matches.csv";
       FetchData data=new FetchData();

       Map<Integer, HashMap<String,String>> matchesData=data.getData(filePath);
       for(Map.Entry<Integer,HashMap<String,String>>matchData:matchesData.entrySet()){
           HashMap<String,String> fields=matchData.getValue();
           if(fields.containsKey("winner")) {
               if(winnerTeams.containsKey(fields.get("winner"))  ) {
                   winnerTeams.put(fields.get("winner"), winnerTeams.get(fields.get("winner")) + 1);
               }else if(!fields.get("winner").isEmpty()){
                   winnerTeams.put(fields.get("winner"), 1);
               }
           }
       }
   }
   public void printMatchWon(){
       for(Map.Entry<String,Integer>winnerTeam:winnerTeams.entrySet()){
           System.out.println("Matches won by "+winnerTeam.getKey()+" :- "+winnerTeam.getValue()+".");
       }
   }
}
