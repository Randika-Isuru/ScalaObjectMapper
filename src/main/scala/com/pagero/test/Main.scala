package com.pagero.test

import com.datastax.driver.core.utils.UUIDs
import com.datastax.driver.mapping.MappingManager
import com.pagero.test.entity.{Activity, Document, PartyIdBean}
import com.pagero.test.persistence.CassandraCluster

object Main extends App with CassandraCluster {

  lazy val mapper = new MappingManager(session).mapper(classOf[Document])
  val activity = Activity("abcdef", "vijayanga")
  val partyIdBean = Set(PartyIdBean("idtype1", "abcdefg"))
  //val intSet: java.util.Set[Int] = new java.util.HashSet[Int]()
  val intSet: Set[Int] = Set(11)

  mapper.save(Document("789", "234", activity, intSet))
}
