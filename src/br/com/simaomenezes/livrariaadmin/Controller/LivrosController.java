package br.com.simaomenezes.livrariaadmin.Controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.simaomenezes.livrariaadmin.Interface.Estante;
import br.com.simaomenezes.livrariaadmin.Interface.MinhaEstante;
import br.com.simaomenezes.livrariaadmin.model.Livro;


/*
   Para que o VRaptor passe a gerenciar essa classe como um controlador, precisamos anotá-la com @Resource. 
   Isso signifia que essa classe controla um dos recursos da aplica ção, no caso os livros. 
   Chamamos de recursos os dados que a aplica ção produz e/ou gerencia e, 
   ao colocarmos o @Resouce em uma classe dizemos ao VRaptor que essa classe será o ponto de acesso via Web de 
   algum dos recursos do sistema.
   
 */

@Resource
public class LivrosController {
	
	public final Estante estante;
	public final Result result;
	public final Validator validator;
	
	public LivrosController(Estante estante, Result result, Validator validator) {
		this.result = result;
		this.estante = estante;
		this.validator = validator;
	}
	
	
	public void formulario(){}
	
	// retorna o livro para ser editado
	public void editar(String isbn, Result result){
		
		Livro livroBuscado = this.estante.buscaLivroIsbn(isbn);
		
		if (livroBuscado == null){
			result.notFound();
		} else {
			result.include(livroBuscado);
			
			result.of(this).formulario();
			
		}
	}
	
	
	public void  lista(){
		this.result.include("Promoção", this.estante.promocaoDia());
		
		List<Livro> livros = this.estante.todosOsLivros();
		this.result.include("Livros", livros);
		
	}
	
	/*
	 * Essa classe Result é o componente do VRaptor responsável pela personaliza-
	   ção do resultado fial da execu ção do método do controller. Além de receber no
	   método, podemos recebê-lo no construtor da classe, principalmente se formos usar
	   o Result na maioria dos métodos:
	 */
	public void salva(Livro livro, Result result){
		// utlizado agora para valida
		validator.validate(livro);
		validator.onErrorRedirectTo(this).formulario();

		// utilizado antes para valida
//		if (livro.getTitulo() == null){
//			validator.add(new ValidationMessage("titulo é obrigatorio", "titulo"));
//		}
//		
//		if (livro.getIsbn() == null){
//			validator.add(new ValidationMessage("Isbn obrigatorio", "Isbn"));
//		}
		
		this.estante.guarda(livro);
		
		result.include("mensagem", "Livro salvo com sucesso");
		result.redirectTo(this).lista();
	}
	
	
//	public void comprar(Livro livro){
//		// todo o processo de comprar o livro
//		result.redirectTo(HomeController.class).paginaInicial();
//	}
	
	public void naoEncontrado(){}

}
