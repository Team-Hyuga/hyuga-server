package com.project.hyuga.domain.user.domain

import com.project.hyuga.domain.user.domain.type.Authority
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.DynamicInsert
import javax.persistence.*
import javax.validation.constraints.NotNull

@DynamicInsert
@Entity
@Table(name = "tbl_user")
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @field:NotNull
    @Column(unique = true)
    val email: String,

    @field:NotNull
    @Column(length = 10)
    val name: String,

    @field:NotNull
    @Column(columnDefinition = "CHAR(60)")
    val password: String,

    @ColumnDefault("a")
    @Column(nullable = false)
    val profileImageUrl: String,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 5)
    val authority: Authority

)