package com.project.hyuga.domain.solution.domain

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class SolutionId(

    @Column(nullable = false)
    val problemId: Long,

    @Column(nullable = false)
    val userId: Long

) : Serializable