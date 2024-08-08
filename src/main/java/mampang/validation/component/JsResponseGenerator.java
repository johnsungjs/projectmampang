package mampang.validation.component;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import mampang.validation.dto.MampangApiResponse;

@Component
public class JsResponseGenerator {

    public ResponseEntity<MampangApiResponse> contiueResponse(String rc, String rd) {

        return ResponseEntity
                .status(HttpStatus.CONTINUE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));

    }

    public ResponseEntity<MampangApiResponse> switchingProtocols(String rc, String rd) {

        return ResponseEntity
                .status(HttpStatus.SWITCHING_PROTOCOLS)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> processing(String rc, String rd) {

        return ResponseEntity
                .status(HttpStatus.PROCESSING)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> ok(Object data, String rc, String rd) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(data, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> created(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> accepted(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> nonAuthorizeInformation(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.NON_AUTHORITATIVE_INFORMATION)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> noContent(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> resetContent(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.RESET_CONTENT)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> partialContent(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.PARTIAL_CONTENT)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> multiStatus(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.MULTI_STATUS)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> alreadyReported(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.ALREADY_REPORTED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> imUsed(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.IM_USED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> multipleChoices(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.MULTIPLE_CHOICES)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> movedPermanently(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.MOVED_PERMANENTLY)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> found(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> seeOther(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.SEE_OTHER)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> notModified(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.NOT_MODIFIED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> temporaryRedirect(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.TEMPORARY_REDIRECT)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> permanentRedirect(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.PERMANENT_REDIRECT)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> badRequest(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> unauthorized(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> paymentRequired(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.PAYMENT_REQUIRED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> forbidden(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> notFound(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> methodNotAllowed(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> notAcceptable(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> proxyAuthentificationRequired(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.PROXY_AUTHENTICATION_REQUIRED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> requestTimeout(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.REQUEST_TIMEOUT)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> conflict(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> gone(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.GONE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> lengthRequired(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.LENGTH_REQUIRED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> preconditionFailed(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.PRECONDITION_FAILED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> payloadTooLarge(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.PAYLOAD_TOO_LARGE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> uriTooLong(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.URI_TOO_LONG)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> unsupportedMediaType(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> rangeNotSatisfiable(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> expectationFailed(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> iAmATeapot(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.I_AM_A_TEAPOT)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> unprocessableEntity(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> locked(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.LOCKED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> failedDependency(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.FAILED_DEPENDENCY)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> tooEarly(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.TOO_EARLY)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> upgradeRequired(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.UPGRADE_REQUIRED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> preconditionRequired(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.PRECONDITION_REQUIRED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> tooManyRequests(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.TOO_MANY_REQUESTS)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> requestHeaderFieldTooLarge(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> unavailableForLegalReasons(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> internalServerError(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> notImplemented(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.NOT_IMPLEMENTED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> badGateway(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.BAD_GATEWAY)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> serviceUnavailable(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> gatewayTimeout(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.GATEWAY_TIMEOUT)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> httpVersionNotSupported(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> variantAlsoNegotiates(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.VARIANT_ALSO_NEGOTIATES)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> insufficientStorage(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.INSUFFICIENT_STORAGE)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> loopDetected(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.LOOP_DETECTED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> notExtended(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.NOT_EXTENDED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

    public ResponseEntity<MampangApiResponse> networkAuthenticationRequired(String rc, String rd) {
        return ResponseEntity
                .status(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(new MampangApiResponse(null, rc, rd));
    }

}
