import controller.Controller; 
import view.ImpactoIAView;   
import view.ImpactoIAFrontEnd;
import model.ImpactoIA;      

public class Main {
    public static void main(String[] args) {
        
        
        boolean useGUI = true;
        
        
        if (args.length > 0 && "--console".equals(args[0])) {
            useGUI = false;
        }
        
        if (useGUI) {
            try {
                
                System.out.println("Iniciando interface gráfica...");
                System.out.println("Display: " + System.getenv("DISPLAY"));
                System.out.println("Wayland: " + System.getenv("WAYLAND_DISPLAY"));
                ImpactoIAFrontEnd.main(args);
            } catch (Exception e) {
                System.out.println("Interface gráfica não disponível. Iniciando modo console...");
                System.out.println("Motivo: " + e.getClass().getSimpleName());
                System.out.println("Detalhes: " + e.getMessage());
                e.printStackTrace();
                useGUI = false;
            }
        }
        
        if (!useGUI) {
            
            System.out.println("Iniciando interface de linha de comando...");
            ImpactoIAView view = new ImpactoIAView();
            view.mostrarInicio();  

            Controller controller = new Controller();
            controller.cadastrarImpacto();
            controller.exibirImpacto();
        }
    }
}
