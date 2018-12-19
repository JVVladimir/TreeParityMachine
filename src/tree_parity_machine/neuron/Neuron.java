package tree_parity_machine.neuron;

import tree_parity_machine.NeuralNetException;

import java.util.Arrays;

public abstract class Neuron {

    protected int output;
    protected int inputs;
    protected double[] weights;

    public abstract void init();

    public abstract int getOutput(double[] input) throws NeuralNetException;

    @Override
    public String toString() {
        return "Neuron{" +
                "inputs=" + inputs +
                ", weights=" + Arrays.toString(weights) +
                '}';
    }
}
