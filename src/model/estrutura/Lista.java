package model.estrutura;

import java.io.File;

public class Lista {

	No Inicio;
	int Tamanho;
	No Ultimo;

	public Lista() {
		super();
	}

	public void Add(File Arquivo) {
		No novoNo = new No(Arquivo);
		String nomeNovo = Arquivo.getName();

		if (this.Inicio == null) {
			this.Inicio = novoNo;
			this.Ultimo = novoNo;
			Tamanho++;
			return;
		}

		String nomeInicio = this.Inicio.getArq().getName();

		if (nomeNovo.compareTo(nomeInicio) < 0) {
			novoNo.setProx(this.Inicio);
			this.Inicio = novoNo;
			Tamanho++;
			return;
		}

		No atual = this.Inicio;

		while (atual.getProx() != null) {
			String nomeProximo = atual.getProx().getArq().getName();

			if (nomeNovo.compareTo(nomeProximo) < 0) {
				novoNo.setProx(atual.getProx());
				atual.setProx(novoNo);
				Tamanho++;
				return;
			}

			atual = atual.getProx();
		}

		atual.setProx(novoNo);
		this.Ultimo = novoNo;
		Tamanho++;
	}

	public void setPaiLista(No Pai) {
		No buffer = this.Inicio;

		do {
			buffer.setPai(Pai);
			buffer = buffer.getProx();
		} while (buffer != null);

	}

	public No ProcuraNoPeloNome(File Arquivo) {
		String Buscando = Arquivo.getName();
		No buffer = this.Inicio;

		do {
			String Nome = buffer.getArq().getName();
			if (Nome.equals(Buscando)) {
				return buffer;
			} else {
				buffer = buffer.getProx();
			}
		} while (buffer != null);
		File erro = new File("Erro");
		No Erro = new No(erro);

		// System.out.println("Erro, não encontrou.");

		return Erro;
	}

	@Override
	public String toString() {
		StringBuffer StrBuffer = new StringBuffer("[");
		No NoBuffer = this.Inicio;

		if (NoBuffer != null && (NoBuffer.getProx() != null)) {
			do {
				StrBuffer.append(NoBuffer);
				StrBuffer.append(", ");
				NoBuffer = NoBuffer.getProx();

			} while (NoBuffer.getProx() != null);

			StrBuffer.append(NoBuffer);
			StrBuffer.append("]");

		} else if (NoBuffer != null) {
			StrBuffer.append(NoBuffer);
		}
		return StrBuffer.toString();
	}
}