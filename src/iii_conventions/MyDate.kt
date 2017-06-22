package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {

    private fun toInt() = year * 10000 + month * 100 + dayOfMonth

//    override fun compareTo(other: MyDate) = when {
//        year != other.year -> year - other.year
//        month != other.month -> month - other.month
//        else -> dayOfMonth - other.dayOfMonth
//    }

    override operator fun compareTo(other: MyDate) = toInt() - other.toInt()

    operator fun rangeTo(other: MyDate) = DateRange(this, other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate,
                override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override operator fun contains(value: MyDate) = value > start && value <= endInclusive

    override fun iterator(): Iterator<MyDate> {
        return object: Iterator<MyDate> {
            var currDate: MyDate = start.addTimeIntervals(TimeInterval.DAY, -1)
            override fun hasNext() = currDate < endInclusive
            override fun next(): MyDate {
                currDate = currDate.nextDay()
                return currDate
            }
        }
    }
}
