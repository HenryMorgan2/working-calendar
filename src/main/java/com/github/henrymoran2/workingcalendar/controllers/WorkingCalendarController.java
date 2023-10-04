package com.github.henrymoran2.workingcalendar.controllers;

import com.github.henrymoran2.workingcalendar.entity.WorkingCalendarEntity;
import com.github.henrymoran2.workingcalendar.service.WorkingCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api")
public class WorkingCalendarController {


    private WorkingCalendarService workingCalendarService;

    public WorkingCalendarController(WorkingCalendarService workingCalendarService) {
        this.workingCalendarService = workingCalendarService;
    }


    @ResponseBody
    @GetMapping("/non-working-days")
    public String getNonWorkingDays(@RequestParam(value = "start", required = false) String start,
                                    @RequestParam(value = "end", required = false) String end) throws ParseException {

        if (start == null || end == null){
            return "Пустые параметры: start или end";
        }

        SimpleDateFormat formatStartDate = new SimpleDateFormat();
        formatStartDate.applyPattern("yyyy-MM-dd");
        Date startDate = formatStartDate.parse(start);

        SimpleDateFormat formatEndDate = new SimpleDateFormat();
        formatEndDate.applyPattern("yyyy-MM-dd");
        Date endDate = formatEndDate.parse(start);

        List<WorkingCalendarEntity> byStartAdnEnd = WorkingCalendarService.getNonWorkingCalendar(startDate, endDate, true);
        System.out.println("Start= " + start + " End=" + end);
        return "non-working-days"; //Здесь вернуть из базы даты не рабочих дней
    }

}
