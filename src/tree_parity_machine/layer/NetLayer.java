package tree_parity_machine.layer;

import tree_parity_machine.neuron.Neuron;

import java.util.Arrays;

public abstract class NetLayer {

    protected int outputs;
    protected int inputs;
    protected Neuron[] neurons;

    @Override
    public String toString() {
        return "NetLayer{" +
                "neurons=" + Arrays.toString(neurons) +
                ", outputs=" + outputs +
                ", inputs=" + inputs +
                '}';
    }
}
