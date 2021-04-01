package itsudparis.application;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import itsudparis.tools.CustomOutputStream;
import itsudparis.tools.fetchdatatoowl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
 
public class gui extends JFrame{
	PrintStream standardOut;
	 static fetchdatatoowl data=new fetchdatatoowl();
     static int i=0;
     int iiii=0;
     static int[] S1={22260,22261,25200,25201,25801,25802,26850
    		 , 27900,27901,28620,28621,28800,28801,29100,29101,46800,46801,72000,72001,72002,72638};
     JButton btn1=new JButton("Scénario");
     JLabel R1=new JLabel("Résident 1:");
     JLabel activity1=new JLabel();
     JLabel R2=new JLabel("    Résident 2:");
     JLabel activity2 =new JLabel();
     JLabel  l1=new JLabel();
	public gui() throws IOException {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	
      
        this.setTitle("Smarthome");
        this.setBounds(0,0,screenSize.width, screenSize.height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container maincontainer=this.getContentPane();
        maincontainer.setLayout(new BorderLayout(8,6));
        Icon img=new ImageIcon(new ImageIcon("images/maisonimage.jpg").getImage().getScaledInstance(770, 600,Image.SCALE_DEFAULT));
        JPanel jacc =new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
               super.paintComponent(g);
               img.paintIcon(this, g, 0,0);
            }
         };
         maincontainer.add(jacc,BorderLayout.CENTER);
        maincontainer.setBackground(Color.black);
        this.getRootPane().setBorder(BorderFactory.createMatteBorder(4,4,4,4,Color.white));
        //top panel
        JPanel topPanel =new JPanel();
        topPanel.setBorder(new LineBorder(Color.black,3));
        topPanel.setBackground(Color.white);
        topPanel.setLayout(new FlowLayout(5));

       
       
        topPanel.add(btn1);
        topPanel.add(R1);
        topPanel.add(activity1);
        topPanel.add(R2);
        topPanel.add(activity2);
        topPanel.add(l1);
        maincontainer.add(topPanel,BorderLayout.NORTH);
        //middlepanel east
        JPanel middlePanel =new JPanel();
        middlePanel.setLayout(new FlowLayout(4,4,4));
      
        middlePanel.setBackground(Color.cyan);
        
        JPanel gridPanel = new JPanel();
        
        gridPanel.setBackground(Color.cyan);
        middlePanel.add(gridPanel);
       
        JTextArea textArea = new JTextArea(40, 45);
        textArea.setEditable(false);
        gridPanel.add(textArea);
        gridPanel.setLayout(new GridLayout(4,1,5,5));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx =3;
        constraints.gridy = 2;
        constraints.insets = new Insets(50, 50, 50, 50);
        constraints.anchor = GridBagConstraints.EAST;
         
        //add(buttonStart, constraints);
         
        constraints.gridx = 2;
      //  add(buttonClear, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
         
        gridPanel.add(new JScrollPane(textArea), constraints);
		
		
        
        maincontainer.add(middlePanel,BorderLayout.EAST);
       
