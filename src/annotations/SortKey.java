package annotations;

import java.lang.annotation.*;

@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target({  ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface SortKey {

    String value() default "";
}
