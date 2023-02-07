package com.project.hyuga.domain.reliability.domain

import com.project.hyuga.domain.user.domain.User
import javax.persistence.*

@Entity
@Table(name = "tbl_user_reliability")
class UserReliability(

    @EmbeddedId
    val id: UserReliabilityId,

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @MapsId("reliabilityId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reliability_id", nullable = false)
    val reliability: Reliability

)