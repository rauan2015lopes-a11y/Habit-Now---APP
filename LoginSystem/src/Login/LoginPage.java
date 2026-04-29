package Login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginPage {

    JFrame frame = new JFrame();
    HashMap<String, String> logininfo;

    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel messageLabel = new JLabel();

    public LoginPage(HashMap<String, String> loginInfoOriginal) {

        logininfo = loginInfoOriginal;

        //  Cores
        Color fundo = new Color(15, 15, 15);
        Color card = new Color(28, 28, 28);
        Color vermelho = new Color(180, 40, 50);
        Color branco = Color.WHITE;
        Color cinza = new Color(170, 170, 170);

        frame.setSize(400, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel container = new JPanel(new GridBagLayout());
        container.setBackground(fundo);

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
        cardPanel.setBackground(card);
        cardPanel.setBorder(BorderFactory.createEmptyBorder(30, 25, 30, 25));

        // Título
        JLabel titulo = new JLabel("HabitNow");
        titulo.setForeground(branco);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Usuário
        JLabel userLabel = new JLabel("Usuário");
        userLabel.setAlignmentX(1.5f);
        userLabel.setAlignmentY(1.0f);
        userLabel.setForeground(cinza);

        userIDField.setMaximumSize(new Dimension(200, 30));
        userIDField.setBackground(new Color(40, 40, 40));
        userIDField.setForeground(branco);

        // Senha
        JLabel passLabel = new JLabel("Senha");
        passLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        passLabel.setVerticalAlignment(SwingConstants.TOP);
        passLabel.setForeground(cinza);

        userPasswordField.setMaximumSize(new Dimension(200, 30));
        userPasswordField.setBackground(new Color(40, 40, 40));
        userPasswordField.setForeground(branco);

        // Botões
        JButton loginButton = new JButton("Entrar");
        JButton registerButton = new JButton("Cadastrar");

        loginButton.setBackground(vermelho);
        loginButton.setForeground(branco);
        registerButton.setBackground(vermelho);
        registerButton.setForeground(branco);

        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Mensagem
        messageLabel.setForeground(Color.LIGHT_GRAY);
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Organização
        cardPanel.add(titulo);
        cardPanel.add(Box.createVerticalStrut(20));
        cardPanel.add(userLabel);
        cardPanel.add(userIDField);
        cardPanel.add(Box.createVerticalStrut(10));
        cardPanel.add(passLabel);
        cardPanel.add(userPasswordField);
        cardPanel.add(Box.createVerticalStrut(20));
        cardPanel.add(loginButton);
        cardPanel.add(Box.createVerticalStrut(10));
        cardPanel.add(registerButton);
        cardPanel.add(Box.createVerticalStrut(10));
        cardPanel.add(messageLabel);

        container.add(cardPanel);
        frame.getContentPane().add(container);

        // Ações

        loginButton.addActionListener(e -> {
            String user = userIDField.getText().trim();
            String pass = String.valueOf(userPasswordField.getPassword());

            if (logininfo.containsKey(user)) {
                if (logininfo.get(user).equals(pass)) {
                    frame.dispose();
                    new Paginabemvindo(user);
                } else {
                    messageLabel.setText("Senha incorreta");
                    messageLabel.setForeground(Color.RED);
                }
            } else {
                messageLabel.setText("Usuário não encontrado");
                messageLabel.setForeground(Color.RED);
            }
        });

        registerButton.addActionListener(e -> {
            new RegisterPage(logininfo);
        });

        frame.setVisible(true);
    }
}