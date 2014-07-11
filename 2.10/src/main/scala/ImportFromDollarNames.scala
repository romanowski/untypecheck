import libs.{Ala, Ala$scala$class}


object ImportFromDollarNames extends TestCase {

  val test1 = {
    val ala: libs.Ala = new Ala
    import ala._
    a
  }
//Eg. object A extennds App is compiled into classes: A, A4 and A$delayedInit$body
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
