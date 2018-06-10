package br.mp.mpce.setin.estudospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.mp.mpce.setin.estudospring.domain.Categoria;
import br.mp.mpce.setin.estudospring.domain.Cidade;
import br.mp.mpce.setin.estudospring.domain.Cliente;
import br.mp.mpce.setin.estudospring.domain.Endereco;
import br.mp.mpce.setin.estudospring.domain.Estado;
import br.mp.mpce.setin.estudospring.domain.Produto;
import br.mp.mpce.setin.estudospring.domain.enums.TipoCliente;
import br.mp.mpce.setin.estudospring.repositories.CategoriaRepository;
import br.mp.mpce.setin.estudospring.repositories.CidadeRepository;
import br.mp.mpce.setin.estudospring.repositories.ClienteRepository;
import br.mp.mpce.setin.estudospring.repositories.EnderecoRepository;
import br.mp.mpce.setin.estudospring.repositories.EstadoRepository;
import br.mp.mpce.setin.estudospring.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository catRepo;
	@Autowired
	private ProdutoRepository prodRepo;
	@Autowired
	private CidadeRepository cidRepo;
	@Autowired
	private EstadoRepository estRepo;
	@Autowired
	private ClienteRepository cliRepo;
	@Autowired
	private EnderecoRepository endRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//CATEGORIAS 
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Sex Shop");
		Categoria cat3 = new Categoria(null,"Brinquedos");
		Categoria cat4 = new Categoria(null,"oneandninethynine");
		
		//PRODUTOS
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
		
		
		//ESTADOS E CIDADES
				Estado est1 = new Estado(null, "Ceará");
				Estado est2 = new Estado(null, "Paraiba");
				Estado est3 = new Estado(null, "Piaui");
				Estado est4 = new Estado(null, "Pernambuco");
				Estado est5 = new Estado(null, "Goiás");
				Estado est6 = new Estado(null, "Maranhão");
				Estado est7 = new Estado(null, "Bahia");
				Estado est8 = new Estado(null, "Sergipe");
				Estado est9 = new Estado(null, "Alagoas");
				Estado est10 = new Estado(null, "Rio Grande do Norte");
				Estado est11 = new Estado(null, "Rio de Janeiro");
				Estado est12 = new Estado(null, "São Paulo");
				Estado est13 = new Estado(null, "Paraná");
				Estado est14 = new Estado(null, "Distrito Federal");
				Estado est15 = new Estado(null, "Mato Grosso");
				Estado est16 = new Estado(null, "Santa Catarina");
				Estado est17 = new Estado(null, "Amazonas");
				Estado est18 = new Estado(null, "Amapá");
				
				Cidade cid1 = new Cidade(null, "Fortaleza", est1);
				Cidade cid2 = new Cidade(null, "Caucaia",   est1);
				Cidade cid3 = new Cidade(null, "Maracanaú", est1);
				Cidade cid4 = new Cidade(null, "Juazeiro",  est1);
				Cidade cid5 = new Cidade(null, "Crato",     est1);
				
				estRepo.saveAll(Arrays.asList(est1,est2,est3,est4,est5,est6,est7,est8,est9,est10,est11,est12,est13,est14,est15,est16,est17,est18));
				cidRepo.saveAll(Arrays.asList(cid1,cid2,cid3,cid4,cid5));
				
				//CLIENTES  E  ENDERECOS
				
				Cliente cli1 = new Cliente(null, "Roberval", "rob@gmail.com", "290239203", TipoCliente.PESSOA_FISICA);
				Cliente cli2 = new Cliente(null, "Jaspion", "jaspion@gmail.com", "255239203", TipoCliente.PESSOA_FISICA);
				Cliente cli3 = new Cliente(null, "Pikachu", "pika@gmail.com", "290239288", TipoCliente.PESSOA_FISICA);
				
				/*cli1.getTelefones().addAll(Arrays.asList("545445454","988989899","987866676"));
				
				Endereco end1 = new Endereco(null, "Rua D. Trombosina", "1200", "Prox. La Casa de Papel", "Good Garden", "60600060", cli1, cid1);
				Endereco end2 = new Endereco(null, "Rua dos Mozos", "00", "Prox. ao Cabaré da Leila", "Praia dos Crush", "60600060", cli2, cid2);

				cli1.getEnderecos().addAll(Arrays.asList(end1));*/
				
				cliRepo.saveAll(Arrays.asList(cli1,cli2,cli3));
				//endRepo.saveAll(Arrays.asList(end1,end2));
	}
	
	
}
