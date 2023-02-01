package com.project.hyuga.domain.badge.domain

import com.project.hyuga.domain.etiquette.domain.type.Category
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_badge")
class Badge(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotNull
    val name: String,

    @field:NotNull
    val badgeImageUrl: String,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 13)
    val category: Category

)