import scala.reflect.runtime._
import scala.tools.reflect.ToolBox

/**
 * Author: Krzysztof Romanowski
 */
object Reusage extends App {

  import universe._

  lazy val toolbox: ToolBox[universe.type] = universe.runtimeMirror(getClass.getClassLoader).mkToolBox()

  val code = "val a = true; a > true"
  val code2 = "val b = true; b < false"


  def livecyle(code: String) = {
    val tree = toolbox.parse(code)
    val typecheck = toolbox.typecheck(tree)
    val untypecheck = toolbox.untypecheck(typecheck)
    toolbox.compile(untypecheck)
  }

  val f = livecyle(code)
  val f2 = livecyle(code)

  println(f(), f2())
}
