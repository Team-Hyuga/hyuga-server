package com.project.hyuga.domain.reliability.domain

import com.project.hyuga.global.entity.BaseUUIDEntity
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Table(name = "tbl_reliability")
@Entity
class Reliability(

    override val id: UUID,

    @field:NotNull
    @Column(columnDefinition = "INT")
    val totalPoint: Int,

    @field:NotNull
    @Column(columnDefinition = "TINYINT")
    val grade: Int

) : BaseUUIDEntity(id)