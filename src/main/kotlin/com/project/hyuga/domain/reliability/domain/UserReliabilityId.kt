package com.project.hyuga.domain.reliability.domain

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class UserReliabilityId(

    @Column(nullable = false)
    val userId: Long,

    @Column(nullable = false)
    val reliabilityId: Long

) : Serializable
