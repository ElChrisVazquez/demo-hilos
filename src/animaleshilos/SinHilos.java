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

public class SinHilos extends JFrame {

    private JPanel[] pnAnimales;
    private JLabel[] lbAnimales;
    private String[] nombres = {"conejo", "tortuga", "zorro"};
    private JButton btnIniciar;
    private int limite;
    private Animal a;

    public SinHilos() throws HeadlessException {
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
            System.out.println("" + pnAnimales[i].getX());
        }

        btnIniciar = new JButton("Comenzar");
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Comienza");
                for (int i = 0; i < lbAnimales.length; i++) {
                    for (int j = 0; j < limite - 100; j++) {
                        pnAnimales[i].setLocation(j, pnAnimales[i].getY());
                    }
                    System.out.println(nombres[i] + " llegó a la meta");
                }
            }
        });
        this.add(btnIniciar);
        this.pack();
        this.setBounds(200, 250, 700, 500);
    }

    public static void main(String[] args) {
        new SinHilos();
    }

}
