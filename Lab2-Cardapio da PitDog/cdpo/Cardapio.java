import java.util.Scanner;

public class Cardapio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] cardapio = new String[10][3]; 
        boolean[] ativos = new boolean[10]; 
        int produtoCount = 0;

        while (true) {
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Excluir Produto");
            System.out.println("4. Consultar Produto");
            System.out.println("5. Mostrar Cardápio");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1: // Cadastrar Produto
                    if (produtoCount >= 10) {
                        System.out.println("Limite de produtos atingido.");
                        break;
                    }

                    System.out.print("Código (6 caracteres): ");
                    String codigo = scanner.nextLine();
                    if (codigo.length() != 6 || !codigo.matches("[A-Za-z0-9]+")) {
                        System.out.println("Código deve ter 6 caracteres alfanuméricos.");
                        break;
                    }

                    System.out.print("Produto (3 a 60 caracteres): ");
                    String produto = scanner.nextLine();
                    if (produto.length() < 3 || produto.length() > 60) {
                        System.out.println("Produto deve ter entre 3 e 60 caracteres.");
                        break;
                    }

                    System.out.print("Ativo (true/false): ");
                    boolean ativo = scanner.nextBoolean();
                    scanner.nextLine(); // Limpa o buffer

                    System.out.print("Preço: ");
                    String preco = scanner.nextLine();

                    cardapio[produtoCount][0] = codigo;
                    cardapio[produtoCount][1] = produto.toUpperCase();
                    cardapio[produtoCount][2] = preco;
                    ativos[produtoCount] = ativo; // Armazena o status ativo
                    produtoCount++;

                    System.out.println("Produto cadastrado com sucesso!");
                    break;

                case 2: // Alterar Produto
                    System.out.print("Informe o código do produto a ser alterado: ");
                    String codigoAlterar = scanner.nextLine();
                    boolean encontradoAlterar = false;

                    for (int i = 0; i < produtoCount; i++) {
                        if (cardapio[i][0].equals(codigoAlterar)) {
                            encontradoAlterar = true;
                            System.out.print("Novo nome do produto: ");
                            String novoProduto = scanner.nextLine();
                            System.out.print("Novo preço: ");
                            String novoPreco = scanner.nextLine();
                            System.out.print("Ativo (true/false): ");
                            boolean novoAtivo = scanner.nextBoolean();
                            scanner.nextLine(); // Limpa o buffer

                            cardapio[i][1] = novoProduto.toUpperCase();
                            cardapio[i][2] = novoPreco;
                            ativos[i] = novoAtivo;

                            System.out.println("Produto alterado com sucesso!");
                            break;
                        }
                    }
                    if (!encontradoAlterar) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 3: // Excluir Produto
                    System.out.print("Informe o código do produto a ser excluído: ");
                    String codigoExcluir = scanner.nextLine();
                    boolean encontradoExcluir = false;

                    for (int i = 0; i < produtoCount; i++) {
                        if (cardapio[i][0].equals(codigoExcluir)) {
                            encontradoExcluir = true;
                            for (int j = i; j < produtoCount - 1; j++) {
                                cardapio[j] = cardapio[j + 1];
                                ativos[j] = ativos[j + 1];
                            }
                            cardapio[produtoCount - 1] = null;
                            ativos[produtoCount - 1] = false;
                            produtoCount--;
                            System.out.println("Produto excluído com sucesso!");
                            break;
                        }
                    }
                    if (!encontradoExcluir) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4: // Consultar Produto
                    System.out.print("Informe o código do produto a ser consultado: ");
                    String codigoConsultar = scanner.nextLine();
                    boolean encontradoConsultar = false;

                    for (int i = 0; i < produtoCount; i++) {
                        if (cardapio[i][0].equals(codigoConsultar)) {
                            encontradoConsultar = true;
                            System.out.printf("Código: %s, Produto: %s, Preço: R$ %s%n", 
                                              cardapio[i][0], cardapio[i][1], cardapio[i][2]);
                            break;
                        }
                    }
                    if (!encontradoConsultar) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 5: // Mostrar Cardápio
                    System.out.println("-------------------------------------------------------------------------------------------------");
                    System.out.printf("%-10s %-60s %-10s%n", "CÓDIGO", "PRODUTO", "VALOR");
                    System.out.println("-------------------------------------------------------------------------------------------------");

                    for (int i = 0; i < produtoCount; i++) {
                        if (ativos[i]) { // Exibe apenas produtos ativos
                            System.out.printf("%-10s %-60s R$ %.2f%n", cardapio[i][0], cardapio[i][1], Double.parseDouble(cardapio[i][2]));
                        }
                    }

                    System.out.println("-------------------------------------------------------------------------------------------------");
                    break;

                case 0: // Sair
                    System.out.println("Saindo...");
                    scanner.close();
                    return; // Encerra o programa

                default: // Opção inválida
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }
}
