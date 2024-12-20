package com.unsa.api_docker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pinturas") // Aseguras que la entidad mapee la tabla "pinturas"
public class Painting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String painting;
    private String artist;

    // Si year_of_painting ahora es un texto (por ejemplo "1556, 1559")
    @Column(name = "year_of_painting")
    private String yearOfPainting;

    private String adjustedPrice;
    private String originalPrice;
    private String dateOfSale;
    private Integer yearOfSale;
    private String seller;
    private String buyer;
    private String auctionHouse;
    private String image;
    private String paintingWikipediaProfile;
    private String artistWikipediaProfile;
    private String description;

    @NotNull
    private Integer room = 0;

    // getters y setters sin lógica adicional
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPainting() { return painting; }
    public void setPainting(String painting) { this.painting = painting; }

    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }

    public String getYearOfPainting() { return yearOfPainting; }
    public void setYearOfPainting(String yearOfPainting) { this.yearOfPainting = yearOfPainting; }

    public String getAdjustedPrice() { return adjustedPrice; }
    public void setAdjustedPrice(String adjustedPrice) { this.adjustedPrice = adjustedPrice; }

    public String getOriginalPrice() { return originalPrice; }
    public void setOriginalPrice(String originalPrice) { this.originalPrice = originalPrice; }

    public String getDateOfSale() { return dateOfSale; }
    public void setDateOfSale(String dateOfSale) { this.dateOfSale = dateOfSale; }

    public Integer getYearOfSale() { return yearOfSale; }
    public void setYearOfSale(Integer yearOfSale) { this.yearOfSale = yearOfSale; }

    public String getSeller() { return seller; }
    public void setSeller(String seller) { this.seller = seller; }

    public String getBuyer() { return buyer; }
    public void setBuyer(String buyer) { this.buyer = buyer; }

    public String getAuctionHouse() { return auctionHouse; }
    public void setAuctionHouse(String auctionHouse) { this.auctionHouse = auctionHouse; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getPaintingWikipediaProfile() { return paintingWikipediaProfile; }
    public void setPaintingWikipediaProfile(String paintingWikipediaProfile) { this.paintingWikipediaProfile = paintingWikipediaProfile; }

    public String getArtistWikipediaProfile() { return artistWikipediaProfile; }
    public void setArtistWikipediaProfile(String artistWikipediaProfile) { this.artistWikipediaProfile = artistWikipediaProfile; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getRoom() { return room; }
    public void setRoom(Integer room) { this.room = room; }
}
