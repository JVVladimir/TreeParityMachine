import graphic.LineGraph;
import tree_parity_machine.NeuralNetException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        /*double[][] res = {{1, 2, 3}, {2, 1, 3}, {4, 3, 1}, {3, 7, 21}, {4, 9, 11}, {0, 30, 7}};
        TreeParityMachine tpm = new TreeParityMachine(3, 6, -2, 2);
        System.out.println(tpm.getOutput(res));
        System.out.println(tpm);*/
        /*GenerateSource.generate_matr(3,4, 0, 3);
        Graph graph = new Graph();
        graph.generateGraph();*/
        ArrayList<Double> list = new ArrayList<>();
        ArrayList<Double> list2 = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            list.add((double)i*i);
            list2.add((double)i*i*i/4);
        }
        new LineGraph().plot(list, list2);
    }

}
