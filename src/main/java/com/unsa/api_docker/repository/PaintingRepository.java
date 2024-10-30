package com.unsa.api_docker.repository;

import com.unsa.api_docker.model.Painting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintingRepository extends JpaRepository<Painting, Long> {
    // Si tienes métodos personalizados, puedes agregarlos aquí.
}
