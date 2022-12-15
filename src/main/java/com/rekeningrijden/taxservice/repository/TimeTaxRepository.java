package com.rekeningrijden.taxservice.repository;

import com.rekeningrijden.taxservice.entity.TimeTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;

public interface TimeTaxRepository extends JpaRepository<TimeTax, Long> {
    List<TimeTax> findAllByStartTimeAndEndTimeAndDayOfWeek(LocalTime startTime, LocalTime endTime, int dayOfWeek);
    List<TimeTax> findAllByDayOfWeek(int dayOfWeek);

    @Query("SELECT t FROM TIMETAX t WHERE t.dayOfWeek IN :daysOfWeek order by t.dayOfWeek, t.startTime asc")
    List<TimeTax> findAllByDaysOfWeek(@Param("daysOfWeek") List<Integer> daysOfWeek);
//    TimeTax findByStartTimeBetween();
}
