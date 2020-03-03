package utils;

/**
 * Класс генерирует целые или вещественные числа в заданном диапазоне, а также массивы
 * Если границы равны 0, то генерируется любое число
 * Если границы равны, но не 0, то возвращается левая граница
 * В остальных случаях генерируется число в заданном диапазоне
 */
public class Random {

    private static long seed;

    private Random() {
    }

    public static short getInt(int leftBound, int rightBound) {
        return (short) new java.util.Random().ints(1, leftBound, rightBound + 1).findFirst().getAsInt();
    }

    public static short[] getInts(int n, int leftBound, int rightBound) {
        short[] shorts = new short[n];
        for(int i = 0; i < n; i++)
            shorts[i] = (short) getInt(leftBound, rightBound);
        return shorts;// new java.util.Random().ints(n, leftBound, rightBound + 1).forEach();
    }

    public static void setSeed(long seed) {
        Random.seed = seed;
    }

    public static long getSeed() {
        return seed;
    }
}
