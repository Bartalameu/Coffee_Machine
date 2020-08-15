val calendar = createCalendar()
calendar.selectCurrentDay()

// println("${calendar.().day.set(21)} ${calendar.selectCurrentDay().month.set(12)} ${calendar.selectCurrentDay().year.set(2112)}  ")
println( "${calendar.day} ${calendar.month} ${calendar.year}" )
