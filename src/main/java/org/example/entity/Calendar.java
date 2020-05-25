package org.example.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Calendar {
    SimpleIntegerProperty id;
    SimpleIntegerProperty numberOfMonth;
    SimpleStringProperty month;
    SimpleIntegerProperty dayOfMonth;
    SimpleIntegerProperty markId;
    SimpleIntegerProperty workerId;

    public Calendar() {
    }

    public Calendar(SimpleIntegerProperty id, SimpleIntegerProperty numberOfMonth, SimpleStringProperty month, SimpleIntegerProperty dayOfMonth, SimpleIntegerProperty markId, SimpleIntegerProperty workerId) {
        this.id = id;
        this.numberOfMonth = numberOfMonth;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.markId = markId;
        this.workerId = workerId;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public int getNumberOfMonth() {
        return numberOfMonth.get();
    }

    public SimpleIntegerProperty numberOfMonthProperty() {
        return numberOfMonth;
    }

    public String getMonth() {
        return month.get();
    }

    public SimpleStringProperty monthProperty() {
        return month;
    }

    public int getDayOfMonth() {
        return dayOfMonth.get();
    }

    public SimpleIntegerProperty dayOfMonthProperty() {
        return dayOfMonth;
    }

    public int getMarkId() {
        return markId.get();
    }

    public SimpleIntegerProperty markIdProperty() {
        return markId;
    }

    public int getWorkerId() {
        return workerId.get();
    }

    public SimpleIntegerProperty workerIdProperty() {
        return workerId;
    }

}
