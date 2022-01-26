package io.workcale.romanconverter

import java.lang.RuntimeException

class IntToRomanConverter {

    companion object{
        private val OnesRomanRanges =  RomanRanges(minor = "I", middle = "V", major = "X")
        private val TensRomanRanges =  RomanRanges(minor = "X", middle = "L", major = "C")
        private val HundredsRomanRanges =  RomanRanges(minor = "C", middle = "D", major = "M")
        private val ThousandsRomanRanges =  RomanRanges(minor = "M")

    }
    private val romanRangePerScale = listOf(
        OnesRomanRanges, TensRomanRanges, HundredsRomanRanges, ThousandsRomanRanges
    )

    fun convert(integer: Int): String {
        if (integer !in 1..3999)
            throw RomanConvertException()
        var i = integer
        var currentScaleIndex = 0
        var result = ""
        while(i != 0){
            val currentScaleValue = i % 10
            result=convertWithRange(currentScaleValue, romanRangePerScale[currentScaleIndex])+result
            currentScaleIndex += 1
            i /= 10
        }
        return result
    }

    private fun convertWithRange(
        integer: Int,
        romanRanges: RomanRanges,
    ): String {
        return when (integer) {
            in 1..3 -> convertBetweenOneAndThree(romanRanges, integer)
            4 -> convertFour(romanRanges)
            5 -> romanRanges.middle
            6 -> convertSix(romanRanges)
            in 6..8 -> convertBetweenSixAndEight(romanRanges, integer)
            9 -> convertNine(romanRanges)
            else -> ""
        }
    }

    private fun convertNine(romanRanges: RomanRanges): String =
        """${romanRanges.minor}${romanRanges.major}"""


    private fun convertBetweenSixAndEight(
        romanRanges: RomanRanges,
        integer: Int,
    ) = romanRanges.middle + convertBetweenOneAndThree(romanRanges, integer - 5)

    private fun convertFour(romanRanges: RomanRanges) = """${romanRanges.minor}${romanRanges.middle}"""

    private fun convertSix(romanRanges: RomanRanges) = """${romanRanges.middle}${romanRanges.minor}"""

    private fun convertBetweenOneAndThree(romanRanges: RomanRanges, integer: Int) = romanRanges.minor.repeat(integer)


    internal class RomanConvertException : RuntimeException()

    internal data class RomanRanges(
        val minor: String,
        val middle: String = "",
        val major: String? = "",
    )

}
