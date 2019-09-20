package com.pagero.test

import com.datastax.driver.core.utils.UUIDs
import com.pagero.dao.impl.DocumentDaoImpl
import com.pagero.entity.{Activity, Document, PartyIdBean}
import com.pagero.service.impl.DocumentServiceImpl
import com.pagero.test.persistence.{MockCassandraConnection, MockDocumentDao}
import org.cassandraunit.CQLDataLoader
import org.cassandraunit.dataset.cql.ClassPathCQLDataSet
import org.scalatest.{BeforeAndAfterAll, FunSuite}

class TestDocument extends FunSuite with BeforeAndAfterAll{

  override def beforeAll(): Unit = {

    MockCassandraConnection.getSession().execute("CREATE KEYSPACE documents WITH replication = {'class': 'NetworkTopologyStrategy', 'DC1': '1'}  AND durable_writes = true;")
    val dataLoader = new CQLDataLoader( MockCassandraConnection.getSession())
    dataLoader.load(new ClassPathCQLDataSet("cql/statementsWithBlankEndings.cql","documents"))
  }

  override def afterAll(): Unit = {

  }

  test("DocumentService.saveDocument success") {

    val activity = Activity("randika", "vijayanga")
    //val partyIdBean = Set(PartyIdBean("isuru", "vijayanga"))
    //val intSet: java.util.Set[Int] = new java.util.HashSet[Int]()
    //val intSet: Set[Int] = Set(11)
    val amount: Int = 12
    val document = Document("4567", UUIDs.timeBased(), "1234567", activity, amount)
    val num = new DocumentServiceImpl(new MockDocumentDao(false)).saveDocument(document)
    assert(num == 1)
  }

  test("DocumentService.saveDocument fail") {

    val activity = Activity("randika", "vijayanga")
    //val partyIdBean = Set(PartyIdBean("isuru", "vijayanga"))
    //val intSet: java.util.Set[Int] = new java.util.HashSet[Int]()
    //val intSet: Set[Int] = Set(11)
    val amount: Int = 12
    val document = Document("4567", UUIDs.timeBased(), "1234567", activity, amount)
    val num = new DocumentServiceImpl(new MockDocumentDao(true)).saveDocument(document)
    assert(num == 2)
  }
}
