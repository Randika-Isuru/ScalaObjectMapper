package com.pagero.entity

import java.util.UUID

import com.datastax.driver.mapping.annotations.{ClusteringColumn, Column, PartitionKey, Table}

import scala.annotation.meta.field

@Table(name = "document", keyspace = "documents_sample")
case class Document(@(Column@PartitionKey @field)(name = "owning_business_party_id") owningBusinessPartyId: String,
                    @(ClusteringColumn @field) id: UUID,
                    @(Column @field)(name = "auth_company_id") authCompanyId: String,
                    @(Column @field)(name = "activities") activities: Activity,
                    @(Column @field)(name = "amount") amount: Int,
                    @(Column @field)(name = "party_ids") partyIds: java.util.Set[Integer],
                    @(Column @field)(name = "activity_set") activitySet: java.util.Set[Activity]
                   )

//, codec = classOf[SetCodec[Int]]
