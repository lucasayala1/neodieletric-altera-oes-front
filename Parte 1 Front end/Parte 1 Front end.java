package view;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.ImpactoIA;

public class ImpactoIAFrontEnd extends Application {
    
    private TextField nomeField;
    private TextField energiaField;
    private CheckBox renovavelCheckBox;
    private TextField aplicacaoField;
    private TextField eficienciaField;
    private TextArea resultadoArea;
    private Controller controller;
    
    @Override
    public void start(Stage primaryStage) {
        controller = new Controller();
        
        primaryStage.setTitle("Calculadora de Impacto de IA");
        

        VBox mainLayout = new VBox(15);
        mainLayout.setPadding(new Insets(20));
        mainLayout.setAlignment(Pos.CENTER);
        
        
        Label titulo = new Label("Sistema de Cálculo de Impacto de IA");
        titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        
     
        GridPane formulario = criarFormulario();
        
      
        HBox botoes = criarBotoes();
        
       
        resultadoArea = new TextArea();
        resultadoArea.setEditable(false);
        resultadoArea.setPrefRowCount(10);
        resultadoArea.setStyle("-fx-font-family: monospace;");
        
        
        mainLayout.getChildren().addAll(titulo, formulario, botoes, resultadoArea);
        
        Scene scene = new Scene(mainLayout, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private GridPane criarFormulario() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        
        
        grid.add(new Label("Nome do Modelo:"), 0, 0);
        nomeField = new TextField();
        grid.add(nomeField, 1, 0);
        
        grid.add(new Label("Consumo de Energia (kWh):"), 0, 1);
        energiaField = new TextField();
        grid.add(energiaField, 1, 1);
        
        grid.add(new Label("Usa Energia Renovável:"), 0, 2);
        renovavelCheckBox = new CheckBox();
        grid.add(renovavelCheckBox, 1, 2);
        
        grid.add(new Label("Aplicação:"), 0, 3);
        aplicacaoField = new TextField();
        grid.add(aplicacaoField, 1, 3);
        
        grid.add(new Label("Eficiência (%):"), 0, 4);
        eficienciaField = new TextField();
        grid.add(eficienciaField, 1, 4);
        
        return grid;
    }