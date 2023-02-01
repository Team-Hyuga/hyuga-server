package com.project.hyuga.domain.solution.domain

import com.project.hyuga.domain.problem.domain.Problem
import com.project.hyuga.domain.user.domain.User
import javax.persistence.*

@Entity
@Table(name = "tbl_solution")
class Solution(

    @EmbeddedId
    val id: SolutionId,

    @MapsId("problemId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id", nullable = false)
    val problem: Problem,

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user : User

)