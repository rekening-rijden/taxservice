package com.rekeningrijden.taxservice.repository;

import com.rekeningrijden.taxservice.entity.TimeTax;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;
import java.util.List;

public interface TimeTaxRepository extends JpaRepository<TimeTax, Long> {
    List<TimeTax> findAllByStartTimeAndEndTimeAndDayOfWeek(LocalTime startTime, LocalTime endTime, int dayOfWeek);
    List<TimeTax> findAllByDayOfWeek(int dayOfWeek);
    TimeTax findByStartTimeBetween();
}
