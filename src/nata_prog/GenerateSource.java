package nata_prog;

import utils.Random;

public class GenerateSource {

    public static int[][] generate_matr(int sizeM, int sizeN){
        int[][] matr = new int[sizeM][sizeN];
        for (int i = 0; i < sizeM; i++)
            for (int j = 0; j< sizeN; j++)
               matr[i][j]  = Random.getInt();
        return matr;
    }

    private static int rnd(int start, int end) {
        end -= start;
        return (int) (Math.random() * ++end) + start;
    }
}
