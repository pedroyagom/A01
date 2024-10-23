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

    // Método principal para iniciar o programa
    public static void main(String[] args) {
        // Criar e exibir a janela principal
        new SistemaPessoa();
    }
}
