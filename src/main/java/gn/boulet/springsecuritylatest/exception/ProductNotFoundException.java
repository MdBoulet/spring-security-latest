package gn.boulet.springsecuritylatest.exception;

public class ProductNotFoundException extends IllegalStateException{
    public ProductNotFoundException(String s) {
        super(s);
    }
}
