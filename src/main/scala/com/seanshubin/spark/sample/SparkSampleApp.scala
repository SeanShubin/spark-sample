package com.seanshubin.spark.sample

import org.apache.spark.{SparkConf, SparkContext}

object SparkSampleApp extends App{
  val sparkConfig: SparkConf = new SparkConf().setAppName("Foo").setMaster("local")
  val sparkContext: SparkContext = new SparkContext(sparkConfig)
  val sample = Seq("aaa")
  val dataSet = sparkContext.parallelize(sample)
  dataSet.foreach(println)
}
