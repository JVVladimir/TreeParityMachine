import javafx.concurrent.Task;
import nata_prog.GenerateSource;
import nata_prog.Graph;
import tree_parity_machine.NeuralNetException;
import tree_parity_machine.TreeParityMachine;
import utils.Random;

import java.util.concurrent.Executors;

import static javafx.application.Application.launch;

public class Main {

    public static void main(String[] args) throws NeuralNetException {
        /*double[][] res = {{1, 2, 3}, {2, 1, 3}, {4, 3, 1}, {3, 7, 21}, {4, 9, 11}, {0, 30, 7}};
        TreeParityMachine tpm = new TreeParityMachine(3, 6, -2, 2);
        System.out.println(tpm.getOutput(res));
        System.out.println(tpm);*/
        GenerateSource.generate_matr(3,4, 0, 3);
        Graph graph = new Graph();
        graph.generateGraph();


    }

}
