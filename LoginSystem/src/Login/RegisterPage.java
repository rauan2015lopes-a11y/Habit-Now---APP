package Login;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
		
public class RegisterPage {

    JFrame frame = new JFrame();

    public RegisterPage(HashMap<String, String> logininfo) {

	        Color fundo = new Color(15, 15, 15);
	        Color card = new Color(28, 28, 28);
	        Color vermelho = new Color(180, 40, 50);
	        Color branco = Color.WHITE;

	        frame.setSize(400, 500);
	        frame.setLocationRelativeTo(null);

	        JPanel container = new JPanel(new GridBagLayout());
	        container.setBackground(fundo);

	        JPanel cardPanel = new JPanel();
	        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
	        cardPanel.setBackground(card);
	        cardPanel.setBorder(BorderFactory.createEmptyBorder(30, 25, 30, 25));

	        JTextField userField = new JTextField();
	        JPasswordField passField = new JPasswordField();
	        JLabel msg = new JLabel();

	        userField.setMaximumSize(new Dimension(200, 30));
	        passField.setMaximumSize(new Dimension(200, 30));

	        JButton cadastrar = new JButton("Cadastrar");

	        cadastrar.setBackground(vermelho);
	        cadastrar.setForeground(branco);

	        cardPanel.add(new JLabel("Novo Usuário"));
	        cardPanel.add(userField);
	        cardPanel.add(Box.createVerticalStrut(10));
	        cardPanel.add(new JLabel("Senha"));
	        cardPanel.add(passField);
	        cardPanel.add(Box.createVerticalStrut(20));
	        cardPanel.add(cadastrar);
	        cardPanel.add(msg);

	        container.add(cardPanel);
	        frame.add(container);

	        cadastrar.addActionListener(e -> {
	            String user = userField.getText().trim();
	            String pass = String.valueOf(passField.getPassword());

	            if (!user.isEmpty() && !pass.isEmpty()) {
	                logininfo.put(user, pass);
	                msg.setText("Cadastrado com sucesso!");
	                msg.setForeground(Color.GREEN);
	            } else {
	                msg.setText("Preencha todos os campos");
	                msg.setForeground(Color.RED);
	            }
	        });

	        frame.setVisible(true);
	    }
}