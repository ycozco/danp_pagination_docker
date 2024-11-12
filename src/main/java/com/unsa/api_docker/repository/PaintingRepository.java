package com.unsa.api_docker.repository;

import com.unsa.api_docker.model.Painting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaintingRepository extends JpaRepository<Painting, Long> {
    // Método para buscar pinturas por 'room' con paginación
    Page<Painting> findByRoom(Integer room, Pageable pageable);
}
