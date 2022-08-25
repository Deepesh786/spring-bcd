package com.learn.compratore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {

    public static void main(String[] args) {

        //List<PlayerComparable> playerList = new ArrayList<>();
        /*ArrayList<PlayerComparable> playerList = new ArrayList<>(Arrays.asList(
                                new PlayerComparable(1,"Dipesh",24),
                                new PlayerComparable(2, "Banana",25),
                                new PlayerComparable(3, "Crazy",26)));*/

        List<PlayerComparable> playerList = new ArrayList<PlayerComparable>(
                List.of(
                        new PlayerComparable(1,"Dipesh",24),
                        new PlayerComparable(3, "Banana",23),
                        new PlayerComparable(2, "Crazy",21)));


        System.out.println("Before sort: "+playerList);

        Collections.sort(playerList);

        System.out.println("After sort: "+playerList);

    }
}
