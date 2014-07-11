


        	$.abasSimples = function ()
        	{
        	
        		/* Guarda IDs dos elementos */
        	
        		var abas = 'p#abas';
        		var conteudos = 'ul#conteudos';
        		
        		/* Oculta todas as abas */
        		
        		$(conteudos + ' li').hide();
        		
        		/* Exibe a primeira aba */
        		
        		$(conteudos + ' li:first-child').show();
        		
        		/* Quando uma aba for clicada */
        		
        		$(abas + ' a').click(function()
        		{
        		
        			/* Remove todas as classes de todas as abas */
        		
        			$(abas + ' a').removeClass('selected');
        			
        			/* Acrescenta uma classe CSS marcando visualmente a aba como selecionada */
        			
        			$(this).addClass('selected');
        			
        			/* Oculta todas as abas abertas */
        			
        			$(conteudos + ' li').hide();
        			
        			/* Exibe a aba que foi clicada */
        			
        			$(conteudos +  ' ' + $(this).attr('href')).show();
        			
        			/* Fim :D */
        			
        			return false;
        			
        		});


   };

   $.abasSimples2 = function () {

       /* Guarda IDs dos elementos */

       var abas = 'p#aba2';
       var conteudos = 'ul#conteudos';

       /* Oculta todas as abas */

       $(conteudos + ' li').hide();

       /* Exibe a primeira aba */

       $(conteudos + ' li:first-child').show();

       /* Quando uma aba for clicada */

       $(abas + ' a').click(function () {

           /* Remove todas as classes de todas as abas */

           $('p#abas' + ' a').removeClass('selected');

           /* Acrescenta uma classe CSS marcando visualmente a aba como selecionada */

           $('p#abas' + ' a' + ' #aba2 ').addClass('selected');

           /* Oculta todas as abas abertas */

           $(conteudos + ' li').hide();

           /* Exibe a aba que foi clicada */

           $(conteudos + ' ' + $(this).attr('href')).show();

           /* Fim :D */

           return false;

       });
       $.abasSimples();

   };

   $.abasSimples3 = function() {

       /* Guarda IDs dos elementos */

       var abas = 'p#aba5';
       var conteudos = 'ul#conteudos';

       /* Oculta todas as abas */

       $(conteudos + ' li').hide();

       /* Exibe a primeira aba */

       $(conteudos + ' li:first-child').show();

       /* Quando uma aba for clicada */

       $(abas + ' a').click(function() {

           /* Remove todas as classes de todas as abas */

           $('p#abas' + ' a').removeClass('selected');

           /* Acrescenta uma classe CSS marcando visualmente a aba como selecionada */

           $('p#abas' + ' a' + ' #aba5 ').addClass('selected');

           /* Oculta todas as abas abertas */

           $(conteudos + ' li').hide();

           /* Exibe a aba que foi clicada */

           $(conteudos + ' ' + $(this).attr('href')).show();

           /* Fim :D */

           return false;

       });
       $.abasSimples();

   };
        	
        	/* Quando o documento estiver carregado… */

   $(document).ready(function () {

       /* Carrega a função das abas */

       $.abasSimples();
       $.abasSimples2();
       $.abasSimples3();
   });

