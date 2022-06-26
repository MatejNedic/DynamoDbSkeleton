package annotations;

public @interface PartiQLQuery {

    String statement() default "";
    String nextToken() default "";
    boolean consistentRead() default false;
}
