package com.example;

public class Main {
    public static void main(String[] args) {
        Framework framework = new Framework();
        ZombieInvasion[] invasions = new ZombieInvasion[100];
        int zombieWins = 0;
        int humanWins = 0;
        int zombieDays = 0;
        int humanDays = 0;
        for (int i = 0; i < 100; i++) {
            invasions[i] = new ZombieInvasion();
            framework.setup(invasions[i]);
            framework.execute();
            if (invasions[i].noHumanLeft()) {
                zombieWins++;
                zombieDays += invasions[i].getCurrentDay();
            } else if (invasions[i].noZombieExist()) {
                humanWins++;
                humanDays += invasions[i].getCurrentDay();
            }
        }
        System.out.println("Percentage of zombie wins = " + zombieWins + "%.");
        System.out.printf("Average days for zombies win = %.2f %n",(zombieDays/(double)zombieWins));
        System.out.println("Percentage of human wins = " + humanWins + "%.");
        System.out.printf("Average days for human win = %.2f %n",(humanDays/(double)humanWins));
    }
}
