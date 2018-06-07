package br.mp.mpce.setin.estudospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.mp.mpce.setin.estudospring.domain.Categoria;
import br.mp.mpce.setin.estudospring.domain.Produto;
import br.mp.mpce.setin.estudospring.repositories.CategoriaRepository;
import br.mp.mpce.setin.estudospring.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository catRepo;
	@Autowired
	private ProdutoRepository prodRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Sex Shop");
		Categoria cat3 = new Categoria(null,"Brinquedos");
		Categoria cat4 = new Categoria(null,"oneandninethynine");
		
		Produto p1 = new Produto(null , "Computador" , 2000.00);
		Produto p2 = new Produto(null ,"Máquina de Escrever" , 2000.00);
		Produto p3 = new Produto(null , "Lápis" , 2000.00);
		Produto p4 = new Produto(null , "Apontador" , 2000.00);
		Produto p5 = new Produto(null , "Xícara" , 2000.00);
		Produto p6 = new Produto(null , "Impressora" , 2000.00);
		Produto p7 = new Produto(null , "Mouse" , 2000.00);
		
		p1.getCategorias().addAll(Arrays.asList(cat1,cat2,cat3,cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2,cat3,cat4));
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
		cat2.getProdutos().addAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
		
		catRepo.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
		prodRepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
	}
	
	
}
