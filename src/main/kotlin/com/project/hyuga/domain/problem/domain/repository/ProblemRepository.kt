package com.project.hyuga.domain.problem.domain.repository

import com.project.hyuga.domain.problem.domain.Problem
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface ProblemRepository : CrudRepository<Problem, UUID>
