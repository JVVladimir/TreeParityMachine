package com.jvvladimir.machine.tree_machine.layer

import com.jvvladimir.machine.learning.LearningParadigm
import com.jvvladimir.machine.tree_machine.NeuralNetException
import com.jvvladimir.machine.tree_machine.neuron.HiddenNeuron

class HiddenLayer(n: Int, k: Int, leftBound: Int, rightBound: Int, paradigm: LearningParadigm) : NetLayer() {

    private lateinit var res: IntArray

    init {
        inputs = n
        outputs = k
        this.paradigm = paradigm
        neurons = Array(k) {
            HiddenNeuron(n, leftBound, rightBound, paradigm)
        }
        neurons.forEach { it.init() }
    }

    fun getOutput(input: IntArray): IntArray {
        if (input.size != inputs * outputs) throw NeuralNetException("Входной вектор не соответствует кол-ву весовых коэффициентов")
        val res = IntArray(outputs)
        for (i in 0 until outputs) res[i] = neurons[i].getOutput(input.copyOfRange(inputs * i, inputs * (i + 1)))
        this.res = res
        return res
    }

    override fun toString() =
            "HiddenLayer{ res= ${res.contentToString()} outputs= $outputs inputs= $inputs neurons= ${neurons.contentToString()} paradigm= $paradigm}"
}