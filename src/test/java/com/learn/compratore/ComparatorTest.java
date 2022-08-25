package com.learn.compratore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorTest {

    public static void main(String[] args) {

        List<PlayerComparator> playerList = new ArrayList<PlayerComparator>(
                List.of(
                        new PlayerComparator(1,"Dipesh",24),
                        new PlayerComparator(3, "Banana",23),
                        new PlayerComparator(2, "Crazy",21)));

        System.out.println("Before sort : "+playerList);

        Collections.sort(playerList,(PlayerComparator p1,PlayerComparator p2) -> p1.getAge()-p2.getAge());

        System.out.println("After sort : "+playerList);

    }
}
