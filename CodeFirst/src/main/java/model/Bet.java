package model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;


@Entity
@Table(name = "bet")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bet_id", nullable = false)
    private Long betID;

    @Column(name = "amount")
    @Min(0)
    private int amount;

    @Column(name = "prediction")
    @Min(0)
    public predictEnum prediction;
    public enum predictEnum{
        HomeWin, Draw, AwayWin;
    }
    @Column(name = "datetime")
    private String datetime;


    public Bet() {
    }

    public Bet(int amount, predictEnum prediction, String datetime) {
        this.amount = amount;
        this.prediction = prediction;
        this.datetime = datetime;
    }
}