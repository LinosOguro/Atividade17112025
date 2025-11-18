package model.estrutura.arvore;

import model.estrutura.lista.ListaEncadeadaSimples;

public class No<T extends Comparable<T>> {
	
	private T valor;
	private ListaEncadeadaSimples<No<T>> filhos;
	private ListaEncadeadaSimples<T> lista;
			
	public No(T valor) {
		super();
		this.valor = valor;
		this.filhos = new ListaEncadeadaSimples<>();
		this.lista = new ListaEncadeadaSimples<>();
		this.lista.append(valor);
	}
	
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	
	public void adicionarFilho(No<T> filho) {
		filhos.append(filho);;
	}
	public ListaEncadeadaSimples<No<T>> getFilhos() {
		return filhos;
	}
	public ListaEncadeadaSimples<T> getLista() {
		return lista;
	}
	
	@Override
	public String toString() {
		return valor.toString();
	}	
}