package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }


}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}
operator fun MyDate.plus(timeInterval: TimeInterval) : MyDate = addTimeIntervals(timeInterval, 1)

class RepeatedTimeInterval(val timeInterval: TimeInterval, val number : Int)
operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)

operator fun MyDate.plus(timeInterval: RepeatedTimeInterval) =
        addTimeIntervals(timeInterval.timeInterval, timeInterval.number)

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = DateIterator(this)

    operator fun contains(date: MyDate): Boolean =
            start <= date && date <= endInclusive
}

class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var currentDate: MyDate = dateRange.start
    override fun next(): MyDate {
        val result = currentDate
        currentDate = currentDate.nextDay()
        return result
    }

    override fun hasNext(): Boolean = currentDate <= dateRange.endInclusive
}

