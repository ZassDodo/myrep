package pt.upacademy.jseproject.textInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import pt.upacademy.jseproject.model.Product;
import pt.upacademy.jseproject.model.Shelf;
import pt.upacademy.jseproject.repositories.ProductRepository;
import pt.upacademy.jseproject.repositories.ShelfRepository;
import pt.upacademy.jseproject.utils.ScannerUtils;


public class TextInterface {

	 static ProductRepository bdProd = ProductRepository.getInstance();

	 static ShelfRepository bdShelf = ShelfRepository.getInstance();
	
	
	private static ScannerUtils sc = new ScannerUtils();

	public static void main(String[] args) {
		showMenuInitial();

	}

	private static void showMenuInitial() {
		
		int[] values = {1, 2, 3};
		while(true) {
			
			System.out.println("Por favor selecione uma das seguintes opções:");
			System.out.println("1) Listar produtos");
			System.out.println("2) Listar prateleiras");
			System.out.println("3) Sair");
			
			int result = sc.getInt("", values);
			System.out.println(result);
			
			switch(result) {
			case 1: showMenuProdutos();
			break;
			case 2: showMenuPrateleiras();
			break;
			case 3: System.exit(0);
			
			}
		}
	}
	
	private static void showMenuProdutos() {
		
		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1) Criar novo produto");
		System.out.println("2) Editar um produto existente");
		System.out.println("3) Consultar o detalhe de um produto");
		System.out.println("4) Remover um produto");
		System.out.println("5) Voltar ao ecrã anterior");
		
		int[] values = {1, 2, 3, 4, 5};

		int result = sc.getInt("", values);
		System.out.println(result);


