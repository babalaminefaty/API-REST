package sn.faty.API.REST.exceptions;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Getter
public enum CodeExceptions {

    NOT_FOUND(1000,"Cet utilisateur nexiste pas",LocalDateTime.now()),

    NOT_CREATED(1001 ,"Utilisateur non cree", LocalDateTime.now()) ;


    int code ;
    String message ;
    LocalDateTime localDateTime ;
    CodeExceptions(int code, String message, LocalDateTime localDateTime) {
        this.code= code ;
         this.message=message ;
          this.localDateTime=localDateTime ;
    }
}
