// COMP2850 Portfolio: Week 2
// Function to redact sensitive information in a string
// Student Name: Nehir Kurumahmut
// Student ID: 201984143
fun redact( inputdocument: String, text: String, char: Char = 'X'): String {
    val redaction = char.toString().repeat(text.length)
    return inputdocument.replace(text, redaction)
}
