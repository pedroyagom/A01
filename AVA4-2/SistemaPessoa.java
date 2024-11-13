import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Classe principal do sistema
public class SistemaPessoa {
    public static void main(String[] args) {
        SistemaPessoaUI sistemaPessoaUI = new SistemaPessoaUI("12.1.2024", "denys.silva");
        sistemaPessoaUI.criarJanela();
    }
}

// Classe responsável pela interface principal do sistema
class SistemaPessoaUI {
    private final String versaoSistema;
    private final String nomeUsuario;
    private final String dataAcesso;

    public SistemaPessoaUI(String versaoSistema, String nomeUsuario) {
        this.versaoSistema = versaoSistema;
        this.nomeUsuario = nomeUsuario;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        this.dataAcesso = dateFormat.format(new Date());
    }

    public void criarJanela() {
        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);

        JMenuBar menuPrincipal = criarMenu(principal);

        JTextArea areaTrabalho = new JTextArea();
        JPanel painelRodape = criarRodape();

        principal.getContentPane().add(BorderLayout.NORTH, menuPrincipal);
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
        principal.getContentPane().add(BorderLayout.SOUTH, painelRodape);

        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }

    private JMenuBar criarMenu(JFrame principal) {
        JMenuBar menuPrincipal = new JMenuBar();

        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }
            public void menuDeselected(javax.swing.event.MenuEvent e) { }
            public void menuCanceled(javax.swing.event.MenuEvent e) { }
        });

        JMenuItem itemCadastroPessoas = new JMenuItem("Cadastro de Pessoas");
        itemCadastroPessoas.addActionListener(e -> new CadastroPessoas(principal).exibirFormulario());

        JMenuItem itemListaUsuarios = new JMenuItem("Lista de Usuários");
        itemListaUsuarios.addActionListener(e -> new ListaUsuarios(principal).exibirLista());

        JMenuItem itemListaPessoas = new JMenuItem("Lista de Pessoas");
        itemListaPessoas.addActionListener(e -> new ListaPessoas(principal).exibirLista());

        menuCadastro.add(itemCadastroPessoas);
        menuVisualizacao.add(itemListaUsuarios);
        menuVisualizacao.add(itemListaPessoas);

        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        return menuPrincipal;
    }

    private JPanel criarRodape() {
        JPanel painelRodape = new JPanel();
        JLabel labelRodape = new JLabel("Versão: " + versaoSistema + "    Usuário: " + nomeUsuario + "    Data de acesso: " + dataAcesso);
        painelRodape.add(labelRodape);
        return painelRodape;
    }
}

// Classe para o cadastro de pessoas
class CadastroPessoas {
    private final JFrame principal;

    public CadastroPessoas(JFrame principal) {
        this.principal = principal;
    }

    public void exibirFormulario() {
        JDialog cadastroPessoas = new JDialog(principal, "Cadastro de Pessoa", true);
        cadastroPessoas.setSize(600, 300);
        cadastroPessoas.setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Cadastro de Pessoa", SwingConstants.CENTER);
        cadastroPessoas.add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(7, 2, 5, 5));
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("Endereço:"));
        painelCampos.add(new JTextField(60));
        painelCampos.add(new JLabel("Cidade:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("UF:"));
        painelCampos.add(new JTextField(2));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Telefone:"));
        painelCampos.add(new JTextField(20));
        painelCampos.add(new JLabel("Sexo:"));
        JComboBox<String> comboSexo = new JComboBox<>(new String[]{"Masculino", "Feminino"});
        painelCampos.add(comboSexo);

        JPanel painelBotoes = criarPainelBotoes(cadastroPessoas);
        cadastroPessoas.add(painelCampos, BorderLayout.CENTER);
        cadastroPessoas.add(painelBotoes, BorderLayout.SOUTH);
        cadastroPessoas.setLocationRelativeTo(principal);
        cadastroPessoas.setVisible(true);
    }

    private JPanel criarPainelBotoes(JDialog dialog) {
        JPanel painelBotoes = new JPanel(new FlowLayout());
        String[] labels = {"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"};
        for (String label : labels) {
            JButton button = new JButton(label);
            if (label.equals("Sair")) {
                button.addActionListener(e -> dialog.setVisible(false));
            } else {
                button.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Botão " + label + " clicado!"));
            }
            painelBotoes.add(button);
        }
        return painelBotoes;
    }
}

// Classe para exibir a lista de usuários
class ListaUsuarios {
    private final JFrame principal;

    public ListaUsuarios(JFrame principal) {
        this.principal = principal;
    }

    public void exibirLista() {
        JDialog listaUsuarios = new JDialog(principal, "Lista de Usuários", true);
        listaUsuarios.setSize(750, 650);
        listaUsuarios.setLayout(new BorderLayout());

        listaUsuarios.add(new JLabel("Lista de Usuários", SwingConstants.CENTER), BorderLayout.NORTH);
        listaUsuarios.add(new JTextArea("Exemplo de lista de usuários..."), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> listaUsuarios.setVisible(false));
        listaUsuarios.add(btnFechar, BorderLayout.SOUTH);

        listaUsuarios.setLocationRelativeTo(principal);
        listaUsuarios.setVisible(true);
    }
}

// Classe para exibir a lista de pessoas
class ListaPessoas {
    private final JFrame principal;

    public ListaPessoas(JFrame principal) {
        this.principal = principal;
    }

    public void exibirLista() {
        JDialog listaPessoas = new JDialog(principal, "Lista de Pessoas", true);
        listaPessoas.setSize(750, 650);
        listaPessoas.setLayout(new BorderLayout());

        listaPessoas.add(new JLabel("Lista de Pessoas", SwingConstants.CENTER), BorderLayout.NORTH);
        listaPessoas.add(new JTextArea("Exemplo de lista de pessoas..."), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> listaPessoas.setVisible(false));
        listaPessoas.add(btnFechar, BorderLayout.SOUTH);

        listaPessoas.setLocationRelativeTo(principal);
        listaPessoas.setVisible(true);
    }
}
