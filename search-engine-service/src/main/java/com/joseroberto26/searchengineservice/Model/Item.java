package com.joseroberto26.searchengineservice.Model;


import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Document(indexName = "search-engine", type = "item", shards =2)
public class Item {

    @Id
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
