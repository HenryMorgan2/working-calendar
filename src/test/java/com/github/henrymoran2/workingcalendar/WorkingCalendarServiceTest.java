package com.github.henrymoran2.workingcalendar;

import com.github.henrymoran2.workingcalendar.dto.WorkingCalendarResponceDTO;
import com.github.henrymoran2.workingcalendar.service.WorkingCalendarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
class WorkingCalendarServiceTest {

//    @InjectMocks
//    private WorkingCalendarService;
//
//    @Mock
//    private WorkingCalendarResponceDTO;
//
//    @Test
//    public void getNonWorkingCalendar(){

//
//        WorkingCalendarService service = new WorkingCalendarService(workingCalendarResponceDTOMock);
//
//        LocalDate startDate = LocalDate.parse("2023-10-13", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        LocalDate endDate = LocalDate.parse("2023-10-17", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//
//        List<LocalDate> left = new ArrayList<>();
//        left.add(LocalDate.parse("2023-10-14", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        left.add(LocalDate.parse("2023-10-15", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//
//        HashMap<String, List<LocalDate>> nonWorkingDays = workingCalendarService.getNonWorkingCalendar(startDate, endDate, true);
//
//        Assertions.assertArrayEquals(left, nonWorkingDays.get("nonWorkingDays"));

//    }


}
