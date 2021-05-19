package com.items.items.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.items.items.beans.Stock;

public interface StockReposetory extends JpaRepository<Stock, Integer> {

}
