package animaleshilos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConHilos extends JFrame {

    private JPanel[] pnAnimales;
    private JLabel[] lbAnimales;
    private String[] nombres = {"conejo", "tortuga", "zorro"};
    private JButton btnIniciar;
    private int limite;
    private Animal a;

    public ConHilos() throws HeadlessException {
        this.setDefaultCloseOperation(3);
        this.setBounds(200, 250, 700, 500);
        this.setVisible(true);

        pnAnimales = new JPanel[3];
        lbAnimales = new JLabel[3];

        this.setLayout(new GridLayout(0, 1));
        for (int i = 0; i < 3; i++) {
            pnAnimales[i] = new JPanel();
            this.add(pnAnimales[i]);
            lbAnimales[i] = new JLabel(nombres[i]);
            lbAnimales[i].setIcon(new ImageIcon("src/img/"+nombres[i]+".gif"));
            lbAnimales[i].setLocation(0, 0);
            pnAnimales[i].setLayout(new BorderLayout());
            pnAnimales[i].add(lbAnimales[i], BorderLayout.WEST);
            limite = this.getWidth();
        }
        

        btnIniciar = new JButton("Comenzar");
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Comienza");
                Animal conejo = new Animal("Conejo", limite - 100, lbAnimales[0]);
                Animal tortuga = new Animal("Tortuga", limite - 100, lbAnimales[1]);
                Animal zorro = new Animal("Zorro", limite - 100, lbAnimales[2]);

                conejo.start();
                tortuga.start();
                zorro.start();

            }
        });
        this.add(btnIniciar);
        this.pack();
        this.setBounds(200, 250, 700, 500);
    }

    public static void main(String[] args) {
        new ConHilos();
    }

}
