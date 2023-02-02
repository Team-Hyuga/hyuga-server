package com.project.hyuga.domain.reliability.domain.repository

import com.project.hyuga.domain.reliability.domain.Reliability
import org.springframework.data.repository.CrudRepository

interface ReliabilityRepository : CrudRepository<Reliability, Long> {
}