package animaleshilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Animal extends Thread {

    private String nombre;
    private int limite;
    private JLabel animal;
    private int pos;

    public Animal(String nombre, int limite, JLabel animal) {
        this.nombre = nombre;
        this.limite = limite;
        this.animal = animal;
        pos = 0;
    }

    @Override
    public void run() {
        super.run();
        while (limite > animal.getX() + pos) {
            animal.setLocation(animal.getX() + pos, animal.getY());
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
            }
            pos++;
        }
        System.out.println(nombre+" llegó a la meta");
    }

}
