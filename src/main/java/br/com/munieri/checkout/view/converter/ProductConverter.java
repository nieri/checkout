package br.com.munieri.checkout.view.converter;

import br.com.munieri.checkout.domain.product.Product;
import br.com.munieri.checkout.view.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductConverter {

    public static ProductDTO convertToDTO(Product entity) {

        ProductDTO dto = new ProductDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    public static Product convertToEntity(ProductDTO product) {

        Product entity = new Product();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        return entity;
    }

    public static List<ProductDTO> convertListToDTO(List<Product> entity) {

        List<ProductDTO> productDTOs = new ArrayList<>();
        for (br.com.munieri.checkout.domain.product.Product product : entity) {
            productDTOs.add(new ProductDTO(product));
        }
        return productDTOs;
    }
}
