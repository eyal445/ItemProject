package com.items.items.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.items.items.beans.Item;

public interface ItemReposetory extends JpaRepository<Item, Integer> {

}
