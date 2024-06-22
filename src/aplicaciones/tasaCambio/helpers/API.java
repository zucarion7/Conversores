package aplicaciones.tasaCambio.helpers;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

//import global_helpers.control.JOptionPanePersonalizador;

//import javax.swing.JOptionPane;

public class API {
	private String urlString;
	private JSONObject jsonObject;
//	private JOptionPanePersonalizador JOPanePers=new JOptionPanePersonalizador();
		
	public API(String url) {
		this.urlString=url;
	}
		
		
	public JSONObject getJSONObject() {
		return this.jsonObject;
	}
		
	public Boolean consumoApi() {
		try {
			URL url=new URL(this.urlString);
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responseCode=conn.getResponseCode();
			if(responseCode!=200) {
				throw new RuntimeException("ocurrio un error "+responseCode);
			}else {
				StringBuilder informationString=new StringBuilder();
				Scanner scan=new Scanner(url.openStream());
				while(scan.hasNext()) {
					informationString.append(scan.nextLine());
				}
				scan.close();					
				String conversionJSONO=informationString.toString();
					
				jsonObject=new JSONObject(conversionJSONO);
					
				return true;
			}
		}
		catch(Exception e) {
//			JOPanePers.Personalizar();
//			JOptionPane.showMessageDialog(null,"Error "+this.urlString+" "+e,"Excepción",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
