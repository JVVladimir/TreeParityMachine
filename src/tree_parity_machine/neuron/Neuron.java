package tree_parity_machine.neuron;

import learning_algorithm.LearningParadigm;
import tree_parity_machine.NeuralNetException;

import java.util.Arrays;

public abstract class Neuron {

    protected int output;
    protected int inputs;
    protected double[] weights;
    protected int leftBound;
    protected int rightBound;
    protected LearningParadigm paradigm;

    public abstract void init();

    public abstract void changeWeights(double[] input, int outputTPM);

    public abstract int getOutput(double[] input) throws NeuralNetException;

    public double[] getWeights() {
        return weights;
    }

    public LearningParadigm getParadigm() {
        return paradigm;
    }

    public void setParadigm(LearningParadigm paradigm) {
        this.paradigm = paradigm;
    }

    @Override
    public String toString() {
        return "Neuron{" +
                "inputs=" + inputs +
                ", weights=" + Arrays.toString(weights) +
                '}';
    }
}
