package com.github.henrymoran2.workingcalendar.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class WorkingCalendarResponceDTO {

    private List<LocalDate> nonWorkingDays;

}
