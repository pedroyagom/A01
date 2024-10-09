
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CadastroWindows extends JFrame {
    private String[][] cardapio = new String[100][3];
    private boolean[] ativos = new boolean[100];
    private int produtoCount = 0;

    private String[][] clientes = new String[100][12];
    private int clienteCount = 0;

    public CadastroWindows() {
        setTitle("Sistema de Gestão");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        JButton produtoButton = new JButton("Produto");
        produtoButton.addActionListener(this::gerenciarProdutos);
        JButton clienteButton = new JButton("Cliente");
        clienteButton.addActionListener(this::gerenciarClientes);
        JButton mostrarCardapioButton = new JButton("Mostrar Cardápio");
        mostrarCardapioButton.addActionListener(e -> mostrarCardapio());
        JButton sairButton = new JButton("Sair");
        sairButton.addActionListener(e -> System.exit(0));

        add(produtoButton);
        add(clienteButton);
        add(mostrarCardapioButton);
        add(sairButton);
    }

    private void gerenciarProdutos(ActionEvent e) {
        String[] opcoes = {"Incluir", "Alterar", "Excluir", "Consultar"};
        String escolha = (String) JOptionPane.showInputDialog(this, "Escolha uma ação:", 
                "Gerenciar Produtos", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case "Incluir": incluirProduto(); break;
            case "Alterar": alterarProduto(); break;
            case "Excluir": excluirProduto(); break;
            case "Consultar": consultarProduto(); break;
        }
    }

    private void incluirProduto() {
        String codigo = JOptionPane.showInputDialog("Código (6 caracteres):");
        String produto = JOptionPane.showInputDialog("Produto (3 a 60 caracteres):");
        String precoStr = JOptionPane.showInputDialog("Preço:");
        String ativoStr = JOptionPane.showInputDialog("Ativo (true/false):");

        if (codigo.length() == 6 && produto.length() >= 3 && produto.length() <= 60) {
            double preco = Double.parseDouble(precoStr);
            boolean ativo = Boolean.parseBoolean(ativoStr);

            cardapio[produtoCount] = new String[]{codigo, produto.toUpperCase(), String.valueOf(preco)};
            ativos[produtoCount] = ativo;
            produtoCount++;

            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(this, "Dados inválidos. Tente novamente.");
        }
    }

    private void alterarProduto() {
        String codigo = JOptionPane.showInputDialog("Informe o código do produto a ser alterado:");
        for (int i = 0; i < produtoCount; i++) {
            if (cardapio[i][0].equals(codigo)) {
                String novoProduto = JOptionPane.showInputDialog("Novo nome do produto:");
                String novoPrecoStr = JOptionPane.showInputDialog("Novo preço:");
                String novoAtivoStr = JOptionPane.showInputDialog("Ativo (true/false):");

                cardapio[i][1] = novoProduto.toUpperCase();
                cardapio[i][2] = novoPrecoStr;
                ativos[i] = Boolean.parseBoolean(novoAtivoStr);

                JOptionPane.showMessageDialog(this, "Produto alterado com sucesso.");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Produto não encontrado.");
    }

    private void excluirProduto() {
        String codigo = JOptionPane.showInputDialog("Informe o código do produto a ser excluído:");
        for (int i = 0; i < produtoCount; i++) {
            if (cardapio[i][0].equals(codigo)) {
                for (int j = i; j < produtoCount - 1; j++) {
                    cardapio[j] = cardapio[j + 1];
                    ativos[j] = ativos[j + 1];
                }
                cardapio[produtoCount - 1] = null;
                ativos[produtoCount - 1] = false;
                produtoCount--;
                JOptionPane.showMessageDialog(this, "Produto excluído com sucesso.");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Produto não encontrado.");
    }

    private void consultarProduto() {
        String codigo = JOptionPane.showInputDialog("Informe o código do produto a ser consultado:");
        for (int i = 0; i < produtoCount; i++) {
            if (cardapio[i][0].equals(codigo)) {
                JOptionPane.showMessageDialog(this, "Código: " + cardapio[i][0] + 
                    "\nProduto: " + cardapio[i][1] + "\nPreço: R$ " + cardapio[i][2]);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Produto não encontrado.");
    }

    private void mostrarCardapio() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-30s %-10s%n", "CÓDIGO", "PRODUTO", "VALOR"));
        sb.append("----------------------------------------------\n");
        for (int i = 0; i < produtoCount; i++) {
            if (ativos[i]) {
                sb.append(String.format("%-10s %-30s R$ %-10.2f%n", cardapio[i][0], cardapio[i][1], Double.parseDouble(cardapio[i][2])));
            }
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Cardápio", JOptionPane.INFORMATION_MESSAGE);
    }

    private void gerenciarClientes(ActionEvent e) {
        String[] opcoes = {"Incluir", "Alterar", "Excluir", "Consultar"};
        String escolha = (String) JOptionPane.showInputDialog(this, "Escolha uma ação:", 
                "Gerenciar Clientes", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case "Incluir": incluirCliente(); break;
            case "Alterar": alterarCliente(); break;
            case "Excluir": excluirCliente(); break;
            case "Consultar": consultarCliente(); break;
        }
    }

    private void incluirCliente() {
        String nome = JOptionPane.showInputDialog("Nome (6 a 60 caracteres):");
        if (nome.length() < 6 || nome.length() > 60) {
            JOptionPane.showMessageDialog(this, "Nome inválido.");
            return;
        }

        String logradouro = JOptionPane.showInputDialog("Logradouro (até 60 caracteres):");
        String numero = JOptionPane.showInputDialog("Número (até 4 caracteres):");
        String bairro = JOptionPane.showInputDialog("Bairro (até 60 caracteres):");
        String cidade = JOptionPane.showInputDialog("Cidade (até 60 caracteres):");
        String cep = JOptionPane.showInputDialog("CEP (formato 99999-999):");
        String estado = JOptionPane.showInputDialog("Estado (2 caracteres):");
        String sexo = JOptionPane.showInputDialog("Sexo (M/F):");
        String telefone = JOptionPane.showInputDialog("Telefone (formato (99) X9999-9999):");

        clientes[clienteCount] = new String[]{nome.toUpperCase(), logradouro, numero, "", bairro, cidade, cep, estado.toUpperCase(), sexo.toUpperCase(), telefone, "", ""};
        clienteCount++;
        JOptionPane.showMessageDialog(this, "Cliente cadastrado com sucesso.");
    }

    private void alterarCliente() {
        String nome = JOptionPane.showInputDialog("Informe o nome do cliente a ser alterado:");
        for (int i = 0; i < clienteCount; i++) {
            if (clientes[i][0].equalsIgnoreCase(nome)) {
                String novoNome = JOptionPane.showInputDialog("Novo nome (6 a 60 caracteres):");
                if (novoNome.length() < 6 || novoNome.length() > 60) {
                    JOptionPane.showMessageDialog(this, "Nome inválido.");
                    return;
                }

                String novoLogradouro = JOptionPane.showInputDialog("Novo logradouro (até 60 caracteres):");
                String novoNumero = JOptionPane.showInputDialog("Novo número (até 4 caracteres):");
                String novoBairro = JOptionPane.showInputDialog("Novo bairro (até 60 caracteres):");
                String novaCidade = JOptionPane.showInputDialog("Nova cidade (até 60 caracteres):");
                String novoCep = JOptionPane.showInputDialog("Novo CEP (formato 99999-999):");
                String novoEstado = JOptionPane.showInputDialog("Novo estado (2 caracteres):");
                String novoSexo = JOptionPane.showInputDialog("Novo sexo (M/F):");
                String novoTelefone = JOptionPane.showInputDialog("Novo telefone (formato (99) X9999-9999):");

                clientes[i][0] = novoNome.toUpperCase();
                clientes[i][1] = novoLogradouro;
                clientes[i][2] = novoNumero;
                clientes[i][4] = novoBairro;
                clientes[i][5] = novaCidade;
                clientes[i][6] = novoCep;
                clientes[i][7] = novoEstado.toUpperCase();
                clientes[i][8] = novoSexo.toUpperCase();
                clientes[i][9] = novoTelefone;

                JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso.");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
    }

    private void excluirCliente() {
        String nome = JOptionPane.showInputDialog("Informe o nome do cliente a ser excluído:");
        for (int i = 0; i < clienteCount; i++) {
            if (clientes[i][0].equalsIgnoreCase(nome)) {
                for (int j = i; j < clienteCount - 1; j++) {
                    clientes[j] = clientes[j + 1];
                }
                clientes[clienteCount - 1] = null;
                clienteCount--;
                JOptionPane.showMessageDialog(this, "Cliente excluído com sucesso.");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
    }

    private void consultarCliente() {
        String nome = JOptionPane.showInputDialog("Informe o nome do cliente a ser consultado:");
        for (int i = 0; i < clienteCount; i++) {
            if (clientes[i][0].equalsIgnoreCase(nome)) {
                JOptionPane.showMessageDialog(this, 
                    "Nome: " + clientes[i][0] + 
                    "\nLogradouro: " + clientes[i][1] + 
                    "\nNúmero: " + clientes[i][2] + 
                    "\nBairro: " + clientes[i][4] + 
                    "\nCidade: " + clientes[i][5] + 
                    "\nCEP: " + clientes[i][6] + 
                    "\nEstado: " + clientes[i][7] + 
                    "\nSexo: " + clientes[i][8] + 
                    "\nTelefone: " + clientes[i][9]);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Cliente não encontrado.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CadastroWindows sistema = new CadastroWindows();
            sistema.setVisible(true);
        });
    }
}

