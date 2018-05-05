import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionBar extends JPanel {
    private JButton attackButton, skillsButton, itemsButton;

    public ActionBar() {
        attackButton = new JButton("Attack");
        skillsButton = new JButton("Skills");
        itemsButton = new JButton("Items");

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameManager.getInstance().managePlayerAttacks();
            }
        });

        setBackground(Color.GRAY);
        setLayout(new FlowLayout());
        this.add(attackButton);
        this.add(skillsButton);
        this.add(itemsButton);
    }
}
