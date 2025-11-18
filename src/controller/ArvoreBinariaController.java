package controller;

import java.io.File;

import model.estrutura.arvore.ArvoreBinaria;
import model.estrutura.lista.ListaEncadeadaSimples;

public class ArvoreBinariaController {
	
	String dir = "C:\\Users\\Default"; // Se colocar um diretório com muitos sub diretórios, o programa demora uma eternidade para ler

	public ArvoreBinariaController() {
		super();
	}
	
	public ArvoreBinaria readDir(String path) throws Exception {
		File raiz = new File(path);
		if (!raiz.exists() || !raiz.isDirectory()) {
			throw new Exception("Diretório inválido: " + path);
		}
		
		ArvoreBinaria arvore = new ArvoreBinaria();
		arvore.add(raiz.getAbsolutePath());
		carregarFilhos(arvore, raiz);
		
		return arvore;
	}
	
	private void carregarFilhos(ArvoreBinaria arvore, File dir) throws Exception {
		File[] lista = dir.listFiles();
		if (lista == null)
			return;
		for (File f : lista) {
			String parent = dir.getAbsolutePath();
			String child = f.getAbsolutePath();
			
			arvore.addFilho(parent, child);
			
			if (f.isDirectory()) {
				carregarFilhos(arvore, f);
			}
		}
	}
	
	public String teste() throws Exception {
		
		ArvoreBinaria arvore = readDir(dir);
		
		return arvore.preOrdem().toString();
	}
}
