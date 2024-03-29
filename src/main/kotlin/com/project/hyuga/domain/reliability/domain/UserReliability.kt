package com.project.hyuga.domain.reliability.domain

import com.project.hyuga.domain.user.domain.User
import com.project.hyuga.global.entity.BaseTimeEntity
import java.io.Serializable
import java.time.LocalDate
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.MapsId
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Table(name = "tbl_user_reliability")
@Entity
class UserReliability(

    @EmbeddedId
    val id: UserReliabilityId,

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user: User?,

    @MapsId("reliabilityId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reliability_id", columnDefinition = "BINARY(16)", nullable = false)
    val reliability: Reliability?,

    @field:NotNull
    @Column(columnDefinition = "TINYINT")
    val point: Int,

    override val createdAt: LocalDate

) : BaseTimeEntity()

@Embeddable
data class UserReliabilityId(

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val userId: UUID,

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val reliabilityId: UUID

) : Serializable