// COMP2850 Portfolio: Week 3
// Tests for median()

import io.kotest.core.spec.style.FreeSpec
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.floats.plusOrMinus

const val tolerance = 0.000001f

@Suppress("Unused")
class MedianTest : FreeSpec({
    "Exception when size=0" {
        shouldThrow<IllegalArgumentException> {
            median(listOf())
        }
    }

    // Write four more tests here
    // This test checks that if the list contains one element, the output should be the element itself.
   @Test
fun MedianOneElement() {
    median(listOf(1.0f)) shouldBe 1.0f
}
// The test checks that if the list contains two elements, then the output should be the average of two elements. For this test, 2.0 + 4.0  = 6.0 / 2 = 3.
@Test
fun MedianTwoElement() {
    median(listOf(2.0f, 4.0f)) shouldBe 3.0f
}
@Test
fun MedianThreeElements() {
    median(listOf(1.0f, 4.0f, 7.0f)) shouldBe 4.0f
}
@Test
fun MedianFourElements() {
    median(listOf(2.0f, 4.0f, 6.0f, 8.0f)) shouldBe 5.0f
}
 

})
