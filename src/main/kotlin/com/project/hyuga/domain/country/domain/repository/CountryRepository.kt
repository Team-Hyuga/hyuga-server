package com.project.hyuga.domain.country.domain.repository

import com.project.hyuga.domain.country.domain.Country
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface CountryRepository : CrudRepository<Country, UUID> {
}