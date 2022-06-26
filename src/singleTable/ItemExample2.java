package singleTable;

import annotations.Column;

import java.math.BigDecimal;

public class ItemExample2 {

    @Column("item_id")
    private String id;

    @Column("item_price")
    private BigDecimal price;
}
