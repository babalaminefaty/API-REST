package sn.faty.API.REST.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UtilisateurNotFoundException  extends  RuntimeException{

    int code ;
    public UtilisateurNotFoundException() {

    }


}
