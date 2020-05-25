package org.example.entity;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Worker {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty lastName = new SimpleStringProperty();
    private SimpleStringProperty position = new SimpleStringProperty();
    private SimpleIntegerProperty depId = new SimpleIntegerProperty();

    public Worker() {
    }

    public Worker(int id, String name, String lastName, String position, int depId) {
        this.id.set(id);
        this.name.set(name);
        this.lastName.set(lastName);
        this.position.set(position);
        this.depId.set(depId);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public String getPosition() {
        return position.get();
    }

    public SimpleStringProperty positionProperty() {
        return position;
    }

    public int getDepId() {
        return depId.get();
    }

    public SimpleIntegerProperty depIdProperty() {
        return depId;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public void setDepId(int depId) {
        this.depId.set(depId);
    }
}
