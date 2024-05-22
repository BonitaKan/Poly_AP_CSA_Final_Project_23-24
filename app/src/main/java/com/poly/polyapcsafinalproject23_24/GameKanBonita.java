package com.poly.polyapcsafinalproject23_24;

import java.util.Scanner;

public class GameKanBonita extends GameActivity {

    //create variables up here
    private Farmer player;



    //write game down here
    //  use other void methods as nesssary
    //  use loops as nessesary
    public void run()
    {
        System.out.print(TextColor.GREEN + "Farm crops and Earn money! Reach $100 to win the game!\n" + TextColor.RESET);
        createFarmer();
        runFarm();
    }

    private void createFarmer()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(TextColor.GREEN + "Farmer name: " + TextColor.RESET);
        String name = scan.nextLine();
        player = new Farmer(name);
    }

    private void runFarm()
    {
        while (player.getMoney() < 100)
        {
            displayStats();
            chooseOption();
        }
        endOfGame();
    }

    private void displayStats()
    {
        Util.clearConsole();
        String text =
                TextColor.BLACK_BOLD_BRIGHT + "\nFarmer:\t\t\t\t" + player.getName() +
                        "\nWheat collected:\t" + player.getWheatCollected() +
                        "\nWheat seeds:\t\t" + player.getWheatSeeds() +
                        "\nWheatField:\t\t\t" + player.getWheatField() +
                        "\nCarrots collected:\t" + player.getCarrotsCollected() +
                        "\nCarrot seeds:\t\t" + player.getCarrotSeeds() +
                        "\nCarrotField:\t\t" + player.getCarrotField() +
                        "\nMoney:\t\t\t\t$" + player.getMoney() + TextColor.RESET;
        System.out.println(text);


    }

    private void chooseOption()
    {
        Util.clearConsole();
        String text = TextColor.RED + """
      What do you want to do?\n""" + TextColor.YELLOW +
                """
                1. Harvest crops
                2. Plant crops
                3. Sell crops
                4. Crop shop
                """ + TextColor.RESET;

        System.out.println(text);
        int option = Util.enterInt(1,4);
        if (option == 1)
        {
            player.harvestFields();
            Util.clearConsole();
            System.out.println(TextColor.RED + "Harvesting fields...\n");
            Util.pauseConsole();
            Util.clearConsole();
            System.out.println("...");
            Util.pauseConsole();
            Util.clearConsole();
            System.out.println("Successfully harvested fields!\n" + TextColor.RESET);
            Util.pauseConsole();
            return;
        }
        else if (option == 2)
        {
            plantCrops();
        }
        else if (option == 3)
        {
            Util.clearConsole();
            Scanner scan = new Scanner(System.in);

            System.out.print(TextColor.GREEN + "What crop do you want to sell? \n1.Wheat\n2.Carrots\n" + TextColor.RESET);

            int option1 = Util.enterInt(1, 2);

            Util.clearConsole();

            if (option1 == 1)
            {
                player.sellAllWheat();
            }
            else if (option1 == 2)
            {
                player.sellAllCarrots();
            }
        }
        else if (option == 4)
        {
            buyCrops();
        }
        else if (option == 5)
        {
            displayStats();
        }

    }



    public void plantCrops()
    {
        Util.clearConsole();
        Scanner scan = new Scanner(System.in);

        System.out.print("Wheat seeds:\t\t" + player.getWheatSeeds() + "\nCarrot seeds:\t\t" + player.getCarrotSeeds() + TextColor.GREEN + "\nWhat crop would you like to plant?\n1. Wheat seeds\n2. Carrot seeds\n" + TextColor.RESET);

        int option = Util.enterInt(1, 2);

        Util.clearConsole();

        System.out.print(TextColor.GREEN + "How many seeds would you like to plant?\n" + TextColor.RESET);

        int quantity = scan.nextInt();

        if (option == 1)
        {
            plantWheat(quantity);
        }
        else if (option == 2)
        {
            plantCarrots(quantity);
        }
    }

    private void plantWheat(int quantity)
    {
        if (player.getWheatSeeds() >= quantity)
        {
            Util.clearConsole();
            System.out.println(TextColor.RED + "You've planted " + quantity + " wheat!\n" + TextColor.RESET);
            Util.pauseConsole();
            player.setWheatSeeds(player.getWheatSeeds() - quantity);
            player.setWheatField(player.getWheatField() + quantity);
        }
        else
        {
            System.out.println(TextColor.GREEN + "You don't have enough wheat seeds.. You can buy some at the Crop Shop!\n" + TextColor.RESET);
            Util.pauseConsole();
            return;
        }
    }

    private void plantCarrots(int quantity)
    {
        if (player.getCarrotSeeds() >= quantity)
        {
            Util.clearConsole();
            System.out.println(TextColor.GREEN + "You've planted " + quantity + " carrots!\n" + TextColor.RESET);
            Util.pauseConsole();
            player.setCarrotSeeds(player.getCarrotSeeds() - quantity);
            player.setCarrotField(player.getCarrotField() + quantity);
        }
        else
        {
            System.out.println(TextColor.RED + "You don't have enough carrot seeds.. You can buy some at the Crop Shop!\n" + TextColor.RESET);
            Util.pauseConsole();
            return;
        }
    }

    private void buyCrops()
    {
        Util.clearConsole();
        Scanner scan = new Scanner(System.in);

        System.out.print(TextColor.RED + "\nMoney:\t$" + player.getMoney() + TextColor.RESET + TextColor.GREEN + "\nWhat would you like to buy?\n1. Wheat seeds - $5\n2. Carrot seeds - $10\n" + TextColor.RESET);

        int option = Util.enterInt(1, 2);

        System.out.print(TextColor.GREEN + "How many would you like to buy?\n" + TextColor.RESET);

        int quantity = scan.nextInt();

        if (quantity <= 0)
        {
            System.out.println(TextColor.RED + "Invalid option! Please enter a positive number.\n" + TextColor.RESET);
            Util.pauseConsole();
            return;
        }

        int totalCost;

        if (option == 1)
        {
            totalCost = quantity * 5; //Wheat cost $5 each
        }
        else if (option == 2)
        {
            totalCost = quantity * 10; //Carrots cost $10 each
        }
        else
        {
            System.out.println(TextColor.RED + "Invalid option!\n" + TextColor.RESET);
            Util.pauseConsole();
            return;
        }


        if (player.getMoney() >= totalCost)
        {
            if (option == 1)
            {
                System.out.print(TextColor.GREEN + "You successfully bought " + quantity + " wheat seeds!\n" + TextColor.RESET);
                Util.pauseConsole();
                player.setWheatSeeds(quantity);
            }
            else if (option == 2)
            {
                System.out.print(TextColor.GREEN +"You successfully bought " + quantity + " carrot seeds!\n" + TextColor.RESET);
                Util.pauseConsole();
                player.setCarrotSeeds(quantity);
            }
            player.setMoney(player.getMoney() - totalCost);
        }
        else
        {
            System.out.print(TextColor.RED + "You don't have enough money...\n" + TextColor.RESET);
            Util.pauseConsole();
            return;
        }
    }

    private void endOfGame()
    {
        Util.clearConsole();
        System.out.println(TextColor.GREEN_BOLD + "Good job! you've reached $1000!\n" + TextColor.RESET);
        Util.pauseConsole();
        System.out.println(TextColor.BLACK + "Do you want to play again?\n" + TextColor.GREEN_BOLD + "1. Yes\n" + TextColor.RED_BOLD + "2. No\n" + TextColor.RESET);
        int option = Util.enterInt(1,2);
        if (option == 1)
        {
            run();
        }
        else if (option == 2)
        {
            endOfGame();
            Util.clearConsole();

        }
    }



}