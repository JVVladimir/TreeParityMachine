package learning_algorithm;

import tree_parity_machine.NeuralNetException;
import tree_parity_machine.TreeParityMachine;
import utils.Random;

import java.util.ArrayList;
import java.util.Arrays;

public class TPMTrainer {

    private int numIteration = 5000;

    public ArrayList<Integer>[] synchronize(TreeParityMachine tpm1, TreeParityMachine tpm2) throws NeuralNetException {
        int k = 0;
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> outputTPM1 = new ArrayList<>();
        ArrayList<Integer> outputTPM2 = new ArrayList<>();
        int[] params = tpm1.getTPMParams();
        double[] input = Random.getIntsCastedToDouble(params[0]);
        while (k < numIteration) {
            int out1 = tpm1.getOutput(input);
            int out2 = tpm2.getOutput(input);
            System.out.println("key1: "+Arrays.toString(tpm1.getSecretKey()));
            System.out.println("key2: "+Arrays.toString(tpm2.getSecretKey()));
            if(Arrays.equals(tpm1.getSecretKey(), tpm2.getSecretKey())) {
                result.add(k);
                break;
            }
            outputTPM1.add(out1);
            outputTPM2.add(out2);
            if (out1 == out2);
            else {
                tpm1.train(input, out2);
                tpm2.train(input, out1);
            }
            input = Random.getIntsCastedToDouble(params[0]);
            k++;
        }
        // System.out.println("*******  "+res+"  ********");
        return new ArrayList[]{outputTPM1, outputTPM2, result};
    }

    public int getNumIteration() {
        return numIteration;
    }

    public void setNumIteration(int numIteration) {
        this.numIteration = numIteration;
    }
}
