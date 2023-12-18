module messenger.adilzhan_slyamgazy_220103151_project_3 {
    requires javafx.controls;
    requires javafx.fxml;


    exports pepessenger.code.Server;
    opens pepessenger.code.Server to javafx.fxml;
    exports pepessenger.code.Client;
    opens pepessenger.code.Client to javafx.fxml;
}