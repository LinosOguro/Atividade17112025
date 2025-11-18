package model.estrutura.arvore;

import model.estrutura.arvore.No;
import model.estrutura.lista.ListaEncadeadaSimples;

public class ArvoreBinaria<T extends Comparable<T>> {

	private No<T> raiz;
		
	public ArvoreBinaria() {
		this.raiz = null;
	}
	
	public No<T> getRaiz() {
		return raiz;
	}
	
	public void add(T valor) {
		if (raiz == null) {
			raiz = new No<>(valor);
		} else {
			No<T> novo = new No<>(valor);
			raiz.adicionarFilho(novo);
		}		
	}
	
	public boolean addFilho(T paiValor, T novoValor) {
		No<T> pai = buscar(raiz, paiValor);
		if (pai == null)
			return false;
		No<T> novoNo = new No<>(novoValor);
		pai.adicionarFilho(novoNo);
		return true;
	}
	
	private No<T> buscar(No<T> atual, T valor) {
		if (atual == null)
			return null;
		if (atual.getValor().equals(valor))
			return atual;
		
		int total = atual.getFilhos().total();
		for (int i = 0; i < total; i++) {
			No<T> encontrado = buscar(atual.getFilhos().get(i).getValor(), valor);
			if (encontrado != null)
				return encontrado;
		}
		return null;
	}
		
	public ListaEncadeadaSimples<T>preOrdem() {
		ListaEncadeadaSimples<T> lista = new ListaEncadeadaSimples<>();
		preOrdem(raiz, lista);
		return lista;
	}
			
	private void preOrdem(No<T> atual, ListaEncadeadaSimples<T> lista) {
		if (atual != null) {
			lista.append(atual.getValor());
			
			int total = atual.getFilhos().total();
			for (int i = 0; i < total; i++) {
				preOrdem(atual.getFilhos().get(i).getValor(), lista);
			}
		}
	}
}
