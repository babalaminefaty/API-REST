package sn.faty.API.REST.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptions  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UtilisateurNotFoundException.class)
    public ResponseEntity<Object>  handleUtilisateurNotFound(){

        Map<String,Object> response = new HashMap<>() ;

        response.put("message:" ,CodeExceptions.NOT_FOUND.getMessage());

        response.put("code:" ,CodeExceptions.NOT_FOUND.getCode());

        response.put("time:" ,CodeExceptions.NOT_FOUND.getLocalDateTime());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND) ;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {

        Map<String ,String> errors=  new HashMap<>()  ;
        List<ObjectError> errorList= ex.getBindingResult().getAllErrors() ;

          errorList.forEach(error ->{
              String message= error.getDefaultMessage() ;

               String field = ((FieldError) error).getField() ;

               errors.put(field, message) ;

          });

        return ResponseEntity.ok().body(errors) ;
    }
}
