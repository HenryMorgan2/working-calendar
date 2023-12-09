package com.github.henrymoran2.workingcalendar.converter;

import com.github.henrymoran2.workingcalendar.dto.WorkingCalendarResponceDTO;
import com.github.henrymoran2.workingcalendar.entity.WorkingCalendarEntity;
import com.github.henrymoran2.workingcalendar.service.WorkingCalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WorkingCalendarConverter {

    public WorkingCalendarResponceDTO getNonWorkingCalendar(List<WorkingCalendarEntity> nonWorkingCalendar){

        WorkingCalendarResponceDTO workingCalendarResponceDTO = new WorkingCalendarResponceDTO();

        workingCalendarResponceDTO.setNonWorkingDays(nonWorkingCalendar.stream().map(WorkingCalendarEntity::getCalendarDate).collect(Collectors.toList()));

        return workingCalendarResponceDTO;
    }
}
