package travel_20190406.storage;

public final class SequenceGenerator {

    private static long value = 0;

    public static long generateSequence() {
        return ++value;
    }
}
