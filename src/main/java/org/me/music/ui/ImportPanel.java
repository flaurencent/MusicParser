/*
 * Created by JFormDesigner on Sat Jul 29 18:44:57 PDT 2023
 */

package org.me.music.ui;

import org.me.music.io.ImportManager;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lauren
 */
public class ImportPanel extends JPanel {

    public ImportPanel() {
        initComponents();
        initDataModels();
    }

    public void initDataModels() {
        updateFirstValues();
    }

    private void updateFirstValues() {
        int base = (int) baseSpinner.getModel().getValue();
        int secondPowerValue = (int) secondPowerSpinner.getModel().getValue();
        int firstPowerValue = (int) firstPowerSpinner.getModel().getValue();
        int shiftValue = (int) shiftValueSpinner.getModel().getValue();
        int mod = (int) modSpinner.getModel().getValue();

        List<String> values = new ArrayList<>();
        Integer currentValue = base;
        String currentStringValue = String.valueOf(base);
        for (int i = 1; i < 100; i++) {
            values.add(currentStringValue);
            currentValue = secondPowerValue * ((int) Math.pow(currentValue, 2)) +
                    firstPowerValue * currentValue
                    - shiftValue;

            if (mod != 0) {
                currentValue = currentValue % mod;
            }
            currentStringValue = String.valueOf(currentValue);
        }

        firstValuesTextPane.setText(String.join(", ", values));
    }

    private void formulaSpinnerActionPerformed() {
        updateFirstValues();
    }

