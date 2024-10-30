package com.unsa.api_docker.controller;

import com.unsa.api_docker.dto.PaginationResponse;
import com.unsa.api_docker.model.Painting;
import com.unsa.api_docker.repository.PaintingRepository;

import jakarta.servlet.http.HttpServletRequest; // Import necesario para HttpServletRequest
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;

@RestController
@RequestMapping("/api/paintings")
public class PaintingController {

    @Autowired
    private PaintingRepository paintingRepository;

    @GetMapping
    public PaginationResponse<Painting> getAllPaintings(HttpServletRequest request) {

        // Imprimir todos los parámetros recibidos
        Enumeration<String> parameterNames = request.getParameterNames();
        System.out.println("Parámetros recibidos:");
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);
            System.out.println(paramName + " = " + paramValue);
        }

        // Obtener los parámetros 'page' y 'size'
        String pageParam = request.getParameter("page");
        String sizeParam = request.getParameter("size");

        // Establecer valores por defecto si los parámetros no están presentes
        int page = 0; // página por defecto
        int size = 10; // tamaño por defecto

        try {
            if (pageParam != null) {
                page = Integer.parseInt(pageParam);
            }
            if (sizeParam != null) {
                size = Integer.parseInt(sizeParam);
            }
        } catch (NumberFormatException e) {
            // Manejar valores inválidos de parámetros
            throw new IllegalArgumentException("Parámetros 'page' o 'size' inválidos");
        }

        System.out.println("Valor final de 'page': " + page);
        System.out.println("Valor final de 'size': " + size);

        Pageable paging = PageRequest.of(page, size);
        Page<Painting> pageResult = paintingRepository.findAll(paging);

        PaginationResponse<Painting> response = new PaginationResponse<>();
        response.setContent(pageResult.getContent());
        response.setPageNumber(pageResult.getNumber());
        response.setPageSize(pageResult.getSize());
        response.setTotalElements(pageResult.getTotalElements());
        response.setTotalPages(pageResult.getTotalPages());
        response.setLast(pageResult.isLast());

        return response;
    }

    @PostMapping
    public Painting createPainting(@RequestBody Painting painting) {
        return paintingRepository.save(painting);
    }

    @GetMapping("/{id}")
    public Painting getPaintingById(@PathVariable Long id) {
        return paintingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Painting not found"));
    }

    @PutMapping("/{id}")
    public Painting updatePainting(@PathVariable Long id, @RequestBody Painting paintingDetails) {
        Painting painting = paintingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Painting not found"));

        // Actualiza todos los campos
        painting.setPainting(paintingDetails.getPainting());
        painting.setArtist(paintingDetails.getArtist());
        painting.setYearOfPainting(paintingDetails.getYearOfPainting());
        painting.setAdjustedPrice(paintingDetails.getAdjustedPrice());
        painting.setOriginalPrice(paintingDetails.getOriginalPrice());
        painting.setDateOfSale(paintingDetails.getDateOfSale());
        painting.setYearOfSale(paintingDetails.getYearOfSale());
        painting.setSeller(paintingDetails.getSeller());
        painting.setBuyer(paintingDetails.getBuyer());
        painting.setAuctionHouse(paintingDetails.getAuctionHouse());
        painting.setImage(paintingDetails.getImage());
        painting.setPaintingWikipediaProfile(paintingDetails.getPaintingWikipediaProfile());
        painting.setArtistWikipediaProfile(paintingDetails.getArtistWikipediaProfile());
        painting.setDescription(paintingDetails.getDescription());

        return paintingRepository.save(painting);
    }

    @DeleteMapping("/{id}")
    public void deletePainting(@PathVariable Long id) {
        Painting painting = paintingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Painting not found"));

        paintingRepository.delete(painting);
    }
}
