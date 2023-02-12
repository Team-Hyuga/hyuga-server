package com.project.hyuga.domain.etiquette.domain

import com.project.hyuga.domain.etiquette.domain.type.Category
import com.project.hyuga.domain.user.domain.User
import com.project.hyuga.global.entity.BaseTimeEntity
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "tbl_etiquette")
class Etiquette(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    title: String,

    content: String,

    @field:NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 13)
    val category: Category,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val writer: User

) : BaseTimeEntity() {

    @field:NotNull
    @Column(length = 30)
    var title = title
        protected set

    @field:NotNull
    @Column(length = 1000)
    var content = content
        protected set

    fun updateEtiquette(title: String, content: String) {
        this.title = title
        this.content = content
    }

}