/*
package com.pagero.test.custom.codec

import java.nio.ByteBuffer

import com.datastax.driver.core.exceptions.InvalidTypeException
import com.datastax.driver.core.{ProtocolVersion, TypeCodec, UDTValue, UserType}
import com.pagero.test.entity.PartyIdBean

class PartyIdBeanCodec extends TypeCodec[PartyIdBean]{

  val innerCodec: TypeCodec[UDTValue]

  val userType: UserType

  def PartyIdBeanCodec(): Unit ={

  }

  def apply: PartyIdBeanCodec = new PartyIdBeanCodec(){

  }

  @throws(classOf[InvalidTypeException])
  override def serialize(value: PartyIdBean, protocolVersion: ProtocolVersion): ByteBuffer = {}

  @throws(classOf[InvalidTypeException])
  override def deserialize(bytes: ByteBuffer, protocolVersion: ProtocolVersion): PartyIdBean = {}

  @throws(classOf[InvalidTypeException])
  override def parse(value: String): PartyIdBean = {}

  @throws(classOf[InvalidTypeException])
  override def format(value: PartyIdBean): String = {}

  def toAddress(value: UDTValue): PartyIdBean = {
    value == null ? null : new Address(
      value.getString("street"),
      value.getInt("zipcode")
    );
  }

  protected UDTValue toUDTValue(Address value) {
    return value == null ? null : userType.newValue()
      .setString("street", value.getStreet())
      .setInt("zipcode", value.getZipcode());
  }

}
*/
