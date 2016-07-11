package br.com.munieri.checkout.domain.product.service;

import br.com.munieri.checkout.domain.product.Product;
import br.com.munieri.checkout.infrastructure.repository.product.ProductRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class ProductServiceTest {

    @InjectMocks
    ProductServiceImpl service;

    @Mock
    ProductRepository addressRepository;

    @BeforeMethod
    public void init(){
        service = new ProductServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_return_product(){

        Product mock = getProductMock();

        when(addressRepository.findById(eq(mock.getId()))).thenReturn(mock);
        Product product = service.find(mock);

        assertEquals(product.getName(), "Celular");
    }

    private Product getProductMock() {
        Product mock = new Product("Celular", 200.00);
        mock.setId(1l);
        return mock;
    }

    @Test
    public void should_return_product_by_id(){

        Product mock = getProductMock();

        when(addressRepository.findById(eq(mock.getId()))).thenReturn(mock);
        Product product = service.findById(1L);

        assertEquals(product.getName(), "Celular");
    }
}
