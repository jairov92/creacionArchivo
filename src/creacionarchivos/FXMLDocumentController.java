/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creacionarchivos;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Estudiante;

/**
 *
 * @author jairo.vergara
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField tNombre;
     @FXML
    private TextField tTelefono;
     @FXML
    private TextField tCorreo;
     @FXML
    private TextField tCodigo;
     @FXML
    private TextField tCarrera;
    
    
    
    @FXML
    private Label label;
    LinkedList<Estudiante>listaE;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        String Nombre = tNombre.getText();
        String Telefono = tTelefono.getText();
        String Correo = tCorreo.getText();
        String Codigo = tCodigo.getText();
        String Carrera = tCarrera.getText();
        Estudiante objE=new Estudiante(Codigo, Carrera, Nombre, Telefono, Correo);
        listaE.add(objE);
    }
        @FXML
    private void guardarXML(ActionEvent event) {
       Estudiante objV=new Estudiante();
       boolean guardar = objV.creacionArchivoXML(listaE);
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaE=new LinkedList<>();
    }    
    
}
