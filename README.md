# Sample to get spark working with Scala 2.12 

## To build
mvn package

## To run
java -jar target/spark-sample.jar

## Code
[SampleSparkApp](src/main/scala/com/seanshubin/spark/sample)
```scala
package com.seanshubin.spark.sample

import org.apache.spark.{SparkConf, SparkContext}

object SparkSampleApp extends App{
  val sparkConfig: SparkConf = new SparkConf().setAppName("Foo").setMaster("local")
  val sparkContext: SparkContext = new SparkContext(sparkConfig)
  val sample = Seq("aaa")
  val dataSet = sparkContext.parallelize(sample)
  dataSet.foreach(println)
}
```
## Current Error
```
Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
18/11/15 10:55:39 INFO SparkContext: Running Spark version 2.4.0
18/11/15 10:55:39 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
18/11/15 10:55:39 INFO SparkContext: Submitted application: Foo
18/11/15 10:55:39 INFO SecurityManager: Changing view acls to: sshubin
18/11/15 10:55:39 INFO SecurityManager: Changing modify acls to: sshubin
18/11/15 10:55:39 INFO SecurityManager: Changing view acls groups to: 
18/11/15 10:55:39 INFO SecurityManager: Changing modify acls groups to: 
18/11/15 10:55:39 INFO SecurityManager: SecurityManager: authentication disabled; ui acls disabled; users  with view permissions: Set(sshubin); groups with view permissions: Set(); users  with modify permissions: Set(sshubin); groups with modify permissions: Set()
18/11/15 10:55:39 INFO Utils: Successfully started service 'sparkDriver' on port 64510.
18/11/15 10:55:39 INFO SparkEnv: Registering MapOutputTracker
18/11/15 10:55:39 INFO SparkEnv: Registering BlockManagerMaster
18/11/15 10:55:39 INFO BlockManagerMasterEndpoint: Using org.apache.spark.storage.DefaultTopologyMapper for getting topology information
18/11/15 10:55:39 INFO BlockManagerMasterEndpoint: BlockManagerMasterEndpoint up
18/11/15 10:55:39 INFO DiskBlockManager: Created local directory at /private/var/folders/s5/nkvgn46x1psd79wyl6hbb_2s4ppbdy/T/blockmgr-5624edac-188c-45c6-a023-9d86e7a71e93
18/11/15 10:55:40 INFO MemoryStore: MemoryStore started with capacity 2004.6 MB
18/11/15 10:55:40 INFO SparkEnv: Registering OutputCommitCoordinator
18/11/15 10:55:40 INFO Utils: Successfully started service 'SparkUI' on port 4040.
18/11/15 10:55:40 INFO SparkUI: Bound SparkUI to 0.0.0.0, and started at http://sshubin.cnvr.conversantmedia.com:4040
18/11/15 10:55:40 INFO Executor: Starting executor ID driver on host localhost
18/11/15 10:55:40 INFO Utils: Successfully started service 'org.apache.spark.network.netty.NettyBlockTransferService' on port 64511.
18/11/15 10:55:40 INFO NettyBlockTransferService: Server created on sshubin.cnvr.conversantmedia.com:64511
18/11/15 10:55:40 INFO BlockManager: Using org.apache.spark.storage.RandomBlockReplicationPolicy for block replication policy
18/11/15 10:55:40 INFO BlockManagerMaster: Registering BlockManager BlockManagerId(driver, sshubin.cnvr.conversantmedia.com, 64511, None)
18/11/15 10:55:40 INFO BlockManagerMasterEndpoint: Registering block manager sshubin.cnvr.conversantmedia.com:64511 with 2004.6 MB RAM, BlockManagerId(driver, sshubin.cnvr.conversantmedia.com, 64511, None)
18/11/15 10:55:40 INFO BlockManagerMaster: Registered BlockManager BlockManagerId(driver, sshubin.cnvr.conversantmedia.com, 64511, None)
18/11/15 10:55:40 INFO BlockManager: Initialized BlockManager: BlockManagerId(driver, sshubin.cnvr.conversantmedia.com, 64511, None)
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 10582
	at com.thoughtworks.paranamer.BytecodeReadingParanamer$ClassReader.accept(BytecodeReadingParanamer.java:563)
	at com.thoughtworks.paranamer.BytecodeReadingParanamer$ClassReader.access$200(BytecodeReadingParanamer.java:338)
	at com.thoughtworks.paranamer.BytecodeReadingParanamer.lookupParameterNames(BytecodeReadingParanamer.java:103)
	at com.thoughtworks.paranamer.CachingParanamer.lookupParameterNames(CachingParanamer.java:90)
	at com.fasterxml.jackson.module.scala.introspect.BeanIntrospector$.getCtorParams(BeanIntrospector.scala:44)
	at com.fasterxml.jackson.module.scala.introspect.BeanIntrospector$.$anonfun$apply$1(BeanIntrospector.scala:58)
	at com.fasterxml.jackson.module.scala.introspect.BeanIntrospector$.$anonfun$apply$1$adapted(BeanIntrospector.scala:58)
	at scala.collection.TraversableLike.$anonfun$flatMap$1(TraversableLike.scala:241)
	at scala.collection.Iterator.foreach(Iterator.scala:944)
	at scala.collection.Iterator.foreach$(Iterator.scala:944)
	at scala.collection.AbstractIterator.foreach(Iterator.scala:1432)
	at scala.collection.IterableLike.foreach(IterableLike.scala:71)
	at scala.collection.IterableLike.foreach$(IterableLike.scala:70)
	at scala.collection.AbstractIterable.foreach(Iterable.scala:54)
	at scala.collection.TraversableLike.flatMap(TraversableLike.scala:241)
	at scala.collection.TraversableLike.flatMap$(TraversableLike.scala:238)
	at scala.collection.AbstractTraversable.flatMap(Traversable.scala:104)
	at com.fasterxml.jackson.module.scala.introspect.BeanIntrospector$.findConstructorParam$1(BeanIntrospector.scala:58)
	at com.fasterxml.jackson.module.scala.introspect.BeanIntrospector$.$anonfun$apply$19(BeanIntrospector.scala:176)
	at scala.collection.TraversableLike.$anonfun$map$1(TraversableLike.scala:234)
	at scala.collection.IndexedSeqOptimized.foreach(IndexedSeqOptimized.scala:32)
	at scala.collection.IndexedSeqOptimized.foreach$(IndexedSeqOptimized.scala:29)
	at scala.collection.mutable.ArrayOps$ofRef.foreach(ArrayOps.scala:194)
	at scala.collection.TraversableLike.map(TraversableLike.scala:234)
	at scala.collection.TraversableLike.map$(TraversableLike.scala:227)
	at scala.collection.mutable.ArrayOps$ofRef.map(ArrayOps.scala:194)
	at com.fasterxml.jackson.module.scala.introspect.BeanIntrospector$.$anonfun$apply$14(BeanIntrospector.scala:170)
	at com.fasterxml.jackson.module.scala.introspect.BeanIntrospector$.$anonfun$apply$14$adapted(BeanIntrospector.scala:169)
	at scala.collection.TraversableLike.$anonfun$flatMap$1(TraversableLike.scala:241)
	at scala.collection.immutable.List.foreach(List.scala:389)
	at scala.collection.TraversableLike.flatMap(TraversableLike.scala:241)
	at scala.collection.TraversableLike.flatMap$(TraversableLike.scala:238)
	at scala.collection.immutable.List.flatMap(List.scala:352)
	at com.fasterxml.jackson.module.scala.introspect.BeanIntrospector$.apply(BeanIntrospector.scala:169)
	at com.fasterxml.jackson.module.scala.introspect.ScalaAnnotationIntrospector$._descriptorFor(ScalaAnnotationIntrospectorModule.scala:22)
	at com.fasterxml.jackson.module.scala.introspect.ScalaAnnotationIntrospector$.fieldName(ScalaAnnotationIntrospectorModule.scala:30)
	at com.fasterxml.jackson.module.scala.introspect.ScalaAnnotationIntrospector$.findImplicitPropertyName(ScalaAnnotationIntrospectorModule.scala:78)
	at com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair.findImplicitPropertyName(AnnotationIntrospectorPair.java:467)
	at com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector._addFields(POJOPropertiesCollector.java:351)
	at com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector.collectAll(POJOPropertiesCollector.java:283)
	at com.fasterxml.jackson.databind.introspect.POJOPropertiesCollector.getJsonValueMethod(POJOPropertiesCollector.java:169)
	at com.fasterxml.jackson.databind.introspect.BasicBeanDescription.findJsonValueMethod(BasicBeanDescription.java:223)
	at com.fasterxml.jackson.databind.ser.BasicSerializerFactory.findSerializerByAnnotations(BasicSerializerFactory.java:348)
	at com.fasterxml.jackson.databind.ser.BeanSerializerFactory._createSerializer2(BeanSerializerFactory.java:210)
	at com.fasterxml.jackson.databind.ser.BeanSerializerFactory.createSerializer(BeanSerializerFactory.java:153)
	at com.fasterxml.jackson.databind.SerializerProvider._createUntypedSerializer(SerializerProvider.java:1203)
	at com.fasterxml.jackson.databind.SerializerProvider._createAndCacheUntypedSerializer(SerializerProvider.java:1157)
	at com.fasterxml.jackson.databind.SerializerProvider.findValueSerializer(SerializerProvider.java:481)
	at com.fasterxml.jackson.databind.SerializerProvider.findTypedValueSerializer(SerializerProvider.java:679)
	at com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.serializeValue(DefaultSerializerProvider.java:107)
	at com.fasterxml.jackson.databind.ObjectMapper._configAndWriteValue(ObjectMapper.java:3559)
	at com.fasterxml.jackson.databind.ObjectMapper.writeValueAsString(ObjectMapper.java:2927)
	at org.apache.spark.rdd.RDDOperationScope.toJson(RDDOperationScope.scala:52)
	at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:145)
	at org.apache.spark.rdd.RDDOperationScope$.withScope(RDDOperationScope.scala:112)
	at org.apache.spark.SparkContext.withScope(SparkContext.scala:699)
	at org.apache.spark.SparkContext.parallelize(SparkContext.scala:716)
	at com.seanshubin.spark.sample.SparkSampleApp$.delayedEndpoint$com$seanshubin$spark$sample$SparkSampleApp$1(SparkSampleApp.scala:9)
	at com.seanshubin.spark.sample.SparkSampleApp$delayedInit$body.apply(SparkSampleApp.scala:5)
	at scala.Function0.apply$mcV$sp(Function0.scala:34)
	at scala.Function0.apply$mcV$sp$(Function0.scala:34)
	at scala.runtime.AbstractFunction0.apply$mcV$sp(AbstractFunction0.scala:12)
	at scala.App.$anonfun$main$1$adapted(App.scala:76)
	at scala.collection.immutable.List.foreach(List.scala:389)
	at scala.App.main(App.scala:76)
	at scala.App.main$(App.scala:74)
	at com.seanshubin.spark.sample.SparkSampleApp$.main(SparkSampleApp.scala:5)
	at com.seanshubin.spark.sample.SparkSampleApp.main(SparkSampleApp.scala)
18/11/15 10:55:40 INFO SparkContext: Invoking stop() from shutdown hook
18/11/15 10:55:40 INFO SparkUI: Stopped Spark web UI at http://sshubin.cnvr.conversantmedia.com:4040
18/11/15 10:55:40 INFO MapOutputTrackerMasterEndpoint: MapOutputTrackerMasterEndpoint stopped!
18/11/15 10:55:40 INFO MemoryStore: MemoryStore cleared
18/11/15 10:55:40 INFO BlockManager: BlockManager stopped
18/11/15 10:55:40 INFO BlockManagerMaster: BlockManagerMaster stopped
18/11/15 10:55:40 INFO OutputCommitCoordinator$OutputCommitCoordinatorEndpoint: OutputCommitCoordinator stopped!
18/11/15 10:55:40 INFO SparkContext: Successfully stopped SparkContext
18/11/15 10:55:40 INFO ShutdownHookManager: Shutdown hook called
18/11/15 10:55:40 INFO ShutdownHookManager: Deleting directory /private/var/folders/s5/nkvgn46x1psd79wyl6hbb_2s4ppbdy/T/spark-4940a7de-47d4-4db4-91fd-1775d684d5d6

```