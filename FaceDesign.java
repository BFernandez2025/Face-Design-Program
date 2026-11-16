import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Ellipse2D;





//*This program is a face design software that allows users to create an outline for a specific face they are wanting to draw.
//Users who like to draw like to do a rough sketch/outlines of what they will draw but if they want exact precision on what they want it
//to look like, then this software helps them to do that. Within the software, the user is presented with the default face outline
//with two eyes and a nose. From there, the user is presented with a panel of different buttons that add and subtract1 unit to the width
//and height of the different components of the face. Additionally, the users are able to drag around the components of the face in order
//for the user to be able to position them freely. With these features, the user is able to design and outline of what they want their
// face to look like and is ultimately able to have an easier time adjusting their sketch for their actual drawing later on. 
//
//In this program, I used the ActionListener as my event Listener to be able to implement the functionality of my buttons. 
// On the JPanel itself, I drew four oval shapes using the painComponent method and created a second JPanel to format the way
// my buttons were displayed so they were readable for the user. The swing components I used were the JLabel for my instructions
// description, the JButtons to adjust the width and height of different parts and ****______*****
// The functionality of the program had no direct instructions. All buttons in the program add and subtract 1 unit of width or height
// each time it is clicked so it may need to be clicked many times before an effect is displayed. Additionally, the initial face
// is not centered to allow for the user to use the drag feature if they want it centered.*/


public class FaceDesign extends JPanel {
    //instance variables for swing components JFrame, JLabels and JButtons
    private JFrame frame;
    private JLabel labelInstructions;
    private JButton eyeSizeWidthLeftAdd;
    private JButton eyeSizeHeightLeftAdd;
    private JButton eyeSizeWidthRightAdd;
    private JButton eyeSizeHeightRightAdd;
    private JButton mouthSizeWidthAdd;
    private JButton mouthSizeHeightAdd;
    private JButton headSizeWidthAdd;
    private JButton headSizeHeightAdd;

    private JButton eyeSizeWidthLeftSub;
    private JButton eyeSizeHeightLeftSub;
    private JButton eyeSizeWidthRightSub;
    private JButton eyeSizeHeightRightSub;
    private JButton mouthSizeWidthSub;
    private JButton mouthSizeHeightSub;
    private JButton headSizeWidthSub;
    private JButton headSizeHeightSub;

    //instance variables for quantity of length and width
    private int eyeSizeWidthQL; //where Q stands for quantity, L stands for left and R stands for right
    private int eyeSizeHeightQL;
    private int eyeSizeWidthQR;
    private int eyeSizeHeightQR;
    private int mouthSizeWidthQ;
    private int mouthSizeHeightQ;
    private int headSizeWidthQ;
    private int headSizeHeightQ;

    //instance variables for x, y coordinates of shapes for movability when dragging
    private int mouthX = 240;
    private int mouthY = 280;
    private int headX = 150;
    private int headY = 100; 
    private int leftEyeX = 200;
    private int leftEyeY = 170;
    private int rightEyeX = 300;
    private int rightEyeY = 170;

    //instance variable for mouseAdapter and paint section to determine what shape is being dragged around]
    private String draggedShape;

    //This is the constructor which creates a new face design everytime an object is created on this class
    public FaceDesign(){
        //These variables set the default quantities for different components of the face before they are altered
        eyeSizeWidthQL = 40; 
        eyeSizeHeightQL = 25;
        eyeSizeWidthQR = 40;
        eyeSizeHeightQR = 25;
        mouthSizeWidthQ = 80;
        mouthSizeHeightQ = 20;
        headSizeWidthQ = 200;
        headSizeHeightQ = 250;
        this.setPreferredSize(new Dimension (600,400));

        //this is a section for creating the JFrame and creating the border for the frame
        frame = new JFrame("Face Design");
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER); //adding the drawing panel and centering it to our border layout

