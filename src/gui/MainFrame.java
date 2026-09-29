package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import interfaces.IJugador;
import models.Jugada;
import models.JugadorMaquina;
import models.Partida;
import services.PartidaService;
import javax.swing.JCheckBox;

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
	private JCheckBox chckbxModoOscuro;

	private JugadorGUI humano;
	private JugadorMaquina maquina;
	private PartidaService partidaService;
	private Partida partida;
	private int nroRonda;

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
		// Inicializar partida
		partidaService = new PartidaService();
		this.humano = new JugadorGUI();
		this.maquina = new JugadorMaquina(partidaService);
		this.partida = new Partida(humano, maquina, partidaService);
		this.nroRonda = 0;

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
		btnPiedra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				humano.setJugada(Jugada.PIEDRA);
				jugar();
			}
		});
		btnPiedra.setBounds(20, 256, 200, 29);
		contentPane.add(btnPiedra);

		btnPapel = new JButton("Papel");
		btnPapel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				humano.setJugada(Jugada.PAPEL);
				jugar();
			}
		});
		btnPapel.setBounds(240, 257, 200, 29);
		contentPane.add(btnPapel);

		btnTijera = new JButton("Tijera");
		btnTijera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				humano.setJugada(Jugada.TIJERA);
				jugar();
			}
		});
		btnTijera.setBounds(460, 257, 200, 29);
		contentPane.add(btnTijera);

		lblMaquinaEligio = new JLabel("Maquina eligio: ");
		lblMaquinaEligio.setBounds(20, 320, 645, 16);
		contentPane.add(lblMaquinaEligio);

		lblGanador = new JLabel("Ganador: ");
		lblGanador.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblGanador.setBounds(20, 360, 640, 80);
		contentPane.add(lblGanador);
		
		chckbxModoOscuro = new JCheckBox("Modo Oscuro");
		chckbxModoOscuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aplicarModoOscuro(chckbxModoOscuro.isSelected());
			}
		});
		chckbxModoOscuro.setBounds(532, 455, 128, 23);
		contentPane.add(chckbxModoOscuro);

	}
	
	private void jugar() {
		Object[] resultado = this.partida.jugarConRtaMaquina();
		nroRonda += 1;
		
		Jugada jugadaMaquina = (Jugada) resultado[1];
		lblMaquinaEligio.setText("Maquina eligio: " + jugadaMaquina);
		
		IJugador ganador = (IJugador) resultado[0];
		if (ganador == null) {
			lblGanador.setText("Ronda " + nroRonda + ": EMPATE");
		} else if (ganador instanceof JugadorGUI) {
			lblGanador.setText("Ronda " + nroRonda + ": GANA HUMANO");
		} else {
			lblGanador.setText("Ronda " + nroRonda + ": GANA MAQUINA");
		}
		
	}
	
	private void aplicarModoOscuro(boolean activado) {
	    Color fondo;
	    Color texto;
	    if (activado) {
	        fondo = new Color(30, 30, 30);
	        texto = new Color(230, 230, 230);
	    } else {
	        fondo = UIManager.getColor("Panel.background");
	        texto = UIManager.getColor("Label.foreground");
	    }

	    contentPane.setBackground(fondo);
	    btnPiedra.setForeground(texto);
	    btnPapel.setForeground(texto);
	    btnTijera.setForeground(texto);
	    
	    lblMaquinaEligio.setForeground(texto);
	    lblGanador.setForeground(texto);
	    chckbxModoOscuro.setForeground(texto);
	}
}
