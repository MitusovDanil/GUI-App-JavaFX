package org.example.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.entity.Mark;

public class MarksRepository {
    private ObservableList<Mark> marks = FXCollections.observableArrayList();

    public void add(Mark mark) {
        marks.add(mark);
    }

    public void del(Mark mark) {
        marks.remove(mark);
    }

    public ObservableList<Mark> getMarks() {
        return marks;
    }

}
