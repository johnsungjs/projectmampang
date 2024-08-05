package mampang.validation.annotation.JsRequestBodyValidation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * CUSTOM AUTHORIZATION, UNTUK CHECK REQUEST BODY TIDAK ADA NULL VALUES
 * 
 * Usage: Cukup tambahkan @JsAuthorization di Controller yang mau dikasih
 * penjagaan
 * 
 * @author John Sung
 * @see www.johnsungjs.vercel.app
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JsRequestBodyValidation {

}

