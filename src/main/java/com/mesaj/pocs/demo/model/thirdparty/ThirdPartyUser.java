package com.mesaj.pocs.demo.model.thirdparty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ThirdPartyUser {

    private Long id;
    private String firstName;
    private String lastName;
    private String maritalStatus;
    private boolean isAlive;
    private LocalDate birthday;
}
