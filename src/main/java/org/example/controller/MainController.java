package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.App;
import org.example.DBConnection.DBConnection;
import org.example.entity.Department;
import org.example.entity.Worker;
import org.example.repository.DepartmentRepository;
import org.example.repository.WorkerRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainController {
    @FXML
    void initialize() {
        try {
            loadDepData();
            setWorkers();
            setTimeSheet();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private TableView<Department> tableDepartments;
    @FXML
    private TableColumn<Department, String> nameOfDep;
    @FXML
    private TableView<Worker> tableWorkers;
    @FXML
    private TableColumn<Worker, Integer> idWorker;
    @FXML
    private TableColumn<Worker, String> workerName;
    @FXML
    private TableColumn<Worker, String> workerLastName;
    @FXML
    private TableColumn<Worker, String> workerPosition;
    @FXML
    private TabPane months;
    @FXML
    private ListView<String> numbersOfDays;
    @FXML
    private ListView<String> valueOfMarks;


    private final DepartmentRepository depR = new DepartmentRepository();
    private Connection connection;

    {
        try {
            connection = new DBConnection().getConnection(App.URL, App.USER, App.PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    загружаем инфо о департаментах из БД и заносим данные в таблицу
    * */
    @FXML
    public void loadDepData() throws SQLException {
        ResultSet resultSet = getResultSet(App.SELECT_DEP);
        while (resultSet.next()) {
            int id = resultSet.getInt("dep_id");
            String name = resultSet.getString("name");
            depR.add(new Department(id, name));
        }
        nameOfDep.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableDepartments.setItems(depR.getDep());
    }

    /*
        отражаем в таблице информацию о работниках по щелчку мыши на название департамента.
        * */
    public void setWorkers() {
        tableDepartments.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            int id = tableDepartments.getSelectionModel().getSelectedItem().getId();
            try {
                loadWorkerData(id);
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.INFORMATION);
                a.setContentText("Выбрать сотрудника");
                a.show();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    /*
    Загружаем информацию из БД о работниках, в соответствии с их департаментом и вносим данные в таблицу
    * */
    @FXML
    public void loadWorkerData(int depId) throws SQLException {
        WorkerRepository workerRep = new WorkerRepository();
        ResultSet resultSet = getResultSet(App.SELECT_WORKERS + depId);
        while (resultSet.next()) {
            int id = resultSet.getInt("work_id");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("last_name");
            String position = resultSet.getString("position");
            int dep = resultSet.getInt("dep_id");
            workerRep.add(new Worker(id, name, lastName, position, dep));
            setWorkerCellValueFactory();
            tableWorkers.setItems(workerRep.getWorkers());
        }
    }

    /*
    устанавливаем столбцы для таблицы сработниками
    * */
    public void setWorkerCellValueFactory() {
        idWorker.setCellValueFactory(new PropertyValueFactory<>("id"));
        workerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        workerLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        workerPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
    }

    /*
    Загружаем дни месяца в список
    * */
    public ObservableList<String> loadDayNumber(int monthNum) {
        ObservableList<String> date = FXCollections.observableArrayList();
        ResultSet resultSet = getResultSet(App.SELECT_DAY + (monthNum + 1));
        try {
            while (resultSet.next()) {
                DateFormat dateFormat = new SimpleDateFormat("dd");
                java.util.Date sqlDate = resultSet.getDate("date");
                String str = dateFormat.format(sqlDate);
                date.add(str);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return date;
    }

    /*
    Загружаем отметки о рабочих днях
    * */

    public ObservableList<String> loadMarks(int workId, int month) {
        ObservableList<String> marks = FXCollections.observableArrayList();
        ResultSet resultSet = getResultSet(App.SELECT_MARKS + workId + " and month(date) = " + (month + 1));
        try {
            while (resultSet.next()) {
                String str = resultSet.getString("marks");
                marks.add(str);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marks;
    }

    /*
   Выводим данные о днях месяца и отметках о днях работы в соответсвии с выбранным работником и выбранным месяцем
   * */

    public void setTimeSheet() {
        int index = 0;
        tableWorkers.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            int workId = tableWorkers.getSelectionModel().getSelectedItem().getId();
            numbersOfDays.setItems(loadDayNumber(index));
            months.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent1 -> {
                int a = months.getSelectionModel().getSelectedIndex();
                valueOfMarks.setItems(loadMarks(workId, a));
            });
        });

    }

    /*
    метод для резалсета
    * */
    public ResultSet getResultSet(String request) {
        ResultSet resultSet = null;
        try {
            resultSet = connection.createStatement().executeQuery(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
