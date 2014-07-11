function loginUsuarios(usuario,senha) {
	
	$.ajax({
		type : "GET",
		url : "Servlet",
		data : {acao : 1000, user: usuario, password: senha},
		dataType : "json",
		success : function(dataResult) {			
			if(dataResult.totalErr == 0){
				location.href=dataResult.redirectTo;
			}else{
				alert(dataResult.message);
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert("Usuario ou Senha Invalidos!");
		},
		beforeSend: function(){			
            $.mobile.showPageLoadingMsg();
		},
		complete: function(){
		    $.mobile.hidePageLoadingMsg();
		}

	});
}

function logoutUsuarios() {	
	$.ajax({
		type : "GET",
		url : "../AMHServlet",
		data : {acao : 1100},
		dataType : "json",
		success : function(dataResult) {
			
			location.href=dataResult.redirectTo;
			
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert(textStatus + "\n" + errorThrown);
		}
	});
}


