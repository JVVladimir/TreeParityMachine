package com.jvvladimir.machine.learning

import com.jvvladimir.machine.tree_machine.NeuralNetException
import com.jvvladimir.machine.tree_machine.TreeParityMachine
import com.jvvladimir.machine.utils.MyRandom.getInts

class TPMTrainer {

    private var epochs = 200

    fun synchronize(tpm1: TreeParityMachine, tpm2: TreeParityMachine): Boolean {
        if (tpm1.learningParadigm !== tpm2.learningParadigm) throw NeuralNetException("Алгоритмы обучения не совпадают!")
        var k = 0
        val params = tpm1.tpmParams
        var input = getInts(params[0] * params[1], -1, 1)
        while (k < epochs) {
            val out1 = tpm1.getOutput(input)
            val out2 = tpm2.getOutput(input)
            if (tpm1.secretKey.contentEquals(tpm2.secretKey)) {
                return true
            }
            if (out1 == out2) {
                tpm1.train(input, out2)
                tpm2.train(input, out1)
            }
            input = getInts(params[0] * params[1], -1, 1)
            k++
        }
        return false
    }
}