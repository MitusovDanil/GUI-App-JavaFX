package org.example.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.entity.Calendar;

public class CalendarRepository {
    private ObservableList<Calendar> calendars = FXCollections.observableArrayList();

    public void add(Calendar cal) {
        calendars.add(cal);
    }

    public void del(Calendar cal) {
        calendars.remove(cal);
    }

    public ObservableList<Calendar> getCalendars() {
        return calendars;
    }
}
