abstract class AbstractDisplay {
  abstract fun open()
  abstract fun print()
  abstract fun close()

  fun display() {
    open()
    for (i in 1..5) {
      print()
    }
    close()
  }
}

class CharDisplay(var ch: Char): AbstractDisplay() {
  override fun open() {
    print("<<")
  }

  override fun print() {
    print(ch)
  }

  override fun close() {
    println(">>")
  }
}

class StringDisplay(var string: String): AbstractDisplay() {
  private var width: Int

  init {
    this.width = string.toByteArray().size
  }

  override fun open() {
    printLine()
  }

  override fun print() {
    println("|${string}|")
  }

  override fun close() {
    printLine()
  }

  private fun printLine() {
    print("+")
    for (i in 1..this.width) {
      print("-")
    }
    println("+")
  }
}

fun main() {
  val d1 = CharDisplay('H')
  val d2 = StringDisplay("Hello world!")
  val d3 = StringDisplay("こんにちは。")
  d1.display()
  d2.display()
  d3.display()
}
