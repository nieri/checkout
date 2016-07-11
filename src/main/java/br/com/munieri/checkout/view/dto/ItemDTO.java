package br.com.munieri.checkout.view.dto;

public class ItemDTO {

    private ProductDTO productDTO;
    private Integer amount;

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemDTO itemDTO = (ItemDTO) o;

        return productDTO.equals(itemDTO.productDTO);

    }

    @Override
    public int hashCode() {
        return productDTO.hashCode();
    }
}
