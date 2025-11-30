package view;

import java.io.File;

import model.estrutura.Arvore;

public class Main {

	public static void main(String[] args) {

		String path = "C:\\TEMP";
		File arquivo = new File(path);

		Arvore arvore = new Arvore();
		arvore.AddTree(arquivo);
	}
}
