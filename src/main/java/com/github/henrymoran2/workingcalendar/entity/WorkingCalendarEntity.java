package com.github.henrymoran2.workingcalendar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity(name = "working_calendar")
@AllArgsConstructor
@NoArgsConstructor
public class WorkingCalendarEntity {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "calendar_date")
    private LocalDate calendarDate;

    @Column(name = "is_holiday")
    private boolean isHoliday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingCalendarEntity that = (WorkingCalendarEntity) o;
        return id == that.id && isHoliday == that.isHoliday && Objects.equals(calendarDate, that.calendarDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, calendarDate, isHoliday);
    }
}
