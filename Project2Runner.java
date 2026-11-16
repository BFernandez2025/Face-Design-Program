public class Project2Runner {
    
    /*
     * Name: Brenden Fernandez
     * Student ID: 501366412
     * 
     ******** Project Description ********
     * 
     * Describe in plain English the overall program/program in a paragraph or 2.
     * This program is a face design software that allows users to create an outline for a specific face they are wanting to draw.
        Users who like to draw like to do a rough sketch/outlines of what they will draw but if they want exact precision on what they want it
        to look like, then this software helps them to do that. Within the software, the user is presented with the default face outline
        with two eyes and a nose. From there, the user is presented with a panel of different buttons that add and subtract1 unit to the width
        and height of the different components of the face. Additionally, the users are able to drag around the components of the face in order
        for the user to be able to position them freely. With these features, the user is able to design and outline of what they want their
        face to look like and is ultimately able to have an easier time adjusting their sketch for their actual drawing later on
     *
     * 
     ******** Swing Requirement ********
     * 
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 3 unique components. Be clear to identify in what
     * files and the lines number (just the starting line is fine) that the
     * components are defined on.
     * 
     * The three unique swing components that I used in the program were JLabel, JButton and ____.
     * I used a JLabel as a way to display the instructions to the user and this functionality is found
     * on line 95 of my program. I used many different JButton declerations starting on line 99 to have seperate functionalities
     * to allow the user to alter the width and height of the face components to their liking. Lastly, I used a new JPanel, one seperate from
     * my drawing JPanel. I created this new JPanel on line 191 and it was created to format all the different buttons in a more
     * visually appealing way for the user to read.
     * 
     * 
     ******** 2D Graphics Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least 1 JPanel used for drawing something. Be clear to
     * identify in what files and the line numbers that this panel is defined on.
     * 
     * I used two JPanels in this project. The first JPanel came from extending my FaceDesign design class from the JPanel class.
     * By extending JPanel to my FaceDesign class, the face is already built on JPanel as a super class, which is where the this keyword
     * is used in lines setting the preferred dimension in line 87. The second JPanel was declared on line 191. This JPanel was added to the Jframe
     * to allow all buttons to be formatted properly and in a way that the user could easily see visually. One JPanel was used to draw,
     * the other was used for formatting the buttons.
     * 
     ******** Event Listener Requirement ********
     *
     * Describe in 1 paragraph how your program satisfies the requirement that
     * there is at least one ActionListener, and there is additionally at least
     * one MouseListener or ActionListener. Be clear to identify in what file
     * and the line numbers that these listeners are defined in.
     * 
     * I used an ActionListener when I implemented the action Listener class on my private classes that alter the width and heights of the 
     * face components. The first example of this can be found on line 309 where I implement the ActionListener class. This was used to
     * be able to fully implement the functionality of the buttons altering width and height. I decided to additionally add a MouseListener/Adapter
     * which can be found starting at line 217 and continuing down with included methods. This mouse listener is used to be able to allow the user
     * to drag the components of the shapes around so position them they way they want it. This is done by overriding the mousePressed, mouseDragged and 
     * mouseReleased methods.
     */

    public static void main(String[] args) {
        FaceDesign design = new FaceDesign();
    }
}
