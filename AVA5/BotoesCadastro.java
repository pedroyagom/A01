import javax.swing.*;
import java.awt.*;

public class BotoesCadastro {
    private final JDialog dialog;

    public BotoesCadastro(JDialog dialog) {
        this.dialog = dialog;
    }

    public JPanel criar() {
        JPanel painelBotoes = new JPanel(new FlowLayout());
        String[] labels = {"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"};
        for (String label : labels) {
            JButton button = new JButton(label);
            if ("Sair".equals(label)) {
                button.addActionListener(e -> dialog.setVisible(false));
            } else {
                button.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Botão " + label + " clicado!"));
            }
            painelBotoes.add(button);
        }
        return painelBotoes;
    }

    // Overloading Example 1: Default Button Creation
    public JButton criarBotao(String label) {
        return criarBotao(label, null);
    }

    // Overloading Example 2: Button with Custom Action
    public JButton criarBotao(String label, Runnable action) {
        JButton button = new JButton(label);
        if (action != null) {
            button.addActionListener(e -> action.run());
        } else {
            button.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Botão " + label + " clicado!"));
        }
        return button;
    }
}
