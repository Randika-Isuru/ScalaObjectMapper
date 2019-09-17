package com.pagero.test.entity

import com.datastax.driver.mapping.annotations.{Field, UDT}

import scala.annotation.meta.field

@UDT(name = "party_id")
case class PartyIdBean(@(Field@field)(name = "id_type") idType: String,
                       @(Field@field)(name = "value") value: String)
