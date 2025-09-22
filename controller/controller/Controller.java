package controller;

import model.ImpactoIA;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private ImpactoIA impactoIA;
    private Scanner scanner; 

    public Controller() {
        scanner = new Scanner(System.in);
    }

    public void cadastrarImpacto() {
        // Entrada do nome do modelo
        String nomeModelo;
        while (true) {
            System.out.print("Digite o nome do modelo: ");
            nomeModelo = scanner.nextLine().trim();
            if (!nomeModelo.isEmpty()) {
                break;
            } else {
                System.out.println("Erro: Nome do modelo não pode estar vazio. Tente novamente.");
            }
        }

        // Entrada do consumo de energia
        double consumoEnergia;
        while (true) {
            try {
                System.out.print("Digite o consumo de energia (kWh): ");
                consumoEnergia = scanner.nextDouble();
                if (consumoEnergia >= 0) {
                    break;
                } else {
                    System.out.println("Erro: O consumo deve ser um valor positivo. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número válido para o consumo. Tente novamente.");
                scanner.nextLine(); // limpa entrada inválida
            }
        }

        // Entrada de energia renovável
        boolean usaEnergiaRenovavel;
        while (true) {
            try {
                System.out.print("Usa energia renovável? (true/false): ");
                usaEnergiaRenovavel = scanner.nextBoolean();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite 'true' ou 'false' para energia renovável. Tente novamente.");
                scanner.nextLine(); // limpa entrada inválida
            }
        }

        scanner.nextLine(); // limpa buffer

        // Entrada da aplicação
        String aplicacao;
        while (true) {
            System.out.print("Digite a aplicação: ");
            aplicacao = scanner.nextLine().trim();
            if (!aplicacao.isEmpty()) {
                break;
            } else {
                System.out.println("Erro: Aplicação não pode estar vazia. Tente novamente.");
            }
        }

        // Entrada da eficiência
        double eficiencia;
        while (true) {
            try {
                System.out.print("Digite a eficiência (%): ");
                eficiencia = scanner.nextDouble();
                if (eficiencia >= 0 && eficiencia <= 100) {
                    break;
                } else {
                    System.out.println("Erro: A eficiência deve estar entre 0 e 100%. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Digite um número válido para a eficiência. Tente novamente.");
                scanner.nextLine(); // limpa entrada inválida
            }
        }

        // Criar objeto com dados validados
        impactoIA = new ImpactoIA(nomeModelo, consumoEnergia, usaEnergiaRenovavel, aplicacao);
        impactoIA.aplicarOtimizacao(eficiencia);

        System.out.println("\nImpacto cadastrado com sucesso!");
    }

    public void exibirImpacto() {
        if (impactoIA != null) {
            System.out.println("=== CÁLCULO DE IMPACTO DE IA ===");
            System.out.println();
            System.out.println("DADOS DO MODELO");
            System.out.println("   Nome: " + impactoIA.getNomeModelo());
            System.out.println("   Aplicação: " + impactoIA.getAplicacao());
            System.out.println("   Consumo de Energia: " + String.format("%.2f", impactoIA.getConsumoEnergia()) + " kWh");
            System.out.println("   Energia Renovável: " + (impactoIA.isUsaEnergiaRenovavel() ? "Sim" : "Não"));
            System.out.println("   Eficiência Aplicada: " + String.format("%.1f", impactoIA.getEficiencia()) + "%");
            System.out.println();
            System.out.println("IMPACTO AMBIENTAL");
            System.out.println("   Emissão Base: " + String.format("%.4f", impactoIA.getEmissaoBase()) + " tCO2");
            System.out.println("   Emissão Otimizada: " + String.format("%.4f", impactoIA.getEmissaoOtimizada()) + " tCO2");
            System.out.println("   Redução de Emissões: " + String.format("%.2f", impactoIA.getEficiencia()) + "%");
            System.out.println();
            System.out.println("ANÁLISE");
            
            // Análise do impacto (exatamente igual ao frontend)
            String analiseImpacto;
            if (impactoIA.getEmissaoOtimizada() < impactoIA.getEmissaoBase() * 0.5) {
                analiseImpacto = "Excelente otimização! Redução significativa de emissões.";
            } else if (impactoIA.getEmissaoOtimizada() < impactoIA.getEmissaoBase() * 0.8) {
                analiseImpacto = "Boa otimização. Há potencial para melhorias.";
            } else {
                analiseImpacto = "Otimização limitada. Considere melhorar a eficiência.";
            }
            System.out.println("   " + analiseImpacto);
            
            String tipoEnergia = impactoIA.isUsaEnergiaRenovavel() ? 
                "Energia limpa - baixo impacto" : "Energia convencional - alto impacto";
            System.out.println("   Tipo de Energia: " + tipoEnergia);
                
            String statusOtimizacao;
            if (impactoIA.getEficiencia() > 80) {
                statusOtimizacao = "Altamente otimizado";
            } else if (impactoIA.getEficiencia() > 50) {
                statusOtimizacao = "Moderadamente otimizado";
            } else {
                statusOtimizacao = "Precisa de mais otimização";
            }
            System.out.println("   Status da Otimização: " + statusOtimizacao);
            
        } else {
            System.out.println("Nenhum impacto cadastrado ainda.");
        }
    }
    
    // Método para obter o impacto (usado pelo frontend)
    public ImpactoIA getImpacto() {
        return this.impactoIA;
    }
    
    // Método para configurar o impacto (usado pelo frontend JavaFX)
    public void setImpacto(ImpactoIA impacto) {
        this.impactoIA = impacto;
    }
    
    // Método para gerar relatório formatado (usado pelo frontend JavaFX)
    public String gerarRelatorio() {
        if (impactoIA == null) {
            return "Nenhum impacto calculado ainda.";
        }
        
        double emissaoBase = impactoIA.getEmissaoBase();
        double emissaoOtimizada = impactoIA.getEmissaoOtimizada(); 
        double reducao = impactoIA.getEficiencia();
        
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("=== CÁLCULO DE IMPACTO DE IA ===\n\n");
        
        relatorio.append("DADOS DO MODELO\n");
        relatorio.append(String.format("   Nome: %s\n", impactoIA.getNomeModelo()));
        relatorio.append(String.format("   Aplicação: %s\n", impactoIA.getAplicacao()));
        relatorio.append(String.format("   Consumo de Energia: %.2f kWh\n", impactoIA.getConsumoEnergia()));
        relatorio.append(String.format("   Energia Renovável: %s\n", impactoIA.isUsaEnergiaRenovavel() ? "Sim" : "Não"));
        relatorio.append(String.format("   Eficiência Aplicada: %.1f%%\n\n", impactoIA.getEficiencia()));
        
        relatorio.append("IMPACTO AMBIENTAL\n");
        relatorio.append(String.format("   Emissão Base: %.4f tCO2\n", emissaoBase));
        relatorio.append(String.format("   Emissão Otimizada: %.4f tCO2\n", emissaoOtimizada));
        relatorio.append(String.format("   Redução de Emissões: %.2f%%\n\n", reducao));
        
        relatorio.append("ANÁLISE\n");
        
        // Análise do impacto
        String analiseImpacto;
        if (emissaoOtimizada < emissaoBase * 0.5) {
            analiseImpacto = "Excelente otimização! Redução significativa de emissões.";
        } else if (emissaoOtimizada < emissaoBase * 0.8) {
            analiseImpacto = "Boa otimização. Há potencial para melhorias.";
        } else {
            analiseImpacto = "Otimização limitada. Considere melhorar a eficiência.";
        }
        relatorio.append(String.format("   %s\n", analiseImpacto));
        
        String tipoEnergia = impactoIA.isUsaEnergiaRenovavel() ? 
            "Energia limpa - baixo impacto" : "Energia convencional - alto impacto";
        relatorio.append(String.format("   Tipo de Energia: %s\n", tipoEnergia));
            
        String statusOtimizacao;
        if (impactoIA.getEficiencia() > 80) {
            statusOtimizacao = "Altamente otimizado";
        } else if (impactoIA.getEficiencia() > 50) {
            statusOtimizacao = "Moderadamente otimizado";
        } else {
            statusOtimizacao = "Precisa de mais otimização";
        }
        relatorio.append(String.format("   Status da Otimização: %s\n", statusOtimizacao));
        
        return relatorio.toString();
    }
}
