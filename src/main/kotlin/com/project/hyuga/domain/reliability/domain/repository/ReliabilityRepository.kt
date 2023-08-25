package com.project.hyuga.domain.reliability.domain.repository

import com.project.hyuga.domain.reliability.domain.Reliability
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ReliabilityRepository : CrudRepository<Reliability, UUID> {
}