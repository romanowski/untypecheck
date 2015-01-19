object ImportMutable extends TestCase {

  val ast = toolbox.parse(
    """
      |import collection.mutable
      |
      |mutable.Map("ala" -> "maKota")
    """.stripMargin)
  toolbox.compile(ast)
}
