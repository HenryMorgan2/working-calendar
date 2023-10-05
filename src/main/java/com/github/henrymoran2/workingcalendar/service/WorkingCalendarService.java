package com.github.henrymoran2.workingcalendar.service;

import com.github.henrymoran2.workingcalendar.dto.WorkingCalendarResponceDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Component
@Data
public class WorkingCalendarService {

    @Autowired
    private final WorkingCalendarResponceDTO workingCalendarResponceDTO;


    public HashMap<String, List<LocalDate>> getNonWorkingCalendar(LocalDate startDate, LocalDate endDate, boolean isHoliday){
        return  workingCalendarResponceDTO.getNonWorkingCalendar(startDate, endDate, isHoliday);
    }

}
