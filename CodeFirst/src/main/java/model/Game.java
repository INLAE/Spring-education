package model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Long townID;
    @Column(name = "away_team_bet_rate")
    private double awayTeamBetRate;
    @Column(name = "away_team_goals")
    private int awayTeamGoals;
    @Column(name = "draw_bet_rate")
    private double drawBetRate;
    @Column(name = "home_team_bet_rate")
    private double homeTeamBetRate;
    @Column(name = "home_team_goals")
    private int homeTeamGoals;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "away_team_id")
    private Team awayTeam;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_team_id")
    private Team homeTeam;

    @Column(name = "result")
    private String result;
    @Column(name = "datetime")
    private String datetime;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private List<PlayerStatistic> playStat;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "game_id")
    private List<Bet> betList;


    public Game(double homeTeamBetRate, int homeTeamGoals, double awayTeamBetRate, int awayTeamGoals, double drawBetRate, String result, String datetime) {
        this.homeTeamBetRate = homeTeamBetRate;
        this.homeTeamGoals = homeTeamGoals;
        this.drawBetRate = drawBetRate;
        this.awayTeamBetRate = awayTeamBetRate;
        this.awayTeamGoals = awayTeamGoals;
        this.result = result;
        this.datetime = datetime;
    }
    public Game(){}


    public void addPlayerStat(PlayerStatistic playS){
        if(playStat == null)
            playStat = new ArrayList<>();
        playStat.add(playS);
    }

    public void addBetList(Bet bet){
        if(betList == null)
            betList = new ArrayList<>();
        betList.add(bet);
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }
    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }
}