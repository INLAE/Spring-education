package model;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "player")
public class Player {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id", nullable = false)
    private Long playerID;
    @OneToOne(mappedBy = "player",
            cascade = CascadeType.ALL)
    private PlayerStatistic playStat;
    @Column(name = "player_name", length = 64)
    private String playerName;

    @Column(name = "player_is_injured")
    private boolean isInjured;

    @Column(name = "player_squad_number")
    @Range(min = MIN_RANGE, max = MAX_RANGE, message = "Dont joke to me, dude!")
    private int playerNumber;

    public Player(String playerName, boolean isInjured, int playerNumber) {
        this.playerName = playerName;
        this.isInjured = isInjured;
        this.playerNumber = playerNumber;
    }
    public Player(){}
}

