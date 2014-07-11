/**
 * @author FelipePaiva
 */

package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.VwAcessoUsuario;

import org.json.JSONException;
import org.json.JSONObject;

import dao.AcessoUsuarioDao;
import util.GenericController;
import util.Message;

public class AcessoUsuario extends GenericController  {
	
	public static HttpServletRequest req;
	public static HttpServletResponse res;

	@Override
	public Object execute(HttpServletRequest request, HttpServletResponse response) {
		
		req = request;
		res = response;
		
		//this.executeLogout(request, response);
		
		HttpSession httpSession = request.getSession(true);
		JSONObject jsonObject = new JSONObject();
		
		httpSession.setAttribute("request", request);
		httpSession.setAttribute("response", response);
		
		
		String usuario = request.getParameter("user");
		String password = request.getParameter("password");
		
		
		Message message = new Message();
		
		//VERIFICA SE OS CAMPOS USUARIO E SENHA FORAM PREENCHIDOS
		if(usuario.equals(null) || usuario.equals(""))
			message.addErrorMessage("", "Nome de usuário não foi preenchido!");
			
		if(password == null || password == "")
			message.addErrorMessage("", "Senha não foi preenchida!");
		
		//SE TODAS AS MENSAGENS FOREM VALIDAS
		if(message.allValid()){	
			
			AcessoUsuarioDao acessoDao = new AcessoUsuarioDao(request);
			
			String esquema = "petshop_bd";
			VwAcessoUsuario acesso = acessoDao.findByNmUser(usuario);
			httpSession.setAttribute("esquema", esquema);		
			//VERIFICA SE SENHA DO BD É IGUAL AO DIGITADO
			if(password.equals(acesso.getVlSenha())){				
				
					try {
						//ADICIONA REDIRECIONAMENTO A SESSAO
						jsonObject.put("redirectTo", "TelaInicial.xhtml");
						jsonObject.put("nmUsuario", usuario);
						httpSession.setAttribute("isLogged", true);
						
						//ADICIONA INFRMACOES DO USUARIO NA SESSAO
						httpSession.setAttribute("nmGrupo", acesso.getNmGrupo());
						httpSession.setAttribute("nmUsuario", usuario);
						httpSession.setAttribute("esquema", esquema);				
						
					} catch (JSONException e) {
						e.printStackTrace();
					}
	
			}else{
				message.addErrorMessage("", "Usuario ou Senha estão incorretos");
				httpSession.setAttribute("isLogged", false);
			}	
			
		}
		
		try {
			jsonObject.put("message", message.getGenerateMessageString());			
			jsonObject.put("totalErr", message.getTotalErrors());
		} catch (JSONException e) {e.printStackTrace();}
				
		return jsonObject;
	}
	
	/**
	 * METODO EFETUA LOGOUT E INVALIDA A SESSAO
	 * @param request, response
	 * @return PAGINA PARA DEIRECIONAMENTO
	 * @author FelipePaiva
	 */
	public Object executeLogout(HttpServletRequest request, HttpServletResponse response) {
		
		
		
		HttpSession httpSession = request.getSession(true);
		JSONObject jsonObject = new JSONObject();
				
		try {
			httpSession.invalidate();
			jsonObject.put("redirectTo", "../login.html");	
			
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		
		return jsonObject;
	}
	
	public static void httpSessionExpirada(){
		try {
			res.sendRedirect("/login.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
