import java.util.Scanner;

public class Cardapio {
    private static final String[][] cardapio = new String[100][3]; // 100 produtos, 3 campos
    private static final boolean[] ativos = new boolean[100]; // Status ativo
    private static final String[][] clientes = new String[100][12]; // 100 clientes, 12 campo
    private static int produtoCount = 0;
    private static int clienteCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Cadastro de Produto");
            System.out.println("2. Cadastro de Cliente");
            System.out.println("3. Mostrar Cardápio");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    menuCadastroProduto();
                    break;
                case 2:
                    menuCadastroCliente();
                    break;
                case 3:
                    mostrarCardapio();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return; // Encerra o programa
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    // Menu de Cadastro de Produto
    private static void menuCadastroProduto() {
        while (true) {
            System.out.println("1. Incluir Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Excluir Produto");
            System.out.println("4. Consultar Produto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    incluirProduto();
                    break;
                case 2:
                    alterarProduto();
                    break;
                case 3:
                    excluirProduto();
                    break;
                case 4:
                    consultarProduto();
                    break;
                case 0:
                    return; // Volta ao menu principal
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    // Menu de Cadastro de Cliente
    private static void menuCadastroCliente() {
        while (true) {
            System.out.println("1. Incluir Cliente");
            System.out.println("2. Alterar Cliente");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Consultar Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    incluirCliente();
                    break;
                case 2:
                    alterarCliente();
                    break;
                case 3:
                    excluirCliente();
                    break;
                case 4:
                    consultarCliente();
                    break;
                case 0:
                    return; // Volta ao menu principal
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    // Funções de Produto
    private static void incluirProduto() {
        if (produtoCount >= 100) {
            System.out.println("Limite de produtos atingido.");
            return;
        }

        System.out.print("Código (6 caracteres): ");
        String codigo = scanner.nextLine();
        if (codigo.length() != 6 || !codigo.matches("[A-Za-z0-9]+")) {
            System.out.println("Código deve ter 6 caracteres alfanuméricos.");
            return;
        }

        System.out.print("Produto (3 a 60 caracteres): ");
        String produto = scanner.nextLine();
        if (produto.length() < 3 || produto.length() > 60) {
            System.out.println("Produto deve ter entre 3 e 60 caracteres.");
            return;
        }

        System.out.print("Ativo (true/false): ");
        boolean ativo = scanner.nextBoolean();
        scanner.nextLine(); // Limpa o buffer

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Limpa o buffer

        // Inicializa o elemento do array antes de atribuir os valores
        cardapio[produtoCount] = new String[3]; // Inicializa a linha do array

        cardapio[produtoCount][0] = codigo;
        cardapio[produtoCount][1] = produto.toUpperCase();
        cardapio[produtoCount][2] = String.valueOf(preco);
        ativos[produtoCount] = ativo; // Armazena o status ativo
        produtoCount++;

        System.out.println("Produto cadastrado com sucesso.");
    }

    private static void alterarProduto() {
        System.out.print("Informe o código do produto a ser alterado: ");
        String codigoAlterar = scanner.nextLine();
        boolean encontradoAlterar = false;

        for (int i = 0; i < produtoCount; i++) {
            if (cardapio[i][0].equals(codigoAlterar)) {
                encontradoAlterar = true;
                System.out.print("Novo nome do produto: ");
                String novoProduto = scanner.nextLine();
                System.out.print("Novo preço: ");
                double novoPreco = scanner.nextDouble();
                scanner.nextLine(); // Limpa o buffer
                System.out.print("Ativo (true/false): ");
                boolean novoAtivo = scanner.nextBoolean();
                scanner.nextLine(); // Limpa o buffer

                cardapio[i][1] = novoProduto.toUpperCase();
                cardapio[i][2] = String.valueOf(novoPreco);
                ativos[i] = novoAtivo;

                System.out.println("Produto alterado com sucesso.");
                break;
            }
        }
        if (!encontradoAlterar) {
            System.out.println("Produto não existe no cadastro.");
        }
    }

    private static void excluirProduto() {
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
                System.out.println("Produto excluído com sucesso.");
                break;
            }
        }
        if (!encontradoExcluir) {
            System.out.println("Produto não existe no cadastro.");
        }
    }

    private static void consultarProduto() {
        System.out.print("Informe o código do produto a ser consultado: ");
        String codigoConsultar = scanner.nextLine();
        boolean encontradoConsultar = false;

        for (int i = 0; i < produtoCount; i++) {
            if (cardapio[i][0].equals(codigoConsultar)) {
                encontradoConsultar = true;
                System.out.printf("Código: %s, Produto: %s, Preço: R$ %.2f%n",
                        cardapio[i][0], cardapio[i][1], Double.parseDouble(cardapio[i][2]));
                break;
            }
        }
        if (!encontradoConsultar) {
            System.out.println("Produto não existe no cadastro.");
        }
    }

    private static void mostrarCardapio() {
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-60s %-10s%n", "CÓDIGO", "PRODUTO", "VALOR");
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        for (int i = 0; i < produtoCount; i++) {
            if (ativos[i]) { // Exibe apenas produtos ativos
                System.out.printf("%-10s %-60s R$ %.2f%n", cardapio[i][0], cardapio[i][1],
                        Double.parseDouble(cardapio[i][2]));
            }
        }

        System.out.println(
                "-------------------------------------------------------------------------------------------------");
    }

    private static void incluirCliente() {
        if (clienteCount >= 100) {
            System.out.println("Limite de clientes atingido.");
            return;
        }

        System.out.print("Nome (6 a 60 caracteres): ");
        String nome = scanner.nextLine();
        if (nome.length() < 6 || nome.length() > 60) {
            System.out.println("Nome deve ter entre 6 e 60 caracteres.");
            return;
        }
        clientes[clienteCount][0] = nome.toUpperCase();

        System.out.print("Logradouro (até 60 caracteres): ");
        String logradouro = scanner.nextLine();
        if (logradouro.length() > 60 || !logradouro.matches("[A-Za-z0-9 ]+")) {
            System.out.println("Logradouro deve ter até 60 caracteres alfanuméricos.");
            return;
        }
        clientes[clienteCount][1] = logradouro;

        System.out.print("Número (até 4 caracteres): ");
        String numero = scanner.nextLine();
        if (numero.length() > 4 || !numero.matches("\\d+")) {
            System.out.println("Número deve ter até 4 caracteres numéricos.");
            return;
        }
        clientes[clienteCount][2] = numero;

        System.out.print("Complemento (opcional, até 60 caracteres): ");
        String complemento = scanner.nextLine();
        if (complemento.length() > 60) {
            System.out.println("Complemento deve ter até 60 caracteres.");
            return;
        }
        clientes[clienteCount][3] = complemento;

        System.out.print("Bairro (até 60 caracteres): ");
        String bairro = scanner.nextLine();
        if (bairro.length() > 60 || !bairro.matches("[A-Za-z0-9 ]+")) {
            System.out.println("Bairro deve ter até 60 caracteres alfanuméricos.");
            return;
        }
        clientes[clienteCount][4] = bairro;

        System.out.print("Cidade (até 60 caracteres): ");
        String cidade = scanner.nextLine();
        if (cidade.length() > 60 || !cidade.matches("[A-Za-z0-9 ]+")) {
            System.out.println("Cidade deve ter até 60 caracteres alfanuméricos.");
            return;
        }
        clientes[clienteCount][5] = cidade;

        System.out.print("CEP (formato 99999-999): ");
        String cep = scanner.nextLine();
        if (!cep.matches("\\d{5}-\\d{3}")) {
            System.out.println("CEP deve estar no formato 99999-999.");
            return;
        }
        clientes[clienteCount][6] = cep;

        System.out.print("Estado (2 caracteres): ");
        String estado = scanner.nextLine();
        if (estado.length() != 2 || !estado.matches("[A-Za-z]+")) {
            System.out.println("Estado deve ter 2 caracteres alfabéticos.");
            return;
        }
        clientes[clienteCount][7] = estado.toUpperCase();

        System.out.print("Sexo (M/F): ");
        String sexo = scanner.nextLine();
        if (!sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("F")) {
            System.out.println("Sexo inválido. Favor tentar novamente.");
            return;
        }
        clientes[clienteCount][8] = sexo.toUpperCase();

        System.out.print("Telefone (formato (99) X9999-9999): ");
        String telefone = scanner.nextLine();
        if (!telefone.matches("\\(\\d{2}\\) [0-9]\\d{4}-\\d{4}")) {
            System.out.println("Telefone deve estar no formato (99) X9999-9999, onde X pode ser um dígito.");
            return;
        }
        clientes[clienteCount][9] = telefone;

        System.out.print("Email (opcional, até 80 caracteres): ");
        String email = scanner.nextLine();
        if (email.length() > 80) {
            System.out.println("Email deve ter até 80 caracteres.");
            return;
        }
        clientes[clienteCount][10] = email;

        System.out.print("Nascimento (formato dd/mm/aaaa): ");
        String nascimento = scanner.nextLine();
        if (!nascimento.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Data de nascimento deve estar no formato dd/mm/aaaa.");
            return;
        }
        clientes[clienteCount][11] = nascimento;

        clienteCount++;
        System.out.println("Cliente cadastrado com sucesso.");
    }

    private static void alterarCliente() {
        System.out.print("Informe o nome do cliente a ser alterado: ");
        String nomeAlterar = scanner.nextLine();
        boolean encontradoAlterar = false;

        for (int i = 0; i < clienteCount; i++) {
            if (clientes[i][0].equalsIgnoreCase(nomeAlterar)) {
                encontradoAlterar = true;

                // Altera os campos do client
                System.out.print("Novo nome (6 a 60 caracteres): ");
                String novoNome = scanner.nextLine();
                if (novoNome.length() < 6 || novoNome.length() > 60) {
                    System.out.println("Nome deve ter entre 6 e 60 caracteres.");
                    return;
                }
                clientes[i][0] = novoNome.toUpperCase();

                System.out.print("Novo logradouro (até 60 caracteres): ");
                String novoLogradouro = scanner.nextLine();
                if (novoLogradouro.length() > 60 || !novoLogradouro.matches("[A-Za-z0-9 ]+")) {
                    System.out.println("Logradouro deve ter até 60 caracteres alfanuméricos.");
                    return;
                }
                clientes[i][1] = novoLogradouro;

                System.out.print("Novo número (até 4 caracteres): ");
                String novoNumero = scanner.nextLine();
                if (novoNumero.length() > 4 || !novoNumero.matches("\\d+")) {
                    System.out.println("Número deve ter até 4 caracteres numéricos.");
                    return;
                }
                clientes[i][2] = novoNumero;

                System.out.print("Novo complemento (opcional, até 60 caracteres): ");
                String novoComplemento = scanner.nextLine();
                if (novoComplemento.length() > 60) {
                    System.out.println("Complemento deve ter até 60 caracteres.");
                    return;
                }
                clientes[i][3] = novoComplemento;

                System.out.print("Novo bairro (até 60 caracteres): ");
                String novoBairro = scanner.nextLine();
                if (novoBairro.length() > 60 || !novoBairro.matches("[A-Za-z0-9 ]+")) {
                    System.out.println("Bairro deve ter até 60 caracteres alfanuméricos.");
                    return;
                }
                clientes[i][4] = novoBairro;

                System.out.print("Nova cidade (até 60 caracteres): ");
                String novaCidade = scanner.nextLine();
                if (novaCidade.length() > 60 || !novaCidade.matches("[A-Za-z0-9 ]+")) {
                    System.out.println("Cidade deve ter até 60 caracteres alfanuméricos.");
                    return;
                }
                clientes[i][5] = novaCidade;

                System.out.print("Novo CEP (formato 99999-999): ");
                String novoCep = scanner.nextLine();
                if (!novoCep.matches("\\d{5}-\\d{3}")) {
                    System.out.println("CEP deve estar no formato 99999-999.");
                    return;
                }
                clientes[i][6] = novoCep;

                System.out.print("Novo estado (2 caracteres): ");
                String novoEstado = scanner.nextLine();
                if (novoEstado.length() != 2 || !novoEstado.matches("[A-Za-z]+")) {
                    System.out.println("Estado deve ter 2 caracteres alfabéticos.");
                    return;
                }
                clientes[i][7] = novoEstado.toUpperCase();

                System.out.print("Novo sexo (M/F): ");
                String novoSexo = scanner.nextLine();
                if (!novoSexo.equalsIgnoreCase("M") && !novoSexo.equalsIgnoreCase("F")) {
                    System.out.println("Sexo inválido. Favor tentar novamente.");
                    return;
                }
                clientes[i][8] = novoSexo.toUpperCase();

                System.out.print("Novo telefone (formato (99) X9999-9999): ");
                String novoTelefone = scanner.nextLine();
                if (!novoTelefone.matches("\\(\\d{2}\\) \\w\\d{4}-\\d{4}")) {
                    System.out.println("Telefone deve estar no formato (99) X9999-9999.");
                    return;
                }
                clientes[i][9] = novoTelefone;

                System.out.print("Novo email (opcional, até 80 caracteres): ");
                String novoEmail = scanner.nextLine();
                if (novoEmail.length() > 80) {
                    System.out.println("Email deve ter até 80 caracteres.");
                    return;
                }
                clientes[i][10] = novoEmail;

                System.out.print("Nova data de nascimento (formato dd/mm/aaaa): ");
                String novaDataNascimento = scanner.nextLine();
                if (!novaDataNascimento.matches("\\d{2}/\\d{2}/\\d{4}")) {
                    System.out.println("Data de nascimento deve estar no formato dd/mm/aaaa.");
                    return;
                }
                clientes[i][11] = novaDataNascimento;

                System.out.println("Cliente alterado com sucesso!");
                break;
            }
        }
        if (!encontradoAlterar) {
            System.out.println("Cliente não existe no cadastro.");
        }
    }

    private static void excluirCliente() {
        System.out.print("Informe o nome do cliente a ser excluído: ");
        String nomeExcluir = scanner.nextLine();
        boolean encontradoExcluir = false;

        for (int i = 0; i < clienteCount; i++) {
            if (clientes[i][0].equalsIgnoreCase(nomeExcluir)) {
                encontradoExcluir = true;
                for (int j = i; j < clienteCount - 1; j++) {
                    clientes[j] = clientes[j + 1];
                }
                clientes[clienteCount - 1] = null;
                clienteCount--;
                System.out.println("Cliente excluído com sucesso.");
                break;
            }
        }
        if (!encontradoExcluir) {
            System.out.println("Cliente não existe no cadastro.");
        }
    }

    private static void consultarCliente() {
        System.out.print("Informe o nome do cliente a ser consultado: ");
        String nomeConsultar = scanner.nextLine();
        boolean encontradoConsultar = false;

        for (int i = 0; i < clienteCount; i++) {
            if (clientes[i][0].equalsIgnoreCase(nomeConsultar)) {
                encontradoConsultar = true;
                System.out.printf(
                        "Nome: %s, Logradouro: %s, Número: %s, Bairro: %s, Cidade: %s, CEP: %s, Estado: %s, Sexo: %s, Telefone: %s, Email: %s, Nascimento: %s%n",
                        clientes[i][0], clientes[i][1], clientes[i][2], clientes[i][4],
                        clientes[i][5], clientes[i][6], clientes[i][7], clientes[i][8],
                        clientes[i][9], clientes[i][10], clientes[i][11]);
                break;
            }
        }
        if (!encontradoConsultar) {
            System.out.println("Cliente não existe no cadastro.");
        }
    }
}
