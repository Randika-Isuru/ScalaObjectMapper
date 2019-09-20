package com.pagero.dao.impl

import com.pagero.dao.DocumentDao
import com.pagero.entity.Document
import com.pagero.persistence.CassandraConnection

import scala.util.Try

object DocumentDaoImpl extends DocumentDao{
  val mapper = CassandraConnection.gerMapper(classOf[Document])

  override def saveDocument(document: Document): Try[String] = {
    mapper.save(document)
    Try("Randika")
  }
}