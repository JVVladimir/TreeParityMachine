package tree_parity_machine;

import tree_parity_machine.layer.HiddenLayer;
import tree_parity_machine.layer.OutputLayer;

public class TreeParityMachine {

    private int n;
    private int k;
    private int leftBound;
    private int rightBound;
    private HiddenLayer hiddenLayer;
    private OutputLayer outputLayer;

    public TreeParityMachine(int n, int k, int leftBound, int rightBound) {
        this.n = n;
        this.k = k;
        this.leftBound = leftBound;
        this.rightBound = rightBound;
        hiddenLayer = new HiddenLayer(n, k, leftBound, rightBound);
        outputLayer = new OutputLayer(k);
    }

    public int getOutput(double[][] input) throws NeuralNetException {
        return outputLayer.getOutput(hiddenLayer.getOutput(input));
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
