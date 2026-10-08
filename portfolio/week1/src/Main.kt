// COMP2850 Portfolio: Week 1
// Program to compute area of a triangle
// Student Name: Nehir Kurumahmut
// Student ID: 201984143

import kotlin.math.sqrt
import kotlin.system.exitProcess
fun main(args: Array<String>) {
  if (args.size < 3) {
    println("Error: values for a, b, c required on command line")
    exitProcess(1)
  }
  val number a = args[0].toDouble()
  val number b = args[1].toDouble()
  val number c = args[2].toDouble()
  val s = (number a + number b + number c) / 2
  val area A1 = s * (s - number a) * (s - number b) * (s - number c)
  val area A2 = sqrt(area A1)
  println("Area = %.5f" .format(area A2))
  }
  
