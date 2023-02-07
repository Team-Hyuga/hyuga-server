package com.project.hyuga.domain.reliability.domain.repository

import com.project.hyuga.domain.reliability.domain.UserReliability
import com.project.hyuga.domain.reliability.domain.UserReliabilityId
import org.springframework.data.repository.CrudRepository

interface UserReliabilityRepository : CrudRepository<UserReliability, UserReliabilityId> {
}