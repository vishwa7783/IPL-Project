package io.mountblue.ipl;

import javax.swing.*;

public class Delivery {
    private int matchId = 0;
    private int inning = 0;
    private String battingTeam = null;
    private  String bowlingTeam = null;
    private int over = 0;
    private int ball = 0;
    private String batsman = null;
    private String nonStriker = null;
    private String bowler = null;
    private int isSuperOver = 0;
    private int wideRuns = 0;
    private int byeRuns = 0;
    private int legByeRuns = 0;
    private int noBallRuns = 0;
    private int penaltyRuns = 0;
    private int batsmanRuns = 0;
    private int extraRuns = 0;
    private int totalRuns = 0;
    private String playerDismissal = null;
    private String dismissalType = null;
    private String fielder = null;

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getInning() {
        return inning;
    }

    public void setInning(int inning) {
        this.inning = inning;
    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(String battingTeam) {
        this.battingTeam = battingTeam;
    }

    public String getBowlingTeam() {
        return bowlingTeam;
    }

    public void setBowlingTeam(String bowlingTeam) {
        this.bowlingTeam = bowlingTeam;
    }

    public int getOver() {
        return over;
    }

    public void setOver(int over) {
        this.over = over;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public String getBatsman() {
        return batsman;
    }

    public void setBatsman(String batsman) {
        this.batsman = batsman;
    }

    public String getNonStriker() {
        return nonStriker;
    }

    public void setNonStriker(String nonStriker) {
        this.nonStriker = nonStriker;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public int getIsSuperOver() {
        return isSuperOver;
    }

    public void setIsSuperOver(int isSuperOver) {
        this.isSuperOver = isSuperOver;
    }

    public int getWideRuns() {
        return wideRuns;
    }

    public void setWideRuns(int wideRuns) {
        this.wideRuns = wideRuns;
    }

    public int getByeRuns() {
        return byeRuns;
    }

    public void setByeRuns(int byeRuns) {
        this.byeRuns = byeRuns;
    }

    public int getLegByeRuns() {
        return legByeRuns;
    }

    public void setLegByeRuns(int legByeRuns) {
        this.legByeRuns = legByeRuns;
    }

    public int getNoBallRuns() {
        return noBallRuns;
    }

    public void setNoBallRuns(int noBallRuns) {
        this.noBallRuns = noBallRuns;
    }

    public int getPenaltyRuns() {
        return penaltyRuns;
    }

    public void setPenaltyRuns(int penaltyRuns) {
        this.penaltyRuns = penaltyRuns;
    }

    public int getBatsmanRuns() {
        return batsmanRuns;
    }

    public void setBatsmanRuns(int batsmanRuns) {
        this.batsmanRuns = batsmanRuns;
    }

    public int getExtraRuns() {
        return extraRuns;
    }

    public void setExtraRuns(int extraRuns) {
        this.extraRuns = extraRuns;
    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public String getPlayerDismissal() {
        return playerDismissal;
    }

    public void setPlayerDismissal(String playerDismissal) {
        this.playerDismissal = playerDismissal;
    }

    public String getDismissalType() {
        return dismissalType;
    }

    public void setDismissalType(String dismissalType) {
        this.dismissalType = dismissalType;
    }

    public String getFielder() {
        return fielder;
    }

    public void setFielder(String fielder) {
        this.fielder = fielder;
    }
}
