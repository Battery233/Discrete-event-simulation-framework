# A discrete event simulation framework with a sample plugin

A simple framework for discrete event simulation and a sample client that uses the framework to simulate a zombie invasion.

A zombie is a fictional(🧟?) undead creature that infects living creatures, which then become zombies. On the first day of the simulation, each zombie goes hunting. When a zombie hunts, one of several things happens:

- With 25% probability, it infects a human, causing the zombie population to increase by one and human population to decrease by one.
- With 20% probability, the zombie is destroyed.
- With 55% probability, the zombie neither infects a human nor is destroyed.

Assuming it is not destroyed, the zombie then goes to sleep, hunting again x*x* time units in the future, where x*x* is a (uniformly distributed) random number between 1 and 10 (inclusive). A newly-infected zombie hunts for the first time on the day (time unit) after it was infected.

The client simulate an initial population of 1 million humans and 4 zombies. The simulation should continue until all humans have become infected, all zombies have been destroyed, or 100 years (36524 time units) have elapsed. Print the outcome at the end of the simulation. The outcome should include the human and zombie populations, and the number of days that elapsed.
