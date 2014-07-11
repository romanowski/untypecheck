import scala.reflect.runtime._
import scala.tools.reflect.ToolBox

object Min extends TestCase {

  import universe._

  val code = "List(1,2).mkString"
  val parsed = toolbox.parse(code)
  val typechecked = toolbox.typecheck(parsed)


  val Select(listTree, name) = typechecked
  val Apply(listApplyTree, params) = listTree
  val newArg = toolbox.parse("Ala(a)")
  val Apply(alaApply, _) = newArg
  val newParams = params.map(value => Apply(alaApply, List(value)))

  val classCode = toolbox.parse("case class Ala(a: Int)")

  val newBody = Block(classCode, Select(Apply(listApplyTree, newArg :: newParams), name))


  // gets AST of function arguments required in expression
  val functionArgs: List[ValDef] = {
    val dummyFunction = s"""(a: Int) => ???"""
    val parsed = toolbox.parse(dummyFunction)
    val Function(args, _) = toolbox.typecheck(parsed)
    args
  }


  val code2 = "( (x: Int), (y: Int)) => x + y"
  val typechecked2 = toolbox.typecheck(toolbox.parse(code2))
  val reparsed = toolbox.parse(universe.showCode(typechecked2))


  //modification of AST
  val newTree = Function(functionArgs, newBody)

  val reseted = toolbox.untypecheck(newTree)
  println(reseted)
  val compiled = toolbox.compile(reseted)
  println(compiled())
}
