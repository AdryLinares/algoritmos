def memoizedCutRod(p: Array[Int], n: Int): Int = {
  val memo = new Array[Option[Int]](n+1)
  (0 to n).foreach(memo(_) = None)

  def memoizedCutRodAux(n: Int): Int = {
    if ( memo(n).isDefined ) memo(n).get
    else if ( n == 0 ) 0
    else {
      val q = (1 to n).map(i => p(i) + memoizedCutRodAux(n - i)).max
      memo(n) = Some(q)
      q
    }
  }

  memoizedCutRodAux(n)
}