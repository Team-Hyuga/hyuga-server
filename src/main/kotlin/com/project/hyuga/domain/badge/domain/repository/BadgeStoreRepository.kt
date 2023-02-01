package com.project.hyuga.domain.badge.domain.repository

import com.project.hyuga.domain.badge.domain.BadgeStore
import com.project.hyuga.domain.badge.domain.BadgeStoreId
import org.springframework.data.repository.CrudRepository

interface BadgeStoreRepository : CrudRepository<BadgeStore, BadgeStoreId> {
}