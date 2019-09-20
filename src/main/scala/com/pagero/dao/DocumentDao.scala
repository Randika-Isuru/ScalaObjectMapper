package com.pagero.dao

import com.pagero.entity.Document

import scala.util.Try

trait DocumentDao {
  def saveDocument(document: Document): Try[String]
}
