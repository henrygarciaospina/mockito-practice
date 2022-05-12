package com.mesaj.pocs.demo.businnesslogic;

import com.mesaj.pocs.demo.model.thirdparty.ThirdPartyUser;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ValidateUser {

    private ThirdPartyUser thirdPartyUser;

    public ValidateUser(ThirdPartyUser thirdPartyUser){
        this.thirdPartyUser = thirdPartyUser;
    }

    public boolean isAndAdult(){
        return ageCalculation(thirdPartyUser.getBirthday()) >= 18;
    }

    public boolean isAlive(){
        return thirdPartyUser.isAlive();
    }

    private Long ageCalculation(LocalDate birthday) {
        return LocalDate.from(birthday).until(LocalDate.now(), ChronoUnit.YEARS);



    }
}
