package com.joseroberto26.searchengineservice.Repository;

import com.joseroberto26.searchengineservice.Model.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends ElasticsearchRepository<Item ,String> {

    List<Item> findAllByTitleContaining(String itemName);

    List<Item> findAllByTitleContainingAndTypeEquals(@Param("title") String title,@Param("type") String type);


}
