/*
 * Created by JFormDesigner on Sat Jul 29 19:31:47 PDT 2023
 */

package org.me.music.ui;

import java.awt.BorderLayout;
import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Lauren
 */
public class ImportDialog extends JDialog {
    public ImportDialog(Window owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Lauren Klein (Lauren E Klein)
        panel1 = new ImportPanel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- panel1 ----
        panel1.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(panel1, BorderLayout.CENTER);
        setSize(500, 450);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Lauren Klein (Lauren E Klein)
    private ImportPanel panel1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
