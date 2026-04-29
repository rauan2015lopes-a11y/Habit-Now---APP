package Login;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Telatarefas extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel painelLista;
    private JTextField campoTarefa;
    private ArrayList<JCheckBox> listaTarefas = new ArrayList<>();
    private JLabel lblVazio;

    public Telatarefas() {

        setTitle("HabitNow");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Cores
        Color fundo = new Color(18, 18, 18); // preto suave
        Color vermelho = new Color(170, 30, 45); // vermelho elegante
        Color branco = Color.WHITE;

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBackground(fundo);
        setContentPane(contentPane);

        // Topo
        JPanel topo = new JPanel();
        topo.setBackground(fundo);

        JLabel titulo = new JLabel("HabitNow");
        titulo.setForeground(branco);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));

        campoTarefa = new JTextField(15);
        campoTarefa.setBackground(new Color(40, 40, 40));
        campoTarefa.setForeground(branco);
        campoTarefa.setCaretColor(branco);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBackground(vermelho);
        btnAdicionar.setForeground(branco);
        btnAdicionar.setFocusPainted(false);

        topo.add(titulo);
        topo.add(campoTarefa);
        topo.add(btnAdicionar);

        contentPane.add(topo, BorderLayout.NORTH);

        // Lista
        painelLista = new JPanel();
        painelLista.setLayout(new BoxLayout(painelLista, BoxLayout.Y_AXIS));
        painelLista.setBackground(fundo);

        JScrollPane scroll = new JScrollPane(painelLista);
        scroll.setBorder(null);
        contentPane.add(scroll, BorderLayout.CENTER);

        // Texto vazio
        lblVazio = new JLabel("Adicione sua primeira tarefa!");
        lblVazio.setForeground(Color.GRAY);
        lblVazio.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelLista.add(Box.createVerticalStrut(20));
        painelLista.add(lblVazio);

        // Botão reset 
        JButton btnResetar = new JButton("Resetar tarefas");
        btnResetar.setBackground(vermelho);
        btnResetar.setForeground(branco);
        btnResetar.setFocusPainted(false);

        contentPane.add(btnResetar, BorderLayout.SOUTH);

        // Adicionar tarefa
        btnAdicionar.addActionListener(e -> {
            String texto = campoTarefa.getText().trim();

            if (!texto.isEmpty()) {

                if (painelLista.getComponentCount() > 0) {
                    painelLista.remove(lblVazio);
                }

                JPanel card = new JPanel(new FlowLayout(FlowLayout.LEFT));
                card.setBackground(new Color(30, 30, 30));
                card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

                JCheckBox check = new JCheckBox();
                check.setBackground(card.getBackground());

                JLabel label = new JLabel(texto);
                label.setForeground(branco);

                card.add(check);
                card.add(label);

                painelLista.add(card);
                listaTarefas.add(check);

                // Riscar tarefa
                check.addActionListener(ev -> {
                    if (check.isSelected()) {
                        label.setText("<html><strike>" + texto + "</strike></html>");
                    } else {
                        label.setText(texto);
                    }
                });

                painelLista.revalidate();
                painelLista.repaint();

                campoTarefa.setText("");
            }
        });

        // Resetar
        btnResetar.addActionListener(e -> {
            for (JCheckBox tarefa : listaTarefas) {
                tarefa.setSelected(false);
            }

            painelLista.removeAll();
            listaTarefas.clear();

            painelLista.add(Box.createVerticalStrut(20));
            painelLista.add(lblVazio);

            painelLista.revalidate();
            painelLista.repaint();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Telatarefas().setVisible(true);
        });
    }
}