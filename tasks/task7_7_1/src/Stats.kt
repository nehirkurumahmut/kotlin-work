// Task 7.7.1: statistics functions
fun median(data: List<Float>): Float {
    if(data.isEmpty()) {
        throw IllegalArgumentException("Error: List is empty.")
    }
    val sorted = data.sorted()
    val middle = sorted.size / 2
    return if (sorted.size % 2 == 1) {
        sorted[middle]
    } else {
      (sorted[middle / 2 - 1] + sorted[n / 2)] / 2f
       } }

@Test
fun MedianOneElement() {
    median(listOf(1.0f)) shouldBe 1.0f
}

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
       
