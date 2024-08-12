package mampang.validation.annotation.JsAuthorization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * CUSTOM AUTHORIZATION, UNTUK SEKARANG DI SET BERBEDA BEDA PER PROJECT
 * 
 * Usage: Cukup tambahkan @JsAuthorization di Controller yang mau dikasih
 * penjagaan
 * 
 * @author John Sung
 * @see www.github.com/johnsungjs/projectmampang
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsAuthorization {

}
