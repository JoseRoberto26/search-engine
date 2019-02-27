package com.joseroberto26.searchengineservice.Controller;

import com.joseroberto26.searchengineservice.Model.Item;
import com.joseroberto26.searchengineservice.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/entities")
public class ItemController {


    @Autowired
    ItemService itemService;


    @PostMapping
    public ResponseEntity saveItem( @Valid @RequestBody List<Item> items){
        itemService.saveItem(items);
        ResponseEntity responseEntity = ResponseEntity.status(HttpStatus.OK).build();
        return responseEntity;
    }

    @GetMapping
    public List<Item> getItems(@RequestParam String q, @RequestParam Optional<String> entity_type){
        List<Item> itemsFound = itemService.searchItems(q, entity_type);
        return itemsFound;
    }

    @GetMapping(value = "/all")
    public Iterable<Item>getAllItems(){
        return itemService.allItems();
    }

}
