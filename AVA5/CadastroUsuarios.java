import javax.swing.*;
import java.awt.*;

public class CadastroUsuarios {
    private final JFrame principal;

    public CadastroUsuarios(JFrame principal) {
        this.principal = principal;
    }

    // Método padrão para exibir o diálogo de cadastro
    public void exibir() {
        exibir("Cadastro de Usuários");
    }

    // Método sobrecarregado: permite alterar o título da janela
    public void exibir(String tituloJanela) {
        exibir(tituloJanela, 600, 300);
    }

    // Método sobrecarregado: permite alterar título e dimensões da janela
    public void exibir(String tituloJanela, int largura, int altura) {
        exibir(tituloJanela, largura, altura, true);
    }

    // Método sobrecarregado: permite alterar título, dimensões e inclusão do botão "Ativo"
    public void exibir(String tituloJanela, int largura, int altura, boolean incluirAtivo) {
        JDialog dialog = new JDialog(principal, tituloJanela, true);
        dialog.setSize(largura, altura);
        dialog.setLayout(new BorderLayout());

        JLabel titulo = new JLabel(tituloJanela, SwingConstants.CENTER);
        dialog.add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(incluirAtivo ? 4 : 3, 2, 5, 5));
        painelCampos.add(new JLabel("Usuário:"));
        painelCampos.add(new JTextField(25));
        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(new JPasswordField(15));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));

        if (incluirAtivo) {
            painelCampos.add(new JLabel("Ativo:"));
            painelCampos.add(new JRadioButton());
        }

        dialog.add(painelCampos, BorderLayout.CENTER);
        dialog.add(new BotoesCadastro(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}
