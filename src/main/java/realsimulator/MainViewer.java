package realsimulator;

import models.TemperatureActor;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

/**
 * Created by User on 11/11/2017.
 */
public class MainViewer {

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    static MainController mc;

    static final int temp_MIN = -10;
    static final int temp_MAX = 40;
    static final int temp_INIT = MainController.STARTING_TEMPERATURE;

    static final int itemp_MIN = 15;
    static final int itemp_MAX = 30;
    static final int itemp_INIT = 22;

    static String strawString = "Straw";
    static String stickString = "Stick";
    static String brickString = "Brick";

    static String openString = "open";
    static String halfString = "half";
    static String closeString = "close";

    static final int itemp_INIT = TemperatureActor.STARTING_TEMPERATURE;

    public static void setMc(MainController mc) {
        MainViewer.mc = mc;
    }

    static final JLabel timeLabel = new JLabel();

    public static void createAndShowGUI(){
        //Create and set up the window.
        JFrame frame = new JFrame("REMOTE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setSize(850,250);
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

        JLabel AClabel =new JLabel("AC Temperature (°C)");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.weightx = 1;
        c.gridy = 0;
        AClabel.setFont(new Font("Arial", Font.PLAIN, 14));
        pane.add(AClabel,c);
        AClabel.setFont(new Font("Arial", Font.PLAIN, 14));
        pane.add(AClabel,c);

        JLabel ITlabel =new JLabel("Inside Temperature (°C)");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.weightx = 1;
        c.gridy = 0;
        ITlabel.setFont(new Font("Arial", Font.PLAIN, 14));
        pane.add(ITlabel,c);

        final JSlider OTslider = new JSlider(JSlider.HORIZONTAL, temp_MIN, temp_MAX, temp_INIT);
        JLabel ITemp =new JLabel();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.weightx = 1;
        c.gridy = 1;
        ITemp.setFont(new Font("Arial", Font.PLAIN, 14));
        pane.add(ITemp,c);

        JSlider OTslider = new JSlider(JSlider.HORIZONTAL, temp_MIN, temp_MAX, temp_INIT);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.weightx = 1;
        c.gridy = 1;
        OTslider.setMajorTickSpacing(10);
        OTslider.setPaintTicks(true);
        OTslider.setPaintLabels(true);
        pane.add(OTslider, c);

        final JSlider ACslider = new JSlider(JSlider.HORIZONTAL, itemp_MIN, itemp_MAX, itemp_INIT);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.weightx = 1;
        c.gridy = 1;
        ACslider.setMajorTickSpacing(3);
        ACslider.setPaintTicks(true);
        ACslider.setPaintLabels(true);
        pane.add(ACslider, c);

        JLabel WSlabel =new JLabel("Wind Speed (KM/H)");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.weightx = 1;
        c.gridy = 2;
        WSlabel.setFont(new Font("Arial", Font.PLAIN, 14));
        pane.add(WSlabel,c);

        JLabel Wlabel =new JLabel("Wall Type");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.weightx = 1;
        c.gridy = 2;
        Wlabel.setFont(new Font("Arial", Font.PLAIN, 14));
        pane.add(Wlabel,c);

        final JSlider WSslider = new JSlider();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.weightx = 1;
        c.gridy = 3;
        WSslider.setMajorTickSpacing(20);
        WSslider.setPaintTicks(true);
        WSslider.setPaintLabels(true);
        Hashtable position1 = new Hashtable();
        position1.put(0, new JLabel("0"));
        position1.put(20, new JLabel("20"));
        position1.put(40, new JLabel("40"));
        position1.put(60, new JLabel("60"));
        position1.put(80, new JLabel("80"));
        position1.put(100, new JLabel("100"));
        WSslider.setValue(MainController.STARTING_WINDSPEED);
        WSslider.setLabelTable(position1);
        pane.add(WSslider, c);


        JRadioButton strawButton = new JRadioButton(strawString);
        strawButton.setMnemonic(KeyEvent.VK_B);
        strawButton.setActionCommand(strawString);
        strawButton.setSelected(true);

        JRadioButton stickButton = new JRadioButton(stickString);
        stickButton.setMnemonic(KeyEvent.VK_C);
        stickButton.setActionCommand(stickString);

        JRadioButton brickButton = new JRadioButton(brickString);
        brickButton.setMnemonic(KeyEvent.VK_D);
        brickButton.setActionCommand(brickString);

        ButtonGroup group = new ButtonGroup();
        group.add(strawButton);
        group.add(stickButton);
        group.add(brickButton);

        c.gridx = 1;
        c.gridy = 3;

        pane.add(strawButton, c);
        c.gridx = 2;
        c.gridy = 3;
        pane.add(stickButton, c);
        c.gridx = 3;
        c.gridy = 3;
        pane.add(brickButton, c);


//        Date date = new Date();
//        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.MINUTE);
//
//        final JSpinner timeSpinner = new JSpinner(sm);
//        final JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
//        timeEditor.getTextField().setEditable( false );
//        timeSpinner.setEditor(timeEditor);



        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 4;
        pane.add(timeLabel, c);


        JButton SP = new JButton("Set Parameter");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 5;
        pane.add(SP, c);

        JLabel Blabel =new JLabel("Blind Configuration");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.weightx = 1;
        c.gridy = 4;
        Blabel.setFont(new Font("Arial", Font.PLAIN, 14));
        pane.add(Blabel,c);

        class OTSliderChange implements ChangeListener {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int fps = (int)source.getValue();
                    System.out.println(fps);
                    mc.setOutsideTemperature(fps);
                }
            }
        }
        JRadioButton openButton = new JRadioButton(openString);
        strawButton.setMnemonic(KeyEvent.VK_B);
        strawButton.setActionCommand(openString);
        strawButton.setSelected(true);

        JRadioButton halfButton = new JRadioButton(halfString);
        stickButton.setMnemonic(KeyEvent.VK_C);
        stickButton.setActionCommand(halfString);

        JRadioButton closeButton = new JRadioButton(closeString);
        brickButton.setMnemonic(KeyEvent.VK_D);
        brickButton.setActionCommand(closeString);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(openButton);
        group1.add(halfButton);
        group1.add(closeButton);

        c.gridx = 1;
        c.gridy = 5;

        pane.add(openButton, c);
        c.gridx = 2;
        c.gridy = 5;
        pane.add(halfButton, c);
        c.gridx = 3;
        c.gridy = 5;
        pane.add(closeButton, c);



        class ACSliderChange implements ChangeListener {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int fps = (int)source.getValue();
                    mc.setACTemperature(fps);
                }
            }
        }

        class WSSliderChange implements ChangeListener {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int fps = (int)source.getValue();
                    mc.setOutsideWindSpeed(fps);
                }
            }
        }

        OTslider.addChangeListener(new OTSliderChange());
        WSslider.addChangeListener(new WSSliderChange());
        ACslider.addChangeListener(new ACSliderChange());

        class calculateListener1 implements ActionListener{
            public void actionPerformed(ActionEvent event){
                int temp = OTslider.getValue();
                int wind = WSslider.getValue();
                int ac = ACslider.getValue();
//                Object timetemp = timeSpinner.getValue();
//                SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//                String time = format.format(date);

                String time = timeEditor.getFormat().format(timeSpinner.getValue());


                System.out.println(temp);
                System.out.println(wind);
                System.out.println(time);


            }
        }

        ActionListener listener1 = new calculateListener1();
        SP.addActionListener(listener1);
    }

    public void setTime(String time){
        timeLabel.setText(time);
    }

}
