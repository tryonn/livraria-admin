package br.com.simaomenezes.livrariaadmin.factory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
@ApplicationScoped // @ApplicationScoped: escopo de aplica ção. Apenas uma instância do componente será criada na aplica ção. Também chamado de singleton, em alusão ao Design Pattern com o mesmo nome.
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
