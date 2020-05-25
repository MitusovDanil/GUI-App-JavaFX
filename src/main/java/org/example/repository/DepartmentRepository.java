package org.example.repository;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.entity.Department;

public class DepartmentRepository {
    private ObservableList<Department> dep = FXCollections.observableArrayList();


    public void add(Department depart) {
        dep.add(depart);
    }


    public void update(Department depart) {

    }


    public void delete(Department depart) {
        dep.remove(depart);
    }

    public ObservableList<Department> getDep() {
        return dep;
    }
}
