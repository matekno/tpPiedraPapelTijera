package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interfaces.IJugador;
import models.Partida;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPiedra;
	private JLabel lblPapel;
	private JLabel lblTijera;
	private JButton btnPiedra;
	private JButton btnPapel;
	private JButton btnTijera;
	private JLabel lblMaquinaEligio;
	private JLabel lblGanador;
	
	private Partida partida = new Partida();
	private JugadorGUI jugador = new JugadorGUI();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPiedra = new JLabel("PIEDRA");
		lblPiedra.setIcon(new ImageIcon(MainFrame.class.getResource("/img/piedra.jpeg")));
		lblPiedra.setBounds(20, 45, 200, 200);
		contentPane.add(lblPiedra);

		lblPapel = new JLabel("PAPEL");
		lblPapel.setIcon(new ImageIcon(MainFrame.class.getResource("/img/papel.jpeg")));
		lblPapel.setBounds(240, 45, 200, 200);
		contentPane.add(lblPapel);

		lblTijera = new JLabel("TIJERA");
		lblTijera.setIcon(new ImageIcon(MainFrame.class.getResource("/img/tijera.jpeg")));
		lblTijera.setBounds(460, 45, 200, 200);
		contentPane.add(lblTijera);

		btnPiedra = new JButton("Piedra");
		btnPiedra.setBounds(20, 256, 200, 29);
		contentPane.add(btnPiedra);

		btnPapel = new JButton("Papel");
		btnPapel.setBounds(240, 257, 200, 29);
		contentPane.add(btnPapel);

		btnTijera = new JButton("Tijera");
		btnTijera.setBounds(460, 257, 200, 29);
		contentPane.add(btnTijera);

		lblMaquinaEligio = new JLabel("Maquina eligio: ");
		lblMaquinaEligio.setBounds(20, 320, 645, 16);
		contentPane.add(lblMaquinaEligio);

		lblGanador = new JLabel("Ganador: ");
		lblGanador.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblGanador.setBounds(20, 360, 640, 80);
		contentPane.add(lblGanador);
	}
}
