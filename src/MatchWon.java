import java.util.HashMap;
import java.util.Map;

public class MatchWon {
    private final HashMap<String,Integer>winnerTeams=new HashMap<>();
   public void countMatchWon(Map<Integer, HashMap<String,String>> matchesData)  {
       for(Map.Entry<Integer,HashMap<String,String>>matchData:matchesData.entrySet()){
           HashMap<String,String> fields=matchData.getValue();
           String winnerTeam=fields.get("winner");
           if(fields.containsKey("winner")) {
               if(winnerTeams.containsKey(winnerTeam)  ) {
                   winnerTeams.put(winnerTeam, winnerTeams.get(winnerTeam) + 1);
               }else if(!winnerTeam.isEmpty()){
                   winnerTeams.put(winnerTeam, 1);
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
