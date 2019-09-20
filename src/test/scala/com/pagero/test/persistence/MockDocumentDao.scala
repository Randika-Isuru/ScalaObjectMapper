package com.pagero.test.persistence

import com.pagero.dao.DocumentDao
import com.pagero.entity.Document

import scala.util.{Failure, Success, Try}

class MockDocumentDao(returnFailure: Boolean) extends DocumentDao {
  override def saveDocument(document: Document): Try[String] = {
    if (returnFailure) {
      Failure(new Exception("test"))
    } else {
      Success("test")
    }
  }
}