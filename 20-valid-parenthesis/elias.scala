object BracketValidator {
  def isValid(s: String): Boolean = {
    import scala.collection.mutable.Stack

    val stack = Stack[Char]()
    for (c <- s) {
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c)
      } else {
        if (stack.isEmpty) return false
        val top = stack.pop()
        if (c == ')' && top != '(') return false
        if (c == '}' && top != '{') return false
        if (c == ']' && top != '[') return false
      }
    }
    stack.isEmpty
  }
}
