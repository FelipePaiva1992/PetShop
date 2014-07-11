/**
 * @author fpaiva
 */


package util;


import java.util.ArrayList;

import org.json.JSONObject;

public class ParseWebService {
	
	
	/**
	 * Recebe o json em string para pegar apenas os valores pertinentes a sua aplicação
	 * @param stringJson com um JSon em formato String
	 * @return JSONObject com os valores adicionados a ele
	 */
	@SuppressWarnings("unused")
	public JSONObject parseJson(String stringJson) {
		
		JSONObject jsonObject = new JSONObject();
		ArrayList<String> arrayList = new ArrayList<String>();
		
//		Localizacao localizacao = null;
//		JSONObject jsonObj = null;
//		try {
//
//			if (stringJson != null) {
//				jsonObj = new JSONObject(stringJson);
//				localizacao = new Localizacao();
//				
//				//dentro de um Json pode existir objetos (que são como caixas que dentro dele existem varios valores) , pode existir Arrays (que são como containers, dentro deles existem varias caixas que dentro existem varios valores) e tambem podem existir apenas valores
//				//sempre se começa com o " jsonObj " e depois você ve se é um array, ou um objeto ou apenas um valor ( quando for array se tem que passar o indice, por exemplo 0, 1 etc)
//				localizacao.setLatitudeOrigem((jsonObj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("start_location").getString("lat")).toString());
//				localizacao.setLongitudeOrigem((jsonObj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("start_location").getString("lng")).toString());
//				
//				localizacao.setLatitudeDestino((jsonObj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("end_location").getString("lat")).toString());
//				localizacao.setLongitudeDestino((jsonObj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONObject("end_location").getString("lng")).toString());
//
//				localizacao.setPolylinha((jsonObj.getJSONArray("routes").getJSONObject(0).getJSONObject("overview_polyline").getString("points")).toString());
//				
//				for(int i =0; i<jsonObj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONArray("steps").length(); i++){
//					
//					byte ptext[] = (jsonObj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONArray("steps").getJSONObject(i).getString("html_instructions")).toString().getBytes();
//					String value = new String(ptext, "UTF-8");
//					arrayList.add(value);
//				
//				}
//				
//				//adiciona em um segundo json os valores obtidos
//				//poderia ser adicionado em um JsonArray tambem se exitirem varios valores do mesmo objeto
//				jsonObject = new JSONObject();			
//				jsonObject.put("polyline", localizacao.getPolylinha());
//				jsonObject.put("latOrigem", localizacao.getLatitudeOrigem());
//				jsonObject.put("lngOrigem", localizacao.getLongitudeOrigem());
//				jsonObject.put("latDestino", localizacao.getLatitudeDestino());
//				jsonObject.put("lngDestino", localizacao.getLongitudeDestino());
//				jsonObject.put("percurso", arrayList);
//				jsonObject.put("tamanhoArray", jsonObj.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(0).getJSONArray("steps").length());
//				
//			}
//		} catch (JSONException e) {
//			System.out.println("Erro de json");
//			
//		}catch (Exception e) {
//			System.out.println("Erro generico");
//		}
		
		return jsonObject;

	}
    
    

}
