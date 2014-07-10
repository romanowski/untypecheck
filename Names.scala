import scala.reflect.runtime._
import scala.tools.reflect.ToolBox

/**
 * Author: Krzysztof Romanowski
 */
object Names extends  App {
  lazy val toolbox: ToolBox[universe.type] = universe.runtimeMirror(getClass.getClassLoader).mkToolBox()


  val ast = toolbox.parse("case class a$$a(i: Int)")
  toolbox.compile(ast)

}
