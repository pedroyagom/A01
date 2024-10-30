import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaPessoa extends JFrame {

    // Construtor da janela principal
    public SistemaPessoa() {
        // Definindo o título da janela
        setTitle("Sistema de Pessoa");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Definir o layout da janela
        setLayout(new BorderLayout());

        // Painel para o conteúdo central (preto)
        JPanel painelCentral = new JPanel();
        painelCentral.setBackground(Color.BLACK);
        add(painelCentral, BorderLayout.CENTER);

        // Criação do Menu
        JMenuBar menuBar = new JMenuBar();

        // Menu Cadastro
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem menuUsuarios = new JMenuItem("Usuários");
        JMenuItem menuPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(menuUsuarios);
        menuCadastro.add(menuPessoas);

        // Ação para abrir a janela de cadastro de usuários
        menuUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirJanelaCadastroUsuarios();
            }
        });

        // Ação para abrir a janela de cadastro de pessoas
        menuPessoas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirJanelaCadastroPessoas();
            }
        });

        // Menu Visualização
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenuItem menuListaUsuarios = new JMenuItem("Lista de usuário");
        JMenuItem menuListaPessoas = new JMenuItem("Lista de Pessoas");
        menuVisualizacao.add(menuListaUsuarios);
        menuVisualizacao.add(menuListaPessoas);

        // Menu Sair
        JMenu menuSair = new JMenu("Sair");
        JMenuItem menuSairItem = new JMenuItem("Sair");
        menuSairItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fecha o programa ao clicar em "Sair"
                System.exit(0);
            }
        });
        menuSair.add(menuSairItem);

        // Adicionar menus à barra de menu
        menuBar.add(menuCadastro);
        menuBar.add(menuVisualizacao);
        menuBar.add(menuSair);

        // Adicionar a barra de menu à janela
        setJMenuBar(menuBar);

        // Criação do rodapé com informações
        JPanel rodape = new JPanel(new BorderLayout());

        // Informações de rodapé
        JLabel infoRodape = new JLabel("Versão: 12.1.2024   Usuário: denys.silva", JLabel.LEFT);

        // Pegando a data atual
        String dataAcesso = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date());
        JLabel dataRodape = new JLabel("Data de acesso: " + dataAcesso, JLabel.RIGHT);

        // Adicionando as informações ao rodapé
        rodape.add(infoRodape, BorderLayout.WEST);
        rodape.add(dataRodape, BorderLayout.EAST);

        rodape.setBorder(BorderFactory.createEtchedBorder());
        add(rodape, BorderLayout.SOUTH);

        // Tornar a janela visível
        setVisible(true);
    }

    // Método para abrir a janela de cadastro de usuários
    private void abrirJanelaCadastroUsuarios() {
        JFrame cadastroFrame = new JFrame("Cadastro de Usuários");
        cadastroFrame.setSize(500, 300);
        cadastroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cadastroFrame.setLocationRelativeTo(null);

        // Painel principal
        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new GridLayout(5, 2, 10, 10));

        // Componentes de entrada de dados
        painelCadastro.add(new JLabel("Usuário:"));
        JTextField campoUsuario = new JTextField();
        painelCadastro.add(campoUsuario);

        painelCadastro.add(new JLabel("Senha:"));
        JPasswordField campoSenha = new JPasswordField();
        painelCadastro.add(campoSenha);

        painelCadastro.add(new JLabel("Email:"));
        JTextField campoEmail = new JTextField();
        painelCadastro.add(campoEmail);

        painelCadastro.add(new JLabel("Ativo:"));
        JRadioButton radioAtivo = new JRadioButton();
        painelCadastro.add(radioAtivo);

        // Painel para os botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());

        // Botões
        String[] botoes = {"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"};
        for (String nomeBotao : botoes) {
            JButton botao = new JButton(nomeBotao);
            botao.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (nomeBotao.equals("Sair")) {
                        cadastroFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Botão clicado: " + nomeBotao);
                    }
                }
            });
            painelBotoes.add(botao);
        }

        // Adicionar painel de cadastro e botões à janela
        cadastroFrame.add(painelCadastro, BorderLayout.CENTER);
        cadastroFrame.add(painelBotoes, BorderLayout.SOUTH);

        // Exibir a janela de cadastro
        cadastroFrame.setVisible(true);
    }

    // Método para abrir a janela de cadastro de pessoas
    private void abrirJanelaCadastroPessoas() {
        JFrame cadastroFrame = new JFrame("Cadastro de Pessoas");
        cadastroFrame.setSize(600, 400);
        cadastroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cadastroFrame.setLocationRelativeTo(null);

        // Painel principal
        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(new GridLayout(7, 2, 10, 10));

        // Componentes de entrada de dados
        painelCadastro.add(new JLabel("Nome:"));
        JTextField campoNome = new JTextField();
        painelCadastro.add(campoNome);

        painelCadastro.add(new JLabel("Endereço:"));
        JTextField campoEndereco = new JTextField();
        painelCadastro.add(campoEndereco);

        painelCadastro.add(new JLabel("Cidade:"));
        JTextField campoCidade = new JTextField();
        painelCadastro.add(campoCidade);

        painelCadastro.add(new JLabel("UF:"));
        JTextField campoUF = new JTextField();
        painelCadastro.add(campoUF);

        painelCadastro.add(new JLabel("Email:"));
        JTextField campoEmail = new JTextField();
        painelCadastro.add(campoEmail);

        painelCadastro.add(new JLabel("Telefone:"));
        JTextField campoTelefone = new JTextField();
        painelCadastro.add(campoTelefone);

        painelCadastro.add(new JLabel("Sexo:"));
        JComboBox<String> campoSexo = new JComboBox<>(new String[] {"M", "F"});
        painelCadastro.add(campoSexo);

        // Painel para os botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new FlowLayout());

        // Botões
        String[] botoes = {"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"};
        for (String nomeBotao : botoes) {
            JButton botao = new JButton(nomeBotao);
            botao.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (nomeBotao.equals("Sair")) {
                        cadastroFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Botão clicado: " + nomeBotao);
                    }
                }
            });
            painelBotoes.add(botao);
        }

        // Adicionar painel de cadastro e botões à janela
        cadastroFrame.add(painelCadastro, BorderLayout.CENTER);
        cadastroFrame.add(painelBotoes, BorderLayout.SOUTH);

        // Exibir a janela de cadastro
        cadastroFrame.setVisible(true);
    }

    // Método principal para iniciar o programa
    public static void main(String[] args) {
        // Criar e exibir a janela principal
        new SistemaPessoa();
    }
}
