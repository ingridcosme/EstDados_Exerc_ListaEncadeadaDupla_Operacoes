/* 
 * Considere listas implementadas por encadeamento duplo, ent�o pede-se para implementar fun��es que:
 * a. Concatenar/intercalar duas listas;
 * b. Dividir uma lista em v�rias;
 */

package controller;

import br.edu.fateczl.ingridcosme.listaencadeadaduplaint.ListaEncadeadaDupla;

public class OpController {

	public OpController() {
		super();
	}
	
	public void insere(int numero, ListaEncadeadaDupla l) {
		l.insertAtBack(numero);
	}
	
	public ListaEncadeadaDupla concatena(
			ListaEncadeadaDupla l1, ListaEncadeadaDupla l2) throws Exception {
		int tamanhoL2 = l2.size();
		int posicao = 0;
		while(posicao < tamanhoL2) {
			l1.insertAtBack(l2.getValue(posicao));
			posicao++;
		}
		return l1;
	}
	
	public ListaEncadeadaDupla intercala(
			ListaEncadeadaDupla l1, ListaEncadeadaDupla l2) throws Exception {
		ListaEncadeadaDupla listaRes = new ListaEncadeadaDupla();
		
		int posicao = 0;
		int tamanho = 0;
		
		//Uso como refer�ncia o tamanho da maior lista
		if(l1.size() >= l2.size()) {
			tamanho = l1.size();
		} else {
			tamanho = l2.size();
		}
		
		while(posicao < tamanho) {
			if(!l1.isEmpty()) {
				listaRes.insertAtBack(l1.getValue(posicao));
			}
			if(!l2.isEmpty()) {
				listaRes.insertAtBack(l2.getValue(posicao));
			}
			posicao++;
		}
		return listaRes;
	}
	
	public ListaEncadeadaDupla[] divide(ListaEncadeadaDupla l, int qtdListas) throws Exception {
		//Vetor de sublistas encadeadas
		ListaEncadeadaDupla listaRes[] = new ListaEncadeadaDupla[qtdListas];
		//�ltima posi��o
		int posicao = l.size() - 1;
		//Quantidade m�nima de elementos nas sublistas
		int qtdNumeros = (posicao + 1) / qtdListas;
		//Quantidade de elementos restantes a serem distribu�dos nas sublistas
		int resto = (posicao + 1) % qtdListas;
		
		//Percorrendo o vetor e criando as sublistas
		for(int k = 0; k < qtdListas; k++) {
			listaRes[k] = new ListaEncadeadaDupla();
			//Inserindo a quantidade m�nima de elementos na sublista
			for(int j = 1; j <= qtdNumeros; j++) {
				if(posicao >= 0) {
					listaRes[k].insertAtFront(l.getValue(posicao));
					//Inserindo os elementos restantes
					if(resto > 0) {
						posicao--;
						listaRes[k].insertAtFront(l.getValue(posicao));
						resto--;
					}
					posicao--;
				}
			}
		}	
		return listaRes;
	}

}