        //This is the section where the label for the instructions at the top are defined and added to the JFrame
        labelInstructions = new JLabel("<html>Welcome to the face outline designer. Below you will find a series of buttons that you can use to alter the width and height of the default shapes of the face.<br> There is one for the head, mouth and both the eyes. You have the option to add or subtract 1 unit of width or height from each face part.<br>You are also able to drag and drop shapes to new positions to customize to your preference. Thank you and we hope you enjoy!<html>", SwingConstants.CENTER); //<html> and <br> are used to create multiline text and SwingConstants.CENTER is used to center the text at the top of the page 
        frame.add(labelInstructions, BorderLayout.NORTH);

        //This is the section where we declare our buttons for increasing the width and height of face parts and set their text labels
        eyeSizeWidthLeftAdd = new JButton();
        eyeSizeWidthLeftAdd.setText("Add eye width for left eye");

        eyeSizeHeightLeftAdd = new JButton();
        eyeSizeHeightLeftAdd.setText("Add eye Height for left eye");

        eyeSizeWidthRightAdd = new JButton();
        eyeSizeWidthRightAdd.setText("Add eye width for right eye");

        eyeSizeHeightRightAdd = new JButton();
        eyeSizeHeightRightAdd.setText("Add eye heigt for right eye");

        mouthSizeWidthAdd = new JButton();
        mouthSizeWidthAdd.setText("Add mouth width");

        mouthSizeHeightAdd = new JButton();
        mouthSizeHeightAdd.setText("Add mouth height");

        headSizeWidthAdd = new JButton();
        headSizeWidthAdd.setText("Add head width");

        headSizeHeightAdd = new JButton();
        headSizeHeightAdd.setText("Add head height");

        


        //This is the section to declare the buttons for decreasing the width and height of different components of the face
        eyeSizeWidthLeftSub = new JButton();
        eyeSizeWidthLeftSub.setText("Subtract eye width for left eye");

        eyeSizeHeightLeftSub = new JButton();
        eyeSizeHeightLeftSub.setText("Subtract eye Height for left eye");

        eyeSizeWidthRightSub = new JButton();
        eyeSizeWidthRightSub.setText("Subtract eye width for right eye");

        eyeSizeHeightRightSub = new JButton();
        eyeSizeHeightRightSub.setText("Subtract eye heigt for right eye");

        mouthSizeWidthSub = new JButton();
        mouthSizeWidthSub.setText("Subtract mouth width");

        mouthSizeHeightSub = new JButton();
        mouthSizeHeightSub.setText("Subtract mouth height");

        headSizeWidthSub = new JButton();
        headSizeWidthSub.setText("Subtract head width");

        headSizeHeightSub = new JButton();
        headSizeHeightSub.setText("Subtract head height");




        //This is the section where we create new instances of our action listener classes for each button and add them to their specified variable function
        eyeWidthListenerLeft EL1 = new eyeWidthListenerLeft();
        eyeSizeWidthLeftAdd.addActionListener(EL1); //Button Listener implements Action Listener
        eyeHeightListenerLeft EL2= new eyeHeightListenerLeft();
        eyeSizeHeightLeftAdd.addActionListener(EL2);
        eyeWidthListenerRight ER1 = new eyeWidthListenerRight();
        eyeSizeWidthRightAdd.addActionListener(ER1);
        eyeHeightListenerRight ER2 = new eyeHeightListenerRight();
        eyeSizeHeightRightAdd.addActionListener(ER2);
        mouthWidthListener m1 = new mouthWidthListener();
        mouthSizeWidthAdd.addActionListener(m1);
        mouthHeightListener m2 = new mouthHeightListener();
        mouthSizeHeightAdd.addActionListener(m2);
        headWidthListener h1 = new headWidthListener();
        headSizeWidthAdd.addActionListener(h1);
        headHeightListener h2 = new headHeightListener();
        headSizeHeightAdd.addActionListener(h2);


