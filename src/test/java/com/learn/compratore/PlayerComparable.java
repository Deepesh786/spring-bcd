package com.learn.compratore;

public class PlayerComparable implements Comparable<PlayerComparable> {

    private int ranking;
    private String name;
    private int age;

    public PlayerComparable(int ranking, String name, int age) {
        this.ranking = ranking;
        this.name = name;
        this.age = age;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PlayerComparable{" +
                "ranking=" + ranking +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(PlayerComparable o) {
        //return Integer.compare(getRanking(), o.getRanking());
        return Integer.compare(getRanking(), o.getRanking());
    }
}
