package com.project.hyuga.domain.problem.domain

import com.project.hyuga.domain.etiquette.domain.type.Category
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_problem")
class Problem(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotNull
    @Column(length = 50)
    val content: String,

    @field:NotNull
    val isAnswer: Boolean,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 13)
    val category: Category

)