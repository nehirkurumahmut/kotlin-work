// COMP2850 Portfolio: Week 2
// Functions for working with triangle geometry
// Student Name: Nehir Kurumahmut
// Student ID: 201984143
import kotlin.math.sqrt

class Triangle ( val sideA: Double, val sideB: Double, val sideC: Double) {
    init {
       if (!isValidTriangle(sideA, sideB, sideC)) {
        throw IllegalArgumentException("Triangle is invalid!")
    } }
    val perimeter: Double
        get() = sideA + sideB + sideC
    val semiPerimeter: Double
        get() = perimeter / 2.0
    val area: Double
        get() {
            val s = semiPerimeter
            return sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
   
  }
   override fun toString(): String = "Triangle($sideA, $sideB, $sideC)"
}
            
// Add isValidTriangle() and triangleArea() functions here

fun isValidTriangle(sideA: Double, sideB: Double, sideC: Double): Boolean {
    return sideA > 0 && sideB > 0 && sideC > 0 && (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA)
  }
  