        eyeWidthListenerLeftSubtract EL1Sub = new eyeWidthListenerLeftSubtract();
        eyeSizeWidthLeftSub.addActionListener(EL1Sub); //Button Listener implements Action Listener
        eyeHeightListenerLeftSubtract EL2Sub = new eyeHeightListenerLeftSubtract();
        eyeSizeHeightLeftSub.addActionListener(EL2Sub);
        eyeWidthListenerRightSubtract ER1Sub = new eyeWidthListenerRightSubtract();
        eyeSizeWidthRightSub.addActionListener(ER1Sub);
        eyeHeightListenerRightSubtract ER2Sub = new eyeHeightListenerRightSubtract();
        eyeSizeHeightRightSub.addActionListener(ER2Sub);
        mouthWidthListenerSubtract m1Sub = new mouthWidthListenerSubtract();
        mouthSizeWidthSub.addActionListener(m1Sub);
        mouthHeightListenerSubtract m2Sub = new mouthHeightListenerSubtract();
        mouthSizeHeightSub.addActionListener(m2Sub);
        headWidthListenerSubtract h1Sub = new headWidthListenerSubtract();
        headSizeWidthSub.addActionListener(h1Sub);
        headHeightListenerSubtract h2Sub = new headHeightListenerSubtract();
        headSizeHeightSub.addActionListener(h2Sub);

        //This is where we create the second JPanel to format the display of the buttons when we run the program
        JPanel buttonFormat = new JPanel();

        buttonFormat.add(eyeSizeWidthLeftAdd);
        buttonFormat.add(eyeSizeHeightLeftAdd);
        buttonFormat.add(eyeSizeWidthRightAdd);
        buttonFormat.add(eyeSizeHeightRightAdd);
        buttonFormat.add(mouthSizeWidthAdd);
        buttonFormat.add(mouthSizeHeightAdd);
        buttonFormat.add(headSizeWidthAdd);
        buttonFormat.add(headSizeHeightAdd);


        buttonFormat.add(eyeSizeWidthLeftSub);
        buttonFormat.add(eyeSizeHeightLeftSub);
        buttonFormat.add(eyeSizeWidthRightSub);
        buttonFormat.add(eyeSizeHeightRightSub);
        buttonFormat.add(mouthSizeWidthSub);
        buttonFormat.add(mouthSizeHeightSub);
        buttonFormat.add(headSizeWidthSub);
        buttonFormat.add(headSizeHeightSub);

        
        buttonFormat.setLayout(new GridLayout(4,4)); //Allow the buttons not to be crammed in one area by using a grid layout
        frame.add(buttonFormat, BorderLayout.SOUTH);

        //This is where we implement our MouseAdapter (MouseListener). Since MouseAdapter already implements MouseListener, there is only the declaration os Mouse Adapter
        MouseAdapter listener = new MouseAdapter(){ //this mouseAdapter will allow the user to drag shapes to different areas. Adapter automatically implements MouseListener so we do not need to implement the interface
            //*This is an overrided method from the MouseListener interface called mousePressed. We create four different Ellipse2D shapes,
            // one for each part of the face and run and if statement logic chain. We get the x and y coordinates from our MouseEvent object
            // and use the if statements to determine which shape the mouse is grabbing to drag. Based on that, the draggeShape variable is changed
            // to let the program know that the user is moving a specific shape.*/

            @Override
            public void mousePressed (MouseEvent e){
                int x = e.getX(); //Get the x,y coordinates of mouse from the MouseEvent object
                int y = e.getY();
                
                Ellipse2D head = new Ellipse2D.Double(headX, headY, headSizeWidthQ, headSizeHeightQ);
                Ellipse2D leftEye = new Ellipse2D.Double(leftEyeX, leftEyeY, eyeSizeWidthQL, eyeSizeHeightQL);
                Ellipse2D rightEye = new Ellipse2D.Double(rightEyeX, rightEyeY, eyeSizeWidthQR, eyeSizeHeightQR);
                Ellipse2D mouth = new Ellipse2D.Double(mouthX, mouthY, mouthSizeWidthQ, mouthSizeHeightQ);

                //use if statment logic to determine which shape is being moved
                if(leftEye.contains(x,y) == true){
                    draggedShape = "leftEye";
                }

                else if(rightEye.contains(x,y) == true){
                    draggedShape = "rightEye";
                }
                
                else if(mouth.contains(x,y) == true){
                    draggedShape = "mouth";
                }

                else if (head.contains(x,y) == true) {
                    draggedShape = "head";
                }   

                else {
                    draggedShape = "";
                }
            }

            //*This is another implemented method from the MouseListener interface called mouseDragged. We once again get the x and
            // y coordinates of the mouse from our mouse event object. We then check based on our previous method what the draggedShape
            // variable string is. Based on that, the x and y coordinates of a specific face piece will be altered and moved until the user
            // releases the mouse. */
            @Override
            public void mouseDragged (MouseEvent e){
                //use the previous if statement logic to implement mouseDragged method for dragging the shapes
                int x = e.getX();
                int y = e.getY();

                if (draggedShape.equals("leftEye")){
                    leftEyeX = x;
                    leftEyeY = y;
                }

                else if (draggedShape.equals("rightEye")){
                    rightEyeX = x;
                    rightEyeY = y;
                }

                else if (draggedShape.equals("mouth")){
                    mouthX = x;
                    mouthY = y;
                }

                else if (draggedShape.equals("head")){
                    headX = x;
                    headY = y;
                }

                repaint(); //call repaint at the end regardless because we need to have the shapes still be drawn
            }

            //*This method is apart of the MouseListener interface as well. However, its functionality is simply to
            //stop the user from the dragging the shape once they release the mouse and set the status of the shape being dragged
            //back to the empty string */ 
            @Override
            public void mouseReleased (MouseEvent e){
                draggedShape = "";
            }
        };

