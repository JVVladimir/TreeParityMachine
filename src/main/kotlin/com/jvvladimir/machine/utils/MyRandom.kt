package com.jvvladimir.machine.utils

import kotlin.random.Random


/**
 * Класс генерирует целые или вещественные числа в заданном диапазоне, а также массивы
 * Если границы равны 0, то генерируется любое число
 * Если границы равны, но не 0, то возвращается левая граница
 * В остальных случаях генерируется число в заданном диапазоне
 */

object MyRandom {

    fun getInt(leftBound: Int, rightBound: Int) = Random.nextInt(leftBound, rightBound + 1)

    fun getInts(n: Int, leftBound: Int, rightBound: Int) = IntRange(0, n - 1).map { getInt(leftBound, rightBound) }.toIntArray()
}