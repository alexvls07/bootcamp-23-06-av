package bootcamp2306_av.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice

public class RestAppExceptionHandler extends ResponseEntityExceptionHandler{
    Logger logger = LoggerFactory.getLogger(RestAppExceptionHandler.class);


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
        logger.error("Error in Rest App", ex);

        RestAppErrorResponse error = new RestAppErrorResponse();
        if (ex instanceof RestAppException) {
            RestAppException restAppException = (RestAppException) ex;
            error.setHttpStatus(restAppException.getHttpStatus().value());
            error.setHttpMessage(restAppException.getHttpStatus().getReasonPhrase());
            error.setErrorMessage(restAppException.getErrorMessage());
            error.setErrorCode(restAppException.getErrorCode());
            error.setTime(restAppException.getTime());
        } else {
            error.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            error.setHttpMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
            error.setErrorMessage(ex.getMessage());
            error.setErrorCode("INTERNAL_SERVER_ERROR");
            error.setTime(Instant.now());
        }

        return ResponseEntity.status(error.getHttpStatus()).body(error);
    }

}
