interface Iterator {
  fun hasNext(): Boolean
  fun next(): Any?
}

interface Aggregate {
  fun iterator(): Iterator
}

class Book(var name: String) {}

class BookShelfIterator(bookShelf: BookShelf) : Iterator {
  private var bookShelf: BookShelf
  private var index: Int

  init {
    this.bookShelf = bookShelf
    this.index = 0
  }

  override fun hasNext(): Boolean {
    return this.index < bookShelf.getLength()
  }

  override fun next(): Any? {
    val book = this.bookShelf.getBookAt(index)
    index++
    return book
  }
}

class BookShelf(maxsize: Int) : Aggregate {

  private var books: Array<Book?>
  private var last: Int = 0

  init {
    this.books = arrayOfNulls<Book>(maxsize)
  }

  fun getBookAt(index: Int): Book? {
    return this.books.get(index)
  }

  fun appendBook(book: Book) {
    this.books[last] = book
    last++
  }

  fun getLength(): Int {
    return this.last
  }

  override fun iterator(): Iterator {
    return BookShelfIterator(this)
  }
}

fun main() {
  val bookShelf = BookShelf(4)
  bookShelf.appendBook(Book("Hello world"))
  bookShelf.appendBook(Book("Bible"))
  bookShelf.appendBook(Book("Cinderella"))
  bookShelf.appendBook(Book("Daddy-Long-Legs"))

  val it = bookShelf.iterator()
  while(it.hasNext()) {
    val book = it.next() as Book
    println(book.name)
  }
}
