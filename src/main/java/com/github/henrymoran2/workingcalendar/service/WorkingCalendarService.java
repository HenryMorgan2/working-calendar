package com.github.henrymoran2.workingcalendar.service;

import com.github.henrymoran2.workingcalendar.entity.WorkingCalendarEntity;
import com.github.henrymoran2.workingcalendar.repository.WorkingCalendarRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Data
public class WorkingCalendarService {

    @Autowired
    private final WorkingCalendarRepository workingCalendarRepository;

    public WorkingCalendarService(WorkingCalendarRepository workingCalendarRepository) {
        this.workingCalendarRepository = workingCalendarRepository;
    }

    public List<WorkingCalendarEntity> getNonWorkingCalendar(Date startDate, Date endDate, boolean isHoliday){

        return workingCalendarRepository.findByCalendarDateBetweenDateAndIsHoliday(startDate, endDate, true);

    }


}
