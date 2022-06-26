package annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({  ElementType.METHOD})
public @interface UpdateQuery {

    String conditionExpression() default "";
    ExpressionAttributeName[] expressionAttributeNames() default {};
    ExpressionAttributeValues[] expressionAttributeValues() default {};
    String updateExpression() default "";
    String keyName();
}
