package com.unsa.api_docker.controller;

import com.unsa.api_docker.dto.PaginationResponse;
import com.unsa.api_docker.model.Painting;
import com.unsa.api_docker.repository.PaintingRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/paintings")
public class PaintingController {

    @Autowired
    private PaintingRepository paintingRepository;

    @GetMapping
    public PaginationResponse<Painting> getAllPaintings(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<Integer> size,
            @RequestParam Optional<Integer> room) {

        int pageNumber = page.orElse(0);
        int pageSize = size.orElse(10);

        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Page<Painting> pageResult;

        if (room.isPresent() && room.get() != 0) {
            pageResult = paintingRepository.findByRoom(room.get(), paging);
        } else {
            pageResult = paintingRepository.findAll(paging);
        }

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
    public Painting createPainting(@Valid @RequestBody Painting painting) {
        return paintingRepository.save(painting);
    }

    @GetMapping("/{id}")
    public Painting getPaintingById(@PathVariable Long id) {
        return paintingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Painting not found"));
    }

    @PutMapping("/{id}")
    public Painting updatePainting(@PathVariable Long id, @Valid @RequestBody Painting paintingDetails) {
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
        painting.setRoom(paintingDetails.getRoom());

        return paintingRepository.save(painting);
    }

    @DeleteMapping("/{id}")
    public void deletePainting(@PathVariable Long id) {
        Painting painting = paintingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Painting not found"));

        paintingRepository.delete(painting);
    }
}
