package com.project.hyuga.domain.badge.domain

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class BadgeStoreId(

    @Column(nullable = false)
    val badgeId: Long,

    @Column(nullable = false)
    val userId: Long

) : Serializable
