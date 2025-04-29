package com.kavindu.validation;

import org.springframework.stereotype.Component;

@Component
public class Validations {

    public boolean isValidEmail(String email) {
        if(email.isBlank()) {
            return false;
        }else return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public boolean isValidName(String name) {
        if(name.isBlank()) {
            return false;
        }else if(!name.matches("^(?! )[A-Za-z\\s]{1,100}(?<! )$")){
            return false;
        }else {
            return true;
        }
    }
}
