package com.jvvladimir.machine.utils

import java.util.Random

/**
 * Класс генерирует целые или вещественные числа в заданном диапазоне, а также массивы
 * Если границы равны 0, то генерируется любое число
 * Если границы равны, но не 0, то возвращается левая граница
 * В остальных случаях генерируется число в заданном диапазоне
 */

object Random {

    fun getInt(leftBound: Int, rightBound: Int): Int {
        return Random().ints(1, leftBound, rightBound + 1).findFirst().asInt
    }

    fun getInts(n: Int, leftBound: Int, rightBound: Int): IntArray {
        val ints = IntArray(n)
        for (i in 0 until n) ints[i] = getInt(leftBound, rightBound)
        return ints
    }
}