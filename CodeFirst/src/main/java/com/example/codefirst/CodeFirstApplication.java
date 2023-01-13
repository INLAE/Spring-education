package com.example.codefirst;

import model.*;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;

public class CodeFirstApplication {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            SessionFactory factory = new MetadataSources(registry)
                    .buildMetadata().buildSessionFactory();
            Session session = factory.openSession();
////////////BARCELONA/////////////////////////////////////////////////////////////////////////////////////////////
            var FCBarcelona = new Team(100_550_000L, "BAR", "Barca.com", "Barcelona");
            var colorPom = new Color("Pomegranate");
            var colorBlue = new Color("Blue");
            var townBarcelona = new Town("Barcelona");
            var countrySpain = new Country("Spain");
            var playerAraujo = new Player("Ronald Araujo", false, 4);
            var playerTorres = new Player("Ferran Torres", true, 11);
            var posAraujo = new Position("Centre Back");
            var posTorres = new Position("Right Winger");
            var statAraujo = new PlayerStatistic(0, 990, 1);
            var statTorres = new PlayerStatistic(2, 720, 3);
            // set town for team
            townBarcelona.addTeam(FCBarcelona);
            // set colors for team
            colorPom.addPrimColors(FCBarcelona);
            colorBlue.addSecColors(FCBarcelona);
            // set country for town
            countrySpain.addTown(townBarcelona);
            // set players for team
            FCBarcelona.addTeamPlayer(playerAraujo);
            FCBarcelona.addTeamPlayer(playerTorres);
            // set position for players
            posTorres.addPlayerToPosition(playerTorres);
            posAraujo.addPlayerToPosition(playerAraujo);
            // set statistic for players
            statAraujo.setPlayer(playerAraujo);
            statTorres.setPlayer(playerTorres);
////////////ARSENAL/////////////////////////////////////////////////////////////////////////////////////////////
            var FCArsenal = new Team(77_228_000L, "ARS", "arsenal.com", "Arsenal");
            var colorRed = new Color("Red");
            var colorWhite = new Color("White");
            var townLondon = new Town("London");
            var countryEngland = new Country("England");
            var playerJesus = new Player("Gabriel Jesus", true, 9);
            var playerTomiyasu = new Player("Takehiro Tomiyasu", false, 18);
            var posJesus = new Position("Striker");
            var posTomiyasu = new Position("Right Back");
            var statJesus = new PlayerStatistic(5, 1260, 5);
            var statTomiyasu = new PlayerStatistic(0, 1170, 0);
            var game1 = new Game(1.9, 3,1.95, 1, 2.2,  "3:1", "30 NOV 2022 07:00 PM" );
            var bet1 = new Bet(15000, Bet.predictEnum.Draw, "29 NOV 2022 12:00 AM");
            var user1 = new User("Fedot", 666999, "popan@pop.com", "password", "popanische");
            // set colors for team
            colorRed.addPrimColors(FCArsenal);
            colorWhite.addSecColors(FCArsenal);
            // set town for team
            townLondon.addTeam(FCArsenal);
            // set country for town
            countryEngland.addTown(townLondon);
            // set players for team
            FCArsenal.addTeamPlayer(playerJesus);
            FCArsenal.addTeamPlayer(playerTomiyasu);
            // set position for players
            posJesus.addPlayerToPosition(playerJesus);
            posTomiyasu.addPlayerToPosition(playerTomiyasu);
            // set statistic for players
            statJesus.setPlayer(playerJesus);
            statTomiyasu.setPlayer(playerTomiyasu);

            game1.addPlayerStat(statJesus);
            game1.addPlayerStat(statTorres);
            game1.addPlayerStat(statTomiyasu);
            game1.addPlayerStat(statAraujo);
            game1.setHomeTeam(FCArsenal);
            game1.setAwayTeam(FCBarcelona);
            game1.addBetList(bet1);
            user1.addBetList(bet1);
/////////////////////////////////////////////////////////////////////////////////////////////////////////

            session.beginTransaction();
            session.persist(colorPom);
            session.persist(colorBlue);
            session.persist(colorRed);
            session.persist(colorWhite);

            session.persist(countrySpain);
            session.persist(countryEngland);
            
            session.persist(posAraujo);
            session.persist(posTorres);
            session.persist(posJesus);
            session.persist(posTomiyasu);

            session.persist(statAraujo);
            session.persist(statTorres);
            session.persist(statJesus);
            session.persist(statTomiyasu);

            session.persist(game1);
            session.persist(user1);

            session.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }

    }
}