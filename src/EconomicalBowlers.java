import java.util.*;

import static java.lang.Integer.parseInt;

public class EconomicalBowlers {
   public HashMap<String,Float>economyBowlers=new HashMap<>();
    HashMap<String,Integer> numOfBalls=new HashMap<>();
    HashMap<String,Integer> runsConceded=new HashMap<>();
    public void setEconomy(String year, Map<Integer,HashMap<String,String>> deliveriesData, Map<Integer,HashMap<String,String>> matchesData){
        ExtraRun extraRun=new ExtraRun();
        List<Integer> matchIds=extraRun.getMatchId(year,matchesData);
        for(Map.Entry<Integer,HashMap<String,String>>deliveryData:deliveriesData.entrySet()){
            HashMap<String,String> fields=deliveryData.getValue();
            Integer matchId=Integer.parseInt(fields.get("match_id"));

            if(matchId>=matchIds.getFirst() && matchId<=matchIds.getLast()){
//                System.out.print(matchId+" ");
                HashMap<Integer,Integer>runsAndBalls=new HashMap<>();
                int runs=0;
                int extraBalls=0;
                int balls=1;
                if(!fields.get("wide_runs").equals("0") ||!fields.get("noball_runs").equals("0")) {
                    extraBalls++;
                    runs+=Integer.parseInt(fields.get("wide_runs"))+Integer.parseInt(fields.get("noball_runs"));
                }
                if(fields.get("is_super_over").equals("1")){
                    extraBalls=0;
                    balls=0;
                    runs=0;
                }
                else{
                    runs+=Integer.parseInt(fields.get("batsman_runs"))-Integer.parseInt(fields.get("legbye_runs"))-Integer.parseInt(fields.get("bye_runs"));
                }
                balls=balls-extraBalls;
                if(numOfBalls.containsKey(fields.get("bowler"))){
                    numOfBalls.put(fields.get("bowler"),numOfBalls.get(fields.get("bowler"))+balls);
                    runsConceded.put(fields.get("bowler"),runsConceded.get(fields.get("bowler"))+runs);
                }else if(!fields.get("bowler").isEmpty()){
                    numOfBalls.put(fields.get("bowler"),balls);
                    runsConceded.put(fields.get("bowler"),runs);
                }

            }
        }

    }
    public void printEconomyBowlers(){
        List<Map.Entry<String, Float>> entryList = new ArrayList<>(economyBowlers.entrySet());

        // Sort the List based on values using a custom Comparator
        Collections.sort(entryList, new Comparator<Map.Entry<String, Float>>() {
            @Override
            public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float> o2) {
                // Compare the values
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        int topTen=1;
        for(Map.Entry<String,Float>entry:entryList){
            if(topTen==11)break;
            topTen++;
            System.out.println("Economy of "+entry.getKey()+" is:-"+entry.getValue());
        }
    }
    public void setEconomyBowlers(){
        for(Map.Entry<String,Integer> entry:numOfBalls.entrySet()){
            economyBowlers.put(entry.getKey(),(float)runsConceded.get(entry.getKey())*6/entry.getValue());
        }
    }
}
