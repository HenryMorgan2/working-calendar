package com.github.henrymoran2.workingcalendar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ResponceDTO {

    private String errorMassage;
    private int errorCode;

}
