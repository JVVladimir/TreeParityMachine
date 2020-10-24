package com.jvvladimir.machine

import com.jvvladimir.machine.learning.LearningParadigm
import com.jvvladimir.machine.learning.TPMTrainer
import com.jvvladimir.machine.tree_machine.TreeParityMachine
import com.jvvladimir.machine.tree_machine.tpm
import org.junit.jupiter.api.Test

class DslTest {

    @Test
    fun `dsl tpm creation test`() {
        val tpm1 = tpm {
            n = 3
            k = 4
            leftBound = -2
            rightBound = 2
            learningParadigm = LearningParadigm.HEBBIAN
        }
        val tpm2 = tpm {
            n = 3
            k = 4
            leftBound = -2
            rightBound = 2
            learningParadigm = LearningParadigm.HEBBIAN
        }
        val trainer = TPMTrainer()
        trainer.synchronize(tpm1, tpm2)
        println("${tpm1.secretKey.contentToString()}\n${tpm2.secretKey.contentToString()}")
    }
}