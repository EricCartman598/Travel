package Travel_20190313.Storage;

public final class SequenceGenerator {

    private static long value = 0;

    public static long generateSequence() {
        return ++value;
    }
}
