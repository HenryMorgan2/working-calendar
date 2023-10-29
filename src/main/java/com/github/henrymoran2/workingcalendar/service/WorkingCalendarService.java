package com.github.henrymoran2.workingcalendar.service;

import com.github.henrymoran2.workingcalendar.entity.WorkingCalendarEntity;
import com.github.henrymoran2.workingcalendar.repository.WorkingCalendarRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@Data
public class WorkingCalendarService {

    @Autowired
    private final WorkingCalendarRepository workingCalendarRepository;

    public List<WorkingCalendarEntity> getNonWorkingCalendar(LocalDate startDate, LocalDate endDate){

       return  workingCalendarRepository.findByCalendarDateBetweenAndIsHoliday(startDate, endDate, true);
    }

}
