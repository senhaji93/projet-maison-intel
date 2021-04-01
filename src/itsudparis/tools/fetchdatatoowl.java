package itsudparis.tools;

import java.io.IOException;


import com.hp.hpl.jena.rdf.model.Model;
import itsudparis.tools.JenaEngine;
import itsudparis.tools.readdatasets;

import com.hp.hpl.jena.rdf.model.Model;

public class fetchdatatoowl {
	    public int[][]	tab = new int[4][10];
	    public String act1;
	    public String act2;
	    public int temp;
	    public static final String ns = "http://www.semanticweb.org/pc/ontologies/2021/0/untitled-ontology-10#";
	    public static String inputDataOntology = "data/smartmaison.owl";
	    public static String inputRule = "data/rules.txt";
	    public static String all= "data/querryequipement.txt";
	    public static String ouverturevolet= "data/query.txt";
	    public static String dejeuneR2 = "data/query1.txt";
	    public static String overturevoletsalon = "data/query2.txt";
	    public static String rentretoilette1  = "data/query3.txt";
	    public static String rentretoilette2  = "data/query20.txt";
	    public static String dormir1 = "data/query4.txt";
	    public static String dormir2 = "data/query5.txt";
	    public static String dejeune1 = "data/query6.txt";
	    public static String sortir1 = "data/query7.txt";
	    public static String Studying2 = "data/query8.txt";
	    public static String regarder_TV1 = "data/query9.txt";
	    public static String inputQuery10 = "data/query10.txt";
	    public static String alarmereviel = "data/query11.txt";
	    public static String alarmereveil2 = "data/query12.txt";
	    public static String fermeturevolet= "data/query13.txt";
	    public static String alumerlumiere= "data/query25.txt";
	    public static String diner1= "data/query14.txt";
	    public static String diner2= "data/query15.txt";
	    public static String v_chambre= "data/query16.txt";
	    public static String v_cuisine= "data/query17.txt";
	    public static String v_salon= "data/query18.txt";
	    public static String lampe1chambre= "data/query21.txt";
	    public static String lampe2cuisine= "data/query22.txt";
	    public static String lampe4salon= "data/query23.txt";
	    public static String lampe5sb= "data/query24.txt";
	    public static String temperaturee= "data/query26.txt";
	    public static String clim= "data/query27.txt";
	    public static String regarder_TV2= "data/query19.txt";
	    public static String preparepdej= "data/query28 .txt";
	   // public static String mangerdine1= "data/query29.txt";
	    //public static String mangerdine2= "data/query10.txt";

