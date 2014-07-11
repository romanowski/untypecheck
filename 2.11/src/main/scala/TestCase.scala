import scala.reflect.runtime._
import scala.tools.reflect.ToolBox

/**
 * Author: Krzysztof Romanowski
 */
class TestCase extends App{
  lazy val toolbox: ToolBox[universe.type] =
    universe.runtimeMirror(this.getClass.getClassLoader).mkToolBox()

}
