package model;

import java.math.BigDecimal;
import java.util.List;

public class Product {
    //
    private int id;

    private String name;

    private BigDecimal price;

    private String description;

    private ECategory category;
    private List<Storage> storageList;
    public Product() {
    }

    public Product(int id, String name, BigDecimal price, String description, ECategory category, List<Storage> storageList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.storageList = storageList;
    }
    public Product(int id, String name, BigDecimal price, String description, ECategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }

    public List<Storage> getStorageList() {
        return storageList;
    }

    public void setStorageList(List<Storage> storageList) {
        this.storageList = storageList;
    }
}

