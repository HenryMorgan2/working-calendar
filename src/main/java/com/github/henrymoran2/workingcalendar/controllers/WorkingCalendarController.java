package com.github.henrymoran2.workingcalendar.controllers;

import com.github.henrymoran2.workingcalendar.converter.WorkingCalendarConverter;
import com.github.henrymoran2.workingcalendar.dto.WorkingCalendarResponceDTO;
import com.github.henrymoran2.workingcalendar.service.WorkingCalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WorkingCalendarController {

    private final WorkingCalendarConverter workingCalendarConverter;
    private final WorkingCalendarService workingCalendarService;

    @ResponseBody
    @GetMapping("/non-working-days")
    public WorkingCalendarResponceDTO getNonWorkingDays(@RequestParam(value = "start") LocalDate start,
                                                        @RequestParam(value = "end") LocalDate end) {

      return workingCalendarConverter.getNonWorkingCalendar(workingCalendarService.getNonWorkingCalendar(start, end));
    }

}
