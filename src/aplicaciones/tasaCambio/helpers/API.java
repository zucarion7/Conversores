package aplicaciones.tasaCambio.helpers;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

import global_helpers.control.JOptionPanePersonalizador;

import javax.swing.JOptionPane;

	public class API {
		private String urlString;
		private boolean validacion;
		private JSONObject jsonObject;
		private JOptionPanePersonalizador JOPanePers=new JOptionPanePersonalizador();
		
		public API(String url) {
			this.urlString=url;
		}
		
		public boolean getValidacion() {
			return this.validacion;
		}
		
		public JSONObject getJSONObject() {
			return this.jsonObject;
		}
		
		public void consumoApi() {
			try {
				
				URL url=new URL(this.urlString);
				
				HttpURLConnection conn=(HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				int responseCode=conn.getResponseCode();
				validacion=true;
				if(responseCode!=200) {
					throw new RuntimeException("ocurrio un error "+responseCode);
				}else {
					StringBuilder informationString=new StringBuilder();
					Scanner scan=new Scanner(url.openStream());
					while(scan.hasNext()) {
						informationString.append(scan.nextLine());
					}
					scan.close();
					
					jsonObject=new JSONObject(informationString.toString());
				}
			}
			catch(Exception e) {
				validacion=false;
				JOPanePers.Personalizar();
				JOptionPane.showMessageDialog(null,"Error " + e,"Exception",JOptionPane.ERROR_MESSAGE);
				
			}
		}
		
//		private String api_key;
//		private URL url;
//		
//		public API() {
//			
//		}
//		
//		public URL getURL() {
//			this.api_key="30d08f3111237f47a95e7ab290f2dc0828f3c276";
//			try {
//				this.url=new URL("https://api.getgeoapi.com/v2/currency/list?api_key=" + api_key + "&format=json");
//			}catch(Exception e) {
//				System.out.println("ocurrio un error "+e);
//			}
//			return url;
//		}
//		
//		public void consumoApi2() {
//			
//			try {
//				String api_key="30d08f3111237f47a95e7ab290f2dc0828f3c276";
//				URL url=new URL("https://api.getgeoapi.com/v2/currency/convert?api_key=" + api_key + "&from="+this.getBase()+"&to="+divisa+"&format=xml");
//				
//				HttpURLConnection conn=(HttpURLConnection) url.openConnection();
//				conn.setRequestMethod("GET");
//				conn.connect();
//				int responseCode=conn.getResponseCode();
//				if(responseCode!=200) {
//					throw new RuntimeException("ocurrio un error "+responseCode);
//				}else {
//					StringBuilder informationString=new StringBuilder();
//					Scanner scan=new Scanner(url.openStream());
//					while(scan.hasNext()) {
//						informationString.append(scan.nextLine());
//					}
//					scan.close();
//					System.out.println(informationString);
//				}
//			}
//			catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
}
