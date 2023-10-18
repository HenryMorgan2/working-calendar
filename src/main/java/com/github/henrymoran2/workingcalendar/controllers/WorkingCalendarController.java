package com.github.henrymoran2.workingcalendar.controllers;

import com.github.henrymoran2.workingcalendar.service.WorkingCalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class WorkingCalendarController {

    private final WorkingCalendarService workingCalendarService;

    @ResponseBody
    @GetMapping("/non-working-days")
    public String getNonWorkingDays(@RequestParam(value = "start", required = false) LocalDate start,
                                    @RequestParam(value = "end", required = false) LocalDate end) {

        if (start == null || end == null){
            return "Пустые параметры: start или end";
        }

        return String.valueOf(workingCalendarService.getNonWorkingCalendar(start, end, true));
    }

}
