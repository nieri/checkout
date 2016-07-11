package br.com.munieri.checkout.view.dto;

public class UserDTO {

    private Long id;
    private String name;
    private AdreessDTO adreess;
    private ContactDTO contact;

    public UserDTO() {
        this.name = "Jhon Joe";
        this.adreess = new AdreessDTO("Alameda Araguaia", 2751, "Barueri", "SP", "06455-906");
        this.contact = new ContactDTO("(11) 2164-3750", "jhon.joe@email.com");
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdreessDTO getAdreess() {
        return adreess;
    }

    public void setAdreess(AdreessDTO adreess) {
        this.adreess = adreess;
    }

    public ContactDTO getContact() {
        return contact;
    }

    public void setContact(ContactDTO contact) {
        this.contact = contact;
    }
}
