package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ZombieHuntsEvent implements Event {
    private final ZombieInvasion simulation;
    private int day;
    private boolean isTerminatorEvent;

    public ZombieHuntsEvent(ZombieInvasion simulation, int day) {
        this.simulation = simulation;
        this.day = day;
        isTerminatorEvent = day >= 36524;
    }

    @Override
    public int getScheduledTime() {
        return day;
    }

    @Override
    public List<Event> executeEvent() {
        if (isTerminatorEvent) {
            return new ArrayList<>();
        } else {
            simulation.setCurrentDay(day);    //set the simulation time to the current event time
            List<Event> newEvents = new ArrayList<>();
            int choice = ThreadLocalRandom.current().nextInt(100);

            if (choice < 25 && !simulation.noHumanLeft()) {
                simulation.infect(); //infect a human
                Event newZombie = new ZombieHuntsEvent(simulation, day + 1);
                newEvents.add(newZombie);
                day += ThreadLocalRandom.current().nextInt(10) + 1;
                newEvents.add(this);
            } else if (choice < 45) {
                simulation.zombieKilled();
            } else { //schedule a new hunt event
                day += ThreadLocalRandom.current().nextInt(10) + 1;
                newEvents.add(this);
            }
            if (simulation.noHumanLeft() || simulation.noZombieExist()) {
                isTerminatorEvent = true;
                return new ArrayList<>();
            }
            return newEvents;
        }
    }

    @Override
    public boolean isTerminatorEvent() {
        return isTerminatorEvent;
    }
}
