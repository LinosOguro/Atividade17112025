package model.estrutura;

import java.io.File;

public class Arvore {
	
	No Raiz;
	
	public void AddTree(File Arquivo) {
		if (Raiz == null) {
			No NovoNo = new No(Arquivo);
			Raiz = NovoNo;
			File[] filhos = Arquivo.listFiles();
			Lista ListaNova = new Lista();
			for (File filho: filhos) {
				ListaNova.Add(filho);
				ListaNova.setPaiLista(NovoNo);
				
				if (filho.isDirectory()) {
					AddTree(filho, ListaNova);
				}

			}
			System.out.println(ListaNova);
		}
	}
	
	public void AddTree(File Arquivo, Lista listaNova) {
		No NovoNo = listaNova.ProcuraNoPeloNome(Arquivo);
		
		if (NovoNo.getArq().getName() == "Erro") {
			System.out.println("Erro fatal, tem algo de errado na hora de enviar o arquivo para criar além da raiz");
			return;
		}

		
		File[] filhos = Arquivo.listFiles();
		Lista ListaNova = new Lista();
		for (File filho: filhos) {
			ListaNova.Add(filho);
			ListaNova.setPaiLista(NovoNo);
			if (filho.isDirectory()) {
				AddTree(filho, ListaNova);
			}

		}
		System.out.println(ListaNova);
	}
	
	
}