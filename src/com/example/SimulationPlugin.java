package com.example;

import java.util.List;

public interface SimulationPlugin {
    /**
     * Initialize the simulation.
     * @return a list of initial events created by the simulation
     */
    List<Event> simulationStarts();

    /**
     * The function will be called when the simulation ends.
     */
    void simulationEnds();
}
