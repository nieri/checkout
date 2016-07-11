package br.com.munieri.checkout.view.dto;


import br.com.munieri.checkout.domain.product.Product;
import br.com.munieri.checkout.view.converter.ProductConverter;

import java.util.*;

public class CartDTO {

    private Map<ItemDTO, Integer> items;
    private Double total = 0d;
    private Double paymentAmount = total;
    private int totalItems = 0;

    public Map<ItemDTO, Integer> getItems() {
        return items;
    }

    public void setItems(Map<ItemDTO, Integer> items) {
        this.items = items;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getTotalItems() {
        return this.totalItems;
    }

    public void addItem(Product product) {

        ItemDTO dto = new ItemDTO();
        dto.setProductDTO(ProductConverter.convertToDTO(product));
        dto.setAmount(1);

        addItem(dto);
    }

    public void addItem(ItemDTO item) {

        if (items == null || items.isEmpty()) {
            items = new LinkedHashMap();
        }
        int size = items.getOrDefault(item, 0);
        ++size;
        items.put(item, size);

        total += item.getProductDTO().getPrice() * item.getAmount();
        totalItems++;

    }

    public void remove(int indexItem) {

        ItemDTO removedItem = (ItemDTO) items.keySet().toArray()[indexItem];
        int index = items.get(removedItem);

        for (int i = 0; i < index; i++) {
            items.remove(removedItem);
            total -= removedItem.getProductDTO().getPrice() * removedItem.getAmount();
            totalItems--;
        }
    }

    public void removeItem(Product product) {

        ItemDTO dto = new ItemDTO();
        dto.setProductDTO(ProductConverter.convertToDTO(product));
        dto.setAmount(1);

        items.forEach((k,v)->{
            if(dto.equals(k)){
                items.replace(dto, v, v-1);
            }
        });

        total -= dto.getProductDTO().getPrice() * dto.getAmount();
        totalItems--;

    }

    public Double getPaymentAmount() {
        paymentAmount = this.total;

        if (this.total > 500) {
            paymentAmount *= 0.95;
        } else if (this.total > 600) {
            paymentAmount *= 0.9;
        } else if (this.total > 700) {
            paymentAmount *= 0.85;
        }
        return paymentAmount;

    }
}
