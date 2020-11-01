open class Banner(var string: String) {
  open fun showWithParen() {
    println("(${string})")
  }

  open fun showWithAster() {
    println("*${string}*")
  }
}

interface Print {
  fun printWeak()
  fun printStrong()
}

class PrintBanner(string: String): Banner(string), Print {
  override fun printWeak() {
    showWithParen()
  }

  override fun printStrong() {
    showWithAster()
  }
}

fun main() {
  val p = PrintBanner("Hello world!") as Print
  p.printWeak()
  p.printStrong()
}
