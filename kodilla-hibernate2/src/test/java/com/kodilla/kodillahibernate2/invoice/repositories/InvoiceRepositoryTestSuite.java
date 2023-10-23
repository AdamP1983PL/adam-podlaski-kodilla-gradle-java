package com.kodilla.kodillahibernate2.invoice.repositories;

import com.kodilla.kodillahibernate2.invoice.entities.Invoice;
import com.kodilla.kodillahibernate2.invoice.entities.Item;
import com.kodilla.kodillahibernate2.invoice.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/*
 * Napisz test o nazwie testInvoiceDaoSave(),
 * sprawdzający, czy faktura z kilkoma pozycjami zapisuje się poprawnie w bazie danych
 * Pamiętaj, że test musi być idempotentny (musi zostawiać bazę danych w stanie takim,
 * w jakim ją zastał – bez nowych wpisów)
 */

@SpringBootTest
class InvoiceRepositoryTestSuite {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    void testInvoiceRepositorySave() {
        // given
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");
        productRepository.save(product1);
        productRepository.save(product2);

        Item item1 = new Item(new BigDecimal(100), 1, new BigDecimal(1));
        item1.setProduct(product1);
        Item item2 = new Item(new BigDecimal(100), 5, new BigDecimal(5));
        item2.setProduct(product2);

        Invoice invoice = new Invoice("FV 2023/10/23/1");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        // when
        invoiceRepository.save(invoice);
        int id = invoice.getId();
        Optional<Invoice> savedInvoice = invoiceRepository.findById(id);


        // then
        assertEquals(2, invoice.getItems().size());
        assertNotEquals(0, id);
        assertEquals("FV 2023/10/23/1", savedInvoice.get().getNumber());

        // cleanUp
        try {
            invoiceRepository.deleteById(id);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
