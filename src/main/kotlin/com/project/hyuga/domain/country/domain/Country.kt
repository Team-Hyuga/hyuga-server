package com.project.hyuga.domain.country.domain

import com.project.hyuga.domain.country.domain.type.Season
import com.project.hyuga.domain.etiquette.domain.type.Category
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_country")
class Country(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

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

)