package com.pagero

import com.datastax.driver.core.utils.UUIDs
import com.pagero.dao.impl.DocumentDaoImpl
import com.pagero.service.impl.DocumentServiceImpl
import com.pagero.entity.{Activity, Document, PartyIdBean}

object Main extends App {

  val activity = Activity("abcdef", "vijayanga")
  val partyIdBean = Set(PartyIdBean("idtype1", "abcdefg"))
  //val intSet: java.util.Set[Int] = new java.util.HashSet[Int]()
  val intSet: Set[Int] = Set(11)
  val amount: Int = 12

  new DocumentServiceImpl(DocumentDaoImpl).saveDocument(Document("4567", UUIDs.timeBased(), "1234567", activity, amount))
}
