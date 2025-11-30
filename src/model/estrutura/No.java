package model.estrutura;

import java.io.File;

public class No {
	
	File Arq;
	No Prox;
	No Pai;
	
	public No(File arq) {
		this.Arq = arq;
	}
	
	public File getArq() {
		return Arq;
	}
	public void setArq(File arq) {
		Arq = arq;
	}
	
	public No getProx() {
		return Prox;
	}
	public void setProx(No prox) {
		Prox = prox;
	}
	
	public No getPai() {
		return Pai;
	}
	public void setPai(No pai) {
		Pai = pai;
	}
	
	public String toString() {
		String nome = this.Arq.getName();
		return nome;
	}
	

}
