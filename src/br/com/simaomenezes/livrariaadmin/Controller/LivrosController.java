package br.com.simaomenezes.livrariaadmin.Controller;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.simaomenezes.livrariaadmin.Interface.Estante;
import br.com.simaomenezes.livrariaadmin.Interface.MinhaEstante;
import br.com.simaomenezes.livrariaadmin.model.Livro;

@Resource
public class LivrosController {
	
	public void formulario(){}
	
	
	public List<Livro> lista(){
		
		Estante estante = new MinhaEstante();
		return estante.todosOsLivros();
		
	}
	public void salva(Livro livro){
		Estante estante = new MinhaEstante();
		estante.guarda(livro);
	}

}
