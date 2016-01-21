package br.com.simaomenezes.livrariaadmin.Interface;

import java.util.Arrays;
import java.util.List;

import br.com.simaomenezes.livrariaadmin.model.Livro;

public class MinhaEstante implements Estante {

	@Override
	public void guarda(Livro livro) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Livro> todosOsLivros() {
		Livro livro = new Livro();
		livro.setIsbn("1230-ewe");
		livro.setDescricao("Aprenda programar games com Livro de unity 5");
		livro.setTitulo("Livro de unity 5");
		
		Livro livro1 = new Livro();
		livro1.setIsbn("009323-3");
		livro1.setDescricao("IA de games com Unity 5");
		livro1.setTitulo("IA for games");
		
		return Arrays.asList(livro, livro1);
	}

}
