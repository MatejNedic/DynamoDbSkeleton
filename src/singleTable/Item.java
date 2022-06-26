package singleTable;

import annotations.Column;
import annotations.SortKey;

import java.math.BigDecimal;

public class Item {

    @Column("item_id")
    private String id;

    @SortKey("SK1")
    private String sortKey;

    @Column("item_price")
    private BigDecimal price;
}
