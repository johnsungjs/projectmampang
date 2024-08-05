package mampang.validation.annotation.JsRequestBodyValidation;

import java.lang.reflect.Field;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import mampang.validation.exception.JsException;

/**
 * LOGIC ANNOTATION @JsRequestBodyValidation
 * 
 * @author John Sung
 * @see www.johnsungjs.vercel.app
 * 
 */
@Aspect
@Component
public class JsRequestBodyValidationAspect {

  @Pointcut("@annotation(JsRequestBodyValidation) || @within(JsRequestBodyValidation)")
  public void handlePointCut() {
    // Pointcut for methods or classes annotated
  }

  @Before("handlePointCut()")
  public void validateRequestBody(JoinPoint jp) throws Throwable {
    if (jp.getArgs() == null || jp.getArgs().length < 1) {
      throw new JsException("01", "REQUEST BODY IS NULL", HttpStatus.BAD_REQUEST);
    }

    System.out.println("REQUEST : " + jp.getArgs()[0]);
    Class<?> objClass = jp.getArgs()[0].getClass();
    Field[] fields = objClass.getDeclaredFields();

    for (Field f : fields) {
      f.setAccessible(true);
      Object value = f.get(jp.getArgs()[0]);
      if (value == null) {
        throw new JsException("02", "NULL VALUE IN THIS FOLLOWING FIELD => " + f.getName(), HttpStatus.BAD_REQUEST);
      }
    }
  }

}
