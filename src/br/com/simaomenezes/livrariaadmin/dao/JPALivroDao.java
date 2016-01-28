package br.com.simaomenezes.livrariaadmin.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import br.com.simaomenezes.livrariaadmin.Interface.LivroDao;
import br.com.simaomenezes.livrariaadmin.model.Livro;

@Component
public class JPALivroDao implements LivroDao{
	
	private final EntityManager manager;
	
	public JPALivroDao(EntityManager _manager) {
		this.manager = _manager;
	}

	@Override
	public void adiciona(Livro livro) {
		this.manager.getTransaction().begin();
		this.manager.persist(livro);
		this.manager.getTransaction().commit();
	}

	@Override
	public List<Livro> todos() {
		return this.manager.createQuery("select * from livro", Livro.class).getResultList();
	}

	@Override
	public Livro buscaPorIsbn(String isbn) {
		return this.manager.find(Livro.class, isbn);
	}

}
