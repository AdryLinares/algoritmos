def selectionSort(xs: List[Int]) = {
  def selectionSortHelper(xs: List[Int], accumulator: List[Int]): List[Int] =
    if(xs.isEmpty) accumulator
    else {
          val ys = maximum(xs)
          selectionSortHelper(ys.tail, ys.head :: accumulator)
    }

  selectionSortHelper(xs, Nil) 
  }