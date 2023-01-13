package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", nullable = false)
    private Long teamID;
    @Column(name = "budget")
    private Long budget;
    @Column(name = "initial")
    private String initial;
    @Column(name = "logo_url")
    private String logoURL;
    @Column(name = "team_name")
    private String teamName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_team_id")
    private List<Player> teamPlayerID;

    @OneToOne(mappedBy = "awayTeam",
            cascade = CascadeType.ALL)
    private Game awayGame;
    @OneToOne(mappedBy = "homeTeam",
            cascade = CascadeType.ALL)
    private Game homeGame;


    public Team(Long budget, String initial, String logoURL, String teamName) {
        this.budget = budget;
        this.initial = initial;
        this.logoURL = logoURL;
        this.teamName = teamName;
    }

    public Team() {
    }

    public void addTeamPlayer(Player player) {
        if (teamPlayerID == null)
            teamPlayerID = new ArrayList<Player>();
        teamPlayerID.add(player);
    }
}
