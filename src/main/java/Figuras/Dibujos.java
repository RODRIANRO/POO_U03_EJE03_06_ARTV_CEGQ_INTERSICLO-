/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Figuras;

//import VentanaDibujo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;


/**
 *
 * @author NOTEBOOK
 */
public class Dibujos extends JFrame implements ActionListener{
    
    private JPanel Panel1;
    private JPanel Panel2;
    private JPanel Panel3;
    private JPanel Panelcolor;
    private VentanaDibujo Panel4;
    private ArrayList<JLabel> labelList;
    private JTextField jTextFieldHeight;
    private JTextField jTextFieldWidth;
    private JComboBox jComboBoxFigure;
    private JComboBox jComboBoxColors;
    private JButton jButtonDraw;
    private JButton jButtonClear;
    

    public Dibujos (String title) {
        super(title);
        this.setSize(400, 600);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        initComponents();
        jButtonDraw.addActionListener(this);
        jButtonClear.addActionListener(this);
        
        
    }
    
    private void initComponents(){
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        Panel1 = new JPanel();
        Panelcolor = new JPanel();
        Panel2 = new JPanel();
        Panel3 = new JPanel();
        
        Panel4 = new VentanaDibujo(new Figura(0, Color.WHITE, 0, 0));
        Panel4.setBorder(new TitledBorder(""));
        Panel4.setPreferredSize(new Dimension(200,300));
        //drawPanel.setBackground(Color.WHITE);
        
        getContentPane().add(Panel1);
        Panel1.add(Panelcolor);
        Panel1.add(Panel2);
        Panel1.add(Panel3);
        
        getContentPane().add(Panel4);
        
        initLabels();
        initTextFields();
        initComboBox();
        initButtons();
        
        setPanels();
        
    }
    
    private void setPanels(){
       Panelcolor.add(labelList.get(0));
       Panelcolor.add(jComboBoxFigure);
       Panelcolor.add(labelList.get(1));
       Panelcolor.add(jComboBoxColors);
       
       Panel2.add(labelList.get(2));
       Panel2.add(labelList.get(3));
       Panel2.add(jTextFieldHeight);
       Panel2.add(labelList.get(4));
       Panel2.add(jTextFieldWidth);
       
       Panel3.add(jButtonDraw);
       Panel3.add(jButtonClear);
        
    }
    
    private void initLabels(){
        labelList = new ArrayList<>();
       
        labelList.add(new JLabel("FIGURA"));
        labelList.add(new JLabel("COLOR"));
        labelList.add(new JLabel("TAMAÑO:"));
        labelList.add(new JLabel("ALTO"));
        labelList.add(new JLabel("ANCHO"));
        
        
    }
    
    private void initTextFields(){
        
        
        jTextFieldHeight = new JTextField(3);
        jTextFieldHeight.setText("");
        jTextFieldWidth = new JTextField(3);
        jTextFieldWidth.setText("");
    }
    
    private void initComboBox(){
        
        jComboBoxColors = new JComboBox();
        jComboBoxFigure = new JComboBox();
        
        jComboBoxFigure.addItem("CIRCULO");
        jComboBoxFigure.addItem("ESTRELLA");
        jComboBoxFigure.addItem("CUADRADO");
        jComboBoxFigure.addItem("RECTANGULO");
        jComboBoxFigure.addItem("TRIANGULO");
        
        jComboBoxColors.addItem("AMARILLO");
        jComboBoxColors.addItem("AZUL");
        jComboBoxColors.addItem("ROJO");
        jComboBoxColors.addItem("VERDE");
        
    }
    
    private void initButtons(){
        jButtonClear = new JButton("BORRAR");
        jButtonDraw = new JButton("GRAFICAR");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jButtonDraw == e.getSource()) {
            getData();
            getColors();
          

        } else{
            
            Panel4.getFigura().setHeight(0);
            Panel4.getFigura().setWidth(0);
            Panel4.repaint();
        }
        
        
      }
    private void getData(){ 
        Panel4.getFigura().setFigura(jComboBoxFigure.getSelectedIndex());
        Panel4.getFigura().setHeight(Integer.parseInt(jTextFieldHeight.getText()));
        Panel4.getFigura().setWidth(Integer.parseInt(jTextFieldWidth.getText()));
              
    }
    private void getColors(){
        if (jComboBoxColors.getSelectedItem().equals("AMARILLO")) {
            Panel4.getFigura().setColor(Color.YELLOW);
        }
        if (jComboBoxColors.getSelectedItem().equals("AZUL")) {
            Panel4.getFigura().setColor(Color.BLUE);
        }
        if (jComboBoxColors.getSelectedItem().equals("ROJO")) {
            Panel4.getFigura().setColor(Color.RED);
        }
        if (jComboBoxColors.getSelectedItem().equals("VERDE")) {
            Panel4.getFigura().setColor(Color.GREEN);
        }
    }
    
    }

















