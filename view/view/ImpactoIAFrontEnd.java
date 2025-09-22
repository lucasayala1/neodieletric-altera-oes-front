 private HBox criarBotoes() {
        HBox botoes = new HBox(10);
        botoes.setAlignment(Pos.CENTER);
        
        Button calcularBtn = new Button("Calcular Impacto");
        calcularBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        calcularBtn.setOnAction(e -> calcularImpacto());
        
        Button limparBtn = new Button("Limpar");
        limparBtn.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-weight: bold;");
        limparBtn.setOnAction(e -> limparCampos());
        
        botoes.getChildren().addAll(calcularBtn, limparBtn);
        return botoes;
    }
    
    private void calcularImpacto() {
        try {
            String nome = nomeField.getText();
            double energia = Double.parseDouble(energiaField.getText());
            boolean renovavel = renovavelCheckBox.isSelected();
            String aplicacao = aplicacaoField.getText();
            double eficiencia = Double.parseDouble(eficienciaField.getText());
            
           
            ImpactoIA impacto = new ImpactoIA(nome, energia, renovavel, aplicacao);
            impacto.aplicarOtimizacao(eficiencia);
            
      
            controller.setImpacto(impacto);
            
            
            String resultado = controller.gerarRelatorio();
            resultadoArea.setText(resultado);
            
        } catch (NumberFormatException ex) {
            resultadoArea.setText("Erro: Por favor, insira valores numéricos válidos para energia e eficiência.");
        } catch (Exception ex) {
            resultadoArea.setText("Erro: " + ex.getMessage());
        }
    }
    
    private void limparCampos() {
        nomeField.clear();
        energiaField.clear();
        renovavelCheckBox.setSelected(false);
        aplicacaoField.clear();
        eficienciaField.clear();
        resultadoArea.clear();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
