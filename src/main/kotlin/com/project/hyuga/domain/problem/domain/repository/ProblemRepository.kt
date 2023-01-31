package com.project.hyuga.domain.problem.domain.repository

import com.project.hyuga.domain.problem.domain.Problem
import org.springframework.data.repository.CrudRepository

interface ProblemRepository : CrudRepository<Problem, Long> {
}