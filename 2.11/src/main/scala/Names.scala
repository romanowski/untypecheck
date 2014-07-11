import scala.reflect.runtime._
import scala.tools.reflect.ToolBox

/**
 * Author: Krzysztof Romanowski
 */
object Names extends TestCase {


  val ast = toolbox.parse("case class a$$a(i: Int)")
  toolbox.compile(ast)

}
