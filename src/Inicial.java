import conversoresApp.ConversoresApp;
import conversoresApp.conversoresVista.ConversoresForm;

public class Inicial {
	public static void main(String[] args) {
		ConversoresForm visual=new ConversoresForm();
		ConversoresApp app=new ConversoresApp(visual);
		app.iniciar();
	}
}
