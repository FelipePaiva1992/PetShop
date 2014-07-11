package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import util.WriterData;




@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	    
	int	 iAcao = 0;
	String sAcao = null;
	
		public Servlet() {super();}
	
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			sAcao = request.getParameter("acao");
			Object data = null;
			
			if(sAcao != null)iAcao = Integer.parseInt(sAcao);
			
			switch (iAcao) {				
			
			case Acoes.LOGOUT:
				data = new AcessoUsuario().executeLogout(request, response);
				WriterData.writeJsonObject((JSONObject)data, response);
				break;
				
			case Acoes.LOGAR:
				data = new AcessoUsuario().execute(request, response);
				WriterData.writeJsonObject((JSONObject)data, response);
				break;
			}
			
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		}
	
}
