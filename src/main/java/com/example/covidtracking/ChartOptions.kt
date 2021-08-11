package com.example.covidtracking

enum class Metric{
    NEGATIVE,POSITIVE,DEATH
}

enum class TimeScale(val numDays:Int){
    WEEK(numDays = 7),
    MONTH(numDays = 30),
    MAX(numDays = -1)
}