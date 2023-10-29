package com.github.henrymoran2.workingcalendar.converter;

import com.github.henrymoran2.workingcalendar.dto.WorkingCalendarResponceDTO;
import com.github.henrymoran2.workingcalendar.entity.WorkingCalendarEntity;
import com.github.henrymoran2.workingcalendar.repository.WorkingCalendarRepository;
import com.github.henrymoran2.workingcalendar.service.WorkingCalendarService;
import io.micrometer.observation.Observation;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class WorkingCalendarConverter {

    @Autowired
    private final WorkingCalendarService workingCalendarService;

    public WorkingCalendarResponceDTO getNonWorkingCalendar(List<WorkingCalendarEntity> nonWorkingCalendar){

        WorkingCalendarResponceDTO workingCalendarResponceDTO = new WorkingCalendarResponceDTO();

        workingCalendarResponceDTO.setNonWorkingDays(nonWorkingCalendar.stream().map(WorkingCalendarEntity::getCalendarDate).collect(Collectors.toList()));

        return workingCalendarResponceDTO;
    }
}
