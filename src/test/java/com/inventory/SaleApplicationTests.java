package com.inventory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.inventory.controller.SaleController;
import com.inventory.entity.ProductSale;
import com.inventory.entity.Sale;
import com.inventory.service.SaleServicce;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes=SaleApplication.class)
class SaleApplicationTests {
    @Autowired
	SaleController saleController;
    @MockBean
    SaleServicce service;
    Date date=new Date();
	Timestamp timestamp=new Timestamp(date.getTime());
    @Test
    public void getAllSalesTest() {
    	
    	Sale sale1=new Sale(1,1,100,10000.00d,timestamp);
    	Sale sale2=new Sale(2,2,200,20000.00d,timestamp);
    	List<Sale> saleList=new ArrayList<Sale>();
    	saleList.add(sale1);
    	saleList.add(sale2);
    	when(service.getAllSales()).thenReturn(saleList);
    	assertEquals(2, saleController.getAllSales().size());
    }
    @Test
    public void createSaleTest() {
    	Sale sale3=new Sale(3,3,300,30000.00d,timestamp);
    	ResponseEntity<String> responseEntity = new ResponseEntity<String>("Sale created successfully!!",HttpStatus.CREATED);
    	when(service.createSale(sale3,1)).thenReturn(responseEntity);
    	ResponseEntity<String> result = saleController.createSale(sale3);
    	assertEquals("Sale created successfully!!", result.getBody());
    	
    	
    }
    @Test
    public void updateSaleTest() {
    	Sale sale4=new Sale(4,4,400,40000.00d,timestamp);
    	ResponseEntity<String> responseEntity = new ResponseEntity<String>("Sale updated successfully!!",HttpStatus.OK);
    	when(service.updateSale(sale4)).thenReturn(responseEntity);
    	ResponseEntity<String> result = saleController.updateSale(sale4);
    	assertEquals("Sale updated successfully!!", result.getBody());
    	
    	
    }
    @Test
    public void deleteSaleTest() {
    	Sale sale4=new Sale(4,4,400,40000.00d,timestamp);
    	ResponseEntity<String> responseEntity=new ResponseEntity<String>("Sale deleted successfully!!",HttpStatus.OK);
    	when(service.deleteSale(sale4.getSaleId())).thenReturn(responseEntity);
    	ResponseEntity<String> result=saleController.deleteSale(sale4.getSaleId());
    	assertEquals("Sale deleted successfully!!", result.getBody());
    }
    /*@Test
    public void getSaleByIdTest() {
    	Sale sale4=new Sale(4,4,400,40000.00d,timestamp);
    	when(service.getSaleById(sale4.getSaleId())).thenReturn(sale4);
    	ProductSale productSale = saleController.getSaleById(sale4.getSaleId());
    	assertEquals(4, productSale.getProductId());
    }*/

}
