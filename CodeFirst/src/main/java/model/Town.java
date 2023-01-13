package model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "town")
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "town_id", nullable = false)
    private Long townID;
    @Column(name = "town_name", length = 64)
    private String townName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "town_id")
    private List<Team> teamTown;

    public Town(String townName) {
        this.townName = townName;
    }
    public Town() {
    }

    public void addTeam(Team team){
        if(teamTown == null)
            teamTown = new ArrayList<Team>();
        teamTown.add(team);
    }
}