package tree_parity_machine.neuron;

import learning_algorithm.LearningParadigm;
import tree_parity_machine.NeuralNetException;
import utils.Random;

public class HiddenNeuron extends Neuron {

    public HiddenNeuron(int inputs, int leftBound, int rightBound, LearningParadigm paradigm) {
        this.inputs = inputs;
        this.paradigm = paradigm;
        weights = new double[inputs];
        Random.setBounds(leftBound, rightBound);
    }

    public void init() {
        for (int i = 0; i < inputs; i++)
            weights[i] = Random.getInt();
    }

    @Override
    public void changeWeights(double[] input, int outputTPM, LearningParadigm paradigm) {
        for (int i = 0; i < input.length; i++)
            switch (paradigm) {
                case HEBIAN:
                    weights[i] += input[i] * outputTPM;
                    break;
                case ANTI_HEBBIAN:
                    weights[i] -= input[i] * outputTPM;
                    break;
                case RANDOM_WALK:
                    weights[i] += input[i];
                    break;
            }
    }

    public int getOutput(double[] input) throws NeuralNetException {
        if (input == null || input.length != inputs)
            throw new NeuralNetException("Входной вектор не соответствует кол-ву весовых коэффициентов");
        double sum = 0;
        for (int i = 0; i < inputs; i++)
            sum += weights[i] * input[i];
        output = sum > 0 ? 1 : -1;
        return output;
    }

}
