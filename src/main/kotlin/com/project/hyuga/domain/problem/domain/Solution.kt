package com.project.hyuga.domain.problem.domain

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

@Table(name = "tbl_solution")
@Entity
class Solution(

    @EmbeddedId
    val id: SolutionId,

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user: User?,

    @MapsId("problemId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id", columnDefinition = "BINARY(16)", nullable = false)
    val problem: Problem?,

    override val createdAt: LocalDate

) : BaseTimeEntity()

@Embeddable
data class SolutionId(

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val userId: UUID,

    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val problemId: UUID

) : Serializable