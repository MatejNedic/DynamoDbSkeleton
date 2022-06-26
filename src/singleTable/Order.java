package singleTable;

import annotations.Column;
import annotations.SortKey;

public class Order {

    private String orderNumber;

    @SortKey("SK1")
    private String sortKey;

    @Column("GS1K")
    private String orderNumberIndexSortKey;
}
