import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//imports for a gui

public class ShapeArray extends JFrame {//instructions for the window

    private JTextField sphereRadiusField, cylinderRadiusField, cylinderHeightField, coneRadiusField, coneHeightField;
    private JTextField sphereAreaField, cylinderAreaField, coneAreaField;
    private JTextField sphereVolumeField, cylinderVolumeField, coneVolumeField; // Tells whats going to be in the window

    public ShapeArray() {
        setTitle("Shape Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));//this  is my new friend grids out the window jpanel to say what
        //goes where


        // GridBag is a very useful tool it gives control to put what where
        JPanel inputPanel = new JPanel(new GridBagLayout());//GridBag is what I was looking for
        GridBagConstraints gbc = new GridBagConstraints();//these 2 lines determine the scope of where things will be
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 2; // ya gotta have x and y coordinates where things will be
        gbc.gridy = 0;// this first bit tells whats going on on the top of the window
        inputPanel.add(new JLabel("Area:"), gbc);//tells theres an area label at x2 y0
        gbc.gridx = 4; // tells theres going to be a volume label at x4 y0
        inputPanel.add(new JLabel("Volume:"), gbc);



        gbc.gridx = 0;//this is like the next line if everything was gridded out in the window
        gbc.gridy = 1;//this is the second line in the panel
        inputPanel.add(new JLabel("Sphere Radius:"), gbc);//this is the label at x0 y1 the second line
        gbc.gridx = 1;//this is the second block in the second space of the window
        sphereRadiusField = new JTextField(10);//this tells that a text box is gonna go here
        inputPanel.add(sphereRadiusField, gbc);//this is the name of the text box to collect the variable
        gbc.gridx = 2;//this is the third block in the second line of the window
        sphereAreaField = new JTextField(10);//an area output field goes here
        sphereAreaField.setEditable(false);//this means its just output and you cant enter any data in this
        inputPanel.add(sphereAreaField, gbc);//this tells what the text box is where it gets data from
        gbc.gridx = 4;//this is the 5th colum in the second line in the window if you could see the lines
        sphereVolumeField = new JTextField(10); //this outputs the volume data in uneditable textbox
        sphereVolumeField.setEditable(false);//not editable
        inputPanel.add(sphereVolumeField, gbc);//tells where it gets its data from
//all the above is the sphere part of the output
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Cylinder Radius:"), gbc);
        gbc.gridx = 1;
        cylinderRadiusField = new JTextField(10);
        inputPanel.add(cylinderRadiusField, gbc);
        gbc.gridx = 2;
        cylinderAreaField = new JTextField(10);
        cylinderAreaField.setEditable(false);
        inputPanel.add(cylinderAreaField, gbc);
        gbc.gridx = 4;
        cylinderVolumeField = new JTextField(10);
        cylinderVolumeField.setEditable(false);
        inputPanel.add(cylinderVolumeField, gbc);
//all of the above is the cylinder part of the output all of this is the same as the sphere but moved down
        //enough spaces to do the same thing as the sphere EXCEPT there is additional input for height
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(new JLabel("Cylinder Height:"), gbc);
        gbc.gridx = 1;
        cylinderHeightField = new JTextField(10);
        inputPanel.add(cylinderHeightField, gbc);
        //this is the height part ^^^^^^

        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(new JLabel("Cone Radius:"), gbc);
        gbc.gridx = 1;
        coneRadiusField = new JTextField(10);
        inputPanel.add(coneRadiusField, gbc);
        gbc.gridx = 2;
        coneAreaField = new JTextField(10);
        coneAreaField.setEditable(false);
        inputPanel.add(coneAreaField, gbc);
        gbc.gridx = 4;
        coneVolumeField = new JTextField(10);
        coneVolumeField.setEditable(false);
        inputPanel.add(coneVolumeField, gbc);
//all of the above is the cone part of the output all of this is the same as the sphere but moved down
        //enough spaces to do the same thing as the sphere EXCEPT there is additional input for height

        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(new JLabel("Cone Height:"), gbc);
        gbc.gridx = 1;
        coneHeightField = new JTextField(10);
        inputPanel.add(coneHeightField, gbc);
        //this is the height part ^^^^^^



        add(inputPanel, BorderLayout.CENTER); //button in the middle

        // button instructions as to where it is
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateListener());
        buttonPanel.add(calculateButton);
        add(buttonPanel, BorderLayout.SOUTH); // button on bottom

        pack(); // cram everything into the window size
        setLocationRelativeTo(null); // center the wondow
        setVisible(true);
    }
    JFrame frame = this;//this tortured me for hours
      private class CalculateListener implements ActionListener {//this tells what happens when the
          //button is pressed
        @Override//this is the polymorphed class thatgs comming out of AWT
        public void actionPerformed(ActionEvent
                e) {
            try {
                double sphereRadius = Double.parseDouble(sphereRadiusField.getText());//variable declarations used in
                //this class to send to the child classes of shape java where the calculations
                //are done. This is where the input numbers go to be sent to those other
                //classes
                double cylinderRadius = Double.parseDouble(cylinderRadiusField.getText());
                double cylinderHeight = Double.parseDouble(cylinderHeightField.getText());
                double coneRadius = Double.parseDouble(coneRadiusField.getText());
                double coneHeight = Double.parseDouble(coneHeightField.getText());

                //this initializes the shapes in this class to reference the shapes
                //of the respective child classes 2 numbers for cylinder 2 numbers for cone and 1 number for spher
                //in a package so to speak
                Sphere sphere = new Sphere(sphereRadius);
                Cylinder cylinder = new Cylinder(cylinderRadius, cylinderHeight);
                Cone cone = new Cone(coneRadius, coneHeight);

                // This is where the numbers returned by the child classes get spit out
                //and how they're formatted
                sphereAreaField.setText(String.format("%.2f", sphere.surface_area()));
                cylinderAreaField.setText(String.format("%.2f", cylinder.surface_area()));
                coneAreaField.setText(String.format("%.2f", cone.surface_area()));

                sphereVolumeField.setText(String.format("%.2f", sphere.volume()));
                cylinderVolumeField.setText(String.format("%.2f", cylinder.volume()));
                coneVolumeField.setText(String.format("%.2f", cone.volume()));

            } catch (NumberFormatException ex) {//this is the invalid input notification
                //that you tried to tell the program a story instead of give it the
                //numbers it wants.
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter numbers only.");
            }
        }
    }

    public static void main(String[] args) {
        new ShapeArray();
    }
}//This rfeturns the program to exit if so the "main" method.
