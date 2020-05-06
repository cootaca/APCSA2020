package APCSA_FRQ_Set4;
import java.util.ArrayList;

public class OnlinePurchaseManager
{
   //purchases stores Gizmos
   private ArrayList<Gizmo> purchases;
   
   
   //point purchases at a new ArrayList   
   public OnlinePurchaseManager()
   {
   	purchases = new ArrayList<Gizmo>();
   }
   
   
   //NOT part of the sample question
   //needed in order to type up and
   //test student code
   public void add( String m, boolean e )
   {
   	purchases.add( new Gizmo( m, e) );
   }
   
   
   //Part A
   //count the number of Gizmos made by maker
   //that are also electronic
   //must call getMaker and isElectronic
   //return the count or 0 if no matches
   public int countElectronicsByMaker(String maker)
   {   
   	//WRITE CODE HERE FOR PART A
	int count =0;
	for(Gizmo giz:purchases) {
		if(giz.getMaker()==maker&&giz.isElectronic()) {
				count++;
		}
	}
   	return count;   	
   }
   

   //Part B
   //loop thought the list and check for matching adjacent pairs
   //return true of any adjacent [ side by side ] pairs are the same
   //to be the same the pairs must have the same maker and
   //be either electronic or non-electronic
   //you really really should use the equals method from Gizmo
   public boolean hasAdjacentEqualPair()
   {  
   	//WRITE CODE HERE FOR PART B
   	if(purchases.size()>=2) {
   		for(int i=0;i<purchases.size()-1;i++){
   			if(purchases.get(i).equals(purchases.get(i+1))){
   				return true;
   			}
   		}
   	}
   	return false;
   }
   
   
   //NOT part of the sample question
   //needed in order to type up and
   //test student code
   public String toString()
   {
   	return "" + purchases;
   }
}


/*Part C

OPEN-ENDED SECTION

A programmer would like to add a method getCheapestGizmoByMaker, 
which returns the least expensive Gizmo purchased by an individual 
from a given maker.

Write a description of how you would change the Gizmo and OnlinePurchaseManager 
classes in order to support this modification. 
 
Make sure to include the following in your response. 

�	Write the method header for the getCheapestGizmoByMaker method. 
	DO write code for this part.
	**
	public int getCheapestGizmoByMaker(String maker){
	}
	
�	Identify any new or modified variables, constants, constructors, 
   or methods aside from the getCheapestGizmoByMaker method. 
   DO NOT write code for this part.
   **
   We would have to add a price instance variable in the Gizmo class, and each Gizmo would have an associated price with it. 
   We would just have to modify the add method in OnlinePurchaseManager to include the price element.
   We would also have to add the get and method for the price.
   
�	Describe, for each new or revised variable, constant, constructor, 
   or method, how it would change or be implemented, including visibility and type. 
   You do not need to describe the getCheapestGizmoByMaker method.
   DO NOT write code for this part.
   **
   The way we would implement the price instance variable would be to add the the variable with the visibility of private, 
   meaning it is only visible and accessible by the Gizmo class.
   It would also be of the primitive type double. 
   Our getPrice method would have a return type of int. It would be a public method, so it would be accessible by instances of the Gizmo class.
   The getCheapestGizmoByMaker would have a return type of int, be a public method, and take a string parameter, which would represent the 
   maker whose cheapest product the method would be trying to find.
*/

