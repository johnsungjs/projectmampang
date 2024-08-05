package mampang.validation.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * EXCEPTION KHUSUS UNTUK RETURN SESUAI FORMAT FORMAT BANK MEGA PAKE RC RD DLL
 * 
 * Usage: Tinggal throw new JsException(rc, rd, httpStatus), 
 * Nanti otomatis tergenerate response
 * 
 * @author John Sung
 * @see www.johnsungjs.vercel.app
 * 
 */
@AllArgsConstructor
@Getter
public class JsException extends RuntimeException {
  private final String rc;
  private final String rd;
  private final HttpStatus httpStatus;
}


