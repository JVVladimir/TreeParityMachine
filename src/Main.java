import graphic.LineGraph;
import learning_algorithm.LearningParadigm;
import learning_algorithm.TPMTrainer;
import tree_parity_machine.TreeParityMachine;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        double mid = 0;
        //int n = 50;
        //for(int i = 0; i < n; i++) {
          //  System.out.println("Inter "+i);
            TreeParityMachine tpm1 = new TreeParityMachine(3, 3, -2, 2);
            tpm1.setLearningParadigm(LearningParadigm.ANTI_HEBBIAN);
            TreeParityMachine tpm2 = new TreeParityMachine(3, 3, -2, 2);
            tpm2.setLearningParadigm(LearningParadigm.ANTI_HEBBIAN);
            TPMTrainer trainer = new TPMTrainer();
            ArrayList<Integer>[] list = trainer.synchronize(tpm1, tpm2);
          //  mid+=list[2].get(0);
        //}
        //System.out.println(mid/n);
        //System.out.println(list[0] + "\n"+list[1]);
        //new LineGraph().plot(list[0], list[1]);
    }

}
