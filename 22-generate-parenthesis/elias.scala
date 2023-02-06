object Solution {
    def generateParenthesis(n: Int): List[String] = {
        def generate(current: String, open: Int, close: Int, n: Int): List[String] = {
                if (current.length == 2 * n) List(current)
                else {
                    var result = List[String]()
                    if (open < n) result = result ::: generate(current + "(", open + 1, close, n)
                    if (close < open) result = result ::: generate(current + ")", open, close + 1, n)
                    result
                }
            }
            generate("", 0, 0, n)
        }
    }
