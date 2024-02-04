import java.util.HashMap;
import java.util.*;

import static java.lang.Integer.parseInt;

public class ExtraRun {
    List<Integer>matchIds=new ArrayList<>();
    FetchData data=new FetchData();
    HashMap<String,Integer>extraRunsTeam=new HashMap<>();
    public void setExtraRun(String year,Map<Integer,HashMap<String,String>> deliveriesData,Map<Integer,HashMap<String,String>> matchesData){
        matchIds=getMatchId(year,matchesData);
        for(Map.Entry<Integer,HashMap<String,String>>deliveryData:deliveriesData.entrySet()){
            HashMap<String,String> fields=deliveryData.getValue();
            String bowlingTeam=fields.get("bowling_team");
            int matchId=parseInt(fields.get("match_id"));
            if(matchId>=matchIds.getFirst() && matchId<=matchIds.getLast()){
                if(extraRunsTeam.containsKey(bowlingTeam)){
                    extraRunsTeam.put(bowlingTeam,extraRunsTeam.get(bowlingTeam)+parseInt(fields.get("extra_runs")));
                }else if(!bowlingTeam.isEmpty()){
                    extraRunsTeam.put(bowlingTeam,parseInt(fields.get("extra_runs")));
                }
            }
        }
    }

    public  List<Integer> getMatchId(String year,Map<Integer,HashMap<String,String>> matchesData){
        int firstId=-1,lastId=1;
        for(Map.Entry<Integer,HashMap<String,String>> matchData:matchesData.entrySet()){
            HashMap<String,String> fields=matchData.getValue();
            if(fields.get("season").equals(year) && firstId==-1 ){
                firstId=matchData.getKey();
                lastId=matchData.getKey();
            }
            else if(fields.get("season").equals(year)){
                lastId=matchData.getKey();
            }
        }
        matchIds.add(firstId);
        matchIds.add(lastId);
        return matchIds;
    }

    public void printTeamsExtraRun(){
        for(Map.Entry<String,Integer> d:extraRunsTeam.entrySet()){
            System.out.println(d.getKey()+" "+d.getValue());
        }
    }
}
