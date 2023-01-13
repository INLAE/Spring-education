package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "color_id", nullable = false)
    private Long productID;
    @Column(name = "color_name", length = 64)
    private String colorName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_kit_color_id")
    private List<Team> primCol;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "secondary_kit_color_id")
    private List<Team> secCol;
    public Color(String colorName) {
        this.colorName = colorName;
    }
    public Color() {
    }

    public void addPrimColors(Team team){
        if(primCol == null)
            primCol = new ArrayList<Team>();
        primCol.add(team);
    }

    public void addSecColors(Team team){
        if(secCol == null)
            secCol = new ArrayList<Team>();
        secCol.add(team);
    }
}
