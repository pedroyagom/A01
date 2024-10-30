package AVA4;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaPessoa {
    public static void main(String[] args) {
        // Inicializa o sistema e cria a interface
        SistemaPessoaUI sistemaPessoaUI = new SistemaPessoaUI("12.1.2024", "denys.silva");
        sistemaPessoaUI.criarJanela();
    }
}

// Classe responsável pela interface do sistema
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
        // Cria o frame principal
        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);

        // Configura o menu principal
        JMenuBar menuPrincipal = criarMenu();
        
        // Área de trabalho (centro)
        JTextArea areaTrabalho = new JTextArea();

        // Configura o rodapé
        Rodape rodape = new Rodape(versaoSistema, nomeUsuario, dataAcesso);
        JPanel painelRodape = rodape.criarRodape();

        // Adiciona componentes ao frame principal
        principal.getContentPane().add(BorderLayout.NORTH, menuPrincipal);
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);
        principal.getContentPane().add(BorderLayout.SOUTH, painelRodape);

        principal.setLocationRelativeTo(null); // Centraliza a janela
        principal.setVisible(true); // Torna a janela visível
    }

    private JMenuBar criarMenu() {
        JMenuBar menuPrincipal = new JMenuBar();

        // Cria e adiciona as opções horizontais do menu principal
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        // Configura o menu "Sair" com evento
        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0); // Sai do sistema
            }
            @Override
            public void menuDeselected(javax.swing.event.MenuEvent e) { }
            @Override
            public void menuCanceled(javax.swing.event.MenuEvent e) { }
        });

        // Adiciona opções de cadastro e visualização
        menuCadastro.add(new JMenuItem("Usuários"));
        menuCadastro.add(new JMenuItem("Pessoas"));
        menuVisualizacao.add(new JMenuItem("Lista de usuários"));
        menuVisualizacao.add(new JMenuItem("Lista de pessoas"));

        // Adiciona os menus à barra de menu
        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        return menuPrincipal;
    }
}

// Classe para o rodapé
class Rodape {
    private final String versaoSistema;
    private final String nomeUsuario;
    private final String dataAcesso;

    public Rodape(String versaoSistema, String nomeUsuario, String dataAcesso) {
        this.versaoSistema = versaoSistema;
        this.nomeUsuario = nomeUsuario;
        this.dataAcesso = dataAcesso;
    }

    public JPanel criarRodape() {
        JPanel painelRodape = new JPanel();
        JLabel labelRodape = new JLabel("Versão: " + versaoSistema + "               Usuário: " + nomeUsuario + "               Data de acesso: " + dataAcesso);
        painelRodape.add(labelRodape);
        return painelRodape;
    }
}
