package main.java.travel_20190315.storage;

public final class SequenceGenerator {

    private static long value = 0;

    public static long generateSequence() {
        return ++value;
    }
}
