package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Framework {
    private SimulationPlugin simulationPlugin; //the plugin for the simulation
    private Queue<Event> eventQueue; //the Queue of events to be executed

    /**
     * Set up the framework.
     *
     * @param simulationPlugin the simulation plugin to be loaded.
     */
    public void setup(SimulationPlugin simulationPlugin) {
        this.simulationPlugin = simulationPlugin;
        eventQueue = new PriorityQueue<>(Comparator.comparingInt(Event::getScheduledTime));
        eventQueue.addAll(simulationPlugin.simulationStarts()); //add initial events of the simulation
    }

    /**
     * Execute all the events in the queue.
     */
    public void execute() {
        while (eventQueue.size() != 0) {    //execute when there are events in the queue.
            Event currentEvent = eventQueue.poll();    //get the next event
            List<Event> newEvents = currentEvent.executeEvent();    //execute the event
            eventQueue.addAll(newEvents);    //add the new created event to the queue
            if (currentEvent.isTerminatorEvent()) {    //ends the simulation if the event is a terminator event
                break;
            }
        }
        simulationPlugin.simulationEnds();
    }
}
