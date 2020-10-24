package com.jvvladimir.machine.tree_machine

import com.jvvladimir.machine.learning.LearningParadigm
import com.jvvladimir.machine.learning.Training
import com.jvvladimir.machine.tree_machine.layer.HiddenLayer
import com.jvvladimir.machine.tree_machine.layer.OutputLayer

class TreeParityMachine(
        block: TreeParityMachine.(TreeParityMachine) -> Unit
) : Training {

    init {
        this.block(this)
    }

    var n: Int = 3
    var k: Int = 4
    var leftBound: Int = -2
    var rightBound: Int = 2
    var learningParadigm: LearningParadigm = LearningParadigm.HEBBIAN

    private val hiddenLayer = HiddenLayer(n, k, leftBound, rightBound, learningParadigm)
    private val outputLayer = OutputLayer(k)

    fun getOutput(input: IntArray): Int {
        return outputLayer.getOutput(hiddenLayer.getOutput(input))
    }

    override fun train(input: IntArray, output: Int) {
        val hiddenNeurons = hiddenLayer.neurons
        for (i in 0 until k) hiddenNeurons[i].changeWeights(input.copyOfRange(n * i, n * (i + 1)), output)
    }

    val secretKey: IntArray
        get() {
            val key = IntArray(n * k)
            val neurons = hiddenLayer.neurons
            for (i in 0 until k) {
                val mas = neurons[i].weights
                if (n >= 0) System.arraycopy(mas, 0, key, i * n, n)
            }
            return key
        }

    val tpmParams: IntArray
        get() = intArrayOf(n, k)

    override fun toString() =
            "TreeParityMachine{ n= $n k= $k leftBound= $leftBound rightBound= $rightBound hiddenLayer= $hiddenLayer outputLayer= $outputLayer paradigm= $learningParadigm}"
}

fun tpm(block: TreeParityMachine.(TreeParityMachine) -> Unit): TreeParityMachine {
    return TreeParityMachine(block)
}