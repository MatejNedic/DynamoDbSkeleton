package repositories;

import annotations.*;
import singleTable.Shop;

import java.math.BigDecimal;
import java.util.Map;

/**
 * You would implement DynamoDbRepository here, like in any Spring Data project.
 */
public interface ShopRepository {

    // Query support

    /**
     * Example that you specify by field.
     */
    @Query(conditionExpressionKey = "for example begins_with(#mySkName, :value)",
            expressionAttributeValues = {
                    @ExpressionAttributeValues(name = "value", value = "${myValueIWantToReference}")
            },
            expressionAttributeNames = {
                    @ExpressionAttributeName(name = "#mySkName", value = "SK1")
            },
            consistentRead = true,
            limit = 10)
    Shop findLatestOrders(String shopId, String myValueIWantToReference);

    /**
     * Example that you specify key in the map.
     */
    @Query(conditionExpressionKey = "for example begins_with(#mySkName, :value)",
            expressionAttributeValues = {
                    @ExpressionAttributeValues(name = "value", value = "${myKeyInMap}")
            },
            expressionAttributeNames = {
                    @ExpressionAttributeName(name = "#mySkName", value = "SK1")
            },
            consistentRead = true,
            limit = 10)
    Shop findLatestOrdersExample2(String shopId, Map<String, Object> expressionAttributeValues);

    // Auto generated behind the scenes
    Shop update(Shop shop);

    // https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/examples-dynamodb-items.html Docs are deprecated.
    @UpdateQuery(
            keyName = "{myKey}",
            updateExpression = "set #amount = :amount for example",
            expressionAttributeValues = {
                    @ExpressionAttributeValues(name = ":amount", value = "${amountToBeChanged}")
            },
            expressionAttributeNames = {
                    @ExpressionAttributeName(name = "#amount", value = "amount")
            }
    )
    Shop updateItemStatus(Key myKey, String shopId, BigDecimal amountToBeChanged);

    // Auto generated behind the scenes
    void save(Shop shop);

    // PartiQL

    /**
     * This can be enhanced with using Pagination from Spring ecosystem, but since it is just an example I kept it simple.
     */
    @PartiQLQuery(statement = "Select * from AMAZON_SHOP where starts_with(${startOfSortKey})... limit ${springSpelMagic}",
            consistentRead = true, nextToken = "{myNextToken}")
    Shop findLatestOrdersExamplePartiQL(String startOfSortKey ,Long springSpelMagic, String myNextToken);


    //Cache examples.

    /**
     * Let's pretend we are using our GlobalSecondaryIndex for simplicity.
     * I want this Search to be Cached while I want some other queries not to be cached.
    */
    @Query()
    @Cache
    Shop findMostBoughtItems();

    /**
     * I don't want this look up to be cached since performance on this search is not required.
     * Also, I would like to spend less money, so it is not a cache hit.
     */
    @Query()
    Shop findLatestBoughtItems();
}
