import learning_algorithm.TPMTrainer;
import tree_parity_machine.TreeParityMachine;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    /*TODO: провести анализ скорости сходимости рабочего алгоритма (10000 примеров и среднее число итерации до сходимости) + график (точка, где сошлось и итерация)
      TODO: сделать график второго выхода в виде "*". Или сместить по оси X на пол итерации.
     */

    public static void main(String[] args) throws Exception {
        double mid = 0;
        int n = 50;
        TreeParityMachine tpm1 = null;
        //for(int i = 0; i < n; i++) {
        tpm1 = new TreeParityMachine(4, 8, -3, 3);
        TreeParityMachine tpm2 = new TreeParityMachine(4, 8, -3, 3);
        TPMTrainer trainer = new TPMTrainer();
        ArrayList<Integer>[] list = trainer.synchronize(tpm1, tpm2);
        //  mid+=list[2].get(0);
        //}
        System.out.println(list[2].get(0));
        System.out.println(Arrays.toString(tpm1.getSecretKey()));
        System.out.println(Arrays.toString(tpm2.getSecretKey()));
        //System.out.println(mid/n);
        //System.out.println(Double.doubleToRawLongBits(tpm1.getSecretKey()));
        System.out.println(toBits(tpm1.getSecretKey()));
        //System.out.println(list[0] + "\n"+list[1]);
        //new LineGraph().plot(list[0], list[1]);
    }

    public static String toBits(double[] mas) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < mas.length; i++)
            str.append(getBits((int) mas[i]));
        return str.toString();
    }

    public static String getBits(final int a) {
        StringBuilder str = new StringBuilder();
        for (int b = 1; b != 0; b <<= 1) {
            if ((a & b) != 0) str.append("1");
            else str.append("0");
        }
        return str.reverse().toString();
    }

}
