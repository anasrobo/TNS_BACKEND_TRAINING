package com.tnsif.shoppingmall.services;

import org.springframework.stereotype.Service;

import com.tnsif.shoppingmall.entity.Item;
import com.tnsif.shoppingmall.repository.ItemRepository;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item get(long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public void delete(long id) {
        itemRepository.deleteById(id);
    }
}
