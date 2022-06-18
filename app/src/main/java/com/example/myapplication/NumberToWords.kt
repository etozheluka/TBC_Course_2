package com.example.myapplication

object NumberToWords {
    private val oneToNineteen = arrayOf(
        "", "ერთი", "ორი", "სამი", "ოთხი", "ხუთი",
        "ექვსი", "შვიდი", "რვა", "ცხრა", "ათი", "თერთმეტი", "თორმეტი", "ცამეტი",
        "თოთხმეტი", "თხუთმეტი", "თექვსმეტი", "ჩვიდმეტი", "თვრამეტი", "ცხრამეტი"
    )
    private val elevenToNineteen = arrayOf(
        "", "თერთმეტი", "თორმეტი", "ცამეტი",
        "თოთხმეტი", "თხუთმეტი", "თექვსმეტი", "ჩვიდმეტი", "თვრამეტი", "ცხრამეტი"
    )
    private val tens = arrayOf(
        "", "ათი", "ოცი", "ოცდაათი", "ორმოცი",
        "ორმოცდაათი", "სამოცი", "სამოცდაათი", "ოთხმოცი", "ოთხმოცდაათი"
    )
    private val plusTens = arrayOf(
        "", "ათი", "ოცდა", "ოცდა", "ორმოცდა",
        "ორმოცდა", "სამოცდა", "სამოცდა", "ოთხმოცდა", "ოთხმოცდა"
    )
    private val hundreds = arrayOf(
        "", "ასი", "ორასი", "სამასი", "ოთხასი",
        "ხუთასი", "ექვსასი", "შვიდასი", "რვაასი", "ცხრაასი"
    )
    private val plusHundreds = arrayOf(
        "", "ას", "ორას", "სამას", "ოთხას",
        "ხუთას", "ექვსას", "შვიდას", "რვაას", "ცხრაას"
    )

    fun convert(n: Int): String {
        val length = n.toString().length
        if (n == 1000) {
            return "ათასი"
        }
        if (length < 4) {
            if (n < 0) {
                return convert(-n)
            }
            if (n == 10 || n == 20 || n == 30 || n == 40 || n == 50 || n == 60 || n == 70 || n == 80 || n == 90) {
                return tens[n / 10]
            }
            if (n == 100 || n == 200 || n == 300 || n == 400 || n == 500 || n == 600 || n == 700 || n == 800 || n == 900) {
                return hundreds[n / 100]
            }
            if (n < 20) {
                return oneToNineteen[n]
            }
            if (n in 100..999) {
                return plusHundreds[n / 100] + convert(n % 100)
            }
            return if (n in 31..39 || n in 51..59 || n in 70..79 || n in 91..99) {
                plusTens[n / 10] + elevenToNineteen[n % 10]
            } else {
                plusTens[n / 10] + oneToNineteen[n % 10]
            }
        } else {
            return "მარტო [1,1000] დაშვებულია"
        }
    }

}