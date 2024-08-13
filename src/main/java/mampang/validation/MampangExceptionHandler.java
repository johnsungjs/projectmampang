package mampang.validation;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

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
    public ResponseEntity<MampangApiResponse> handleBadRequest(HttpMessageNotReadableException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, "95", "HttpMessageNotReadableException: " + e.getMessage()));
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<MampangApiResponse> handleSqlException(SQLException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, "96", "SQLException: " + e.getMessage()));
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    public ResponseEntity<MampangApiResponse> handleSqlSyntaxError(SQLSyntaxErrorException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, "97", "SQLSyntaxErrorException: " + e.getMessage()));
    }

    @ExceptionHandler(ConnectTimeoutException.class)
    public ResponseEntity<MampangApiResponse> handleConnectionTimeout(ConnectTimeoutException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, "98",
                        "ConnectTimeoutException: " + e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MampangApiResponse> handleException(Exception e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, "99", "UNHANDLED EXCEPTION" + e.getMessage()));
    }
}
