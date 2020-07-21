package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.inventory.entity.Product;
import com.inventory.entity.ProductSale;
import com.inventory.entity.Sale;
import com.inventory.service.SaleServicce;

@RestController
public class SaleController {
	@Autowired
	SaleServicce service;
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/ims/getAllSales")
	public List<Sale> getAllSales(){
		List<Sale> saleList=service.getAllSales();
		return saleList;
	}
	@PostMapping("/ims/createSale")
	public ResponseEntity<String> createSale(@RequestBody Sale sale){
		return service.createSale(sale);		
		
	}
	@PutMapping("/ims/updateSale")
	public ResponseEntity<String> updateSale(@RequestBody Sale sale){
		return service.updateSale(sale);		
		
	}
	@DeleteMapping("/ims/deleteSale/{saleId}")
	public ResponseEntity<String> deleteSale(@PathVariable Integer saleId){
		return service.deleteSale(saleId);		
		
	}
	@GetMapping("/ims/getSaleById/{saleId}")
	public ProductSale getSaleById(@PathVariable Integer saleId){
		
		Sale sale= service.getSaleById(saleId);	
		Product product=restTemplate.getForObject("http://product-info-service/ims/getProductById/"+sale.getProductId(), Product.class);
		System.out.println(product);
		//restTemplate.getForObj
		ProductSale productSale=new ProductSale();
		productSale.setSaleId(sale.getSaleId());
		productSale.setProductId(sale.getProductId());
		productSale.setProductQuantity(sale.getProductQuantity());		
		productSale.setProductPrice(product.getProductPrice());
		productSale.setSalePrice(sale.getSalePrice());
		productSale.setSaleDate(sale.getSaleDate());
		return productSale;
		
	}
}
