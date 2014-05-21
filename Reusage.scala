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


  val normal = toolbox.compile(toolbox.parse(code))
  val normal2 = toolbox.compile(toolbox.parse(code2))

  println(normal(), normal2())

  def livecyle(code: String) = {
    val tree = toolbox.parse(code)
    val typecheck = toolbox.typecheck(tree)
    val untypecheck = toolbox.untypecheck(typecheck)
    toolbox.compile(untypecheck)
  }

  val withUntypecheck = livecyle(code)
  val withUntypecheck2 = livecyle(code)

  println(withUntypecheck(), withUntypecheck2())
}
