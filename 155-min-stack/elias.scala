class MinStack {
  private var elements = List.empty[Int]
  private var minStack = List.empty[Int]

  def push(x: Int): Unit = {
    elements = x :: elements
    if (minStack.isEmpty || x <= minStack.head) minStack = x :: minStack
    else minStack = minStack.head :: minStack
  }

  def pop(): Unit = {
    if (elements.nonEmpty) {
      elements = elements.tail
      minStack = minStack.tail
    }
  }

  def top(): Int = elements.head

  def getMin(): Int = minStack.head
}
