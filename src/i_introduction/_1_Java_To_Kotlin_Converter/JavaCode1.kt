package i_introduction._1_Java_To_Kotlin_Converter

import util.JavaCode

class JavaCode1: JavaCode() {
    fun task1(collection: Collection<Int>): String {
        val sb = StringBuilder()
        sb.append("{")
        val iterator = collection.iterator()
        while (iterator.hasNext()) {
            sb.append(iterator.next())
            if (iterator.hasNext()) {
                sb.append(", ")
            }
        }
        sb.append("}")
        return sb.toString()
    }
}
