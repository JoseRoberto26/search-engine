package com.joseroberto26.searchengineservice.Service;

import com.joseroberto26.searchengineservice.Exceptions.EmptyNameException;
import com.joseroberto26.searchengineservice.Model.Item;
import com.joseroberto26.searchengineservice.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public void saveItem(List<Item> items) throws EmptyNameException{
        itemRepository.saveAll(items);
    }

    public List<Item> searchItems(String itemName, Optional<String> itemType){
        if(itemType.isPresent()){
            return itemRepository.findAllByTitleContainingAndTypeEquals(itemName, itemType.get());
        }else{
            return itemRepository.findAllByTitleContaining(itemName);
        }
    }

    public Iterable<Item>allItems(){
        return itemRepository.findAll();
    }

}
