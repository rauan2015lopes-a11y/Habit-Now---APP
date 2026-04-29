package Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Paginabemvindo {

    JFrame frame = new JFrame();

    Paginabemvindo(String userID) {

        // Cores
        Color fundo = new Color(15, 15, 15);
        Color cardColor = new Color(28, 28, 28);
        Color vermelho = new Color(180, 40, 50);
        Color branco = Color.WHITE;
        Color cinza = new Color(170, 170, 170);

        frame.setTitle("HabitNow");
        frame.setSize(400, 600); //formato de celular
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel(new GridBagLayout());
        contentPane.setBackground(fundo);
        frame.setContentPane(contentPane);

        // Central
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(cardColor);
        card.setBorder(new EmptyBorder(30, 25, 30, 25));

        card.setMaximumSize(new Dimension(300, 400));

        // Título
        JLabel titulo = new JLabel("HabitNow");
        titulo.setForeground(branco);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Boas vindas
        JLabel welcome = new JLabel("Olá, " + userID + "!");
        welcome.setForeground(branco);
        welcome.setFont(new Font("Arial", Font.BOLD, 18));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Frases 
        JLabel frase1 = new JLabel("Sua rotina começa aqui");
        frase1.setForeground(cinza);
        frase1.setFont(new Font("Arial", Font.PLAIN, 14));
        frase1.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel frase2 = new JLabel("Organize e evolua diariamente");
        frase2.setForeground(cinza);
        frase2.setFont(new Font("Arial", Font.PLAIN, 14));
        frase2.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Botão
        JButton btnIniciar = new JButton("Começar");
        btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIniciar.setBackground(vermelho);
        btnIniciar.setForeground(branco);
        btnIniciar.setFocusPainted(false);
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 14));
        btnIniciar.setMaximumSize(new Dimension(200, 40));

        // Espaçamento
        card.add(titulo);
        card.add(Box.createVerticalStrut(25));
        card.add(welcome);
        card.add(Box.createVerticalStrut(15));
        card.add(frase1);
        card.add(Box.createVerticalStrut(5));
        card.add(frase2);
        card.add(Box.createVerticalStrut(30));
        card.add(btnIniciar);

        contentPane.add(card);

        // Ação
        btnIniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Telatarefas().setVisible(true);
            }
        });

        frame.setVisible(true);
    }
}