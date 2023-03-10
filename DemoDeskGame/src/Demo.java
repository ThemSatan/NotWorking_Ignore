import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo extends JFrame {

    private JFileChooser chooser = new JFileChooser(".");
    private JPanel panelMain;
    private JRadioButton rateButton1;
    private JRadioButton rateButton2;
    private JRadioButton rateButton3;
    private JCheckBox ownedButton;
    private JTextField nameArea;
    private JButton previousButton;
    private JButton nextButton;
    private JButton loadButton;

    private List<String> seznamDeskovek = new ArrayList<>();
    private int aktualniDeskovka = 0;

    public Demo() {
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(
                        nextButton,
                        "message"
                );
            }
        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void dalsiDeskovka() {
        int pocetDeskovek = seznamDeskovek.size();
        if (pocetDeskovek == 0) {
            aktualniDeskovka = 0;
            return;
        }
        aktualniDeskovka++;
        if (aktualniDeskovka >= pocetDeskovek) {
            aktualniDeskovka = 0;
            return;
        }
        zobrazAktualniDeskovku();
    }

    private void InitComponents() {
        loadButton.addActionListener(e -> readFromFile());

    }

    private void zobrazAktualniDeskovku() {
        if (seznamDeskovek.size() == 0) {
            nameArea.setText("-- V seznamu nic není");
        } else {
            nameArea.setText(seznamDeskovek.get(aktualniDeskovka));
        }
    }

    private void readFromFile() {
        int result = chooser.showOpenDialog(this);
        //Klikl uzivatel na Open? pokud ano tak zpracuje udalost e v e n t:
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            JOptionPane.showMessageDialog(
                    this,
                    "Uživatel zvolil soubor: " + selectedFile.getAbsoluteFile()
            );
            try (Scanner scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(selectedFile)
                    )
            )) {
            } catch (
                    FileNotFoundException e) {
                throw new RuntimeException();
            }
        }
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        d.setTitle("Test - Radio buttons a uhm check buton");
        d.setContentPane(d.panelMain);
        d.setSize(500, 500);
        d.setVisible(true);
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
