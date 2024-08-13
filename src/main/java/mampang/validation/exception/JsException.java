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
 * @param rc = Your Custom Response Code
 * @param rd = Your Custom Response Description
 * @param httpStatus = HTTP Status
 * 
 * @author John Sung
 * @see www.github.com/johnsungjs/projectmampang
 * 
 */
@AllArgsConstructor
@Getter
public class JsException extends RuntimeException {
  private final String rc;
  private final String rd;
  private final HttpStatus httpStatus;
}


