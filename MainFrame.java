import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame implements ActionListener {

    JFrame frame = new JFrame();
    JLabel title = new JLabel("Perimeter & Area Calculator");
    JLabel solveFor = new JLabel();
    JComboBox shape,function;
    JPanel mainPanel,shapeImage,inputPanel;
    JLabel shapeImg = new JLabel();
    JLabel formula = new JLabel();
    JLabel answer = new JLabel();
    JButton submit,calculate;
    JTextField textField = new JTextField();
    JTextField textField2 = new JTextField();

    ImageIcon enterImg = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\enterButton.png");
    ImageIcon rectangleImg = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\Rectangle.png");
    ImageIcon circleImg = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\Circle.png");

    MainFrame() {
        frame.setSize(1300,690);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(242,241,241));

        String[] shapes = {"Rectangle","Circle"};
        String[] solve = {"Area","Perimeter"};

        solveFor.setText("Solve for: ");
        solveFor.setBounds(40,30,200,30);
        solveFor.setFont(new Font("Poppins",Font.PLAIN,25));

        shape = new JComboBox(shapes);
        shape.setBounds(70,70,200,30);
        shape.setFont(new Font("Poppins",Font.PLAIN,23));
        shape.addItemListener(null);

        function = new JComboBox(solve);
        function.setBounds(70,110,200,30);
        function.setFont(new Font("Poppins",Font.PLAIN,23));
        function.addItemListener(null);

        submit = new JButton();
        submit.setBounds(291,88,65,35);
        submit.setIcon(enterImg);
        submit.addActionListener(this);
        submit.setFocusable(false);
        submit.setBorderPainted(false);

        calculate = new JButton();
        calculate.setBounds(570,340,65,40);
        calculate.addActionListener(this);
        calculate.setBorderPainted(false);
        calculate.setIcon(enterImg);
        calculate.setFocusable(false);

        answer = new JLabel();
        answer.setBounds(50,340,470,50);
        answer.setFont(new Font("Poppins", Font.BOLD,20));

        shapeImg.setBounds(50,200,250,200);

        title.setBounds(60,15,500,50);
        title.setFont(new Font("Poppins",Font.BOLD,35));
        title.setBackground(Color.green);

        formula.setBounds(70,410,250,50);
        formula.setFont(new Font("Poppins",Font.BOLD,30));

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.white);
        mainPanel.setBounds(60,80,1180,500);

        inputPanel = new JPanel();
        inputPanel.setLayout(null);
        inputPanel.setBounds(430,50,670,410);
        inputPanel.setBackground(new Color(242,241,241));

        mainPanel.add(solveFor);
        mainPanel.add(inputPanel);
        mainPanel.add(shape);
        mainPanel.add(function);
        mainPanel.add(submit);
        mainPanel.add(shapeImg);
        mainPanel.add(formula);
        inputPanel.add(textField);
        inputPanel.add(textField2);
        inputPanel.add(calculate);
        inputPanel.add(answer);
        frame.add(mainPanel);
        frame.add(title);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        textField.setFont(new Font("Poppins",Font.PLAIN,20));
        textField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField2.setFont(new Font("Poppins",Font.PLAIN,20));
        textField2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        textField.setBounds(150,120,300,50);
        textField2.setBounds(150,210,300,50);

        String selectedShape = (String) shape.getSelectedItem();
        String selectedSolve = (String) function.getSelectedItem();

        if(e.getSource() == submit) {
                if (selectedShape.equals("Rectangle") && selectedSolve.equals("Area")) {
                    formula.setText("A = wl");
                    textField.setText("Enter length");
                    textField2.setText("Enter width");
                    textField2.setVisible(true);
                    shapeImg.setIcon(rectangleImg);
                }
                else if(selectedShape.equals("Rectangle") && selectedSolve.equals("Perimeter")) {
                    formula.setText("A = 2(w+l)");
                    textField.setText("Enter length");
                    textField2.setText("Enter width");
                    textField2.setVisible(true);
                    shapeImg.setIcon(rectangleImg);
                }
                else if(selectedShape.equals("Circle") && selectedSolve.equals("Area")) {
                    formula.setText("A = πr2");
                    textField.setText("Enter radius");
                    textField2.setVisible(false);
                    shapeImg.setIcon(circleImg);
                }
                else if(selectedShape.equals("Circle") && selectedSolve.equals("Perimeter")) {
                    formula.setText("C = 2πr");
                    textField.setText("Enter radius");
                    textField2.setVisible(false);
                    shapeImg.setIcon(circleImg);
                }
            }
            try {
                if (e.getSource() == calculate) {
                    double inputtedNumber1 = Double.valueOf(textField.getText());
                    double inputtedNumber2 = Double.valueOf(textField2.getText());

                    Circle circle = new Circle(inputtedNumber1);
                    Rectangle rectangle = new Rectangle(inputtedNumber1,inputtedNumber2);

                    if (selectedShape.equals("Rectangle") && selectedSolve.equals("Area")) {
                        answer.setText("Area of the Rectangle is " + rectangle.CalculateArea());
                    }
                    else if(selectedShape.equals("Rectangle") && selectedSolve.equals("Perimeter")) {
                        answer.setText("Perimeter of the Rectangle is " + rectangle.CalculatePerimeter());
                    }
                    else if(selectedShape.equals("Circle") && selectedSolve.equals("Area")) {
                        answer.setText("Area of the Circle is " + circle.CalculateArea());
                    }
                    else if(selectedShape.equals("Circle") && selectedSolve.equals("Perimeter")) {
                        answer.setText("Perimeter of the Circle is " + circle.CalculatePerimeter());
                    }
                }

            }catch(Exception e1){
                JOptionPane.showMessageDialog(null, "Wrong Input");
            }
        }
    }
