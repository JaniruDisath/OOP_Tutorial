package com.example.lecture_3.dto;

public class DigitalProduct extends Product {

    private String downlaodUrl;
    private Double fileSizeMB;


    public DigitalProduct() {
    }

    public DigitalProduct(Long id, String name, double price, String downlaodUrl, Double fileSizeMB) {
        super(id, name, price);
        this.downlaodUrl = downlaodUrl;
        this.fileSizeMB = fileSizeMB;
    }

    public String getDownlaodUrl() {
        return downlaodUrl;
    }

    public void setDownlaodUrl(String downlaodUrl) {
        this.downlaodUrl = downlaodUrl;
    }

    public Double getFileSizeMB() {
        return fileSizeMB;
    }

    public void setFileSizeMB(Double fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
    }
}
