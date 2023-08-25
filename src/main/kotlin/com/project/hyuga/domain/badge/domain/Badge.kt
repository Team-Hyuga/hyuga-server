package com.project.hyuga.domain.badge.domain

import com.project.hyuga.domain.etiquette.domain.type.Category
import com.project.hyuga.global.entity.BaseUUIDEntity
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Table(name = "tbl_badge")
@Entity
class Badge(

    override val id: UUID,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    val name: String,

    @field:NotNull
    val imageUrl: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(15)")
    val category: Category

) : BaseUUIDEntity(id)