		switch(result) {
			case 1: criarProdutos();
			break;
			case 2: editProdutos();
			break;
			case 3: detProdutos();
			break;
			case 4: remProdutos();
			break;
			case 5: return;
		}
		
	}
	
	private static void criarProdutos() {
		int iva = sc.getInt("Escreva o IVA do produto:");
		int disc = sc.getInt("Escreva o valor unitário de desconto:");
		int pvp = sc.getInt("Escreva preço de venda ao público:");

		Product prod = new Product(disc, iva ,pvp);
		bdProd.createEntity(prod);
		
	}
	
	private static void editProdutos() {
		
		Collection<Integer> prodIds = bdProd.getAllIds();
		System.out.println("IDs existentes: "+ prodIds);
		if (prodIds.isEmpty()) {
			System.out.println("Nao ha nenh1 produto para ser alterado.");
		} else {
		int id = sc.getInt("Escreva o ID do produto que quer editar:");
		Product productToEdit = bdProd.getEntityByID(id);
		int iva = sc.getInt("Escreva o novo IVA do produto:");
		int disc = sc.getInt("Escreva o novo valor unitário de desconto:");
		int pvp = sc.getInt("Escreva o novo preço de venda ao público:");
		Collection<Integer> shelfIds = bdShelf.getAllIds();
		System.out.println("Ids de prateleiras existentes: "+ shelfIds);
		if (shelfIds.size() == 0) {
			System.out.println("Nao ha prateleiras disponiveis para este produto.");
		} else {
		int shelfId = sc.getInt("Escreva o ID de uma nova prateleira para este produto: ");
		Shelf shelfToEdit = bdShelf.getEntityByID(shelfId);
		bdShelf.editEntity(shelfToEdit);
		}
		productToEdit.setDisc(disc);
		productToEdit.setIva(iva);
		productToEdit.setPvp(pvp);
		
		
		bdProd.editEntity(productToEdit);
		
		}
		
	}

	
	private static void detProdutos() {
		Collection<Integer> allIds = bdProd.getAllIds();
		System.out.println("IDs existentes: "+ allIds);
		if (allIds.isEmpty()) {
			System.out.println("Nao existe nenh1 produto para ser consultado.");
		}
		else {
			int id = sc.getInt("Escreva o ID do produto que quer consultar:");
			System.out.println("Detalhes do produto: " + bdProd.getEntityByID(id));
		}
		
		}

	
	private static void remProdutos() {
		
		Collection<Integer> allIds = bdProd.getAllIds();
		System.out.println("IDs existentes: "+ allIds);
		if (allIds.size() == 0) {
			System.out.println("Nao ha produtos disponveis para remover.");
		} else {
		int id = sc.getInt("Escreva o ID do produto que quer remover:");
		Product removedProd = bdProd.remEntity(id);
		
		ArrayList<Integer> shelfs = removedProd.getShelfs();
		for (int shelfId : shelfs) {
				Shelf shelf = bdShelf.getEntityByID(shelfId);
				shelf.setProductId(0);	
			
		}
		
		

		System.out.println("O produto " + removedProd + " foi removido.");

			}
	
	}
	
	
	private static void showMenuPrateleiras() {
		
		System.out.println("Por favor selecione uma das seguintes opções:");
		System.out.println("1) Criar nova prateleira");
		System.out.println("2) Editar uma prateleira existente");
		System.out.println("3) Consultar o detalhe de uma prateleira");
		System.out.println("4) Remover uma prateleira");
		System.out.println("5) Voltar ao ecrã anterior");
		
		int[] values = {1, 2, 3, 4, 5};

		int result = sc.getInt("", values);
		System.out.println(result);


		switch(result) {
			case 1: criarPrateleiras();
			break;
			case 2: editPrateleiras();
			break;
			case 3: detPrateleiras();
			break;
			case 4: remPrateleiras();
			break;
			case 5: return;
		}
}
	
	private static void criarPrateleiras() {
		
		int cap = sc.getInt("Escreva a capacidade da prateleira:");
		Collection<Integer> allIds = bdProd.getAllIds();
		System.out.println("IDs existentes: "+ allIds);
		if (allIds.isEmpty()) {
			System.out.println("Nao ha produtos disponiveis para esta prateleira.");
			int pal = sc.getInt("Escreva o preço de aluguer de localização (diário):");
			Shelf shelf = new Shelf(cap, 0 ,pal);
			bdShelf.createEntity(shelf);

		} else {
		int productId = sc.getInt("Escreva o produto que alberga:");
		int pal = sc.getInt("Escreva o preço de aluguer de localização (diário):");


		Shelf shelf = new Shelf(cap, productId ,pal);
		int shelfId = bdShelf.createEntity(shelf);
		if(productId != 0) {
			Product prod = bdProd.getEntityByID(productId);
			prod.addShelf(shelfId);
			bdProd.editEntity(prod);
			
		}
		}
	}
	
	private static void editPrateleiras() {
		
		Collection<Integer> shelfIds = bdShelf.getAllIds();
		System.out.println("IDs existentes: "+ shelfIds);
		if (shelfIds.size() == 0) {
			System.out.println("Nao ha nenhuma prateleira para ser alterada.");}
		else {
		
		int id = sc.getInt("Escreva o ID da prateleira que quer editar:");
		Shelf shelfToEdit = bdShelf.getEntityByID(id);
		int cap = sc.getInt("Escreva a nova capacidade da prateleira:");
		int pal = sc.getInt("Escreva o novo preço de aluguer de localização (diário):");
		
		Collection<Integer> prodIds = bdProd.getAllIds();
		System.out.println("Ids de produtos existentes: "+ prodIds);
		if (prodIds.isEmpty()) {
			System.out.println("Nao ha nenhum produto disponivel para esta prateleira");
		} else {
		int productId = sc.getInt("Escreva o novo produto que alberga:");
		Product productToEdit = bdProd.getEntityByID(productId);
		shelfToEdit.setProductId(productId);
		bdProd.editEntity(productToEdit);
		}
		shelfToEdit.setCap(cap);
		shelfToEdit.setPal(pal);


		bdShelf.editEntity(shelfToEdit);
		}

		
	}
	
	private static void detPrateleiras() {
		Collection<Integer> allIds = bdShelf.getAllIds();
		System.out.println("IDs existentes: "+ allIds);
		if (allIds.size() == 0) {
			System.out.println("Nao ha nenhuma prateleira para ser consultada.");

		} else {
		int id = sc.getInt("Escreva o ID da prateleira que quer consultar:");
		System.out.println("Detalhes da prateleira: " + bdShelf.getEntityByID(id));
		}

	}
	
	private static void remPrateleiras() {
		
		Collection<Integer> allIds = bdShelf.getAllIds();
		System.out.println("IDs existentes: "+ allIds);
		if (allIds.isEmpty()) {
			System.out.println("Nao ha prateleiras para serem removidas.");
		} else {
		int id = sc.getInt("Escreva o ID da prateleira que quer remover:");
		Shelf removedShelf = bdShelf.remEntity(id);
		int productId = removedShelf.getProductId();
		if( productId != 0) {
			Product prod = bdProd.getEntityByID(productId);
			prod.removeShelf(id);
			
		}
		System.out.println("A prateleira " + removedShelf + " foi removida.");
		


	}
	}
}
