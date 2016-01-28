package br.com.simaomenezes.livrariaadmin.Interface;

import java.util.List;

import br.com.simaomenezes.livrariaadmin.model.Livro;

public interface LivroDao {
	
	void adiciona(Livro livro);
	
	List<Livro> todos();
	Livro buscaPorIsbn(String isbn);
	

}
