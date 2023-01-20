package view;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
				setarData();
			}
		});
		setTitle("Carômetro");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/favicon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 172, 379, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Main.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(334, 8, 32, 32);
		panel.add(lblStatus);
		
		lblData = new JLabel("");
		lblData.setForeground(SystemColor.text);
		lblData.setHorizontalAlignment(SwingConstants.LEFT);
		lblData.setBounds(10, 22, 245, 14);
		panel.add(lblData);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro cadastro = new Cadastro();
				cadastro.setVisible(true);
			}
		});
		btnAdicionar.setToolTipText("Adicionar aluno(a)");
		btnAdicionar.setIcon(new ImageIcon(Main.class.getResource("/img/foto.png")));
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setBounds(37, 22, 128, 128);
		contentPane.add(btnAdicionar);
		
		JButton btnCarometro = new JButton("");
		btnCarometro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carometro carometro = new Carometro();
				carometro.setVisible(true);
			}
		});
		btnCarometro.setIcon(new ImageIcon(Main.class.getResource("/img/students.png")));
		btnCarometro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCarometro.setToolTipText("Carômetro");
		btnCarometro.setBounds(212, 22, 128, 128);
		contentPane.add(btnCarometro);
	}//fim do construtor
	
	DAO dao = new DAO();
	private JLabel lblData;
	
	private void status() {
		try {
			Connection con = dao.conectar();			
			if (con == null) {
				lblStatus.setIcon(new ImageIcon(Main.class.getResource("/img/dboff.png")));				
			} else {
				lblStatus.setIcon(new ImageIcon(Main.class.getResource("/img/dbon.png")));				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void setarData() {
		Date data = new Date();
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		lblData.setText(formatador.format(data));
	}
}//fim do código
