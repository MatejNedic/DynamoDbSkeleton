package singleTable;

import annotations.PartitionKey;
import annotations.SortKey;
import annotations.Table;

/**
 * List<ShopExample2> would be returned for more items and orders searched.
 * For a single Item ShopExample2 object will be returned.
 * I prefer this way of modeling more.
 */
@Table("AMAZON_SHOP")
public class ShopExample2 {

    @PartitionKey("PK1")
    private String shopId;

    @SortKey("SK1")
    private String sortKey;

    /**
     * I don't think there is need for optional since you will search items or orders.
     */
    private ItemExample2 item;

    private OrderExample2 order;
}
