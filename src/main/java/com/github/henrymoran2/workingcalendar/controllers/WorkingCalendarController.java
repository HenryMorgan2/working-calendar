package com.github.henrymoran2.workingcalendar.controllers;

import com.github.henrymoran2.workingcalendar.service.WorkingCalendarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/api")
public class WorkingCalendarController {

    private final WorkingCalendarService workingCalendarService;

    public WorkingCalendarController(WorkingCalendarService workingCalendarService) {
        this.workingCalendarService = workingCalendarService;
    }

    @ResponseBody
    @GetMapping("/non-working-days")
    public String getNonWorkingDays(@RequestParam(value = "start", required = false) String start,
                                    @RequestParam(value = "end", required = false) String end) {

        if (start == null || end == null){
            return "Пустые параметры: start или end";
        }

        LocalDate startDate = LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = LocalDate.parse(end, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return String.valueOf(workingCalendarService.getNonWorkingCalendar(startDate, endDate, true));
    }

}
