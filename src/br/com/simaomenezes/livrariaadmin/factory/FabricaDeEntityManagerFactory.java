package br.com.simaomenezes.livrariaadmin.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped // @ApplicationScoped: escopo de aplica ��o. Apenas uma inst�ncia do componente ser� criada na aplica ��o. Tamb�m chamado de singleton, em alus�o ao Design Pattern com o mesmo nome.
public class FabricaDeEntityManagerFactory implements ComponentFactory<EntityManagerFactory>{
	
	private EntityManagerFactory factory;
	
	public FabricaDeEntityManagerFactory() {
		factory = Persistence.createEntityManagerFactory("default");
	}

	@Override
	public EntityManagerFactory getInstance() {
		// TODO Auto-generated method stub
		return this.factory;
	}

}