      //middlepanel east
      
        
        JPanel bottomPanel =new JPanel();
        bottomPanel.setLayout(new FlowLayout(3));
        bottomPanel.setBorder(new LineBorder(Color.black,3));
        bottomPanel.setBackground(Color.white);
        maincontainer.add(bottomPanel,BorderLayout.SOUTH);
        JButton btn5=new JButton("Salle de bain");
        JButton btn6=new JButton("Chambre");
        JButton btn7=new JButton("Cuisine");
        JButton btn8=new JButton("Salon");
        bottomPanel.add(btn8);
        bottomPanel.add(btn7);
        bottomPanel.add(btn6);
        bottomPanel.add(btn5);
        
        
        JPanel sb = new JPanel() {
   		 public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        ImageIcon img0= new ImageIcon("images/toilette.jpg");
		        g.drawImage(img0.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		  
		        g.setFont(new Font("default", Font.BOLD, 18));
    	        g.drawString("Lampe :", 40, 100);
		        if(data.tab[2][4]==1) {
		        	
		        	g.drawString("allumée", 200,100);
		        	
		        }else {
		        	g.drawString("éteint", 200, 100);
		        }
		        g.drawString("Armoire :", 40, 150);
                if(data.tab[2][2]==1) {
                	
               	 g.drawString("ouverte", 200, 150);
               	
		        }else {
		        	g.drawString("fermée", 200, 150);
		        }
                g.drawString("Climatiseur :", 40, 200);
		        if(data.tab[2][3]==1) {
		        	
		        	g.drawString("allumé", 200, 200);
		        	
		        }else {
		        	g.drawString("éteint", 200, 200);
		        }
		        g.drawString("Chasse d'eau:", 40, 250);
		        if(data.tab[2][1]==1) {
		        	
		        	g.drawString("active", 200, 250);
		        	
		        }else {
		        	g.drawString("fermée", 200, 250);
		        }
		        g.drawString("Porte: ", 40, 300);
		        if(data.tab[2][0]==1) {
		        	
		        	
		        	 g.drawString("ouverte", 200, 300);
		        	 
		        }else {
		        	 g.drawString("fermée", 200, 300);
		        }
		        
                
		        /*    
		        Icon img=new ImageIcon(new ImageIcon("images/lamp.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img.paintIcon(this, g, 40,40);
		        g.drawString("Lamp", 40, 155);
		        if(data.tab[2][4]==1) {
		        	g.drawString("true", 40, 170);
		        }else {
		        	g.drawString("false", 40, 170);
		        }
		        
		        Icon img2=new ImageIcon(new ImageIcon("images/armoire_toilette.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img2.paintIcon(this, g, 155,40);
		        g.drawString("armoire", 155, 155);
		        if(data.tab[2][2]==1) {
		        	 g.drawString("true", 155, 170);
		        }else {
		        	 g.drawString("false", 155, 170);
		        }
		       
		        Icon img3=new ImageIcon(new ImageIcon("images/clim.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img3.paintIcon(this, g, 270,40);
		        g.drawString("Climatiseur", 270, 155);
		        if(data.tab[2][3]==1) {
		        	g.drawString("true", 270, 170);
		        }else {
		        	g.drawString("false", 270, 170);
		        }
		        
		        Icon img4=new ImageIcon(new ImageIcon("images/chasse_deau.jpeg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img4.paintIcon(this, g, 395,40);
		        g.drawString("chasse_deau", 395, 155);
		        if(data.tab[2][1]==1) {
		        	  g.drawString("true", 395, 170);
		        }else {
		        	  g.drawString("false", 395, 170);
		        }
		      
		        Icon img5=new ImageIcon(new ImageIcon("images/porte.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img5.paintIcon(this, g, 530,40);
		        g.drawString("porte", 530, 155);
		        if(data.tab[2][0]==1) {
		        	 g.drawString("true", 530, 170);
		        }else {
		        	 g.drawString("false", 530, 170);
		        }
		       
		      
		          Icon img6=new ImageIcon(new ImageIcon("images/vole.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		         img6.paintIcon(this, g, 665,40);
		        g.drawString("chasse_deau", 665, 155);
		        g.drawString("false", 665, 170);
		        */
		    
		    }
	};
    	sb.setBackground(Color.RED);
    	 
       
         
        
       
       
    	JPanel chambre = new JPanel() {
    		 public void paintComponent(Graphics g) {
    		        super.paintComponent(g);
    		        ImageIcon img0= new ImageIcon("images/chambre2.jpg");
    		        g.drawImage(img0.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
    		        g.setFont(new Font("default", Font.BOLD, 18));
    		       
    		        g.drawString("Lampe :", 40, 100);
    		        if(data.tab[3][4]==1) {
    		        	
    		        	g.drawString("allumée", 200,100);
    		        	
    		        }else {
    		        	g.drawString("éteint", 200, 100);
    		        }
    		        g.drawString("Lit :", 40, 150);
                    if(data.tab[3][0]==1) {
                    	
                   	 g.drawString("occupé", 200, 150);
                   	
    		        }else {
    		        	g.drawString("libre", 200, 150);
    		        }
                    g.drawString("Climatiseur :", 40, 200);
    		        if(data.tab[3][3]==1) {
    		        	
    		        	g.drawString("allumé", 200, 200);
    		        	
    		        }else {
    		        	g.drawString("éteint", 200, 200);
    		        }
    		        g.drawString("Volets :", 40, 250);
    		        if(data.tab[3][2]==1) {
    		        	
    		        	g.drawString("ouverts", 200, 250);
    		        	
    		        }else {
    		        	g.drawString("fermés", 200, 250);
    		        }
    		        g.drawString("Armoire: ", 40, 300);
    		        if(data.tab[3][1]==1) {
    		        	
    		        	 g.drawString("ouverte", 200, 300);
    		        	 
    		        }else {
    		        	 g.drawString("fermée", 200, 300);
    		        }
    		       
    		      
    		        /*
    		        Icon img=new ImageIcon(new ImageIcon("images/lamp.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
    		        img.paintIcon(this, g, 40,40);
    		        g.drawString("Lamp", 40, 155);
    		        if(data.tab[3][4]==1) {
    		        	g.drawString("true", 40, 170);
    		        }else {
    		        	g.drawString("false", 40, 170);
    		        }
    		        
    		        Icon img2=new ImageIcon(new ImageIcon("images/lit.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
    		        img2.paintIcon(this, g, 155,40);
    		        g.drawString("Lit", 155, 155);
    		        if(data.tab[3][0]==1) {
    		        	g.drawString("true", 155, 170);
    		        }else {
    		        	g.drawString("false", 155, 170);
    		        }
    		        
    		        Icon img3=new ImageIcon(new ImageIcon("images/clim.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
    		        img3.paintIcon(this, g, 270,40);
    		        g.drawString("Climatiseur", 270, 155);
    		        if(data.tab[3][3]==1) {
    		        	g.drawString("true", 270, 170);
    		        }else {
    		        	g.drawString("false", 270, 170);
    		        }
    		        
    		        Icon img4=new ImageIcon(new ImageIcon("images/vole.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
    		        img4.paintIcon(this, g, 395,40);
    		        g.drawString("volee", 395, 155);
    		        if(data.tab[3][2]==1) {
    		        	g.drawString("true", 395, 170);
    		        }else {
    		        	g.drawString("false", 395, 170);
    		        }
    		        
    		        Icon img5=new ImageIcon(new ImageIcon("images/porte.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
    		        img5.paintIcon(this, g, 530,40);
    		        g.drawString("porte", 530, 155);
    		        g.drawString("false", 530, 170);
    		        Icon img6=new ImageIcon(new ImageIcon("images/armoire.jpeg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
    		        img6.paintIcon(this, g, 665,40);
    		        g.drawString("armoire", 665, 155);
    		        if(data.tab[3][1]==1) {
    		            g.drawString("true", 665, 170);
    		        }else {
    		            g.drawString("false", 665, 170);
    		        }
    		    */
    		    
    		    }
    	};
    	chambre.setBackground(Color.GREEN);
    	JPanel cuisine = new JPanel() {
   		 public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        ImageIcon img0= new ImageIcon("images/cuisine1.jpg");
		        g.drawImage(img0.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		  
		        
		        g.setFont(new Font("default", Font.BOLD, 18));
		        g.drawString("Lampe :", 40, 100);
		        if(data.tab[1][5]==1) {
		        	
		        	g.drawString("allumée", 200,100);
		        	
		        }else {
		        	g.drawString("éteint", 200, 100);
		        }
		        g.drawString("Frigo  :", 40, 150);
                if(data.tab[1][2]==1) {
                	
               	 g.drawString("ouvert", 200, 150);
               	
		        }else {
		        	g.drawString("fermé", 200, 150);
		        }
                g.drawString("Climatiseur :", 40, 200);
		        if(data.tab[1][7]==1) {
		        	
		        	g.drawString("allumé", 200, 200);
		        	
		        }else {
		        	g.drawString("éteint", 200, 200);
		        }
		        g.drawString("Volets :", 40, 250);
		        if(data.tab[1][6]==1) {
		        	
		        	g.drawString("ouverts", 200, 250);
		        	
		        }else {
		        	g.drawString("fermés", 200, 250);
		        }
		        g.drawString("Chaise 1 : ", 40, 300);
		        if(data.tab[1][0]==1) {
		        	
		        	 g.drawString("occupée", 200, 300);
		        	 
		        }else {
		        	 g.drawString("libre", 200, 300);
		        }
		        g.drawString("Chaise 2 : ", 40, 350);
		        if(data.tab[1][1]==1) {
		        	
		        	 g.drawString("occupée", 200, 350);
		        	 
		        }else {
		        	 g.drawString("libre", 200, 350);
		        }
		        
                g.drawString("Robinet :", 40, 400);
		        
		        if(data.tab[1][4]==1) {
		        	
		        	g.drawString("ouvert ", 200, 400);
		        	
		        }else {
		        	g.drawString("fermé", 200, 400);
		        }
		        g.drawString("Tiroire :",40 , 450);
		        if(data.tab[1][3]==1) {
		        	
		        	g.drawString("ouvert", 200, 450);
		        	
		        }else {
		        	 g.drawString("fermé", 200, 450);
		        }
		        /*
		        Icon img=new ImageIcon(new ImageIcon("images/lamp.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img.paintIcon(this, g, 40,40);
		        g.drawString("Lamp", 40, 155);
		        if(data.tab[1][5]==1) {
		        	g.drawString("true", 40, 170);
		        }else {
		        	g.drawString("false", 40, 170);
		        }
		        
		        Icon img2=new ImageIcon(new ImageIcon("images/frigo.jpeg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img2.paintIcon(this, g, 155,40);
		        g.drawString("frigo", 155, 155);
		        if(data.tab[1][2]==1) {
		        	g.drawString("true", 155, 170);
		        }else {
		        	g.drawString("false", 155, 170);
		        }
		        
		        Icon img3=new ImageIcon(new ImageIcon("images/clim.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img3.paintIcon(this, g, 270,40);
		        g.drawString("Climatiseur", 270, 155);
		        if(data.tab[1][7]==1) {
		        	 g.drawString("true", 270, 170);
		        }else {
		        	 g.drawString("false", 270, 170);
		        }
		       
		        Icon img4=new ImageIcon(new ImageIcon("images/vole.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img4.paintIcon(this, g, 395,40);
		        g.drawString("volee", 395, 155);
		        if(data.tab[1][6]==1) {
		        	g.drawString("true", 395, 170);
		        }else {
		        	g.drawString("false", 395, 170);
		        }
		        
		        Icon img5=new ImageIcon(new ImageIcon("images/porte.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img5.paintIcon(this, g, 530,40);
		        g.drawString("porte", 530, 155);
		        g.drawString("false", 530, 170);
		        Icon img6=new ImageIcon(new ImageIcon("images/robinet.jpeg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img6.paintIcon(this, g, 665,40);
		        g.drawString("robinet", 665, 155);
		        if(data.tab[1][4]==1) {
		        	 g.drawString("true", 665, 170);
		        }else {
		        	 g.drawString("false", 665, 170);
		        }
		       
		        Icon img7=new ImageIcon(new ImageIcon("images/chaise1.jpeg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img7.paintIcon(this, g, 40,190);
		        g.drawString("chaise1", 40, 305);
		     
		        if(data.tab[1][0]==1) {
		        	   g.drawString("true", 40, 320);
		        }else {
		        	   g.drawString("false", 40, 320);
		        }
		        Icon img8=new ImageIcon(new ImageIcon("images/chaise2.jpeg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img8.paintIcon(this, g, 155,190);
		        g.drawString("chaise2", 155, 305);
		        if(data.tab[1][1]==1) {
		        	g.drawString("true", 155, 320);
		        }else {
		        	g.drawString("false", 155, 320);
		        }
		        
		        Icon img9=new ImageIcon(new ImageIcon("images/teroire.jpeg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img9.paintIcon(this, g, 270,190);
		        g.drawString("teroire", 270, 305);
		        if(data.tab[1][3]==1) {
		        	g.drawString("true", 270, 320);
		        }else {
		        	g.drawString("false", 270, 320);
		        }*/
		        
		        
		    
		    }
	};;
    	cuisine.setBackground(Color.black);
    	JPanel salon = new JPanel() {
    		
   		 public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        g.setFont(new Font("default", Font.BOLD, 18));
		        
		        ImageIcon img0= new ImageIcon("images/salon1.gif");
		        g.drawImage(img0.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		       
		        g.drawString("Lampe :", 40, 100);
		        if(data.tab[0][6]==1) {
		        	
		        	g.drawString("allumée", 200,100);
		        	
		        }else {
		        	g.drawString("éteint", 200, 100);
		        }
		        g.drawString("Canapé 1 :", 40, 150);
                if(data.tab[0][2]==1) {
                	
               	 g.drawString("occupé", 200, 150);
               	
		        }else {
		        	g.drawString("libre", 200, 150);
		        }
                g.drawString("Climatiseur :", 40, 200);
		        if(data.tab[0][4]==1) {
		        	
		        	g.drawString("allumé", 200, 200);
		        	
		        }else {
		        	g.drawString("éteint", 200, 200);
		        }
		        g.drawString("Volets :", 40, 250);
		        if(data.tab[0][5]==1) {
		        	
		        	g.drawString("ouverts", 200, 250);
		        	
		        }else {
		        	g.drawString("fermés", 200, 250);
		        }
		        g.drawString("Canapé 2 : ", 40, 300);
		        if(data.tab[0][3]==1) {
		        	 
		        	 g.drawString("occupé", 200, 300);
		        	 
		        }else {
		        	 g.drawString("libre", 200, 300);
		        }		        
                g.drawString("Canapé convertible :", 40, 350);
		        
		        if(data.tab[0][1]==1) {
		        	
		        	g.drawString("occupé ", 250, 350);
		        	
		        }else {
		        	g.drawString("libre", 250, 350);
		        }
		        g.drawString("TV :",40 , 400);
		        if(data.tab[0][0]==1) {
		        	
		        	g.drawString("Alumée", 200, 400);
		        	
		        }else {
		        	 g.drawString("éteint", 200, 400);
		        }
		        /*      
		       
		  
		        Icon img=new ImageIcon(new ImageIcon("images/lamp.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img.paintIcon(this, g, 40,40);
		        
		        if(data.tab[0][1]==1) {
		        	g.drawString("true", 40, 170);
		        }else {
		        	g.drawString("false", 40, 170);
		        }
		        
		        Icon img2=new ImageIcon(new ImageIcon("images/canape1.jpeg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img2.paintIcon(this, g, 155,40);
		        g.drawString("canape1", 155, 155);
                 if(data.tab[0][2]==1) {
                	 g.drawString("true", 155, 170);
		        }else {
		        	g.drawString("false", 155, 170);
		        }
		        
		        Icon img3=new ImageIcon(new ImageIcon("images/clim.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img3.paintIcon(this, g, 270,40);
		        g.drawString("Climatiseur", 270, 155);
		        if(data.tab[0][4]==1) {
		        	g.drawString("true", 270, 170);
		        }else {
		        	g.drawString("false", 270, 170);
		        }
		        
		        Icon img4=new ImageIcon(new ImageIcon("images/vole.jpg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img4.paintIcon(this, g, 395,40);
		        g.drawString("volee", 395, 155);
		        if(data.tab[0][5]==1) {
		        	g.drawString("true", 395, 170);
		        }else {
		        	g.drawString("false", 395, 170);
		        }
		        
		        Icon img5=new ImageIcon(new ImageIcon("images/canape2.jpeg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img5.paintIcon(this, g, 530,40);
		        g.drawString("canape2", 530, 155);
		        if(data.tab[0][3]==1) {
		        	 g.drawString("true", 530, 170);
		        }else {
		        	 g.drawString("false", 530, 170);
		        }
		       
		        Icon img6=new ImageIcon(new ImageIcon("images/tv.jpeg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img6.paintIcon(this, g, 665,40);
		        g.drawString("tv", 665, 155);
		        if(data.tab[0][0]==1) {
		        	g.drawString("Alume", 665, 170);
		        }else {
		        	 g.drawString("false", 665, 170);
		        }
		     
		       
		        Icon img7=new ImageIcon(new ImageIcon("images/canape_conv.jpeg").getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		        img7.paintIcon(this, g, 40,190);
		        g.drawString("canape conv", 40, 305);
		        
		        if(data.tab[0][1]==1) {
		        	g.drawString("true", 40, 320);
		        }else {
		        	g.drawString("false", 40, 320);
		        }
		   */  
		       
		    }
	};
    	//salon.setBackground(Color.orange);
    	
    	btn5.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
        
        	  {
        		
      			//ajout paneau boutons
        		  maincontainer.add(sb,BorderLayout.CENTER);
        		  sb.updateUI();
        		  maincontainer.remove(chambre);
        		  maincontainer.remove(salon);
        		  maincontainer.remove(cuisine);
        		  
        		  //System.out.println("sbb" );
        	
      		}
          }
        });
    	btn6.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
        
        	  {
        		  
        		  
      			//ajout paneau boutons
        		  maincontainer.add(chambre,BorderLayout.CENTER);
        		  maincontainer.remove(sb);
        		  maincontainer.remove(salon);
        		  maincontainer.remove(cuisine);
        	
        		  chambre.updateUI();
        		  
      		}
          }
        });
    	btn7.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
        
        	  {
        		 
      			//ajout paneau boutons
        		  maincontainer.add(cuisine,BorderLayout.CENTER);
        		  cuisine.updateUI();
        		  maincontainer.remove(sb);
        		  maincontainer.remove(salon);
        		  maincontainer.remove(chambre);
      		}
          }
        });
    	btn8.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
        
        	  {
        		  
      			//ajout paneau boutons
        		  maincontainer.add(salon,BorderLayout.CENTER);
        		  salon.updateUI();
        		  maincontainer.remove(sb);
        		  maincontainer.remove(chambre);
        		  maincontainer.remove(cuisine);
      		}
          }
        });
        
    	PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
   
        // keeps reference of standard output stream
        standardOut = System.out; 
        // re-assigns standard output stream and error output stream
        System.setOut(printStream);
        System.setErr(printStream);
        
        btn1.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            
          try {
        	  if(i<20) {
        		  
			    data.fetch(S1[i]);	       
		        activity1.setText(data.act1);	      
		       activity2.setText(data.act2);
		        l1.setText("     temperature "+data.temp);
		        activity1.invalidate();
		        activity1.repaint();
		        activity2.invalidate();
		        activity2.repaint();
		        l1.invalidate();
		        l1.repaint();
		        invalidate();
		        repaint();
		       
		        if(iiii>=0) {
		        	
		        	 maincontainer.remove(jacc);
		            
		           iiii++;
		        }
		       
		        topPanel.repaint();maincontainer.repaint();
		       
		        
			salon.updateUI();
			chambre.updateUI();
			sb.updateUI();
			cuisine.updateUI();}else System.out.println("------fin-----------");
        	 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
         
          i++;
         
          }
        });
 
     
	}

    public static void main(String[] args){
    gui mygui = null;
	try {
		mygui = new gui();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    mygui.setVisible(true);
     
    }
}
