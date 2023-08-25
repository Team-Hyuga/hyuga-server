package com.project.hyuga.domain.problem.domain

import com.project.hyuga.domain.etiquette.domain.type.Category
import com.project.hyuga.global.entity.BaseEntity
import java.time.LocalDate
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Table(name = "tbl_problem")
@Entity
class Problem(

    override val id: UUID,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(50)")
    val description: String,

    @field:NotNull
    @Column(columnDefinition = "BIT(1)")
    val isAnswer: Boolean,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(15)")
    val category: Category,

    override val createdAt: LocalDate

) : BaseEntity(id)
