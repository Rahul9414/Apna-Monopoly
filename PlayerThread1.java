public class PlayerThread1 extends Thread {
    Main objmain;
    int assignedStatus; //using this variable we are assigning a particular status to each player
    //which helps us while running threads for a particular player
    PlayerThread1(Main objmain, int assignedStatus) {
        this.objmain = objmain;
        this.assignedStatus = assignedStatus;
    }

    @Override
    public void run(){
        try{
            synchronized(objmain){
                while(Main.flag){
                    while(Main.currentStatus!=assignedStatus){ //here we are checking that if the assigned status of a player is not equal to current status then that player has to wait
                        objmain.wait();
                    }
                    Die randomNumber = new Die();
                    int dieFace = randomNumber.getFace(); //here we are generating the random number
                    Players objplayers = Main.players.get((Main.currentStatus)-1); //by this we are accessing which player's thread is running
                    System.out.println(objplayers.name+ " rolled " + dieFace);
                    int currentBoardPos = objplayers.updatePosition(dieFace); //here we are updating the position of player
                    if(currentBoardPos>=19){
                        currentBoardPos = currentBoardPos % 19;
                    }
                    Square objSquare = Tickets.squares[currentBoardPos]; //object for the current board position on which the player is
                    objplayers.property.add(objSquare.name);//here we are storing the current property of player on which the player has land
                    int propertyOwner = Tickets.isPurchasedStatus(objSquare); //now we got to know that who owns the property. If property owner comes out to be 0 then no one owns that property and the current player can buy if he/she has suffiecient funds
                    if(propertyOwner==0){ //means he can buy property
                        if(objplayers.money>=objSquare.price){
                            if(objSquare.name.equals("Community Chest")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                                objSquare.task(objplayers);
                            }
                            else if(objSquare.name.equals("Chance")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                                objSquare.task(objplayers);
                            }
                            else if(objSquare.name.equals("Income Tax")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                                objSquare.task(objplayers);
                            }
                            else if(objSquare.name.equals("Rail Road")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Jail")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Go Square")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                                objSquare.task(objplayers);
                            }
                            else if(objSquare.name.equals("Utility")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Free Parking")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Luxary Tax")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                                objSquare.task(objplayers);
                            }
                            else if(objSquare.name.equals("Go To Jail")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                                objSquare.task(objplayers);
                            }
                            else{
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                                objplayers.substractMoney(objSquare.price); 
                                Tickets.PlayerProperties.put(objSquare.name, Main.currentStatus);
                            }
                        }
                    }
                    else{ 
                        if(objplayers.money>=objSquare.rent){//he is going to pay rent
                            System.out.println(objplayers.name + " is going to pay rent for " + objSquare.name + " to " + Main.players.get(propertyOwner-1).getName());
                            objplayers.substractMoney(objSquare.rent); 
                            // System.out.println(objplayers.getMoney()+ " is the current funds");
                            Main.players.get(propertyOwner-1).addMoney(objSquare.rent); //the rent will get added to that players account who owns the property 
                        }
                        else{ //if he can't pay rent as well then we are going to stop all the threads
                            System.out.println(objplayers.name + " has neither money to pay rent nor buy property");
                            for(int j=0;j<Main.numberOfPlayer;j++){
                                Main.objplayerthreads[j].stop();
                            }
                        } 
                    }
                    if(Main.currentStatus==Main.numberOfPlayer){// this block will run when all the players has played one turn and this block is used to disply the game's state after rotation of die by all players
                        System.out.println("Current Game State :");
                        for(int i=0; i<Main.numberOfPlayer;i++){
                            System.out.println(Main.players.get(i).getName() + "    " + Main.players.get(i).property.get(Main.players.get(i).property.size()-1) + "     "+ Main.players.get(i).getMoney()); //here we are printing the name of player, last position, and money 
                        }
                        System.out.println();
                        Main.currentStatus=1;
                    }
                    else{
                        Main.currentStatus+=1;
                    }
                    objmain.notifyAll();
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception " + e);
        }
    }
}
