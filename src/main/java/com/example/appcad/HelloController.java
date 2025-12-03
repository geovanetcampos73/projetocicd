package com.example.appcad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloController {

    @FXML private Label lbl_texto;

    @FXML private TextField txtlogin;
    @FXML public  PasswordField txtsenha;
    @FXML private TableView<Cidade> tbviewcid;
    @FXML private TableColumn<Cidade,Integer> codigo;
    @FXML private TableColumn<Cidade, String> descricao;
    @FXML private TableColumn<Cidade, Integer> coduf;
    @FXML private TableColumn<Cidade, String> uf;

    @FXML
    protected void btnabrir_click(){
        try{

            if (txtlogin.getText().equals("")){
                Alert mensagem=new Alert(Alert.AlertType.WARNING,"Você deve digitar o login",ButtonType.OK);
                mensagem.show();
                return;
            }
            if (txtsenha.getText().equals("")) {
                Alert mensagem=new Alert(Alert.AlertType.WARNING,"Você deve digitar a senha",ButtonType.OK);
                mensagem.show();
                return;
            }
            else {

                codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
                descricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
                coduf.setCellValueFactory(new PropertyValueFactory<>("coduf"));
                uf.setCellValueFactory(new PropertyValueFactory<>("uf"));

                Connection con = ConexaoBanco.getConnection();
                Statement stm = con.createStatement();
                String strlsql = "Select * from cidade";
                ResultSet rscidades = stm.executeQuery(strlsql);
                ObservableList<Cidade> listacidades = FXCollections.observableArrayList();
                while (rscidades.next()) {
                    listacidades.add(new Cidade(
                            rscidades.getInt("codigo"),
                            rscidades.getString("descricao"),
                            rscidades.getInt("coduf"),
                            rscidades.getString("uf")));
                }
                tbviewcid.setItems(listacidades);
            }
        }
        catch (SQLException e){
            System.out.println("Erro:"+e.getMessage());
        }

    }
}
