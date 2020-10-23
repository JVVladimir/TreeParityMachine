package com.jvvladimir.machine.tree_machine.neuron

import com.jvvladimir.machine.learning.LearningParadigm

abstract class Neuron {
    protected var output = 0
    protected var inputs = 0
    lateinit var weights: IntArray
        protected set
    protected var leftBound = 0
    protected var rightBound = 0
    lateinit var paradigm: LearningParadigm

    abstract fun init()
    abstract fun changeWeights(input: IntArray, outputTPM: Int)
    abstract fun getOutput(input: IntArray): Int
    override fun toString(): String {
        return "Neuron{" +
                "output=" + output +
                ", inputs=" + inputs +
                ", weights=" + weights.contentToString() +
                ", leftBound=" + leftBound +
                ", rightBound=" + rightBound +
                ", paradigm=" + paradigm +
                '}'
    }
}