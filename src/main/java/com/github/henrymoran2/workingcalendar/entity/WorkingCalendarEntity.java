package com.github.henrymoran2.workingcalendar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class WorkingCalendarEntity {

    @Id
    private long id;
    private Date calendar_date;
    private boolean is_holiday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkingCalendarEntity that = (WorkingCalendarEntity) o;
        return id == that.id && is_holiday == that.is_holiday && Objects.equals(calendar_date, that.calendar_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, calendar_date, is_holiday);
    }
}
