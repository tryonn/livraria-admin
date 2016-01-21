package br.com.simaomenezes.livrariaadmin.Interface;

import java.util.List;

import br.com.simaomenezes.livrariaadmin.model.Livro;

public interface Estante {
	
	void guarda(Livro livro);
	List<Livro> todosOsLivros();
}
