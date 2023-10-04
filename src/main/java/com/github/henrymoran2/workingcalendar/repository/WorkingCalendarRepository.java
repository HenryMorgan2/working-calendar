package com.github.henrymoran2.workingcalendar.repository;

import com.github.henrymoran2.workingcalendar.entity.WorkingCalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface WorkingCalendarRepository extends JpaRepository<WorkingCalendarEntity, Long> {

//    @Query(value = "SELECT id, calendar_date, is_holiday FROM public.working_calendar WHERE calendar_date >= ?1 AND calendar_date <= ?2 AND is_holiday = true;", nativeQuery = true)
//    List<WorkingCalendarEntity>  findByColumnDateBetweenDateAndIsholiday(Date startDate, Date endDate, boolean true);

    List<WorkingCalendarEntity> findByCalendarDateBetweenDateAndIsHoliday(Date startDate, Date endDate, boolean isholiday);

}
