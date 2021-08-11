package com.example.covidtracking

import android.graphics.RectF
import com.robinhood.spark.SparkAdapter

class CovidSparkAdapter(private val dailyData: List<CovidData>):SparkAdapter() {
    var metric=Metric.POSITIVE
    var days=TimeScale.MAX
    override fun getCount()=dailyData.size

    override fun getItem(index: Int)=dailyData[index]

    override fun getY(index: Int): Float {
        val chosenDayData=dailyData[index]
        return when (metric){
            Metric.NEGATIVE->chosenDayData.negativeIncrease.toFloat()
            Metric.POSITIVE->chosenDayData.positiveIncrease.toFloat()
            Metric.DEATH->chosenDayData.deathIncrease.toFloat()
        }

    }

    override fun getDataBounds(): RectF {
        val bounds= super.getDataBounds()
        if(days!=TimeScale.MAX){
            bounds.left=count-days.numDays.toFloat()
        }

        return bounds
    }


}
