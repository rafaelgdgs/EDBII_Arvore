package br.ufrn.imd.visao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.JFileChooser;

import br.ufrn.imd.modelo.Node;
import br.ufrn.imd.modelo.Tree;

public class ABB {
	
	public static void lerDoArquivo(String arquivo1, String arquivo2) throws FileNotFoundException {
        //File file = new File(arquivo1);
        Scanner scanner1 = new Scanner(new FileReader(arquivo1));

        List<Integer> vet = new ArrayList<Integer>();
        while (scanner1.hasNext()) {
        	vet.add(scanner1.nextInt());
        }
        Tree arvore = new Tree();
        arvore.raiz = new Node(vet.get(0));
        for(int l = 1; l < vet.size(); l++) {
            arvore.inserir(vet.get(l));
        }

        Scanner scanner = new Scanner(new FileReader(arquivo2));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] textoLinha = line.split(" ");

            if(Objects.equals(textoLinha[0], "INSIRA")) {
                int valor = Integer.parseInt(textoLinha[1]);
                if(arvore.inserir(valor))
                    System.out.println(valor + " adicionado");
                else System.out.println(valor + " já está na árvore, não pode ser inserido");
            }
            else if(Objects.equals(textoLinha[0], "BUSCAR")) {
                if(arvore.buscar(Integer.parseInt(textoLinha[1])) != null)
                    System.out.println("Chave encontrada");
                else System.out.println("Chave não encontrada");
            }
            else if(Objects.equals(textoLinha[0], "REMOVA")) {
                if (arvore.remover(Integer.parseInt(textoLinha[1]))) {
                	System.out.println(Integer.parseInt(textoLinha[1]) + " removido");
                }
                else {
                	System.out.println(Integer.parseInt(textoLinha[1]) + " não está na árvore, não pode ser removido");
                }
            }
            else if(Objects.equals(textoLinha[0], "ENESIMO")) {
                System.out.println(arvore.enesimoElemento(Integer.parseInt(textoLinha[1])));
            }
            else if(Objects.equals(textoLinha[0], "POSICAO")) {
                System.out.println(arvore.posicao(Integer.parseInt(textoLinha[1])));
            }
            else if(Objects.equals(textoLinha[0], "MEDIANA")) {
                System.out.println(arvore.mediana());
            }
            else if(Objects.equals(textoLinha[0], "MEDIA")) {
                System.out.println(arvore.media(Integer.parseInt(textoLinha[1])));
            }
            else if(Objects.equals(textoLinha[0], "CHEIA")) {
                if (arvore.ehCheia()) {
                	System.out.println("A arvore é cheia");
                }
                else {
                	System.out.println("A arvore não é cheia");
                }
            }
            else if(Objects.equals(textoLinha[0], "COMPLETA")) {
                if (arvore.ehCompleta()) {
                	System.out.println("A arvore é completa");
                }
                else {
                	System.out.println("A arvore não é completa");
                }
            }
            else if(Objects.equals(textoLinha[0], "PREORDEM")) {
                System.out.println(arvore.pre_ordem());
            }
            else if(Objects.equals(textoLinha[0], "IMPRIMA")) {
                arvore.imprimeArvore(Integer.parseInt(textoLinha[1]));
            }
        }
    }

	public static void main(String[] args) {
		
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Selecione o arquivo 1");
        if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)
            return;

        String arquivo1 = chooser.getSelectedFile().getAbsolutePath();

        chooser.setDialogTitle("Selecione o arquivo 2");
        if (chooser.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)
            return;

        String arquivo2 = chooser.getSelectedFile().getAbsolutePath();

        try {
			ABB.lerDoArquivo(arquivo1, arquivo2);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
//		try {
//			ABB.lerDoArquivo("Endereco_arquivo1.txt", "Endereco_arquivo2.txt");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
	}

}
