import javax.swing.*;
import java.awt.*;

public class ListaUsuarios {
    private final JFrame principal;

    public ListaUsuarios(JFrame principal) {
        this.principal = principal;
    }

    // Método padrão para exibir a lista
    public void exibir() {
        exibir("Lista de Usuários", "Exemplo de lista de usuários...");
    }

    // Método sobrecarregado: permite alterar o título do diálogo
    public void exibir(String titulo) {
        exibir(titulo, "Exemplo de lista de usuários...");
    }

    // Método sobrecarregado: permite alterar o título e o conteúdo da lista
    public void exibir(String titulo, String conteudo) {
        exibir(titulo, conteudo, 750, 650);
    }

    // Método sobrecarregado: permite alterar título, conteúdo e dimensões
    public void exibir(String titulo, String conteudo, int largura, int altura) {
        JDialog dialog = new JDialog(principal, titulo, true);
        dialog.setSize(largura, altura);
        dialog.setLayout(new BorderLayout());

        dialog.add(new JLabel(titulo, SwingConstants.CENTER), BorderLayout.NORTH);

        JTextArea textArea = new JTextArea(conteudo);
        textArea.setEditable(false); // Tornar a área de texto apenas leitura
        dialog.add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dialog.setVisible(false));
        dialog.add(btnFechar, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}
