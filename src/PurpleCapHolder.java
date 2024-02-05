import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurpleCapHolder {

    HashMap<String, Integer> bowlersBowled=new HashMap<>();
    public void setPlayerDismissal(String year, Map<Integer,HashMap<String,String>> deliveriesData, Map<Integer,HashMap<String,String>> matchesData){

        ExtraRun extraRun=new ExtraRun();
        List<Integer> matchIds=new ArrayList<>();
        matchIds=extraRun.getMatchId(year,matchesData);

        for(Map.Entry<Integer,HashMap<String,String>>deliveryData:deliveriesData.entrySet()){

            HashMap<String,String> fields=deliveryData.getValue();
            String bowler=fields.get("bowler");
            String dismissedPlayer=fields.get("player_dismissed");
            int matchId=Integer.parseInt(fields.get("match_id"));
            if(matchId>=matchIds.getFirst() && matchIds.getLast()>=matchId) {
                if (dismissedPlayer != null) {
                    if (!bowlersBowled.containsKey(bowler)) {
                        bowlersBowled.put(bowler, 1);
                    } else {
                        int bowled = bowlersBowled.get(bowler) + 1;
                        bowlersBowled.put(bowler, bowled);
                    }
                }
            }
        }
    }


    public void printPurpleCapHolder(String year){
        int i=0;
        int mostWicket=0;
        String purpleHolder="";
        for(Map.Entry<String,Integer>bowlerBowled:bowlersBowled.entrySet()){
            if(mostWicket<bowlerBowled.getValue()){
                mostWicket=bowlerBowled.getValue();
                purpleHolder=bowlerBowled.getKey();
            }
        }
        System.out.println("Purple Holder in "+year +" is "+purpleHolder+" with "+mostWicket+" wickets.");
    }
}