        //This section just adds our adapter as a Mouse Listener and Mouse Motion Listener to ensure clicking and motion methods are implemented on our panel
        addMouseListener(listener); //detects clicking methods
        addMouseMotionListener(listener); //detects the dragging motions

        //This section allows us to combine JFrame and JPanel works together and making it so they are all visible to the user
        frame.pack(); //We can set the dimensions of the frame by using .pack() with our JPanel
        frame.setLocationRelativeTo(null); //defaults to centre
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //This is an actionListener class the adds 1 to the left eye width and then calls the paint method to adjust the drawing
    private class eyeWidthListenerLeft implements ActionListener{ //Button Listener for eye Width
        public void actionPerformed(ActionEvent e){
            //Add 1 to the width of the eye
            eyeSizeWidthQL++; 
            repaint();
        }
    }

    //This is an actionListener class the adds 1 to the left eye Height and then calls the paint method to adjust the drawing
    private class eyeHeightListenerLeft implements ActionListener{ //Button Listener for eye Height
        public void actionPerformed(ActionEvent e){
            //Add 1 to the height of the eye
            eyeSizeHeightQL++;
            repaint();
        }
    }

    //This is an actionListener class the adds 1 to the Right eye width and then calls the paint method to adjust the drawing
    private class eyeWidthListenerRight implements ActionListener{ //Button Listener for eye Width
        public void actionPerformed(ActionEvent e){
            //Add 1 to the width of the eye
            eyeSizeWidthQR++; 
            repaint();
        }
    }

    //This is an actionListener class the adds 1 to the Right eye width and then calls the paint method to adjust the drawing
    private class eyeHeightListenerRight implements ActionListener{ //Button Listener for eye Height
        public void actionPerformed(ActionEvent e){
            //Add 1 to the height of the eye
            eyeSizeHeightQR++;
            repaint();
        }
    }

    //This is an actionListener class the adds 1 to the mouth width and then calls the paint method to adjust the drawing
    private class mouthWidthListener implements ActionListener{ //Button Listener for mouth width
        public void actionPerformed(ActionEvent e){
            //Add 1 to the height of the eye
            mouthSizeWidthQ++;
            repaint();
        }
    }

    //This is an actionListener class the adds 1 to the mouth height and then calls the paint method to adjust the drawing
    private class mouthHeightListener implements ActionListener{ //Button Listener for mouth Height
        public void actionPerformed(ActionEvent e){
            //Add 1 to the height of the eye
            mouthSizeHeightQ++;
            repaint();
        }
    }

