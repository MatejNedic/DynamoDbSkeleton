package annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({  ElementType.METHOD})
public @interface Query {

    String filterExpression() default "";
    String indexName() default "";
    String conditionExpressionKey() default "";
    ExpressionAttributeName[] expressionAttributeNames() default {};
    ExpressionAttributeValues[] expressionAttributeValues() default {};
    boolean scanIndexForward() default false;
    boolean consistentRead() default false;

    // If we detect -1 we just use default clients Limit and ignore the field.
    long limit() default -1L;
}
