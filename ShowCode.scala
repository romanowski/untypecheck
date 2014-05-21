import scala.reflect.runtime._
import scala.tools.reflect.ToolBox

/**
 * Author: Krzysztof Romanowski
 */
object ShowCode extends App {

  import universe._

  lazy val toolbox: ToolBox[universe.type] = universe.runtimeMirror(getClass.getClassLoader).mkToolBox()

  val code = "class CustomFunction extends Function2[scala.Int, scala.Int, Any] {\n  override def apply(x$1: Int, x$2: Int) = x$1.+(x$2)\n}"

  val parsed = toolbox.parse(code)
  val reCode = universe.showCode(parsed)
  val reParsed = toolbox.parse(reCode)
  println(reCode)
}
