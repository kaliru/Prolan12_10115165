package Object;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ObjectPanel {
    
    public void limp_text(JPanel panel){
        for(int i = 0; panel.getComponents().length > i; i++){
            if(panel.getComponents()[i] instanceof JTextField){
                ((JTextField)panel.getComponents()[i]).setText("");
            }
            else if(panel.getComponents()[i] instanceof JPasswordField){
                ((JPasswordField)panel.getComponents()[i]).setText("");
            }else if(panel.getComponents()[i] instanceof JComboBox){
                ((JComboBox)panel.getComponents()[i]).setSelectedIndex(0);
            }
        }
    }
    
}
