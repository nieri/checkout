package br.com.munieri.checkout.view.dto;

public class ContactDTO {

    private Long id;
    private String phone;
    private String email;

    public ContactDTO(String fone, String email) {
        this.phone = fone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
