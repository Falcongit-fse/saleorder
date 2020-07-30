package com.inventory.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.inventory.entity.Sale;
import com.inventory.repository.SaleRepository;
@Service
public class SaleServicce {
	@Autowired
	SaleRepository saleRepository;
	public List<Sale> getAllSales(){
		List<Sale> saleList=(List<Sale>) saleRepository.findAll();
		return saleList;
	}
	public ResponseEntity<String> createSale(Sale sale,Integer soldQuantity){
		 saleRepository.save(sale);
		 Integer productsSold=soldQuantity+sale.getProductQuantity();
		 int updateRows=saleRepository.updateProductSold(sale.getProductId(),productsSold );
		 System.out.println(updateRows+"rows updated!!");
		 return new ResponseEntity<String>("Sale created successfully!!",HttpStatus.CREATED);		
		
	}
	public ResponseEntity<String> updateSale(Sale sale){
		 saleRepository.save(sale);
		 return new ResponseEntity<String>("Sale updated successfully!!",HttpStatus.OK);		
		
	}
	public ResponseEntity<String> deleteSale(Integer saleId){
		 saleRepository.deleteById(saleId);
		 return new ResponseEntity<String>("Sale deleted successfully!!",HttpStatus.OK);		
		
	}
	public Sale getSaleById(Integer saleId) {
		Sale sale=null;
		Optional<Sale> optionalSale = saleRepository.findById(saleId);
		if(optionalSale.isPresent())
			sale= optionalSale.get();
		return sale;
	}

}
