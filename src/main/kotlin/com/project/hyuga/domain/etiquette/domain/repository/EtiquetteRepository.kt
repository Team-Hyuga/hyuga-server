package com.project.hyuga.domain.etiquette.domain.repository

import com.project.hyuga.domain.etiquette.domain.Etiquette
import org.springframework.data.repository.CrudRepository

interface EtiquetteRepository : CrudRepository<Etiquette, Long> {
}