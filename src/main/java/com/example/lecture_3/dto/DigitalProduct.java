package com.example.lecture_3.dto;

public class DigitalProduct extends Product {

    private String downloadUrl;
    private Double fileSizeMB;


    public DigitalProduct() {
    }

    public DigitalProduct(Long id, String name, double price, String downloadUrl, Double fileSizeMB) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Double getFileSizeMB() {
        return fileSizeMB;
    }

    public void setFileSizeMB(Double fileSizeMB) {
        this.fileSizeMB = fileSizeMB;
    }
}
