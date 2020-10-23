package com.jvvladimir.machine.tree_machine.layer

import com.jvvladimir.machine.tree_machine.NeuralNetException
import com.jvvladimir.machine.tree_machine.neuron.OutputNeuron

class OutputLayer(k: Int) : NetLayer() {

    init {
        inputs = k
        outputs = 1
        neurons = Array(1) {
            neurons[it] = OutputNeuron(k)
            neurons[it].init()
            neurons[it]
        }
    }

    fun getOutput(input: IntArray): Int {
        if (input.size != inputs) throw NeuralNetException("Входной вектор не соответствует числу нейронов на скрытом слое")
        return neurons[0].getOutput(input)
    }
}