package com.items.items.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.items.items.beans.Item;
import com.items.items.beans.Stock;
import com.items.items.service.StockService;

@RestController
@RequestMapping("Stock")
@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
public class StockController {
	@Autowired
	private StockService stockService;

	@PostMapping("add-item")
	public ResponseEntity<?> addItem(@RequestBody Item item) {
		try {
			stockService.addItem(item);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok("Item added!");

	}

	@PostMapping("add-stock")
	public ResponseEntity<?> addStock(@RequestBody Stock stock) {
		try {
			stockService.addStock(stock);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok("Stock added!");

	}

	@DeleteMapping("delete-item/{itemID}")
	public ResponseEntity<?> deleteItem(@PathVariable int itemID) throws SQLException {
		try {
			stockService.deleteItem(itemID);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok("Item deleted!");

	}

	@GetMapping("get-item-details/{itemID}")
	public ResponseEntity<?> getItemDeatls(@PathVariable int itemID) {
		try {
			return new ResponseEntity<Item>(stockService.getItemDetails(itemID), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}

	}

	@GetMapping("get-one-stock/{stockID}")
	public ResponseEntity<?> getOneStock(@PathVariable int stockID) {
		try {
			return new ResponseEntity<Stock>(stockService.getOneStock(stockID), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}

	}

	@GetMapping("get-all-items")
	public ResponseEntity<?> getAllItems() throws SQLException {
		try {
			return new ResponseEntity<List<Item>>(stockService.getAllItems(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("get-all-stocks")
	public ResponseEntity<?> getAllStocks() throws SQLException {
		try {
			return new ResponseEntity<List<Stock>>(stockService.getAllStocks(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("purchase")
	public ResponseEntity<?> purchaseItem(@RequestBody Item item) {
		try {
			stockService.purchaseItem(item);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok("purchased success!");

	}
	@PostMapping("upcoming-item")
	public ResponseEntity<?> upcomingItem(@RequestBody Item item) {
		try {
			stockService.upcomingItem(item);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok("purchased success!");

	}
	



	@PostMapping("add-item-to-stock/{itemID}/{stockID}")
	public ResponseEntity<?> addItemFromStock(@PathVariable int itemID, @PathVariable int stockID) {
		try {
			stockService.addPurchaseItems(itemID, stockID);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok("item added to the stock!");

	}
	@PostMapping("delete-item-to-stock/{itemID}/{stockID}")
	public ResponseEntity<?> deleteItemFromStock(@PathVariable int itemID, @PathVariable int stockID) {
		try {
			stockService.deletePurchaseItems(itemID, stockID);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return ResponseEntity.ok("item deleted from stock!");

	}

}
