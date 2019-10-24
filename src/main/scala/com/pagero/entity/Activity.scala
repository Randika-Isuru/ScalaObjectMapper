package com.pagero.entity

import com.datastax.driver.mapping.annotations.{Field, UDT}

import scala.annotation.meta.field

@UDT(name = "activity", keyspace = "documents_sample")
case class Activity(@(Field@field)(name = "action") action: String,
                    @(Field@field)(name = "user") user: String)
