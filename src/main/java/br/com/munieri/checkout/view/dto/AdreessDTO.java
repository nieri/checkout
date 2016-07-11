package br.com.munieri.checkout.view.dto;

public class AdreessDTO {

    private Long id;
    private String street;
    private String state;
    private String city;
    private int number;
    private String cep;

    public AdreessDTO(String street, int number, String city, String state, String cep) {
        this.street = street;
        this.state = state;
        this.city = city;
        this.number = number;
        this.cep = cep;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
