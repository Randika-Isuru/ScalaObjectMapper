package com.pagero.service.impl

import com.pagero.dao.DocumentDao
import com.pagero.entity.Document
import com.pagero.service.DocumentService

import scala.util.{Failure, Success}

class DocumentServiceImpl(documentDao: DocumentDao) extends DocumentService {

  //val documentDao: DocumentDao = DocumentDaoImpl
  //val documentDao: DocumentReDao = DocumentDaoImpl

  override def saveDocument(document: Document): Int = {
    val saveTry = documentDao.saveDocument(document)

    saveTry match {
      case Success(documentSaved) =>
        println(s"document saved $documentSaved")
        1
      case Failure(documentSaveFailed) =>
        println(s"Docuemtn save failed $documentSaveFailed")
        2

    }
  }

}