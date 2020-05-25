package org.example.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.entity.Worker;

public class WorkerRepository {
    private ObservableList<Worker> workers = FXCollections.observableArrayList();

    public void add(Worker wor) {
        workers.add(wor);
    }

    public void del(Worker wor) {
        workers.remove(wor);
    }

    public ObservableList<Worker> getWorkers() {
        return workers;
    }

}
