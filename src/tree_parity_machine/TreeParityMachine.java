package tree_parity_machine;

import learning_algorithm.LearningParadigm;
import learning_algorithm.Training;
import tree_parity_machine.layer.HiddenLayer;
import tree_parity_machine.layer.OutputLayer;
import tree_parity_machine.neuron.Neuron;

import java.util.Arrays;

public class TreeParityMachine implements Training {

    private int n;
    private int k;
    private int leftBound;
    private int rightBound;
    private HiddenLayer hiddenLayer;
    private OutputLayer outputLayer;
    private LearningParadigm paradigm;

    public TreeParityMachine(int n, int k, int leftBound, int rightBound) {
        this.n = n;
        this.k = k;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        this.paradigm = LearningParadigm.HEBIAN;
        hiddenLayer = new HiddenLayer(n, k, leftBound, rightBound, paradigm);
        outputLayer = new OutputLayer(k);
    }

    public int getOutput(double[] input) throws NeuralNetException {
        return outputLayer.getOutput(hiddenLayer.getOutput(input));
    }

    @Override
    public void train(double[] input) {
        try {
            int output = getOutput(input);
            double[] hiddenOutput = hiddenLayer.getOutput(input);
            Neuron[] hiddenNeurons = hiddenLayer.getNeurons();
            for (int i = 0; i < hiddenOutput.length; i++)
                if (hiddenOutput[i] == output)
                    hiddenNeurons[i].changeWeights(input, output, paradigm);
        } catch (NeuralNetException e) {
            e.printStackTrace();
        }
    }

    public double[] getSecretKey() {
        double[] key = new double[n*k];
        Neuron[] neurons = hiddenLayer.getNeurons();
        for(int i = 0; i < k; i++) {
            double[] mas = neurons[i].getWeights();
            for(int j = 0; j < n; j++)
                key[i+j] = mas[j];
        }
        return key;
    }

    public LearningParadigm getLearningParadigm() {
        return paradigm;
    }

    public void setLearningParadigm(LearningParadigm paradigm) {
        this.paradigm = paradigm;
    }

    public int[] getTPMParams() {
        int[] params = {n, k};
        return params;
    }

    @Override
    public String toString() {
        return "TreeParityMachine{" +
                "n=" + n +
                ", k=" + k +
                ", leftBound=" + leftBound +
                ", rightBound=" + rightBound +
                ", hiddenLayer=" + hiddenLayer +
                ", outputLayer=" + outputLayer +
                '}';
    }
}
