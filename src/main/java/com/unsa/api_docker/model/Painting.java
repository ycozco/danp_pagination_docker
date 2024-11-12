package com.unsa.api_docker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Painting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String painting;
    private String artist;
    private Integer yearOfPainting;
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

    // Nuevo campo 'room'
    @NotNull
    private Integer room = 0; // Valor por defecto 0

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPainting() {
        return painting != null ? painting : "";
    }

    public void setPainting(String painting) {
        this.painting = painting;
    }

    public String getArtist() {
        return artist != null ? artist : "";
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getYearOfPainting() {
        return yearOfPainting != null ? yearOfPainting : 0;
    }

    public void setYearOfPainting(Integer yearOfPainting) {
        this.yearOfPainting = yearOfPainting;
    }

    public String getAdjustedPrice() {
        return adjustedPrice != null ? adjustedPrice : "";
    }

    public void setAdjustedPrice(String adjustedPrice) {
        this.adjustedPrice = adjustedPrice;
    }

    public String getOriginalPrice() {
        return originalPrice != null ? originalPrice : "";
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getDateOfSale() {
        return dateOfSale != null ? dateOfSale : "";
    }

    public void setDateOfSale(String dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public Integer getYearOfSale() {
        return yearOfSale != null ? yearOfSale : 0;
    }

    public void setYearOfSale(Integer yearOfSale) {
        this.yearOfSale = yearOfSale;
    }

    public String getSeller() {
        return seller != null ? seller : "";
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getBuyer() {
        return buyer != null ? buyer : "";
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getAuctionHouse() {
        return auctionHouse != null ? auctionHouse : "";
    }

    public void setAuctionHouse(String auctionHouse) {
        this.auctionHouse = auctionHouse;
    }

    public String getImage() {
        return image != null ? image : "";
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPaintingWikipediaProfile() {
        return paintingWikipediaProfile != null ? paintingWikipediaProfile : "";
    }

    public void setPaintingWikipediaProfile(String paintingWikipediaProfile) {
        this.paintingWikipediaProfile = paintingWikipediaProfile;
    }

    public String getArtistWikipediaProfile() {
        return artistWikipediaProfile != null ? artistWikipediaProfile : "";
    }

    public void setArtistWikipediaProfile(String artistWikipediaProfile) {
        this.artistWikipediaProfile = artistWikipediaProfile;
    }

    public String getDescription() {
        return description != null ? description : "";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRoom() {
        return room != null ? room : 0;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }
}
