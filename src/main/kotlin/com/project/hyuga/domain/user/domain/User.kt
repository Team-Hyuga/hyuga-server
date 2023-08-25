package com.project.hyuga.domain.user.domain

import com.project.hyuga.domain.badge.domain.BadgeStore
import com.project.hyuga.domain.problem.domain.Solution
import com.project.hyuga.domain.user.domain.type.Authority
import com.project.hyuga.global.entity.BaseUUIDEntity
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull

@Table(name = "tbl_user")
@Entity
class User(

    override val id: UUID,

    @field:NotNull
    @Column(unique = true)
    val email: String,

    @field:NotNull
    @Column(columnDefinition = "CHAR(60)")
    val password: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(10)")
    val name: String,

    @field:NotNull
    @Column(columnDefinition = "VARCHAR(6)")
    @Enumerated(EnumType.STRING)
    val authority: Authority,

    @field:NotNull
    val profileImageUrl: String = "a",

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    val solutions: MutableList<Solution> = mutableListOf(),

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    val badges: MutableList<BadgeStore> = mutableListOf()

) : BaseUUIDEntity(id)