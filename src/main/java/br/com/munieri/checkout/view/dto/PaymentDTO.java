package br.com.munieri.checkout.view.dto;

public class PaymentDTO {

    private Long id;
    private String type;

    public PaymentDTO(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
