import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class gameGUI extends JPanel{

    JButton buttons[] = new JButton[9];

    public gameGUI (){
        setLayout(new GridLayout(3,3));
        createGrid();

    }
    public void createGrid(){

        for (int i = 8; i >= 0; i--){
            buttons[8 - i] = new JButton();
            buttons[8 - i].setToolTipText(" ");
            buttons[8 - i].addActionListener(new buttonListener());

            add(buttons[8 - i]);


        }
    }

    public void updateButton(String token, int buttonNumber){
        buttons[buttonNumber].setToolTipText(token);
    }

    public void resetGrid(){
        for (int i = 8; i >= 0; i--)
            buttons[i].setToolTipText(" ");
    }

    public class buttonListener implements ActionListener {

        int alternate = 0;

        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource(); //get the particular button that was clicked

            for (int i = 8; i >= 0; i--){
                if (buttonClicked == buttons[i])
                    return i;
            }
        }
    }

/*            if (alternate % 2 == 0)
                buttonClicked.setText("X");
            else
                buttonClicked.setText("O");

            if (checkForWin() == true) {
                JOptionPane.showConfirmDialog(null, "Game Over.");
                resetButtons();
            }

            alternate++;

        }
    }
/*    public class buttonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JButton buttonClicked = (JButton)e,getSource;
        }

  } */

}
