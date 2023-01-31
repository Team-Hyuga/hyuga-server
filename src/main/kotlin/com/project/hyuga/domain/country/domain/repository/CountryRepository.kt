package com.project.hyuga.domain.country.domain.repository

import com.project.hyuga.domain.country.domain.Country
import org.springframework.data.repository.CrudRepository

interface CountryRepository : CrudRepository<Country, Long> {
}