/******************************************************
***  Class Name: ListController
***  Class Author: Gabriel Winkler
******************************************************
*** Purpose of the class: This class will take input from the different text
*** boxes and add to or delete from the linked list.
******************************************************
*** Date: September 9th, 2017
******************************************************
*** List of changes with dates:
*** September 9th: Write the ListController class
******************************************************
*** Look at this!
*** As suggested by Rae in class, I made the list sort itself when displayed.
*******************************************************/


/**
 *
 * @author Gabriel
 */
public class ListController 
{
    private IntLinkedList groot;
    private int countUp;
    private int countDown;

/******************************************************
***  Method Name: linkAdd
***  Method Author: Gabriel Winkler
******************************************************
*** Purpose of the Method: To allow a temporary link for adding a new link to the list.
*** Method Inputs: integer from user
******************************************************
*** Date: September 9th, 2017
******************************************************/

    public void linkAdd(int nextInt)
    {
        IntLinkedList temp = new IntLinkedList();
        temp.value = nextInt;
        IntLinkedList temp2;
        countUp = 0;
        
        if(groot == null)
        {
            groot = temp;
        }
        
        else
        {
            temp2 = groot;
            while(temp2.nextLL != null)
                temp2 = temp2.nextLL;
            temp2.nextLL = temp;
        }
    }
/******************************************************
***  Method Name: printLList
***  Method Author: Gabriel Winkler
******************************************************
*** Purpose of the Method: To manage displaying the status of the Linked List
*** Return value:
*** This method will return a String containing the Linked List
******************************************************
*** Date: September 9th, 2017
******************************************************/
public String printLList()
    {
        IntLinkedList temp = groot;
        String display = "";
        while(temp!= null)
        {
           display += (temp.value + "    ");
           //System.out.println(temp.value + "    "); //prints link list from beginning
           temp = temp.nextLL; //points to next link
        }
        
        return display;
    }
/******************************************************
***  Method Name: delLink
***  Method Author: Gabriel Winkler
******************************************************
*** Purpose of the Method: To handle the deletion of a link in the list.
*** Method Inputs: integer from the user
*** Return value: This returns the portion of the list that was no deleted.
******************************************************
*** Date: September 9th, 2017
******************************************************/

public IntLinkedList delLink(int number)
    {
        IntLinkedList current = groot;              
        IntLinkedList previous = groot; 
        countDown = 0;
        while(current.value != number) 
        { 
            if(current.nextLL == null) 
                return null;
            else 
            { 
                previous = current;
                current = current.nextLL;
                countDown++;
            }  
        }  
        
        if(current == groot) 
            groot = groot.nextLL;         
        else                               
            previous.nextLL = current.nextLL; 
        
        return current;
    }
/******************************************************
***  Method name: sortedLink
***  Method Author: Gabe with input from Rae
******************************************************
*** This method inputs a link into the link list while sorting it
*** at the same time. It also calls the find() method, which verifies
*** that the user's number has not been entered already before we attempt
*** to insert it into the link list.
*** Method Inputs: integer value from user
*** Return value: returns either 1 or -1
*** The return values are based on whether a number has already been entered 
*** into the list
******************************************************
*** Date: September 9th, 2016
******************************************************
*** Cool stuff: Rae showed me that it was possible to keep the list sorted as
***   the user adds more integers to it.
*****************************************************/

    public int sortedLink(int myValue)
    {
        IntLinkedList temp= new IntLinkedList();
        temp.value = myValue;
        IntLinkedList previous = null;  
        IntLinkedList current = groot;
        countUp = 0;
        
        if(search(myValue) == 1)  //This adds a link if value has not already been entered
        {    
            while(current != null && myValue > current.value) // or myValue > current 
            {                     
                previous = current;
                current = current.nextLL;   // go to next item
                countUp++;
            }
            if(previous==null)
                groot = temp;                             
        
            else 
                previous.nextLL = temp;      
        
            temp.nextLL = current;  
            //System.out.println("It took "+countUp+" iterations to insert.");// test display of count iterations
            return 1;              //returns number of iteration
        }        
        else
        {
            return -1;  //does not add number to list because it has already been entered
        }
    }
    
/******************************************************
***  Method name: search
***  Method author: Gabriel Winkler
******************************************************
*** This method searches to see if a number is already in the list 
*** Method Inputs: integer from user
*** Return value: returns -1 if number is found or 1 if number is not found
******************************************************
*** Date: September 9th, 2016
******************************************************/

    public int search(int number)      // find link with given number 
    {                           
        IntLinkedList current = groot;    
        
        if(groot != null)    //only runs if list is not empty
        {
            while(current.value != number) 
            { 
                if(current.nextLL == null)
                    return 1;
                else 
                    current = current.nextLL;
            } 
            return -1;
        }
        else return 1;
    }
}
