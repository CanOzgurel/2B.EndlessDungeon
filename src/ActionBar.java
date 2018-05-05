import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActionBar extends JPanel {
    private JButton attackButton,itemsButton;
    private ArrayList<JButton> skills = new ArrayList<JButton>();
    private int i =0;

    public ActionBar() {
        attackButton = new JButton("Attack");

        skills.add(new JButton("Sacred Sword"));
        skills.add(new JButton("Fireball"));
        skills.add(new JButton("Frost Nova"));

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().managePlayerAttacks(0);
            }
        });

        skills.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().managePlayerAttacks(1);
            }
        });

        skills.get(1).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().managePlayerAttacks(2);
            }
        });

        skills.get(2).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().managePlayerAttacks(3);
            }
        });


        setBackground(Color.GRAY);
        setLayout(new FlowLayout());
        this.add(attackButton);
        this.add(skills.get(0));
        this.add(skills.get(1));
        this.add(skills.get(2));
    }
}