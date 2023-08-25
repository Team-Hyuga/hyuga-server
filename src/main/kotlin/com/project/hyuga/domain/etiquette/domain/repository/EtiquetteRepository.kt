package com.project.hyuga.domain.etiquette.domain.repository

import com.project.hyuga.domain.etiquette.domain.Etiquette
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface EtiquetteRepository : CrudRepository<Etiquette, UUID> {
}