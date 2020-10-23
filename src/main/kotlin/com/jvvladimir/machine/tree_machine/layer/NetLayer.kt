package com.jvvladimir.machine.tree_machine.layer

import com.jvvladimir.machine.learning.LearningParadigm
import com.jvvladimir.machine.learning.LearningParadigm.HEBBIAN
import com.jvvladimir.machine.tree_machine.neuron.Neuron

abstract class NetLayer {
    protected var outputs = 0
    protected var inputs = 0
    lateinit var neurons: Array<Neuron>
    var paradigm: LearningParadigm = HEBBIAN

    override fun toString() = "NetLayer{ neurons= ${neurons.contentToString()} outputs= $outputs inputs= $inputs}"
}