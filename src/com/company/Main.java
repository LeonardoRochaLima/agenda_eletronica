package com.company;
import java.io.*;
import java.util.*;


public class Main{
    public static void main(String args[]) throws  IOException {
        contato();
    }

    public static void contato() throws IOException {
        Scanner leitura = new Scanner(System.in);
        int escolha = 9;
        do {
            System.out.println("1 - Cadastrar um novo Contato");
            System.out.println("2 - Excluir um Contato");
            System.out.println("3 - Busque um Contato");
            System.out.println("4 - Listar Todos Contatos");
            System.out.println("0 - Encerrar o Programa");
            escolha = leitura.nextInt();
            switch (escolha) {
                case 1:
                    File arquivo = new File("Agenda.txt");
                    TreeMap<String, String> mapaAgenda = new TreeMap<>();
                    Scanner keyboard = new Scanner(System.in);
                    System.out.printf("Digite o Nome do Novo Contato: ");
                    String nome = keyboard.nextLine();
                    System.out.printf("Digite o Número do Novo Contato: ");
                    String telefone = keyboard.nextLine();
                    mapaAgenda.put(nome, telefone);
                    if (!arquivo.exists()) {
                        arquivo.createNewFile();
                    } else {
                        FileReader leitor = new FileReader(arquivo);
                        BufferedReader leitorLinha = new BufferedReader(leitor);
                        String linha = "";
                        while ((linha = leitorLinha.readLine()) != null) {
                            String[] textoSeparado = linha.split(", ");
                            mapaAgenda.put(textoSeparado[0], textoSeparado[1]);
                        }
                        leitor.close();
                    }
                    FileWriter leitor1 = new FileWriter(arquivo);
                    BufferedWriter escritor = new BufferedWriter(leitor1);
                    Map<String, String> mapaAgendaOrdenado = new TreeMap<String, String>(mapaAgenda);
                    for (Map.Entry<String, String> i : mapaAgendaOrdenado.entrySet()) {
                        escritor.write(i.getKey() + ", " + i.getValue());
                        escritor.newLine();
                    }
                    escritor.close();
                    leitor1.close();
                    break;
                case 2:
                    arquivo = new File("Agenda.txt");
                    TreeMap<String, String> mapaAgenda2 = new TreeMap<>();
                    Scanner keyboard2 = new Scanner(System.in);
                    System.out.printf("Digite o Nome do que deseja Excluir: ");
                    String excluir = keyboard2.nextLine();
                    if (!arquivo.exists()) {
                        arquivo.createNewFile();
                    } else {
                        FileReader leitor = new FileReader(arquivo);
                        BufferedReader leitorLinha = new BufferedReader(leitor);
                        String linha = "";
                        while ((linha = leitorLinha.readLine()) != null) {
                            String[] textoSeparado = linha.split(", ");
                            mapaAgenda2.put(textoSeparado[0], textoSeparado[1]);
                        }
                        if (mapaAgenda2.containsKey(excluir)) {
                            mapaAgenda2.remove(excluir);
                            System.out.println("Contato excluído com sucesso!!");
                        } else {
                            System.out.println("O contato ainda não existe na agenda.");
                        }
                        leitor.close();
                    }
                    FileWriter leitor2 = new FileWriter(arquivo);
                    BufferedWriter escritor2 = new BufferedWriter(leitor2);
                    Map<String, String> mapaAgendaOrdenado2 = new TreeMap<String, String>(mapaAgenda2);
                    for (Map.Entry<String, String> i : mapaAgendaOrdenado2.entrySet()) {
                        escritor2.write(i.getKey() + ", " + i.getValue());
                        escritor2.newLine();
                    }
                    escritor2.close();
                    leitor2.close();
                    break;
                case 3:
                    arquivo = new File("Agenda.txt");
                    TreeMap<String, String> mapaAgenda3 = new TreeMap<>();
                    Scanner keyboard3 = new Scanner(System.in);
                    System.out.printf("Digite o Nome do que deseja Buscar: ");
                    String buscar = keyboard3.nextLine();
                    if (!arquivo.exists()) {
                        arquivo.createNewFile();
                    } else {
                        FileReader leitor = new FileReader(arquivo);
                        BufferedReader leitorLinha = new BufferedReader(leitor);
                        String linha = "";
                        while ((linha = leitorLinha.readLine()) != null) {
                            String[] textoSeparado = linha.split(", ");
                            mapaAgenda3.put(textoSeparado[0], textoSeparado[1]);
                        }
                        leitor.close();
                    }
                    FileWriter leitor3 = new FileWriter(arquivo);
                    BufferedWriter escritor3 = new BufferedWriter(leitor3);
                    Map<String, String> mapaAgendaOrdenado3 = new TreeMap<String, String>(mapaAgenda3);
                    for (Map.Entry<String, String> i : mapaAgendaOrdenado3.entrySet()) {
                        escritor3.write(i.getKey() + ", " + i.getValue());
                        escritor3.newLine();
                    }
                    for (Map.Entry<String, String> j : mapaAgendaOrdenado3.entrySet()) {
                        if (mapaAgenda3.containsKey(buscar)) {
                            System.out.println("Contato encontrado: "+ j.getKey()+", "+ j.getValue());
                            buscar = null;
                            break;
                        } else {
                            System.out.println("O contato ainda não existe na agenda.");
                            break;
                        }

                    }


                    escritor3.close();
                    leitor3.close();
                    break;
                case 4:
                    arquivo = new File("Agenda.txt");
                    if (!arquivo.exists()) {
                        System.out.println("A agenda ainda não existe. Será necessário criá-la e adicionar contatos para listá-los");
                    } else {
                        FileReader leitorArquivo = new FileReader(arquivo);
                        BufferedReader caminhadorArquivo = new BufferedReader(leitorArquivo);
                        while (caminhadorArquivo.ready()) {
                            String linha = caminhadorArquivo.readLine();
                            System.out.println(linha);
                        }
                        leitorArquivo.close();
                    }
                    break;
                case 0:
                    System.out.println("Finalizando Programa");
            }
        } while (escolha != 0);
    }
}
