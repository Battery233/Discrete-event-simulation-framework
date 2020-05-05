package com.example;

import java.util.ArrayList;
import java.util.List;

public class ZombieInvasion implements SimulationPlugin {
    private int currentDay;
    private int human;
    private int zombie;

    public ZombieInvasion() {
        currentDay = 0;
        human = 1_000_000;
        zombie = 4;
    }

    public boolean noHumanLeft() {
        return human <= 0;
    }

    public boolean noZombieExist() {
        return zombie <= 0;
    }

    public void infect() {
        human--;
        zombie++;
    }

    public void zombieKilled() {
        zombie--;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    @Override
    public List<Event> simulationStarts() {
        List<Event> result = new ArrayList<>();
        result.add(new ZombieHuntsEvent(this, 0));
        result.add(new ZombieHuntsEvent(this, 0));
        result.add(new ZombieHuntsEvent(this, 0));
        result.add(new ZombieHuntsEvent(this, 0));
        return result;
    }

    @Override
    public void simulationEnds() {
        System.out.println("Current day count = " + currentDay);
        System.out.println("Current human left = " + human);
        System.out.println("Current zombies left = " + zombie);
    }
}
