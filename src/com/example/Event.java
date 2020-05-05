package com.example;

import java.util.List;

public interface Event {
    /**
     * get the time schedule when the event should happen.
     * @return a int to present the time point on the time line
     */
    int getScheduledTime();

    /**
     * Execute the event, which should also change the state of the simulator.
     * @return the list of new events created by executing this event.
     */
    List<Event> executeEvent();

    /**
     * Test if the current event is the terminator event (last event)
     * @return whether the event is the terminator event.
     */
    boolean isTerminatorEvent();
}
