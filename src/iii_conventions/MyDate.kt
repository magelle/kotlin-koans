package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (this.year.compareTo(other.year) != 0) return this.year.compareTo(other.year)
        if (this.month.compareTo(other.month) != 0) return this.month.compareTo(other.month)
        if (this.dayOfMonth.compareTo(other.dayOfMonth) != 0) return this.dayOfMonth.compareTo(other.dayOfMonth)
        return 0
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> = object : Iterator<MyDate> {
        private var current: MyDate = this@DateRange.start

        override fun hasNext(): Boolean {
            return current <= this@DateRange.endInclusive
        }

        override fun next(): MyDate {
            val cur = current
            current = cur.nextDay()
            return cur
        }
    }
}

operator fun DateRange.contains(date: MyDate): Boolean = this.start < date && date <= this.endInclusive