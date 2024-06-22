package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		/* O método createEntityManagerFactory instância um objeto do tipo EntityManagerFactory */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		/* O método createEntityManager instância um objeto do tipo EntityManager */
		EntityManager em = emf.createEntityManager();
		
		/* recuperando um objeto do tipo pessoa do banco de dados pelo id(essa é uma entidade monitorada) */
		Pessoa p = em.find(Pessoa.class, 2);
		
		/* Uma entidade monitorada é uma entidade que ou acabou de ser
		 * inserida no banco de dados ou ela foi selecionada */
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		emf.close();
		em.close();
		
		/*
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "Carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquin Torres", "Joaquin@gmail.com");
		Pessoa p3 = new Pessoa(null, "Anna Maria", "Anna@gmail.com");
		*/
		
		/*
		 * Quando o JPA faz alguma operação que não é uma simples leitura do 
		 * banco de dados ele precisa de uma transação.
		 * */
		//em.getTransaction().begin();
		/* O método persist pega num objeto e persiste no banco de dados */
		/*
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		*/
		
	}

}