	public  void fetch(int line) throws IOException{
        Model model = JenaEngine.readModel(inputDataOntology);
        Model inferedModel = JenaEngine.readInferencedModelFromRuleFile(model, inputRule);
       // JenaEngine.updateValueOfDataTypeProperty(inferedModel, ns, "Peter", "age", 10);
        //
        for(int iii=0;iii<4;iii++) {
        	for(int jjj=0;jjj<10;jjj++) {
        		tab[iii][jjj]=0;
        	}
        }
        //JenaEngine.createInstanceOfClass(model, ns, "Femme", "abc");
        readdatasets data=new readdatasets();
        
        data.readdata(line);  
       String[] tokens=data.getTokens();
     
       int[] temperature=data.getTemperature();
       
    //updateheure
      String[] heure=tokens[0].split(":");
      JenaEngine.updateValueOfDataTypeProperty(inferedModel, ns,"heure", "heureest", Integer.parseInt(heure[0]));
      JenaEngine.updateValueOfDataTypeProperty(inferedModel, ns,"heure", "minest", Integer.parseInt(heure[1]));
      JenaEngine.updateValueOfDataTypeProperty(inferedModel, ns,"heure", "secest", Integer.parseInt(heure[2]));
      //updatetemperature
      JenaEngine.updateValueOfDataTypeProperty(inferedModel, ns,"capteur", "temperature",temperature[Integer.parseInt(heure[0])]);
      temp=temperature[Integer.parseInt(heure[0])];
       //System.out.print(JenaEngine.executeQueryFile(inferedModel, all));	
     // System.out.print(JenaEngine.executeQueryFile(inferedModel, temperaturee));	
       for(int i=1;i<=20;i++) {
    	  
			 String col = tokens[i];
              if(i==1){
            	  if(Integer.parseInt(col)== 1){
            		  System.out.print(" l'armoire de la chambre est ouverte  \n"); 
    			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "photocell1", "etat", "true");
    			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "armoire1", "etat", "true");
    			      this.tab[3][1]=1;
            	  }else {
            		  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "photocell1", "etat", "false");
    			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "armoire1", "etat", "false");

            		  
            	  }
              }
              if((i==2)) {
            	  if(Integer.parseInt(col)== 1) {
            		  System.out.print("le canape convertible est occupe \n"); 
    			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "photocell2", "etat", "true");
    			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "canape_convertible", "etat", "true");
    			      this.tab[0][1]=1;
            	  }else {
     			     JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "photocell2", "etat", "false");
     			     JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "canape_convertible", "etat", "false");

     			     }

              }
			 if((i==3)) {
				 if(Integer.parseInt(col)== 1) {System.out.print(" la TV est allumee \n"); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "IR", "etat", "true");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "tv", "etat", "true");
                 this.tab[0][0]=1;
                 }else {	
                	 JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "IR", "etat", "false");
                	 JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "tv", "etat", "false");
                	 this.tab[0][0]=0;
}
			 }	 			      
			
			 if((i==4)) {
				 
				 if(Integer.parseInt(col)== 1) { System.out.print("le canape 1 est occupe \n");  
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "force_sensor1", "etat", "true");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "canape1", "etat", "true");
			      this.tab[0][2]=1;
				     }else {		
				  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "force_sensor1", "etat", "false");
				  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "canape1", "etat", "false");

}
				
			 }
			 if((i==5)) {
				 if(Integer.parseInt(col)== 1) {System.out.print("le canape 2 est occupe\n"); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "force_sensor2", "etat", "true");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "canape2", "etat", "true");
			      this.tab[0][3]=1;
			      }else {
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "force_sensor2", "etat", "false");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "canape2", "etat", "false");

}
				 
	
			 }
			 if((i==6)) {
				 if(Integer.parseInt(col)== 1) { System.out.print("la chaise 1 est occupee 	\n"); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "distance1", "etat", "true");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "chaise1", "etat", "true");
			      this.tab[1][0]=1;
				     }else {
				  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "distance1", "etat", "false");
				  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "chaise1", "etat", "false");

}
				
			 }
			 if((i==7)) {
				 if(Integer.parseInt(col)== 1) { System.out.print("la chaise 2  est occupee \n"); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "distance2", "etat", "true");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "chaise2", "etat", "true");
			      this.tab[1][1]=1;
			      }else {				 
			       JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "distance2", "etat", "false");
			       JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "chaise2", "etat", "false");

} 
			 }
			  if(i==8) {
				  if(Integer.parseInt(col)== 1) { System.out.print("le frigo est ouvert \n"); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "photocell3", "etat", "true");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "frigo", "etat", "true");
			      this.tab[1][2]=1;
			      }else {				 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "photocell3", "etat", "false");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "frigo", "etat", "false");

}
			  }
				 
			  if((i==9)) {
				  if(Integer.parseInt(col)== 1) {System.out.print("le tiroire de la cuisine est ouvert \n"); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "photocell4", "etat", "true");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "tiroireCuisine1", "etat", "true");
			      this.tab[1][3]=1;
				     }else {				 
				  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "photocell4", "etat", "false");
				  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "tiroireCuisine1", "etat", "false");

                           }
				  
			 }
			 if((i==10)) {
				 System.out.print("");
			 }	
			
				
			 if((i==11)) {
				  if(Integer.parseInt(col)== 1) {System.out.print("l'armoire de la salle de bain est ouverte \n"); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "armoire2", "etat", "true");
			      this.tab[2][2]=1;
				     }else {				 
				  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "armoire2", "etat", "false");

                           }
			 }
		
			 if((i==12)) {
				  if(Integer.parseInt(col)== 1) { System.out.print("la porte de la maison est ouverte	\n"); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "contact_sensor1", "etat", "true");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "porte_maison", "etat", "true");

			      }else {
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "contact_sensor1", "etat", "false");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "porte_maison", "etat", "false");

}
				
			 }
			 if((i==13)) {
				  if(Integer.parseInt(col)== 1) { System.out.print("la porte de la salle de bain est ouverte	\n"); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "contact_sensor2", "etat", "true");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "porte_sb", "etat", "true");
			      this.tab[2][0]=1;
				     }else {			     
				  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "contact_sensor2", "etat", "false");
				  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "porte_sb", "etat", "false");

}
				
			 }

			 if((i==14)) {
				 System.out.print(""); 	
				
			 }
			 if((i==15)) {
				 if(Integer.parseInt(col)== 1) {System.out.print("detection de presence dans la cuisine	\n"); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "sonar_distance1", "etat", "true");
				   }else { JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "sonar_distance1", "etat", "false");}
				 
			 }
			     
			 if((i==16)) {
				 if(Integer.parseInt(col)== 1) { System.out.print("detection de presence dans le salon \n"); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "sonar_distance2", "etat", "true");
			     // JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "sonar_distance2", "etat", "true");
///////////////////////////il faut rajoute capteur pres salon dans owl
			      }else {				  
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "sonar_distance2", "etat", "false");
			      //JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "sonar_distance2", "etat", "false");

}
			 }
			 if((i==18)) {
				 if(Integer.parseInt(col)== 1) { System.out.print("la chasse_d'eau est active	\n"); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "distance3", "etat", "true");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "chasse_d'eau1", "etat", "true");
			      this.tab[2][1]=1;
			      }else { 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "distance3", "etat", "false");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "chasse_d'eau1", "etat", "false");

			      }
				
			 }
				 
			 if((i==17)) {
				 if(Integer.parseInt(col)== 1) { System.out.print(" "); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "distance4", "etat", "true");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "robinet1", "etat", "true");
			      this.tab[1][4]=1;
			      }else { 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "distance4", "etat", "false");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "robinet1", "etat", "false");
			      }
				
			 }
				
			 if((i==19)) {
				 if(Integer.parseInt(col)== 1) { //restregl
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "temperature1", "etat", "true");
			    //  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "temperature1", "etat", "true");

				     }else {
				  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "temperature1", "etat", "false");
				 // JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "temperature1", "etat", "false");
}
				 
			 }

			 if((i==20)) {
				 if(Integer.parseInt(col)== 1) { System.out.print("le lit est occupe \n"); 
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "force_sensor3", "etat", "true");
			      JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "lit", "etat", "true");
			      this.tab[3][0]=1;
				  }else { 
				  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "force_sensor3", "etat", "false");
				  JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "lit", "etat", "false");

				  }
				
			 }
				 
			 
			 
		 }
       int act11=0;
       int act22=0;
       String fermeturevoletq=JenaEngine.executeQueryFile(inferedModel,fermeturevolet);
       String alumerlumiereq=JenaEngine.executeQueryFile(inferedModel,alumerlumiere);
       String ouverturevoletq=JenaEngine.executeQueryFile(inferedModel,ouverturevolet);
       String overturevoletsalonq=JenaEngine.executeQueryFile(inferedModel,overturevoletsalon);
       String dejeune1q=JenaEngine.executeQueryFile(inferedModel,dejeune1);
       String dormir1q=JenaEngine.executeQueryFile(inferedModel,dormir1);
       String dormir2q=JenaEngine.executeQueryFile(inferedModel,dormir2);
       String rentretoilette1q=JenaEngine.executeQueryFile(inferedModel,rentretoilette1);
       String rentretoilette2q=JenaEngine.executeQueryFile(inferedModel,rentretoilette2);
       String sortir1q=JenaEngine.executeQueryFile(inferedModel,sortir1);
       String Studying2q=JenaEngine.executeQueryFile(inferedModel,Studying2);
       String regarder_TV1q=JenaEngine.executeQueryFile(inferedModel,regarder_TV1);
       String  alarmerevielq=JenaEngine.executeQueryFile(inferedModel, alarmereviel);
       String   dejeuneR2q=JenaEngine.executeQueryFile(inferedModel,  dejeuneR2);
       String   alarmereveil2q=JenaEngine.executeQueryFile(inferedModel,  alarmereveil2);
       String   diner1q=JenaEngine.executeQueryFile(inferedModel,  diner1);
       String   diner2q=JenaEngine.executeQueryFile(inferedModel,  diner2);
       String   v_chambreq=JenaEngine.executeQueryFile(inferedModel,  v_chambre);
       String   v_cuisineq=JenaEngine.executeQueryFile(inferedModel,  v_cuisine);
       String   v_salonq=JenaEngine.executeQueryFile(inferedModel,  v_salon);
       String regarder_TV2q=JenaEngine.executeQueryFile(inferedModel,regarder_TV2);
       String lampe5sbq=JenaEngine.executeQueryFile(inferedModel,lampe5sb);
       String lampe4salonq=JenaEngine.executeQueryFile(inferedModel, lampe4salon);
       String lampe2cuisineq=JenaEngine.executeQueryFile(inferedModel,lampe2cuisine);
       String lampe1chambreq=JenaEngine.executeQueryFile(inferedModel,lampe1chambre);
       String climq=JenaEngine.executeQueryFile(inferedModel,clim);
       String  preparepdejq=JenaEngine.executeQueryFile(inferedModel, preparepdej);
      // String  mangerdine2q=JenaEngine.executeQueryFile(inferedModel, mangerdine2);
       //String  mangerdine1q=JenaEngine.executeQueryFile(inferedModel, mangerdine1);
      
      
       if(preparepdejq.contains("true")) {
    	   System.out.print("le resident 1 prepare son petit dejeuner \n");
			act1="prepare le petit dejeuner";
			act11++;
		}
      
       if(climq.contains("true")) {
    	   this.tab[2][3]=1;
    	   this.tab[3][3]=1;
    	   this.tab[1][7]=1;
    	   this.tab[0][4]=1;
		}
       if(v_chambreq.contains("true")) {
    	   this.tab[3][2]=1;
		}
      if(v_cuisineq.contains("true")) {
    	  this.tab[1][6]=1;
		}
      if(v_salonq.contains("true")) {
    	  this.tab[0][5]=1;
		}
       if(lampe5sbq.contains("true")) {
    	   this.tab[2][4]=1;
		}
       if(lampe4salonq.contains("true")) {
    	   this.tab[0][6]=1;
		}
       if(lampe2cuisineq.contains("true")) {
    	   this.tab[1][5]=1;
		}
       if(lampe1chambreq.contains("true")) {
    	   this.tab[3][4]=1;
		}
        
       
       if(diner1q.contains("true")) {
			System.out.print("notification : c'est l'heure du diner pour le resident 1 \n");
		}
       if(diner2q.contains("true")) {
			System.out.print("notification : c'est l'heure du diner pour le resident 2 \n");
		}
      
       
       if(alarmereveil2q.contains("true")) {
			System.out.print("notification : c'est l'heure du reveil pour le resident 2 \n");
		}
       if(alumerlumiereq.contains("true")) {
    			System.out.print("notification :  allumee la lumiere \n");
    		}
       if(dejeuneR2q.contains("true")) {
			System.out.print("notification : c'est l'heure du  dejeune pour le resident 2\n");
		}
       if(fermeturevoletq.contains("true")) {
    	   System.out.print("notification :  fermeture des volets  \n");
    	   this.tab[3][2]=0;
    	   this.tab[1][6]=0;
    	   this.tab[0][5]=0;
		}
       if(ouverturevoletq.contains("true")) {
			System.out.print("notification : ouverture des volets de la chambre et de la cuisine\n");
			this.tab[3][2]=1;
	    	this.tab[1][6]=1;
		}
       if(overturevoletsalonq.contains("true")) {
			System.out.print("notification : ouverture des volets du salon\n");
			this.tab[0][5]=1;
		}
      if(dejeune1q.contains("true")) {
			System.out.print("le resident 1 prend son petit dejeuner \n");
			act1="prendre le petit dejeuner";
			act11++;
		}
       if(dormir1q.contains("true")) {
			System.out.print("le resident 1 est entrain de dormir  \n");
			act1="dormir";
			act11++;
		}
       if(alarmerevielq.contains("true")) {
			System.out.print("notification : c'est l'heure du reveil pour le resident 1\n");
		}
       if(dormir2q.contains("true")) {
			System.out.print("le resident 2 est entrain de dormir \n");
			act2="dormir";
			act22++;
		}
       if(rentretoilette1q.contains("true")) {
			System.out.print("le resident 1 utilise la salle de bain \n");
			act1="occuper la salle de bain";
            act11++;
		} 
       if(rentretoilette2q.contains("true")) {
			System.out.print("le resident 2 utilise la salle de bain \n");
			act2="occuper la salle de bain";
			act22++;
		} 
       if(sortir1q.contains("true")) {
			System.out.print("le resident 1 est sorti \n");
			act1="sortir";
			act11++;
		} 
       if(Studying2q.contains("true")) {
			System.out.print("le resident 2 est entain d'etudie \n");
			act2="etudier";
			act22++;
		} 
       if(regarder_TV1q.contains("true")) {
			System.out.print("le resident 1 regarde la TV \n");
			act1="regarder la TV";
			act11++;
		} 
       if(regarder_TV2q.contains("true")) {
			System.out.print("le resident 2 regarde la TV \n");
			act2="regarder la TV";
			act22++;
		} 
       // JenaEngine.updateValueOfObjectProperty(inferedModel, ns, "lampe1", "etat", "true");
    /*   if(act11==0) {
			act1=" ";
		} 
       if(act22==0) {
			act2="";
		} */
        //query on the model
       
    }

	public String getAct1() {
		return act1;
	}

	public void setAct1(String act1) {
		this.act1 = act1;
	}

	public String getAct2() {
		return act2;
	}

	public void setAct2(String act2) {
		this.act2 = act2;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public int[][] getTab() {
		return tab;
	}

	public void setTab(int[][] tab) {
		this.tab = tab;
	}

}
