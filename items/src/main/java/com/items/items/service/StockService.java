package com.items.items.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.items.items.beans.Item;
import com.items.items.beans.Stock;
import com.items.items.exception.NotAllowedException;
import com.items.items.exception.PurchaseItemException;
import com.items.items.repo.ItemReposetory;
import com.items.items.repo.StockReposetory;

@Service
public class StockService {
	private int stockID;
	@Autowired
	private ItemReposetory itemReposetory;
	@Autowired
	private StockReposetory stockReposetory;

	public void addItem(Item item) throws NotAllowedException {
		Stock stock = stockReposetory.getOne(stockID);
		List<Item> items = itemReposetory.findAll();
		for (Item i : items) {
			if (i.getId() == item.getId()) {
				throw new NotAllowedException("you can't add a new item to a stock that have a item with the same id");

			}
		}
		itemReposetory.save(item);

	}

	public void updateStock(Stock stock) {
		stockReposetory.saveAndFlush(stock);
	}

	public void deleteItem(int itemID) {
		Item item = itemReposetory.getOne(itemID);
		List<Stock> stocks = stockReposetory.findAll();
		for (Stock stock : stocks) {
			if (stock.getItems().contains(item)) {
				stock.getItems().remove(item);
				itemReposetory.saveAndFlush(item);

			}
		}
		itemReposetory.deleteById(itemID);
	}

	public void addStock(Stock stock) {
		stockReposetory.save(stock);
	}

	public Item getItemDetails(int itemID) {
		return itemReposetory.findById(itemID).get();

	}

	public List<Item> getAllItems() {
		return itemReposetory.findAll();

	}

	public Stock getOneStock(int stockID) {
		return stockReposetory.findById(stockID).get();

	}

	public List<Stock> getAllStocks() {
		return stockReposetory.findAll();

	}

	public void addPurchaseItems(int itemID, int stockID) {
		Stock stock = stockReposetory.getOne(stockID);
		Item item = itemReposetory.getOne(itemID);
		stock.addItem(item);
		stockReposetory.saveAndFlush(stock);
	}

	public void deletePurchaseItems(int itemID, int stockID) {
		Stock stock = stockReposetory.getOne(stockID);
		Item item = itemReposetory.getOne(itemID);
		stock.removeItem(item);
		stockReposetory.saveAndFlush(stock);
	}

	public void purchaseItem(Item item) throws PurchaseItemException {
		Item fromdb = itemReposetory.getOne(item.getId());
		if (fromdb.getAmount() <= 0) {
			throw new PurchaseItemException("you cannot purchase item when ammount=0");
		}

		System.out.println("it's sims that you can purchase this item");
		System.out.println(fromdb);
		fromdb.setAmount(fromdb.getAmount()-1);
		System.out.println(fromdb);
		itemReposetory.saveAndFlush(fromdb);

	}
	public void upcomingItem(Item item) throws PurchaseItemException {
		Item fromdb = itemReposetory.getOne(item.getId());
		if (fromdb.getAmount() <= 0) {
			throw new PurchaseItemException("you cannot purchase item when ammount=0");
		}

		System.out.println("it's sims that you can purchase this item");
		System.out.println(fromdb);
		fromdb.setAmount(fromdb.getAmount()+1);
		System.out.println(fromdb);
		itemReposetory.saveAndFlush(fromdb);

	}
}
