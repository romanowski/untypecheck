/**
 * Author: Krzysztof Romanowski
 */
object ClassesWithImports extends TestCase {

  val code =
    """
      |import libs._
      |class Ala(){
      | def apply(x: Int) = LibObject.name
      |}
    """.stripMargin

  val astOk = toolbox.parse(s"{ $code }")
  toolbox.compile(astOk)

  println("With { around - works} ")

  val ast = toolbox.parse(code)
  toolbox.compile(ast)

}
