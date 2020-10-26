import ChecksumCalculator.calcChecksum

object Summer {
    def main(args: Array[String]): Unit = {
        for (arg <- args)
            println(arg + ": " + calcChecksum(arg))
    }
}
