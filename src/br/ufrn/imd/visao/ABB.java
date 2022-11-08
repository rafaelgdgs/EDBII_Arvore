package br.ufrn.imd.visao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

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
                arvore.remover(Integer.parseInt(textoLinha[1]));
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
		
//		System.out.println("pre_ordem: " + t.pre_ordem());
//		System.out.println("simetrica: " + t.simetrica());
//		System.out.println("enesimoElemento: " + t.enesimoElemento(5));
//		System.out.println("posicao: " + t.posicao(8));
//		System.out.println("buscar: " + t.buscar(10).valor);
//		//t.inserir(11);
//		System.out.println("nova simetrica: " + t.simetrica());
//		System.out.println("media: " + t.media(14));
//		System.out.println("mediana: " + t.mediana());
//		System.out.println("ehCheia: " + (t.ehCheia() ? "True" : "False"));
		
//		Tree t = new Tree();
//		t.inserir(6);
//		t.inserir(5);
//		t.inserir(9);
//		t.inserir(2);
//		t.inserir(5);
//		t.inserir(4);
//		t.inserir(7);
//		t.inserir(3);
		
//		t.inserir(5);
//		t.inserir(3);
//		t.inserir(2);
//		t.inserir(4);
//		t.inserir(8);
//		t.inserir(6);
//		t.inserir(9);
//		t.inserir(15);
//		t.inserir(1);
		
		
		//System.out.println("raiz = " + t.raiz.valor);
		//System.out.println("simetrica: " + t.simetrica());
		//System.out.println("enesimoElemento: " + t.enesimoElemento(4));
		//Node c = t.buscar(5);
		//System.out.println("Valor: " + c.valor + " ,  H: " + c.h + " , ih: " + c.ih);
//		t.imprimeArvore(1);
		//t.imprimeArvore(2);
		//System.out.println("ehCheia: " + (t.ehCheia() ? "True" : "False"));
		//System.out.println("ehCompleta: " + (t.ehCompleta() ? "True" : "False"));
//		t.remover(5);
//		t.imprimeArvore(1);
		
		try {
			ABB.lerDoArquivo("\\\\wsl.localhost\\Ubuntu\\home\\jhinlinux\\EDBII\\tests\\arquivo1.txt", "\\\\wsl.localhost\\Ubuntu\\home\\jhinlinux\\EDBII\\tests\\arquivo2.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
