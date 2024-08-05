package mampang.validation.annotation.JsAuthorization;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import mampang.validation.exception.JsException;

/**
 * LOGIC ANNOTATION @JsAuthorization
 * 
 * @author John Sung
 * @see www.johnsungjs.vercel.app
 * 
 */
@Aspect
@Component
public class JsAuthorizationAspect {

  @Autowired
  HttpServletRequest request;

  @Pointcut("@annotation(JsAuthorization) || @within(JsAuthorization)")
  public void handlePointCut() {
    // Pointcut for methods or classes annotated
  }

  @Before("handlePointCut()")
  public void validateRequestHeader() throws Throwable, JsException {

    if (request.getHeader("Authorization") == null) {
      throw new JsException("01", "AUTHORIZATION MUST NOT BE NULL", HttpStatus.BAD_REQUEST);
    }
  }
}
