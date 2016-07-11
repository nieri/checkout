package br.com.munieri.checkout.view.dto;

import java.util.Map;

public class OrderDTO {

    private Long id;
    private Map<ItemDTO, Integer> items;
    private UserDTO user;
    private Double amount;
    private PaymentDTO payment;
    private String message;

    public OrderDTO(Map<ItemDTO, Integer> items, Double amount) {
        this.id = 23453543546l;
        this.user = new UserDTO();
        this.items = items;
        this.amount = amount;
        this.payment = new PaymentDTO("Boleto Bancário");
        this.message = "Atenção: Você receberá um e-mail com a </br>confirmação e todos os detalhes do seu pedido.</br>" +
                "Por favor, verifique as configurações AntiSpan</br> do seu provedor de e-mail";
    }

    public Long getId() {
        return id;
    }

    public Map<ItemDTO, Integer> getItems() {
        return items;
    }

    public UserDTO getUser() {
        return user;
    }

    public Double getAmount() {
        return amount;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}