package main.java.travel_20190307.Storage;

public final class SequenceGenerator {

    private static long value = 0;

    public static long generateSequence() {
        return ++value;
    }
}
