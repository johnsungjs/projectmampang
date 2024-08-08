package mampang.validation;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.netty.channel.ConnectTimeoutException;
import mampang.validation.dto.MampangApiResponse;
import mampang.validation.exception.JsException;

//kalau ada yang gacocok sama responsenya bisa diubah disini, tinggal buat dto baru, limitationnya itu di JsException dia baru terima 3 parameter yaitu data, rc, rd
//nanti tinggal override aja tiap methodnya
@ControllerAdvice
public class MampangExceptionHandler {

  @ExceptionHandler(JsException.class)
  public ResponseEntity<MampangApiResponse> handleAuthorizationException(JsException ex) {
    MampangApiResponse response = new MampangApiResponse(null, ex.getRc(), ex.getRd());
    return ResponseEntity
        .status(ex.getHttpStatus())
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(response);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<MampangApiResponse> handleBadRequest() {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(new MampangApiResponse(null, "98", "BAD REQUEST, POSSIBILITY NULL REQUEST BODY OR NULL REQUEST PARAM"));
  }

  @ExceptionHandler(ConnectTimeoutException.class)
  public ResponseEntity<MampangApiResponse> handleConnectionTimeout() {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(new MampangApiResponse(null, "97",
            "CONNECTION TIMEOUT, PLEASE CHECK YOUR CONNECTION SETTINGS"));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<MampangApiResponse> handleException() {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(new MampangApiResponse(null, "98", "NO PATH FOUND, PLEASE CHECK YOUR API URL"));
  }
}
