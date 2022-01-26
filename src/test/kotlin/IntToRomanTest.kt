import io.workcale.romanconverter.IntToRomanConverter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class IntToRomanTest {

    private val converter: IntToRomanConverter = IntToRomanConverter()

    @Test
    internal fun `convert 0 to roman should return an exception`() {
        assertThrows<IntToRomanConverter.RomanConvertException> {
            val result: String = converter.convert(0)
        }
    }

    @Test
    internal fun `convert negative integer to roman should return an exception`() {
        assertThrows<IntToRomanConverter.RomanConvertException> {
            val result: String = converter.convert(-10)
        }
    }

    @Test
    internal fun `convert high integer to roman should return an exception`() {
        assertThrows<IntToRomanConverter.RomanConvertException> {
            val result: String = converter.convert(4000)
        }
    }

    @Test
    internal fun `convert 1 to roman should return I`() {
        val result: String = converter.convert(1)
        assertThat(result).isEqualTo("I")
    }

    @Test
    internal fun `convert 2 to roman should return II`() {
        val result: String = converter.convert(2)
        assertThat(result).isEqualTo("II")
    }

    @Test
    internal fun `convert 3 to roman should return III`() {
        val result: String = converter.convert(3)
        assertThat(result).isEqualTo("III")
    }

    @Test
    internal fun `convert 4 to roman should return IV`() {
        val result: String = converter.convert(4)
        assertThat(result).isEqualTo("IV")
    }

    @Test
    internal fun `convert 5 to roman should return V`() {
        val result: String = converter.convert(5)
        assertThat(result).isEqualTo("V")
    }

    @Test
    internal fun `convert 6 to roman should return VI`() {
        val result: String = converter.convert(6)
        assertThat(result).isEqualTo("VI")
    }

    @Test
    internal fun `convert 7 to roman should return VII`() {
        val result: String = converter.convert(7)
        assertThat(result).isEqualTo("VII")
    }

    @Test
    internal fun `convert 8 to roman should return VIII`() {
        val converter = IntToRomanConverter()
        val result: String = converter.convert(8)
        assertThat(result).isEqualTo("VIII")
    }

    @Test
    internal fun `convert 9 to roman should return IX`() {
        val result: String = converter.convert(9)
        assertThat(result).isEqualTo("IX")
    }

    @Test
    internal fun `convert 10 to roman should return X`() {
        val result: String = converter.convert(10)
        assertThat(result).isEqualTo("X")
    }

    @Test
    internal fun `convert 20 to roman should return XX`() {
        val result: String = converter.convert(20)
        assertThat(result).isEqualTo("XX")
    }

    @Test
    internal fun `convert 60 to roman should return LX`() {
        val result: String = converter.convert(60)
        assertThat(result).isEqualTo("LX")
    }

    @Test
    internal fun `convert 100 to roman should return C`() {
        val result: String = converter.convert(60)
        assertThat(result).isEqualTo("LX")
    }

    @Test
    internal fun `convert 2000 to roman should return MM`() {
        val result: String = converter.convert(2000)
        assertThat(result).isEqualTo("MM")
    }


    @Test
    internal fun `convert 1994 to roman should return MCMXCIV`() {
        val result: String = converter.convert(1994)
        assertThat(result).isEqualTo("MCMXCIV")
    }

    @Test
    internal fun `convert 22 to roman should return XXII`() {
        val result: String = converter.convert(22)
        assertThat(result).isEqualTo("XXII")
    }



}