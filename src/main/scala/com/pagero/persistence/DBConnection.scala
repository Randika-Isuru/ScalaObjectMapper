package com.pagero.persistence

import com.datastax.driver.core.{Cluster, Session}
import com.datastax.driver.mapping.Mapper

trait DBConnection {

  def getCluster(): Cluster
  def getSession(): Session
  def gerMapper[T](obj: Class[T]): Mapper[T]
}
