package br.com.appbus.appBus.dto;

public class LocalizacaoDTO {

    private double latitude;
    private double longitude;

    // Construtor vazio (obrigatório para Spring)
    public LocalizacaoDTO() {
    }

    // Getters e Setters
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

