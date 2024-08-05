package mampang.validation.component;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import mampang.validation.dto.MampangApiResponse;

@Component
public class JsResponseGenerator {
  public ResponseEntity<MampangApiResponse> success(Object data, String rc, String rd) {

    return ResponseEntity
        .status(HttpStatus.OK)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(new MampangApiResponse(data, rc, rd));
  }

  public ResponseEntity<MampangApiResponse> created(String rc, String rd) {
    return ResponseEntity
        .status(HttpStatus.OK)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(new MampangApiResponse(null, rc, rd));
  }

  public ResponseEntity<MampangApiResponse> internalError(String rc, String rd) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(new MampangApiResponse(null, rc, rd));
  }

  public ResponseEntity<MampangApiResponse> badRequest(String rc, String rd) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
        .body(new MampangApiResponse(null, rc, rd));
  }
}
