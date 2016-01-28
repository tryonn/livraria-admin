package br.com.simaomenezes.livrariaadmin.factory;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;


@Component // indica que a classe � gerenciada pelo vraptor
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
		O m�todo est� criado, mas quando ele deve ser chamado? Ele deve ser chamado 
		quando acabarmos de usar o manager, ou seja, ao fial do escopo da f�brica.
		Conseguimos fazer isso com o callback @PreDestroy. Um m�todo de qualquer
		componente que estiver anotado com @PreDestroy ser� chamado logo antes do
		objeto ser destru�do, muito �til para liberar os recursos abertos. Esse m�todo 
		precisa retornar void e n�o ter argumentos. No nosso caso queremos chamar o m�todo
		fechaManager ao fial do escopo da f�brica, ent�o vamos anot�-lo:
	*/
	@PreDestroy
	public void fecharManaher(){
		this.manager.close();
	}
	
	

}
