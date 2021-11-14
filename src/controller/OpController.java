/* 
 * Considere listas implementadas por encadeamento duplo, então pede-se para implementar funções que:
 * a. Concatenar/intercalar duas listas;
 * b. Dividir uma lista em várias;
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
		
		//Uso como referência o tamanho da maior lista
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
		//Última posição
		int posicao = l.size() - 1;
		//Quantidade mínima de elementos nas sublistas
		int qtdNumeros = (posicao + 1) / qtdListas;
		//Quantidade de elementos restantes a serem distribuídos nas sublistas
		int resto = (posicao + 1) % qtdListas;
		
		//Percorrendo o vetor e criando as sublistas
		for(int k = 0; k < qtdListas; k++) {
			listaRes[k] = new ListaEncadeadaDupla();
			//Inserindo a quantidade mínima de elementos na sublista
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
