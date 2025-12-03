module com.example.appcad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.mariadb.jdbc;
    opens com.example.appcad to javafx.fxml;
    exports com.example.appcad;
}