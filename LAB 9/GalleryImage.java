

import java.awt.event.*;
import javax.swing.*;

public class GalleryImage {
    public static void main(String[] args) {
        new InnerGalleryImage();
    }
}

class InnerGalleryImage implements ActionListener{
    JFrame frame, frame2;
    JButton one,two,three,four;

    InnerGalleryImage(){
        
        frame = new JFrame("Home");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(2000, 2000);
        frame.setLocationRelativeTo(null);

        frame2 = new JFrame("Home 2");
        frame2.setLayout(null);
        frame2.setDefaultCloseOperation(frame2.EXIT_ON_CLOSE);
        frame2.setSize(800, 500);
        frame2.setLocationRelativeTo(null);
        
        ImageIcon img1 = new ImageIcon("aditya.jpg");
        one = new JButton(img1);
        ImageIcon img2 = new ImageIcon("aditya1.jpg");
        two = new JButton(img2);
        ImageIcon img3 = new ImageIcon("aditya2.jpg");
        three = new JButton(img3);
        ImageIcon img4 = new ImageIcon("aditya3.jpg");
        four = new JButton(img4);
        
        one.setBounds(100,100,220,220);
        two.setBounds(400,100,220,220);
        three.setBounds(700,100,220,220);
        four.setBounds(1000,100,220,220);

        // one.setBorderPainted(false);
        
        frame.add(one);
        frame.add(two);
        frame.add(three);
        frame.add(four);
        
        frame.setVisible(true);
        frame2.setVisible(false);

        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==one) {
            frame2.setVisible(true);
            frame2.add(one);
            one.setBounds(10,10,700,400);
            }

        else if (e.getSource()==two) {
            frame2.setVisible(true);
            frame2.add(two);
            two.setBounds(10,10,700,400);
        }
        else if (e.getSource()==two) {
            frame2.setVisible(true);
            frame2.add(three);
            three.setBounds(10,10,700,400);
        }
        else{
            frame2.setVisible(true);
            frame2.add(four);
            four.setBounds(10,10,700,400);

        }
    }
}


