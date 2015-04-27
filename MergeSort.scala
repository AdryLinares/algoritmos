def mergeSort[T](pred: (T, T) => Boolean)(xs: Stream[T]): Stream[T] = {
    val m = xs.length / 2
    if (m == 0) xs
    else {
        def merge(ls: Stream[T], rs: Stream[T]): Stream[T] = (ls, rs) match {
            case (Stream.Empty, _) => rs
            case (_, Stream.Empty) => ls
            case (l #:: ls1, r #:: rs1) =>
                if (pred(l, r)) l #:: merge(ls1, rs)
                else r #:: merge(ls, rs1)
        }
        val (l, r) = xs splitAt m
        merge(mergeSort(pred)(l), mergeSort(pred)(r))
    }
}

def numbers(remain: Int): Stream[Int] =
    if (remain == 0) Stream.Empty
    else Stream.cons(util.Random.nextInt(100), numbers(remain - 1))

println(mergeSort((x: Int, y: Int) => x < y)(numbers(4)).toList)