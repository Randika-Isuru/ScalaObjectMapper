package com.pagero

import com.datastax.driver.core.utils.UUIDs
import com.pagero.dao.impl.DocumentDaoImpl
import com.pagero.service.impl.DocumentServiceImpl
import com.pagero.entity.{Activity, Document, PartyIdBean}

import scala.collection.JavaConverters._

object Main extends App {

  val activity = Activity("abcdef", "vijayanga")
  val partyIdBean = Set(PartyIdBean("idtype1", "abcdefg"))
  //val intSet: java.util.Set[Int] = new java.util.HashSet[Int]()
  val intSet: Set[Integer] = Set(11,12,13,14)
  val amount: Int = 12
  val activitySet: Set[Activity] = Set(Activity("action1", "randika"), Activity("action2", "isuru"), Activity("action3", "vijayanga"))

  new DocumentServiceImpl(DocumentDaoImpl).saveDocument(Document("4567", UUIDs.timeBased(), "1234567", activity, amount, intSet.asJava, activitySet.asJava))
}
