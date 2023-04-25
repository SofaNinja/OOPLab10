module com.example.ooplab10 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.ooplab10 to javafx.fxml;
    exports com.example.ooplab10;
}