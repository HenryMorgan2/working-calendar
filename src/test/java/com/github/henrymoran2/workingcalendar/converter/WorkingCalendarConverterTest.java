package com.github.henrymoran2.workingcalendar.converter;

import com.github.henrymoran2.workingcalendar.dto.WorkingCalendarResponceDTO;
import com.github.henrymoran2.workingcalendar.entity.WorkingCalendarEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class WorkingCalendarConverterTest {

//    @InjectMocks
    private WorkingCalendarConverter workingCalendarConverter = new WorkingCalendarConverter();

     @Test
    public void getNonWorkingCalendar_whenSearchNonWorkingDaysBetweenPeriod_thenReturnNonWorkingDays() {

        // given
        List<WorkingCalendarEntity> nonWorkingDays = Arrays.asList(
                new WorkingCalendarEntity(1L, LocalDate.of(2023,11, 4),true),
                new WorkingCalendarEntity(2L, LocalDate.of(2023,11, 5),true)
        );

        List<LocalDate> nonWorkingDaysLocalDate = Arrays.asList(
                LocalDate.of(2023,11, 4),
                LocalDate.of(2023,11, 5)
        );


        WorkingCalendarResponceDTO workingCalendarResponceDTO = new WorkingCalendarResponceDTO();
        workingCalendarResponceDTO.setNonWorkingDays(nonWorkingDaysLocalDate);

        // when
        WorkingCalendarResponceDTO actual = workingCalendarConverter.getNonWorkingCalendar(nonWorkingDays);

        // then
        assertThat(actual).isEqualTo(workingCalendarResponceDTO);
    }





}