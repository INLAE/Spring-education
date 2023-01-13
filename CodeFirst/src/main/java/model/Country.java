package model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Long countryID;
    @Column(name = "country_name", length = 64)
    private String countryName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private List<Town> ListOfTown;

    public Country(String countryName) {
        this.countryName = countryName;
    }
    public Country() {
    }

    public void addTown(Town town){
        if(ListOfTown == null)
            ListOfTown = new ArrayList<Town>();
        ListOfTown.add(town);
    }
}
