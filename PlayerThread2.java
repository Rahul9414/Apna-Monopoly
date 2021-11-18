import java.util.*;

public class PlayerThread2 extends Thread {
    Main objmain;

    PlayerThread2(Main objmain) {
        this.objmain = objmain;
    }

    @Override
    public void run(){
        try{
            synchronized(objmain){
                int i=0;
                while(i<50){
                    while(Main.status!=2){
                        objmain.wait();
                    }
                    Die randomNumber = new Die();
                    int dieFace = randomNumber.getFace(); //here we are generating the random number
                    Players objplayers = Main.players.get((Main.status)-1); //player ka object aaya
                    int currentBoardPos = objplayers.updatePosition(dieFace); //here we are updating the position of player
                    // Tickets objtickets = new Tickets();
                    if(currentBoardPos>=19){
                        currentBoardPos = currentBoardPos % 19;
                    }
                    Square objSquare = Tickets.squares[currentBoardPos]; //object for the current board position on which the player is
                    int propertyOwner = Tickets.isPurchasedStatus(objSquare); //now we got to know that who owns the property
                    //objSquare.name
                    if(propertyOwner==0){ //means he can buy property
                        if(objplayers.money>=objSquare.price){
                            if(objSquare.name.equals("Community Chest")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Chance")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Income Tax")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Rail Road")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Jail")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Go Square")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Utility")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Free Parking")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Luxary Card")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Go To Jail")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else{
                                System.out.println(objplayers.name + " has come to "+ objSquare.name + " " +objplayers.getMoney());
                                objplayers.substractMoney(objSquare.price); 
                                Tickets.PlayerProperties.put(objSquare.name, Main.status);
                            }
                        }
                        else{
                            System.out.println("Paisa nahi hai mere pass2");
                        }
                    }
                    else{ 
                        if(objplayers.money>=objSquare.rent){//he is going to pay rent
                            System.out.println(objplayers.name + " is going to pay rent for " + objSquare.name + " to " + Main.players.get(propertyOwner-1).getName());  
                            objplayers.substractMoney(objSquare.rent); 
                            Main.players.get(propertyOwner-1).addMoney(objSquare.rent); //jiski property hai usse paisa mil gaya
                        }
                        // else{ //if he can't pay rent as well then he is kicked out and we make his money as 0
                        //     objplayers.money =0;
                        // } 
                    }
                    // if(Main.players.get(Main.status+1).getMoney()>0){
                    //     Main.status+=1;
                    //     objmain.notifyAll();

                    // }
                    // else{
                    //     Main.status+=2;
                    //     objmain.notifyAll();
                    // }
                    i++;
                    System.out.println(Main.status);
                    Main.status=3;
                    objmain.notifyAll();
                }
            }
        }
        catch(Exception e){
            System.out.println("Exception2" + e);
            e.printStackTrace();
            
        }
    }
}
