package main.java.Game;

import java.util.Random;

public class RandomNumberGenerator {
    private Random r = new Random();
    public   int generateNewCoordinate(int minValue, int maxValue) {
        return r.nextInt((maxValue - minValue) + 1) + minValue;
    }
}
