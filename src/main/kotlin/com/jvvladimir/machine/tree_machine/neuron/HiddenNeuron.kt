package com.jvvladimir.machine.tree_machine.neuron

import com.jvvladimir.machine.learning.LearningParadigm
import com.jvvladimir.machine.tree_machine.NeuralNetException
import com.jvvladimir.machine.utils.MyRandom.getInt
import com.jvvladimir.machine.utils.MyRandom.getInts

class HiddenNeuron(inputs: Int, leftBound: Int, rightBound: Int, paradigm: LearningParadigm) : Neuron() {

    init {
        this.inputs = inputs
        this.paradigm = paradigm
        weights = IntArray(inputs)
        this.leftBound = leftBound
        this.rightBound = rightBound
    }

    override fun init() {
        weights = getInts(inputs, leftBound, rightBound)
    }

    override fun changeWeights(input: IntArray, outputTPM: Int) {
        for (i in input.indices) {
            val dW = input[i] * outputTPM
            weights[i] = when (paradigm) {
                LearningParadigm.HEBBIAN -> weights[i] + dW
                LearningParadigm.ANTI_HEBBIAN -> weights[i] - dW
                LearningParadigm.RANDOM_WALK -> weights[i] + input[i]
            }
            if (weights[i] > rightBound) weights[i] = rightBound else if (weights[i] < leftBound) weights[i] = leftBound
        }
    }

    override fun getOutput(input: IntArray): Int {
        if (input.size != inputs) throw NeuralNetException("Входной вектор не соответствует кол-ву весовых коэффициентов")
        var sum = 0
        for (i in 0 until inputs) sum += weights[i] * input[i]
        output = if (sum > 0) 1 else -1
        return output
    }
}