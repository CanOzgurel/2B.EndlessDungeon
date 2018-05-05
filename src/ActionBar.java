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
        itemsButton = new JButton("Items");
        
        	skills.add(new JButton("Skill1"));
        	skills.add(new JButton("Skill2"));
        	skills.add(new JButton("Skill3"));
//        }else if(ObjectHandler.getInstance().getPlayer().getPlayerType().getType() == "Assassin") {
//        	skills.add(new JButton("rogueSkill1"));
//        	skills.add(new JButton("rogueSkill2"));
//        	skills.add(new JButton("rogueSkill3"));
//        }
//        else if(ObjectHandler.getInstance().getPlayer().getPlayerType().getType() == "Mage") {
//        	skills.add(new JButton("mageSkill1"));
//        	skills.add(new JButton("mageSkill2"));
//        	skills.add(new JButton("mageSkill3"));
//        }

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
        this.add(itemsButton);
        this.add(skills.get(0));
        this.add(skills.get(1));
        this.add(skills.get(2));
    }
}
