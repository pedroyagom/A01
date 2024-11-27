import javax.swing.*;
import java.awt.*;

public class SistemaPessoa {

    public static void main(String[] args) {
        new SistemaPessoa().iniciarSistema();
    }

    // Método padrão para iniciar o sistema
    public void iniciarSistema() {
        iniciarSistema("Sistema Pessoa", 800, 800);
    }

    // Método sobrecarregado: permite alterar o título da janela principal
    public void iniciarSistema(String tituloJanela) {
        iniciarSistema(tituloJanela, 800, 800);
    }

    // Método sobrecarregado: permite alterar o título e o tamanho da janela principal
    public void iniciarSistema(String tituloJanela, int largura, int altura) {
        JFrame principal = new JFrame(tituloJanela);
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(largura, altura);

        // Criação do menu
        JMenuBar menuPrincipal = criarMenu(principal);
        JTextArea areaTrabalho = new JTextArea();

        // Rodapé com informações do sistema
        JPanel painelRodape = new JPanel();
        JLabel labelRodape = new JLabel(
            "Versão: " + ConfiguracoesSistema.VERSAO_SISTEMA +
            "    Usuário: " + ConfiguracoesSistema.NOME_USUARIO +
            "    Data de acesso: " + ConfiguracoesSistema.DATA_ACESSO
        );
        painelRodape.add(labelRodape);

        principal.getContentPane().add(BorderLayout.NORTH, menuPrincipal);
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
        principal.getContentPane().add(BorderLayout.SOUTH, painelRodape);

        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }

    // Método para criar o menu
    private JMenuBar criarMenu(JFrame principal) {
        JMenuBar menuPrincipal = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }

            public void menuDeselected(javax.swing.event.MenuEvent e) {}

            public void menuCanceled(javax.swing.event.MenuEvent e) {}
        });

        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);

        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);

        itemMenuCadastroUsuarios.addActionListener(e -> new CadastroUsuarios(principal).exibir());
        itemMenuCadastroPessoas.addActionListener(e -> new CadastroPessoas(principal).exibir());
        itemMenuVisualizacaoListaUsuarios.addActionListener(e -> new ListaUsuarios(principal).exibir());
        itemMenuVisualizacaoListaPessoas.addActionListener(e -> new ListaPessoas(principal).exibir());

        return menuPrincipal;
    }
}
