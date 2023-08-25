package com.project.hyuga.domain.etiquette.domain

import com.project.hyuga.domain.etiquette.domain.type.Category
import com.project.hyuga.domain.user.domain.User
import com.project.hyuga.global.entity.BaseEntity
import java.time.LocalDate
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Table(name = "tbl_etiquette")
@Entity
class Etiquette(

    override val id: UUID,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    val user: User?,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(50)")
    val title: String,

    @field:NotNull
    @Column(columnDefinition = "TEXT")
    val content: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(15)")
    val category: Category,

    override val createdAt: LocalDate

) : BaseEntity(id)
