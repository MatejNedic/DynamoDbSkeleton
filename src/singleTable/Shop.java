package singleTable;

import annotations.PartitionKey;
import annotations.Table;

import java.util.List;

@Table("AMAZON_SHOP")
public class Shop {

    @PartitionKey("PK1")
    private String shopId;

    private List<Item> items;

    private List<Order> orders;

}
