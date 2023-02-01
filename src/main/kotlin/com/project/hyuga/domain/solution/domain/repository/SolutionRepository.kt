package com.project.hyuga.domain.solution.domain.repository

import com.project.hyuga.domain.solution.domain.Solution
import com.project.hyuga.domain.solution.domain.SolutionId
import org.springframework.data.repository.CrudRepository

interface SolutionRepository : CrudRepository<Solution, SolutionId> {
}