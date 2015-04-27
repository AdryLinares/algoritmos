object CutRodBottomUp { 
  val DEFAULT_REVENUE = -1

  def run(prices: Array[Int], rodLength: Int): Int = {
    var revenues = new Array[Int](rodLength + 1)
    revenues.update(0, 0)

    for (j <- 1 to rodLength) {
      var maxRevenue = DEFAULT_REVENUE
      for (i <- 1 to j) {
	maxRevenue = math.max(maxRevenue, prices(i - 1) + revenues(j - i))
      }
      revenues(j) = maxRevenue
    }

    return revenues(rodLength)
  }
}  

