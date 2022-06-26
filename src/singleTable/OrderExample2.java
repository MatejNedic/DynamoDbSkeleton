package singleTable;

import annotations.Column;

public class OrderExample2 {

    private String orderNumber;

    @Column("GS1K")
    private String orderNumberIndexSortKey;
}
