fun main() {
    /*1. გვაქვს მთელი რიცხვების ჩამონათვალი სადაც ერთის გარდა ყველა რიცხვი მეორდება, იპოვეთ
    ის რიცხვი რომელიც არ მეორდება.int singleNumber(int[] nums)*/
    val nums1 = intArrayOf(4, 1, 2, 1, 2)
    val result1 = singleNumber(nums1)
    println("1. რიცხვი რომელიც არ მეორდება: $result1")

    /*2. გვაქვს 1,5,10,20 და 50 თეთრიანი მონეტები. დაწერეთ ფუნქცია, რომელსაც გადაეცემა თანხა
(თეთრებში) და აბრუნებს მონეტების მინიმალურ რაოდენობას, რომლითაც შეგვიძლია ეს თანხა დავახურდაოთ.*/
    val amount = 27
    val result2 = minSplit(amount)
    println("2. მონეტების მინიმალურ რაოდენობას, რომლითაც შეგვიძლია დავახურდაოთ:  $result2")

    /*3. მოცემულია მასივი, რომელიც შედგება მთელი რიცხვებისგან. დაწერეთ ფუნქცია რომელსაც
გადაეცემა ეს მასივი და აბრუნებს მინიმალურ მთელ რიცხვს, რომელიც 0-ზე მეტია და ამ მასივში არ შედის.*/
    val nums3 = intArrayOf(1, 2, 3)
    val result3 = notContains(nums3)
    println("3. დადებითი უმცირესი რიცხვი რომელიც არარის მასივში:  $result3")

    /*4.მოცემულია ორი binary string a და b, დააბრუნეთ მათი ჯამი, როგორც binary string.*/
    val a = "1010"
    val b = "1011"
    val result4 = addBinary(a, b)
    println("4. ორობითი რიცხვების ჯამი: $result4")

    /*5. გვაქვს n სართულიანი კიბე, ერთ მოქმედებაში შეგვიძლია ავიდეთ 1 ან 2 საფეხურით. დაწერეთ
ფუნქცია რომელიც დაითვლის n სართულზე ასვლის ვარიანტების რაოდენობას.*/
    val stairsCount = 6
    val result5 = countVariants(stairsCount)
    println("5. მე-$stairsCount სართულზე 1 ან 2 საფეხურით ასვლის ვარიანტების რაოდენობა: $result5")
}

fun singleNumber(nums: IntArray): Int {
    var result = 0
    for (num in nums) {
        result = result xor num
    }
    return result
}
fun minSplit(amount: Int): Int {
    val coins = intArrayOf(50, 20, 10, 5, 1)
    var remainingAmount = amount
    var minCoins = 0
    for (coin in coins) {
        val count = remainingAmount / coin
        minCoins += count
        remainingAmount -= count * coin
    }
    return minCoins
}
fun notContains(nums: IntArray): Int {
    var smallestPositive = 1
    while (nums.contains(smallestPositive)) {
        smallestPositive++
    }
    return smallestPositive
}
fun addBinary(a: String, b: String): String {
    val numA = a.reversed()
    val numB = b.reversed()
    var carry = 0
    val result = StringBuilder()
    var i = 0
    while (i < numA.length || i < numB.length || carry != 0) {
        val digitA = if (i < numA.length) numA[i] - '0' else 0
        val digitB = if (i < numB.length) numB[i] - '0' else 0
        val sum = digitA + digitB + carry
        result.append(sum % 2)
        carry = sum / 2
        i++
    }
    return result.reverse().toString()
}
fun countVariants(stairsCount: Int): Int {
    if (stairsCount <= 2) {
        return stairsCount
    }
    var prev1 = 1
    var prev2 = 2
    var current = 0
    for (i in 3..stairsCount) {
        current = prev1 + prev2
        prev1 = prev2
        prev2 = current
    }
    return current
}
