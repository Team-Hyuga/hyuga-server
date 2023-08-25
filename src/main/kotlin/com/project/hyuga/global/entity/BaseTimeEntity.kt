package com.project.hyuga.global.entity

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.MappedSuperclass
import javax.validation.constraints.NotNull

@MappedSuperclass
abstract class BaseTimeEntity(

    @field:NotNull
    @Column(columnDefinition = "DATETIME(6)", updatable = false)
    val createdAt: LocalDate = LocalDate.now()

)