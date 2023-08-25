package com.project.hyuga.domain.badge.domain

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

@Table(name = "tbl_badge_store")
@Entity
class BadgeStore(

    @EmbeddedId
    val id: BadgeStoreId,

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user: User?,

    @MapsId("badgeId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "badge_id", columnDefinition = "BINARY(16)", nullable = false)
    val badge: Badge?,

    override val createdAt: LocalDate

) : BaseTimeEntity()

@Embeddable
data class BadgeStoreId(

    @Column(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val userId: UUID,

    @Column(name = "badge_id", columnDefinition = "BINARY(16)", nullable = false)
    val badgeId: UUID

) : Serializable
