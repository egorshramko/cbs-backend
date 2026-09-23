package io.github.egorshramko.cbs.util.validator.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Component;

import io.github.egorshramko.cbs.model.Session;
import io.github.egorshramko.cbs.util.validator.Validator;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * SessionDateValidator
 * 
 * Класс проверяющий, что сеанс еще не начался
 */
@Slf4j 
@Component 
public class SessionDateValidator implements Validator<Session> {

    @Override
    public Boolean validate(Session session) {
        
        //Получение даты-времени сеанса
        final LocalDateTime sessionDateTime = session.getSessionDatetime();

        //Получение часового пояса кинотеатра
        final ZoneId cinemaTimezone = session
                .getHall()
                .getCinema()
                .getCity()
                .getTimezoneId();
        
        //Проверка, что текущее время раньше, чем начало сеанса (с учетом часового пояса)
        final ZonedDateTime currentDateTime = ZonedDateTime.now();
        final ZonedDateTime zonedSessionDatetime = sessionDateTime.atZone(cinemaTimezone);

        return currentDateTime.isBefore(zonedSessionDatetime);
    }

}
