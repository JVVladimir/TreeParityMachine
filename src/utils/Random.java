package utils;

/**
 * Класс генерирует целые или вещественные числа в заданном диапазоне
 *  Если границы равны 0, то генерируется любое число
 *  Если границы равны, но не 0, то возвращается левая граница
 *  В остальных случаях генерируется число в заданном диапазоне
 */
public class Random {

    private static long seed;
    private static double left = 0, right = 0;

    private Random() {
    }

    public static double getDouble() {
        if (left == 0 && right == 0)
            return new java.util.Random().nextDouble();
        else if (left == right)
            return left;
        else
            return left + new java.util.Random().nextDouble() * (right - left);
    }

    public static int getInt() {
        if (left == 0 && right == 0)
            return new java.util.Random().nextInt();
        else if (left == right)
            return (int)left;
        else
            return (int)(left + Math.round(new java.util.Random().nextDouble() * (right - left)));
    }

    public static void setSeed(long seed) {
        Random.seed = seed;
    }

    public static long getSeed() {
        return seed;
    }

    public static void setBounds(double leftBound, double rightBound) {
        left = leftBound;
        right = rightBound;
    }
}
