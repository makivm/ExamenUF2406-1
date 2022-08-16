package vistas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Envio;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraEnvios extends JFrame {

	private JPanel contentPane;
	private JTextField textOrigen;
	private JTextField textDestino;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton rdbtnOExtranjero,rdbtnDExtranjero;
	private JComboBox comboBoxTipo;
	private JSpinner spinnerPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraEnvios frame = new CalculadoraEnvios();
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
	public CalculadoraEnvios() {
		setTitle("Calculadora envíos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][163.00,grow]", "[grow,fill][grow,fill][grow,fill][grow,fill][grow,fill][grow,fill][][]"));
		
		JLabel lblNewLabel_4 = new JLabel("Ciudad Origen:");
		contentPane.add(lblNewLabel_4, "flowy,cell 0 0,alignx trailing");
		
		textOrigen = new JTextField();
		contentPane.add(textOrigen, "cell 1 0,growx");
		textOrigen.setColumns(10);
		
		JRadioButton rdbtnONacional = new JRadioButton("Nacional");
		buttonGroup.add(rdbtnONacional);
		rdbtnONacional.setSelected(true);
		contentPane.add(rdbtnONacional, "flowx,cell 1 1");
		
		JLabel lblNewLabel_5 = new JLabel("Ciudad Destino:");
		contentPane.add(lblNewLabel_5, "cell 0 2,alignx trailing");
		
		textDestino = new JTextField();
		contentPane.add(textDestino, "cell 1 2,growx");
		textDestino.setColumns(10);
		
		JRadioButton rdbtnDNacional = new JRadioButton("Nacional");
		buttonGroup_1.add(rdbtnDNacional);
		rdbtnDNacional.setSelected(true);
		contentPane.add(rdbtnDNacional, "flowx,cell 1 3");
		
		JLabel lblNewLabel = new JLabel("Tipo de envío:");
		contentPane.add(lblNewLabel, "cell 0 4");
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Paq 10- Antes de las 10h", "Paq 14- Antes de las 14h", "Paq 24- Al día siguiente"}));
		contentPane.add(comboBoxTipo, "cell 1 4,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Peso:");
		contentPane.add(lblNewLabel_1, "cell 0 5");
		
		rdbtnDExtranjero = new JRadioButton("Extranjero");
		buttonGroup_1.add(rdbtnDExtranjero);
		contentPane.add(rdbtnDExtranjero, "cell 1 3");
		
		rdbtnOExtranjero = new JRadioButton("Extranjero");
		buttonGroup.add(rdbtnOExtranjero);
		contentPane.add(rdbtnOExtranjero, "cell 1 1");
		
		spinnerPeso = new JSpinner();
		spinnerPeso.setModel(new SpinnerNumberModel(1, 1, 40, 1));
		contentPane.add(spinnerPeso, "cell 1 5");
		
		JButton btnCalcular = new JButton("Calcular Precio");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validar();
			}
		});
		contentPane.add(btnCalcular, "cell 0 7 2 1,alignx center");
	}

	protected void validar() {
		
		if(textOrigen.getText()==null||textOrigen.getText().isBlank() || 
				textDestino.getText()==null||textDestino.getText().isBlank()  ) {
			JOptionPane.showMessageDialog(this, "Debe introducir los campos ciudad Origen y ciudad Destino."," Compruebe los datos", JOptionPane.WARNING_MESSAGE);
			return;	
		}
		String origen= textOrigen.getText();
		boolean tipoON=true;
		
		if(rdbtnOExtranjero.isSelected()) {
			tipoON=false;
		}
		
		String destino= textDestino.getText();
		boolean tipoDN=true;
	
		if(rdbtnDExtranjero.isSelected()) {
			tipoDN=false;
		}
		
		String tipoenvio=(String)comboBoxTipo.getSelectedItem();
		
		int peso=(int) spinnerPeso.getValue();
		
		Envio envio=new Envio(origen, tipoON, destino, tipoDN, tipoenvio, peso);
		
		JOptionPane.showMessageDialog(this, "El importe total es: "+envio.calcularImporte()," Importe Total", JOptionPane.WARNING_MESSAGE);
	}

}
