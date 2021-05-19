package com.items.items.clr;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import com.items.items.beans.Item;
import com.items.items.beans.Stock;
import com.items.items.service.StockService;

@Component
public class Test implements CommandLineRunner {

	@Autowired
	private StockService stockService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Item it1 = new Item();
		it1.setName("Bag by Adidas");
		it1.setAmount(80);
		it1.setInventory_code("1234");

		Item it2 = new Item();
		it2.setName("Beg by Nike");
		it2.setAmount(40);
		it2.setInventory_code("12345");

		Item it3 = new Item();
		it3.setName("TV by Toshiba");
		it3.setAmount(50);
		it3.setInventory_code("123");

		Item it4 = new Item();

		it4.setName("TV by Sony");
		it4.setAmount(80);
		it4.setInventory_code("123456");

		Item it5 = new Item();
		it5.setName("Radio");
		it5.setAmount(30);
		it5.setInventory_code("1245");

		

//add stock+add items
		Stock stock = new Stock();
		stock.setName("Main_Stock");
		stock.setItems(Arrays.asList(it1, it2, it3, it4, it5));
		stockService.addStock(stock);
		
		
//		stockService.deleteItem(1);
		System.out.println("---------------get item deatls-----------------");
		System.out.println(stockService.getItemDetails(2));
		System.out.println("---------------get all items-----------------");
		System.out.println(stockService.getAllItems());
		System.out.println("---------------get one stock-----------------");
		System.out.println(stockService.getOneStock(1));
		
	}
	
	

}
