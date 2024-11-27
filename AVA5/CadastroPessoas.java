import javax.swing.*;
import java.awt.*;

public class CadastroPessoas {
    private final JFrame principal;

    public CadastroPessoas(JFrame principal) {
        this.principal = principal;
    }

    // Método padrão para exibir o diálogo de cadastro
    public void exibir() {
        exibir("Cadastro de Pessoas");
    }

    // Método sobrecarregado: permite alterar o título da janela
    public void exibir(String tituloJanela) {
        exibir(tituloJanela, 600, 300);
    }

    // Método sobrecarregado: permite alterar título e dimensões da janela
    public void exibir(String tituloJanela, int largura, int altura) {
        JDialog dialog = new JDialog(principal, tituloJanela, true);
        dialog.setSize(largura, altura);
        dialog.setLayout(new BorderLayout());

        JLabel titulo = new JLabel(tituloJanela, SwingConstants.CENTER);
        dialog.add(titulo, BorderLayout.NORTH);

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
        painelCampos.add(new JComboBox<>(new String[]{"Masculino", "Feminino"}));

        dialog.add(painelCampos, BorderLayout.CENTER);
        dialog.add(new BotoesCadastro(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}
