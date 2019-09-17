package com.pagero.test.entity

import java.util.UUID

import com.datastax.driver.mapping.annotations.{ClusteringColumn, Column, PartitionKey, Table}

import scala.annotation.meta.field

@Table(name = "document")
case class Document (@(Column @PartitionKey @field)(name = "owning_business_party_id")  owningBusinessPartyId: String,
                     //@(ClusteringColumn @field) id: UUID,
                     @(Column @field)(name = "auth_company_id") authCompanyId: String,
                     @(Column @field)(name = "activities") activities: Activity,
                     @(Column @field)(name = "party_ids") receiverPartyIds: Set[Int])//, codec = classOf[SetCodec[Int]]