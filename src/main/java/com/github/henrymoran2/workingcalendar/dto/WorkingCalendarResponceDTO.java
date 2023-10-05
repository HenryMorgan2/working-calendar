package com.github.henrymoran2.workingcalendar.dto;

import com.github.henrymoran2.workingcalendar.entity.WorkingCalendarEntity;
import com.github.henrymoran2.workingcalendar.repository.WorkingCalendarRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
@Data
public class WorkingCalendarResponceDTO {

    private String nonWorkingDays;
    private ArrayList<String> nonWorkingDaysValue;


    @Autowired
    private final WorkingCalendarRepository workingCalendarRepository;

    public WorkingCalendarResponceDTO(WorkingCalendarRepository workingCalendarRepository) {
        this.workingCalendarRepository = workingCalendarRepository;
    }

    public HashMap<String, List<LocalDate>> getNonWorkingCalendar(LocalDate startDate, LocalDate endDate, boolean isHoliday){

        List<WorkingCalendarEntity> nonWorkingDaysList = workingCalendarRepository.findByCalendarDateBetweenAndIsHoliday(startDate, endDate, isHoliday);
        
        HashMap<String, List<LocalDate>> nonWorkingDays = new HashMap<>();
        ArrayList<LocalDate> nonWorkingDaysString = new ArrayList<>();

        for (WorkingCalendarEntity nonWorkingDaysEntity :nonWorkingDaysList) {
            nonWorkingDaysString.add(nonWorkingDaysEntity.getCalendarDate());
        }

        nonWorkingDays.put("nonWorkingDays", nonWorkingDaysString);
        return nonWorkingDays;

    }


}
