package io.mountblue.ipl;

import io.mountblue.ipl.Match;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String MATCH_FILE_PATH = "src/io/mountblue/ipl/archive/matches.csv";
    private static final String DELIVERY_FILE_PATH = "src/io/mountblue/ipl/archive/deliveries.csv";
    public static final int MATCH_ID = 0;
    public static final int SEASON = 1;
    public static final int CITY = 2;
    public static final int MATCH_DATE = 3;
    public static final int TEAM1 = 4;
    public static final int TEAM2 = 5;
    public static final int TOSS_WINNER = 6;
    public static final int TOSS_DECISION = 7;
    public static final int MATCH_RESULT = 8;
    public static final int DL_APPLIED = 9;
    public static final int WINNER = 10;
    public static final int WIN_BY_RUNS = 11;
    public static final int WIN_BY_WICKETS = 12;
    public static final int PLAYER_OF_MATCH = 13;
    public static final int MATCH_VENUE = 14;
    public static final int UMPIRE1 = 15;
    public static final int UMPIRE2 = 16;

    public static void main(String[] args) {
        List<Match> matchesData=getMatchesData();
        List<Delivery> deliveriesData=getDeliveryData();

        findNumberOfMatchPlayedPerYear(matchesData);
        findNumberOfMatchWonByTeams(matchesData);


    }

    public static List<Match> getMatchesData()  {
        List<Match> matches = new ArrayList<>();

        try{
            BufferedReader bufferedReader=new BufferedReader(new FileReader(MATCH_FILE_PATH));
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)",-1);
                Match match = new Match();
                match.setMatchId(Integer.parseInt(data[MATCH_ID]));
                match.setSeason(Integer.parseInt(data[SEASON]));
                match.setCity(data[CITY]);
                match.setDate(data[MATCH_DATE]);
                match.setTeam1(data[TEAM1]);
                match.setTeam2(data[TEAM2]);
                match.setTossWineer(data[TOSS_WINNER]);
                match.setTossDecision(data[TOSS_DECISION]);
                match.setResult(data[MATCH_RESULT]);
                match.setDlApplied(Integer.parseInt(data[DL_APPLIED]));
                match.setWinner(data[WINNER]);
                match.setWinByRuns(Integer.parseInt(data[WIN_BY_RUNS]));
                match.setWinByWickets(Integer.parseInt(data[WIN_BY_WICKETS]));
                match.setPlayerOfMatch(data[PLAYER_OF_MATCH]);
                match.setVenue(data[MATCH_VENUE]);
                match.setUmpire1(data[UMPIRE1]);
                match.setUmpire2(data[UMPIRE2]);

                matches.add(match);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        return matches;
    }

    public static List<Delivery> getDeliveryData() {
        List<Delivery> deliveries = new ArrayList<>();
        try{
            BufferedReader bufferedReader=new BufferedReader(new FileReader(DELIVERY_FILE_PATH));
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                Delivery delivery = new Delivery();
                delivery.setMatchId(Integer.parseInt(data[MATCH_ID]));
                delivery.setInning(Integer.parseInt(data[1]));
                delivery.setBattingTeam(data[2]);
                delivery.setBowlingTeam(data[3]);
                delivery.setOver(Integer.parseInt(data[4]));
                delivery.setBall(Integer.parseInt(data[5]));
                delivery.setBatsman(data[6]);
                delivery.setNonStriker(data[7]);
                delivery.setBowler(data[8]);
                delivery.setInning(Integer.parseInt(data[9]));
                delivery.setWideRuns(Integer.parseInt(data[10]));
                delivery.setByeRuns(Integer.parseInt(data[11]));
                delivery.setLegByeRuns(Integer.parseInt(data[12]));
                delivery.setNoBallRuns(Integer.parseInt(data[13]));
                delivery.setPenaltyRuns(Integer.parseInt(data[14]));
                delivery.setBatsmanRuns(Integer.parseInt(data[15]));
                delivery.setExtraRuns(Integer.parseInt(data[16]));
                delivery.setTotalRuns(Integer.parseInt(data[17]));
                delivery.setPlayerDismissal(data[18]);
                delivery.setDismissalType(data[19]);
                delivery.setFielder(data[20]);

                deliveries.add(delivery);
            }
        }catch(IOException e){
                e.printStackTrace();
        }
        return deliveries;
    }

    private static void findNumberOfMatchPlayedPerYear(List<Match> matchesData) {
        HashMap<Integer,Integer> matchesPlayedPerYear = new HashMap<>();
        for(Match match:matchesData){
            if(matchesPlayedPerYear.containsKey(match.getSeason())){
                matchesPlayedPerYear.put(match.getSeason(),matchesPlayedPerYear.get(match.getSeason())+1);
            }else{
                matchesPlayedPerYear.put(match.getSeason(),1);
            }
        }

        for(Map.Entry<Integer,Integer>matchPlayedPerYear:matchesPlayedPerYear.entrySet()){
            System.out.println(matchPlayedPerYear.getKey()+" :- "+matchPlayedPerYear.getValue());
        }
    }

    private static void findNumberOfMatchWonByTeams(List<Match> matchesData) {
        HashMap<String,Integer> matchesWonByTeam = new HashMap<>();
        for(Match match : matchesData){
            if(matchesWonByTeam.containsKey(match.getWinner())){
                matchesWonByTeam.put(match.getWinner(),matchesWonByTeam.get(match.getWinner())+1);
            }else if(!match.getWinner().isEmpty()){
                matchesWonByTeam.put(match.getWinner(),1);
            }
        }

        for(Map.Entry<String,Integer> matchWonByTeam : matchesWonByTeam.entrySet()){
            System.out.println(matchWonByTeam.getKey()+" :- "+matchWonByTeam.getValue());
        }
    }
}