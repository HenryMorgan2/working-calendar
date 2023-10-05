package com.github.henrymoran2.workingcalendar.repository;

import com.github.henrymoran2.workingcalendar.entity.WorkingCalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkingCalendarRepository extends JpaRepository<WorkingCalendarEntity, Long> {

    List<WorkingCalendarEntity> findByCalendarDateBetweenAndIsHoliday(LocalDate startDate, LocalDate endDate, boolean isHoliday);

}
