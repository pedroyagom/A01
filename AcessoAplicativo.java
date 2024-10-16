import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcessoAplicativo {

    // Usuário e senha corretos
    private static final String USERNAME = "denys.silva";
    private static final String PASSWORD = "Teste@2024";

    public static void main(String[] args) {
        // Criando a janela
        JFrame frame = new JFrame("Acesso ao Aplicativo");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Criando os componentes
        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setBounds(10, 20, 80, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        frame.add(userText);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 50, 80, 25);
        frame.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        frame.add(passwordText);

        JButton confirmButton = new JButton("Confirmar");
        confirmButton.setBounds(10, 80, 100, 25);
        frame.add(confirmButton);

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(120, 80, 100, 25);
        frame.add(cancelButton);

        // Ação para o botão "Confirmar"
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if (username.equals(USERNAME) && password.equals(PASSWORD)) {
                    JOptionPane.showMessageDialog(frame, "Acesso confirmado!");
                    frame.dispose(); // Fecha a janela
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuário ou senha inválido!");
                }
            }
        });

        // Ação para o botão "Cancelar"
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela
            }
        });

        // Tornar a janela visível
        frame.setVisible(true);
    }
}
