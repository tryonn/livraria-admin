package br.com.simaomenezes.livrariaadmin.dao;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.simaomenezes.livrariaadmin.Interface.Estante;
import br.com.simaomenezes.livrariaadmin.Interface.LivroDao;
import br.com.simaomenezes.livrariaadmin.model.Livro;

@Component
public class EstanteNoBancoDeDados implements Estante{
	
	private final LivroDao dao;
	
	public EstanteNoBancoDeDados(LivroDao dao) {
		this.dao = dao;
	}

	@Override
	public void guarda(Livro livro) {
		dao.adiciona(livro);
		
	}

	@Override
	public List<Livro> todosOsLivros() {
		return dao.todos();
	}

	@Override
	public Livro buscaLivroIsbn(String isbn) {
		return dao.buscaPorIsbn(isbn);
	}

	@Override
	public Livro promocaoDia() {
		// TODO Auto-generated method stub
		return null;
	}

}
