import learning_algorithm.TPMTrainer;
import tree_parity_machine.TreeParityMachine;
import utils.FileManager;

import java.nio.file.Path;
import java.util.Arrays;

import static learning_algorithm.LearningParadigm.HEBBIAN;

public class Main {

    private static final String PATH_TO_KEYS = "C:/Users/vkashitsyn/IdeaProjects/TreeParityMachine/src/resources/keys";

    public static void main(String[] args) {
        var tpm1 = new TreeParityMachine(3, 4, -2, 2, HEBBIAN);
        var tpm2 = new TreeParityMachine(3, 4, -2, 2, HEBBIAN);
        var trainer = new TPMTrainer();
        trainer.synchronize(tpm1, tpm2);
        System.out.println(Arrays.toString(tpm1.getSecretKey()) + "\n" + Arrays.toString(tpm2.getSecretKey()));
        System.out.println("Древовидные машины чётности успшено обучены!");
        FileManager.saveToFile(tpm1.getSecretKey(), tpm2.getSecretKey(), Path.of(PATH_TO_KEYS));
    }

}
