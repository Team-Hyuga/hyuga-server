package com.project.hyuga.domain.badge.domain

import com.project.hyuga.domain.user.domain.User
import com.project.hyuga.global.entity.BaseTimeEntity
import javax.persistence.*

@Entity
@Table(name = "tbl_badge_store")
class BadgeStore(

    @EmbeddedId
    val id: BadgeStoreId,

    @MapsId("badgeId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "badge_id", nullable = false)
    val badge: Badge,

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user : User

) : BaseTimeEntity() {

    @Column(columnDefinition = "TINYINT", nullable = false)
    var badgeCount: Int = 0
        protected set

    fun plusCount() {
        this.badgeCount++
    }

}