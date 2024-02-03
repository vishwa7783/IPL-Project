import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MatchPlayed {
        HashMap<String,Integer>matchPlayedTeam=new HashMap<>();
      public void countMatchPlayed(Map<Integer,HashMap<String,String>> matchesData)throws IOException {
          for(Map.Entry<Integer, HashMap<String,String>>matchData:matchesData.entrySet()){
              HashMap<String,String>fields=matchData.getValue();
              if(fields.containsKey("season")){
                  if(matchPlayedTeam.containsKey(fields.get("season"))){
                      matchPlayedTeam.put(fields.get("season"),matchPlayedTeam.get(fields.get("season"))+1);
                  }else if(!fields.get("season").isEmpty()){
                      matchPlayedTeam.put(fields.get("season"),1);
                  }
              }
          }

      }
    public void printMatchPlayed(){
        for(Map.Entry<String,Integer>team:matchPlayedTeam.entrySet()){
            System.out.println("Number of Matches Played in "+team.getKey()+" is :- "+team.getValue()+"." );
        }
    }
}
