package view;

import javax.swing.JOptionPane;

import br.edu.fateczl.ingridcosme.listaencadeadaduplaint.ListaEncadeadaDupla;
import controller.OpController;

public class Principal {

	public static void main(String[] args) {
		OpController opCont = new OpController();
		ListaEncadeadaDupla l1 = new ListaEncadeadaDupla();
		ListaEncadeadaDupla l2 = new ListaEncadeadaDupla();
		ListaEncadeadaDupla aux = new ListaEncadeadaDupla();
		
		int opc = 0;
		while(opc != 9) {
			String opcao = JOptionPane.showInputDialog(null, menu());
			opc = Integer.parseInt(opcao);
			switch(opc) {
			
			case 0:
				int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Lista 1\nDigite um número"));
				opCont.insere(numero, l1);
				break;
			
			case 1:
				numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Lista 2\nDigite um número"));
				opCont.insere(numero, l2);
				break;
			
			case 2:
				try {
					aux = opCont.concatena(l1, l2);
					System.out.println("Nova lista: "+aux.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 3:
				try {
					aux = opCont.intercala(l1, l2);
					System.out.println("Nova lista: "+aux.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 4:
				int lista = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual lista deseja dividir?"
						+ "\nDigite 1 ou 2"));
				numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de "
						+ "sublistas desejadas"));
				try {
					if(lista == 1) {
						ListaEncadeadaDupla[] vetor = opCont.divide(l1, numero);
						for(ListaEncadeadaDupla i: vetor) {
							System.out.println("Sublista: "+i.toString());
						}
					} else {
						ListaEncadeadaDupla[] vetor = opCont.divide(l2, numero);
						for(ListaEncadeadaDupla i: vetor) {
							System.out.println("Sublista: "+i.toString());
						}
					}					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 9:
				break;
			
			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção válida", "ERRO", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		
	}
	
	private static String menu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Digite uma opção:\n");
		buffer.append("0 - Inserir um número à lista no. 1\n");
		buffer.append("1 - Inserir um número à lista no. 2\n");
		buffer.append("2 - Concatenar as duas listas\n");
		buffer.append("3 - Intercalar as duas listas\n");
		buffer.append("4 - Dividir uma lista (criar sublistas)\n");
		buffer.append("9 - Encerra a aplicação\n");

		return buffer.toString();
	}

}
