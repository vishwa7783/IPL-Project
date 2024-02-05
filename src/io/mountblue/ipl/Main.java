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
    public static final int INNING = 1;
    public static final int BATTING_TEAM = 2;
    public static final int BOWLING_TEAM = 3;
    public static final int OVER = 4;
    public static final int BALL = 5;
    public static final int BATSMAN = 6;
    public static final int NON_STRIKER = 7;
    public static final int BOWLER_DATA = 8;
    public static final int IS_SUPER_OVER = 9;
    public static final int WIDE_RUNS = 10;
    public static final int BYE_RUNS = 11;
    public static final int LEG_BYE_RUNS = 12;
    public static final int NO_BALL_RUNS = 13;
    public static final int PENALTY_RUNS = 14;
    public static final int BATSMAN_RUNS = 15;
    public static final int EXTRA_RUNS = 16;
    public static final int TOTAL_RUNS = 17;
    public static final int PLAYER_DISMISSAL = 18;
    public static final int DISMISSAL_TYPE = 19;
    public static final int FIELDER = 20;

    public static void main(String[] args) {
        List<Match> matchesData=getMatchesData();
        List<Delivery> deliveriesData=getDeliveryData();

        findNumberOfMatchPlayedPerYear(matchesData);
        findNumberOfMatchWonByTeams(matchesData);
        findExtraRunsConcededPerTeamIn2016(deliveriesData, matchesData);
//        findTopEconomicalBowlersOf2015(deliveriesData, matchesData);

    }

//    private static void findTopEconomicalBowlersOf2015(List<Delivery> deliveriesData, List<Match> matchesData) {
//        int[] matchIds = getMatchIds(matchesData,2015);
//    }

    private static void findExtraRunsConcededPerTeamIn2016(List<Delivery> deliveriesData, List<Match> matchesData) {
        HashMap<String,Integer> extraRunsConcededByTeams = new HashMap<>();
        int[] matchIds = getMatchIds(matchesData,2016);

        for(Delivery delivery : deliveriesData){
            if(delivery.getMatchId()>=matchIds[0] && delivery.getMatchId()<=matchIds[1]){
                if(extraRunsConcededByTeams.containsKey(delivery.getBowlingTeam())){
                    extraRunsConcededByTeams.put(delivery.getBowlingTeam(),extraRunsConcededByTeams.get(delivery.getBowlingTeam())+delivery.getExtraRuns());
                }else{
                    extraRunsConcededByTeams.put(delivery.getBowlingTeam(),delivery.getExtraRuns());
                }
            }
        }

        for(Map.Entry<String,Integer> extraRunsConcedeByTeam:extraRunsConcededByTeams.entrySet()){
            System.out.println(extraRunsConcedeByTeam.getKey()+" :- "+extraRunsConcedeByTeam.getValue());
        }
        System.out.println();
    }

    private static int[] getMatchIds(List<Match> matchesData,int year) {
        int [] matchIds =new int[2];
        for(Match match : matchesData){
            if(match.getSeason()==year && matchIds[0]==0){
                matchIds[0]=match.getMatchId();
                matchIds[1]= match.getMatchId();
            }
            matchIds[1]= match.getMatchId();
        }
        return matchIds;
    }

    public static List<Match> getMatchesData()  {
        List<Match> matches = new ArrayList<>();

        try{
            BufferedReader bufferedReader=new BufferedReader(new FileReader(MATCH_FILE_PATH));
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",",-1);
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
                delivery.setInning(Integer.parseInt(data[INNING]));
                delivery.setBattingTeam(data[BATTING_TEAM]);
                delivery.setBowlingTeam(data[BOWLING_TEAM]);
                delivery.setOver(Integer.parseInt(data[OVER]));
                delivery.setBall(Integer.parseInt(data[BALL]));
                delivery.setBatsman(data[BATSMAN]);
                delivery.setNonStriker(data[NON_STRIKER]);
                delivery.setBowler(data[BOWLER_DATA]);
                delivery.setIsSuperOver(Integer.parseInt(data[IS_SUPER_OVER]));
                delivery.setWideRuns(Integer.parseInt(data[WIDE_RUNS]));
                delivery.setByeRuns(Integer.parseInt(data[BYE_RUNS]));
                delivery.setLegByeRuns(Integer.parseInt(data[LEG_BYE_RUNS]));
                delivery.setNoBallRuns(Integer.parseInt(data[NO_BALL_RUNS]));
                delivery.setPenaltyRuns(Integer.parseInt(data[PENALTY_RUNS]));
                delivery.setBatsmanRuns(Integer.parseInt(data[BATSMAN_RUNS]));
                delivery.setExtraRuns(Integer.parseInt(data[EXTRA_RUNS]));
                delivery.setTotalRuns(Integer.parseInt(data[TOTAL_RUNS]));
                delivery.setPlayerDismissal(data[PLAYER_DISMISSAL]);
                delivery.setDismissalType(data[DISMISSAL_TYPE]);
                delivery.setFielder(data[FIELDER]);

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
        System.out.println();
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
        System.out.println();
    }
}