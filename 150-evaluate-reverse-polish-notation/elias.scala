  def evalRPn(tokens: Array[String]): Int = {

    val builder = Map.newBuilder[String, (Int, Int) => Int]
    builder += ("+" -> ((x: Int, y: Int) => x + y): (String, (Int, Int) => Int))
    builder += ("-" -> ((x: Int, y: Int) => x - y): (String, (Int, Int) => Int))
    builder += ("*" -> ((x: Int, y: Int) => x * y): (String, (Int, Int) => Int))
    builder += ("/" -> ((x: Int, y: Int) => x / y): (String, (Int, Int) => Int))


    val op  = builder.result()
    var res = 0
    var d   = mutable.Stack[Int]()

    for (i <- tokens) i match {
      case i if (op.contains(i)) =>
        i match {
          case "-" => {
            val a = d.pop()
            val b = d.pop()
            d.push(op(i)(b, a))
          }
          case "/" => {
            val c: Int = d.pop()
            val e: Int = d.pop()
            d.push(op(i)(e, c))
          }
          case _ => {
            val f = d.pop()
            val g = d.pop()
            d.push(op(i)(f, g))
          }
        }
      case _ => d.push( i.toInt)
    }


   d(0)

  }
