package br.com.simaomenezes.livrariaadmin.factory;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;


@Component // indica que a classe é gerenciada pelo vraptor
public class FabricaDeEntityManager implements ComponentFactory<EntityManager>{

	private EntityManager manager;
	
	public FabricaDeEntityManager(EntityManagerFactory factory) {
		this.manager = factory.createEntityManager();
	}
	
	@Override
	public EntityManager getInstance() {
		return this.manager;
	}
	
	
	
	/*
		O método está criado, mas quando ele deve ser chamado? Ele deve ser chamado 
		quando acabarmos de usar o manager, ou seja, ao fial do escopo da fábrica.
		Conseguimos fazer isso com o callback @PreDestroy. Um método de qualquer
		componente que estiver anotado com @PreDestroy será chamado logo antes do
		objeto ser destruído, muito útil para liberar os recursos abertos. Esse método 
		precisa retornar void e não ter argumentos. No nosso caso queremos chamar o método
		fechaManager ao fial do escopo da fábrica, então vamos anotá-lo:
	*/
	@PreDestroy
	public void fecharManaher(){
		this.manager.close();
	}
	
	

}
