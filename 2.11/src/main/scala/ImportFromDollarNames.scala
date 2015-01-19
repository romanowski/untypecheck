import libs.{Ala, Ala$scala$class}

/**
 * Author: Krzysztof Romanowski
 */
object ImportFromDollarNames extends TestCase {

  val test1 = {
    val ala: libs.Ala = new Ala
    import ala._
    a
  }

  val test2 = {
    val ala: libs.Ala$scala$class = new Ala$scala$class
    import ala._
    a
  }

  val parsed = toolbox.parse( """
      val ala: libs.Ala = new Ala
      import ala._
      a
                              """)
  val parsed2 = toolbox.parse( """
      val ala: libs.Ala$scala$class = new Ala$scala$class
      import ala._
      a
                               """)

  toolbox.compile(parsed2)
  toolbox.compile(parsed)
}