    private void chooseFileButtonActionPerformed() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showDialog(this, "Choose");
        File selectedFile = fileChooser.getSelectedFile();
        fileField.setText(selectedFile.getAbsolutePath());
        playFileButton.setEnabled(!fileField.getText().isBlank());
    }

    private void playFileButtonActionPerformed() {
        int type;
        switch (playTypeComboBox.getItemAt(playTypeComboBox.getSelectedIndex())) {
            case "Base":
                type = 1;
                break;
            case "Rotational Map":
                type = 2;
                break;
            case "Mod 89 Map":
                type = 3;
                break;
            case "Shifted Rotational Map":
                type = 4;
                break;
            default:
                type = 1;
                break;
        }

        ImportManager.getInstance().playFile(fileField.getText(), type);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Lauren Klein (Lauren E Klein)
        option1Panel = new JPanel();
        option1Label = new JLabel();
        fileField = new JTextField();
        chooseFileButton = new JButton();
        playTypeComboBox = new JComboBox<>();
        playFileButton = new JButton();
        label5 = new JLabel();
        option2Panel = new JPanel();
        option2Label = new JLabel();
        baseLabel = new JLabel();
        baseSpinner = new JSpinner();
        label1 = new JLabel();
        secondPowerSpinner = new JSpinner();
        panel1 = new JPanel();
        label3 = new JLabel();
        firstPowerSpinner = new JSpinner();
        label4 = new JLabel();
        shiftValueSpinner = new JSpinner();
        label2 = new JLabel();
        modSpinner = new JSpinner();
        middleCLabel = new JLabel();
        firstValuesLabel = new JLabel();
        firstValuesScrollPane = new JScrollPane();
        firstValuesTextPane = new JTextPane();

        //======== this ========
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 55, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

        //======== option1Panel ========
        {
            option1Panel.setBorder(new CompoundBorder(
                new TitledBorder("Option 1"),
                new EmptyBorder(5, 5, 5, 5)));
            option1Panel.setLayout(new GridBagLayout());
            ((GridBagLayout)option1Panel.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
            ((GridBagLayout)option1Panel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
            ((GridBagLayout)option1Panel.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
            ((GridBagLayout)option1Panel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- option1Label ----
            option1Label.setText("Choose an existing file to play in the specified format.");
            option1Panel.add(option1Label, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- fileField ----
            fileField.setText("C:\\\\Users\\\\Lauren\\\\Repositories\\\\MusicParser\\\\src\\\\main\\\\resources\\\\sampleNotes.txt");
            option1Panel.add(fileField, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- chooseFileButton ----
            chooseFileButton.setText("Choose");
            chooseFileButton.addActionListener(e -> chooseFileButtonActionPerformed());
            option1Panel.add(chooseFileButton, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- playTypeComboBox ----
            playTypeComboBox.setModel(new DefaultComboBoxModel<>(new String[] {
                "Base",
                "Rotational Map",
                "Mod 89 Map",
                "Shifted Rotational Map"
            }));
            option1Panel.add(playTypeComboBox, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- playFileButton ----
            playFileButton.setText("Play");
            playFileButton.addActionListener(e -> playFileButtonActionPerformed());
            option1Panel.add(playFileButton, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label5 ----
            label5.setText("Shifting by 41 to get to middle C.");
            option1Panel.add(label5, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));
        }
        add(option1Panel, new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== option2Panel ========
        {
            option2Panel.setBorder(new CompoundBorder(
                new TitledBorder("Option 2"),
                new EmptyBorder(5, 5, 5, 5)));
            option2Panel.setLayout(new GridBagLayout());
            ((GridBagLayout)option2Panel.getLayout()).columnWidths = new int[] {0, 0, 55, 0, 0};
            ((GridBagLayout)option2Panel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
            ((GridBagLayout)option2Panel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0, 1.0E-4};
            ((GridBagLayout)option2Panel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};

            //---- option2Label ----
            option2Label.setText("Generate custom sequences.");
            option2Panel.add(option2Label, new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- baseLabel ----
            baseLabel.setText("Base:");
            option2Panel.add(baseLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- baseSpinner ----
            baseSpinner.setModel(new SpinnerNumberModel(19, 1, 100, 1));
            baseSpinner.addChangeListener(e -> formulaSpinnerActionPerformed());
            option2Panel.add(baseSpinner, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- label1 ----
            label1.setText("Formula");
            option2Panel.add(label1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- secondPowerSpinner ----
            secondPowerSpinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
            secondPowerSpinner.addChangeListener(e -> formulaSpinnerActionPerformed());
            option2Panel.add(secondPowerSpinner, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== panel1 ========
            {
                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {47, 0, 0, 50, 0};
                ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- label3 ----
                label3.setText("x^2 +");
                panel1.add(label3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- firstPowerSpinner ----
                firstPowerSpinner.setModel(new SpinnerNumberModel(1, 1, 100, 1));
                firstPowerSpinner.addChangeListener(e -> formulaSpinnerActionPerformed());
                panel1.add(firstPowerSpinner, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- label4 ----
                label4.setText("x +");
                panel1.add(label4, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- shiftValueSpinner ----
                shiftValueSpinner.setModel(new SpinnerNumberModel(-619, -999, 999, 1));
                shiftValueSpinner.addChangeListener(e -> formulaSpinnerActionPerformed());
                panel1.add(shiftValueSpinner, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            option2Panel.add(panel1, new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- label2 ----
            label2.setText("Mod");
            option2Panel.add(label2, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- modSpinner ----
            modSpinner.setModel(new SpinnerNumberModel(89, 0, 999, 1));
            modSpinner.addChangeListener(e -> formulaSpinnerActionPerformed());
            option2Panel.add(modSpinner, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //---- middleCLabel ----
            middleCLabel.setText("MIDI Middle C is: 60");
            option2Panel.add(middleCLabel, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- firstValuesLabel ----
            firstValuesLabel.setText("First 100 values:");
            option2Panel.add(firstValuesLabel, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

            //======== firstValuesScrollPane ========
            {
                firstValuesScrollPane.setViewportView(firstValuesTextPane);
            }
            option2Panel.add(firstValuesScrollPane, new GridBagConstraints(0, 5, 4, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(option2Panel, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Lauren Klein (Lauren E Klein)
    private JPanel option1Panel;
    private JLabel option1Label;
    private JTextField fileField;
    private JButton chooseFileButton;
    private JComboBox<String> playTypeComboBox;
    private JButton playFileButton;
    private JLabel label5;
    private JPanel option2Panel;
    private JLabel option2Label;
    private JLabel baseLabel;
    private JSpinner baseSpinner;
    private JLabel label1;
    private JSpinner secondPowerSpinner;
    private JPanel panel1;
    private JLabel label3;
    private JSpinner firstPowerSpinner;
    private JLabel label4;
    private JSpinner shiftValueSpinner;
    private JLabel label2;
    private JSpinner modSpinner;
    private JLabel middleCLabel;
    private JLabel firstValuesLabel;
    private JScrollPane firstValuesScrollPane;
    private JTextPane firstValuesTextPane;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