    //This is an actionListener class the adds 1 to the head width and then calls the paint method to adjust the drawing
    private class headWidthListener implements ActionListener{ //Button Listener for head width
        public void actionPerformed(ActionEvent e){
            headSizeWidthQ++;
            repaint();
        }
    }

    //This is an actionListener class the adds 1 to the head height and then calls the paint method to adjust the drawing
    private class headHeightListener implements ActionListener{ //Button Listener for head Height
        public void actionPerformed(ActionEvent e){
            //Add 1 to the height of the eye
            headSizeHeightQ++;
            repaint();
        }
    }

    //This is an actionListener class the subtracts 1 from the left eye width and then calls the paint method to adjust the drawing
    private class eyeWidthListenerLeftSubtract implements ActionListener{ //Button Listener for eye Width
        public void actionPerformed(ActionEvent e){
            //Add 1 to the width of the eye
            eyeSizeWidthQL--; 
            repaint();
        }
    }

    //This is an actionListener class the subtracts 1 from the left eye height and then calls the paint method to adjust the drawing
    private class eyeHeightListenerLeftSubtract implements ActionListener{ //Button Listener for eye Height
        public void actionPerformed(ActionEvent e){
            //Add 1 to the height of the eye
            eyeSizeHeightQL--;
            repaint();
        }
    }

    //This is an actionListener class the subtracts 1 from the right eye width and then calls the paint method to adjust the drawing
    private class eyeWidthListenerRightSubtract implements ActionListener{ //Button Listener for eye Width
        public void actionPerformed(ActionEvent e){
            //Add 1 to the width of the eye
            eyeSizeWidthQR--; 
            repaint();
        }
    }

    //This is an actionListener class the subtracts 1 from the right eye height and then calls the paint method to adjust the drawing
    private class eyeHeightListenerRightSubtract implements ActionListener{ //Button Listener for eye Height
        public void actionPerformed(ActionEvent e){
            //Add 1 to the height of the eye
            eyeSizeHeightQR--;
            repaint();
        }
    }

    //This is an actionListener class the subtracts 1 from the mouth width and then calls the paint method to adjust the drawing
    private class mouthWidthListenerSubtract implements ActionListener{ //Button Listener for mouth width
        public void actionPerformed(ActionEvent e){
            //Add 1 to the height of the eye
            mouthSizeWidthQ--;
            repaint();
        }
    }

    //This is an actionListener class the subtracts 1 from the mouth height and then calls the paint method to adjust the drawing
    private class mouthHeightListenerSubtract implements ActionListener{ //Button Listener for mouth Height
        public void actionPerformed(ActionEvent e){
            //Add 1 to the height of the eye
            mouthSizeHeightQ--;
            repaint();
        }
    }

    //This is an actionListener class the subtracts 1 from the head width and then calls the paint method to adjust the drawing
    private class headWidthListenerSubtract implements ActionListener{ //Button Listener for head width
        public void actionPerformed(ActionEvent e){
            headSizeWidthQ--;
            repaint();
        }
    }

    //This is an actionListener class the subtracts 1 from the head height and then calls the paint method to adjust the drawing
    private class headHeightListenerSubtract implements ActionListener{ //Button Listener for head Height
        public void actionPerformed(ActionEvent e){
            //Add 1 to the height of the eye
            headSizeHeightQ--;
            repaint();
        }
    }

    //*This method is our protected paintComponent method which allows us to draw our shapes onto the JPanel.
    //We still call the super class method and cast Graphics G to 2D graphics. After that, we simply draw the four component
    //of our face based on the variable dimensions that we have defined in our instance variables and altered through the buttons
    //and listeners. */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        //Draw the head
        g2.drawOval(headX, headY, headSizeWidthQ, headSizeHeightQ);

        //Draw the eyes
        g2.drawOval(leftEyeX, leftEyeY, eyeSizeWidthQL, eyeSizeHeightQL);
        g2.drawOval(rightEyeX, rightEyeY, eyeSizeWidthQR, eyeSizeHeightQR);

        //Draw the mouth
        g2.drawOval(mouthX, mouthY, mouthSizeWidthQ, mouthSizeHeightQ);
    }


}

