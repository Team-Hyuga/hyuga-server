package com.project.hyuga.domain.badge.domain.repository

import com.project.hyuga.domain.badge.domain.Badge
import org.springframework.data.repository.CrudRepository

interface BadgeRepository : CrudRepository<Badge, Long> {
}