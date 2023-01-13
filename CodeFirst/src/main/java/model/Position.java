package model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id", nullable = false)
    private Long positionID;
    @Column(name = "position_name", length = 64)
    private String positionName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private List<Player> playersPositions;

    public Position(String positionName) {
        this.positionName = positionName;
    }

    public Position() {
    }

    public void addPlayerToPosition(Player player){
        if(playersPositions == null)
            playersPositions = new ArrayList<Player>();
        playersPositions.add(player);
    }
}
