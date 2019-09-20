package com.pagero.service

import com.pagero.entity.Document

trait DocumentService{

  def saveDocument(document: Document): Int
}
