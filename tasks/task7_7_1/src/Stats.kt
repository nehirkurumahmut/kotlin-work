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
       
