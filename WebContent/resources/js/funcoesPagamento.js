var valor ;
		function parcelaPagamento(){
			var tipoPag = $('#tipoPagamento').val();
			html = "";
			html += "<br/>";
			html += "<select id='xPagamento' onchange='dividirValor()' class='m-wrap'>";
			html += "	<option selected='selected'>Parcelas</option>";
			
			if(tipoPag == "3" || tipoPag=="2"){
				html += "	<option value='1'>1x</option>";
				html += "	<option value='2'>2x</option>";
				html += "	<option value='3'>3x</option>";
				html += "	<option value='4'>4x</option>";
				html += "	<option value='5'>5x</option>";
				html += "	<option value='6'>6x</option>";
			}
			if(tipoPag == "1"){
				html += "	<option value='1'>1x</option>";
			}
			
			html += "</select>";
			
			$('#parcelamento').html(html).trigger("create");
			
		}  

		function dividirValor(){
			
			var vezes = $('#xPagamento').val();
			
			var valorR = valor/vezes;
			$('#valorTotal').html(vezes +'X R$' + valorR).trigger("create");
		}
		
		function preencherValor(){
			var agendamento = $('#agendamentosCliente').val();
			if(agendamento == 1){
				valor = 250;
			}
			if(agendamento == 2){
				valor = 550;
			}		

			$('#valorTotal').html("R$ " +valor);
		}
		
		function pagando(){
			alert("Efetuado Pagamento!");
			window.location.reload();
		}
		