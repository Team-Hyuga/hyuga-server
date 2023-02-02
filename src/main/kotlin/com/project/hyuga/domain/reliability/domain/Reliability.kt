package com.project.hyuga.domain.reliability.domain

import javax.persistence.*

@Entity
@Table(name = "tbl_reliability")
class Reliability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false)
    var totalScore = 0
        protected set

    @Column(nullable = false)
    var peopleCount = 0
        protected set

    @Column(nullable = false)
    var grade = 0
        protected set

    fun addScoreAndCount(score: Int) {
        this.totalScore += score
        this.peopleCount++
    }

}