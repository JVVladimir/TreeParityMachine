package com.jvvladimir.machine.tree_machine.neuron

import com.jvvladimir.machine.tree_machine.NeuralNetException

class OutputNeuron(inputs: Int) : Neuron() {

    init {
        this.inputs = inputs
        weights = IntArray(inputs)
    }

    override fun init() {
        weights.fill(1)
    }

    override fun changeWeights(input: IntArray, outputTPM: Int) {
        TODO("Not implemented")
    }

    override fun getOutput(input: IntArray): Int {
        if (input.size != inputs) throw NeuralNetException("Входной вектор не соответствует кол-ву весовых коэффициентов")
        var res = 1
        for (i in 0 until inputs) res *= input[i]
        output = res
        return res
    }
}