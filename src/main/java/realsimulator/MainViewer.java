package realsimulator;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

/**
 * Created by User on 11/11/2017.
 */
public class MainViewer {

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    public static void createAndShowGUI(){
        //Create and set up the window.
        JFrame frame = new JFrame("REMOTE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private static void addComponentsToPane(Container pane) {

        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        pane.setLayout(new GridBagLayout());
        JFrame frame = new JFrame();
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            c.fill = GridBagConstraints.HORIZONTAL;
        }

        JLabel OTlabel =new JLabel("Outside Temperature (°C)");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.weightx = 1;
        c.gridy = 0;
        OTlabel.setFont(new Font("Arial", Font.PLAIN, 14));
        pane.add(OTlabel,c);

        JSlider slider = new JSlider();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.weightx = 1;
        c.gridy = 1;
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        Hashtable position = new Hashtable();
        position.put(0, new JLabel("-10"));
        position.put(20, new JLabel("0"));
        position.put(40, new JLabel("10"));
        position.put(60, new JLabel("20"));
        position.put(80, new JLabel("30"));
        position.put(100, new JLabel("40"));
        slider.setLabelTable(position);
        pane.add(slider, c);

        JLabel WSlabel =new JLabel("Wind Speed (KM/H)");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.weightx = 1;
        c.gridy = 2;
        WSlabel.setFont(new Font("Arial", Font.PLAIN, 14));
        pane.add(WSlabel,c);

        JSlider slider1 = new JSlider();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.weightx = 1;
        c.gridy = 3;
        slider1.setMajorTickSpacing(20);
        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        Hashtable position1 = new Hashtable();
        position1.put(0, new JLabel("0"));
        position1.put(20, new JLabel("20"));
        position1.put(40, new JLabel("40"));
        position1.put(60, new JLabel("60"));
        position1.put(80, new JLabel("80"));
        position1.put(100, new JLabel("100"));
        slider1.setLabelTable(position1);
        pane.add(slider1, c);


    }
}
