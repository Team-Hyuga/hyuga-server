package com.project.hyuga.domain.problem.domain.repository

import com.project.hyuga.domain.problem.domain.Solution
import com.project.hyuga.domain.problem.domain.SolutionId
import org.springframework.data.repository.CrudRepository

interface SolutionRepository : CrudRepository<Solution, SolutionId>
