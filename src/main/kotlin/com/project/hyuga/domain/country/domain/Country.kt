package com.project.hyuga.domain.country.domain

import com.project.hyuga.domain.country.domain.type.Season
import com.project.hyuga.domain.etiquette.domain.type.Category
import com.project.hyuga.global.entity.BaseUUIDEntity
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_country")
class Country(

    override val id: UUID,

    @field:NotNull
    @Column(unique = true)
    val name: String,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    val season: Season,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 13)
    val category: Category

) : BaseUUIDEntity(id)
