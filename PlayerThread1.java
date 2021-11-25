public class PlayerThread1 extends Thread {
    Main objmain;
    int assignedStatus; //using this variable we are assigning a particular status to each player
    //which helps us while running threads for a particular player
    int positionHolder = 19;
    PlayerThread1(Main objmain, int assignedStatus) {
        this.objmain = objmain;
        this.assignedStatus = assignedStatus;
    }

    @Override
    public void run(){
        try{
            synchronized(objmain){
                while(true){
                    while(Main.currentStatus!=assignedStatus){ //here we are checking that if the assigned status of a player is not equal to current status then that player has to wait
                        objmain.wait();
                    }
                    Die randomNumber = new Die();
                    int dieFace = randomNumber.getFace(); //here we are generating the random number
                    Players objplayers = Main.players.get((Main.currentStatus)-1); //by this we are accessing which player's thread is running
                    System.out.println(objplayers.name+ " rolled " + dieFace);
                    int currentBoardPos = objplayers.updatePosition(dieFace); //here we are updating the position of player
                    if(currentBoardPos>positionHolder){
                        positionHolder+=19;
                        objplayers.addMoney(20);
                        System.out.println(objplayers.getName()+ " has passed through the Go Square ticket and 20 is added.");
                    }
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
                                if(objplayers.money>=50){
                                    objSquare.task(objplayers);
                                }
                                else{
                                    System.out.println(objplayers.name+" does not have money to pay the Income Tax");
                                    System.out.println("Game Stopped");
                                    objplayers.stopThreads();
                                } 
                            }
                            else if(objSquare.name.equals("Jail")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                                if(objplayers.money>=75){
                                    objSquare.task(objplayers);
                                }
                                else{
                                    System.out.println(objplayers.name+" does not have money to come out of the jail");
                                    System.out.println("Game Stopped");
                                    objplayers.stopThreads();
                                }
                            }
                            else if(objSquare.name.equals("GO")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                                objSquare.task(objplayers);
                            }
                            else if(objSquare.name.equals("Free Parking")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                            }
                            else if(objSquare.name.equals("Luxary Tax")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                                if(objplayers.money>=100){
                                    objSquare.task(objplayers);
                                }
                                else{
                                    System.out.println(objplayers.name+" does not have money to pay the Luxary Tax");
                                    System.out.println("Game Stopped");
                                    objplayers.stopThreads();
                                }
                            }
                            else if(objSquare.name.equals("Go To Jail")){
                                System.out.println(objplayers.name + " has come to "+ objSquare.name);
                                objSquare.task(objplayers);
                            }
                            else{//he has reached a buyable property
                                System.out.println(objplayers.name + " has come to "+ objSquare.name + " and the player buys it for "+objSquare.price);
                                objplayers.substractMoney(objSquare.price); 
                                Tickets.PlayerProperties.put(objSquare.name, Main.currentStatus);
                            }
                        }
                        else{// when player has no money to buy the property which is not bought by anyone else
                            System.out.println(objplayers.getName() + " does not have enough funds to buy the property.");
                        }
                    }
                    else{ 
                        if((objSquare.name.equals("Electric Company")? objplayers.money>=4*dieFace: objplayers.money>=objSquare.rent) && (Main.currentStatus!=propertyOwner)){//he is going to pay rent if the player has not landed to his own property
                            
                            if(objSquare.name.equals("Electric Company")){ //if player has come to electric company then money subtracted should be equal to 4 times of the distance he/she has travelled to come to electric company
                                objplayers.substractMoney(4*dieFace);
                                Main.players.get(propertyOwner-1).addMoney(4*dieFace); //the rent will get added to that players account who owns the property
                                System.out.println(objplayers.name + " is going to pay rent for " + objSquare.name + " to " + Main.players.get(propertyOwner-1).getName() + " of amount "+4*dieFace);
                            }
                            else{
                                objplayers.substractMoney(objSquare.rent);
                                Main.players.get(propertyOwner-1).addMoney(objSquare.rent); //the rent will get added to that players account who owns the property
                                System.out.println(objplayers.name + " is going to pay rent for " + objSquare.name + " to " + Main.players.get(propertyOwner-1).getName() + " of amount "+objSquare.rent);
                            }
                        }
                        else if(Main.currentStatus==propertyOwner){// this block of code will run when player has landed to his own property.
                            System.out.println(objplayers.name+ " has landed to his own property i.e. " +objSquare.name + " so no rent will be deducted");
                        }
                        else{ //if he can't pay rent as well then we are going to stop all the threads
                            System.out.println(objplayers.name + " does not have sufficient funds to pay rent to "+ Main.players.get(propertyOwner-1).getName());
                            System.out.println("Game Stopped");
                            objplayers.stopThreads();
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
