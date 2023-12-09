package com.github.henrymoran2.workingcalendar.controllers;

import com.github.henrymoran2.workingcalendar.dto.WorkingCalendarResponceDTO;
import com.github.henrymoran2.workingcalendar.entity.WorkingCalendarEntity;
import com.github.henrymoran2.workingcalendar.repository.WorkingCalendarRepository;
import com.github.henrymoran2.workingcalendar.service.WorkingCalendarService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WorkingCalendarServiceTest {

    @InjectMocks
    private WorkingCalendarService workingCalendarService;

    @Mock
    private WorkingCalendarRepository workingCalendarRepository;

    @Test
    public void getNonWorkingCalendar_whenSearchNonWorkingDaysBetweenPeriod_thenReturnNonWorkingDays() {

        // given
        LocalDate startDate = LocalDate.of(2023,11, 1);
        LocalDate endDate = LocalDate.of(2023,11, 7);

        List<WorkingCalendarEntity> nonWorkingDays = Arrays.asList(
                new WorkingCalendarEntity(1L, LocalDate.of(2023,11, 4),true),
                new WorkingCalendarEntity(2L, LocalDate.of(2023,11, 5),true)
        );

        when(workingCalendarRepository.findByCalendarDateBetweenAndIsHoliday(startDate, endDate, true))
                .thenReturn(nonWorkingDays);

        // when
        List<WorkingCalendarEntity> actual = workingCalendarService.getNonWorkingCalendar(startDate, endDate);

        // then
        assertThat(actual).isEqualTo(nonWorkingDays);
    }


}
