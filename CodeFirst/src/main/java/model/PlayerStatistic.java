package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "playerStatistic")
public class PlayerStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "playerStatistic_id", nullable = false)
    private Long playerStatisticId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ps_player_id")
    private Player player;
    @Column(name = "assists")
    @Min(0)
    private int assists;
    @Column(name = "minutes_played")
    @Min(0)
    private int minutesPlayed;
    @Column(name = "scored_goals")
    @Min(0)
    private int scoredGoals;

    public PlayerStatistic() {
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PlayerStatistic(int assists, int minutesPlayed, int scoredGoals) {
        this.assists = assists;
        this.minutesPlayed = minutesPlayed;
        this.scoredGoals = scoredGoals;
    }
}
