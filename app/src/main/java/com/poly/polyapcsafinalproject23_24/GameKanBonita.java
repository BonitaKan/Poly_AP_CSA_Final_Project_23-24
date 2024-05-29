package com.poly.polyapcsafinalproject23_24;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class GameKanBonita extends GameActivity {

    //create variables up here
    private KanBonitaFarmer player;



    //write game down here
    //  use other void methods as nesssary
    //  use loops as nessesary
    public void run()
    {
        setContentView(R.layout.activity_kanbonita_title);

        Button btnPlay = findViewById(R.id.btn_play);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createFarmer();
            }
        });
    }

    private void createFarmer()
    {
        setContentView(R.layout.activity_kanbonita_enter_name);

        EditText farmerName = findViewById(R.id.et_name);
        Button btnDone = findViewById(R.id.btn_done);

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (farmerName.getText().toString().isEmpty())
                {
                    player = new KanBonitaFarmer("KanBonitaFarmer");
                }
                else
                {
                    player = new KanBonitaFarmer(farmerName.getText().toString());
                }
                displayStats();
            }
        });



    }

    private void runFarm()
    {
        if (player.getMoney() < 100)
        {
            displayStats();
            chooseOption();
        }
        endOfGame();
    }

    private void displayStats()
    {
        setContentView(R.layout.activity_kanbonita_stats);
        TextView tvMoneyVal = findViewById(R.id.tv_money_val);
        TextView tvWheatVal = findViewById(R.id.tv_wheat_val);
        TextView tvWheatFieldVal = findViewById(R.id.tv_wheat_field_val);
        TextView tvWheatSeedsVal = findViewById(R.id.tv_wheat_seeds_val);
        TextView tvCarrotsVal = findViewById(R.id.tv_carrots_val);
        TextView tvCarrotsFieldVal = findViewById(R.id.tv_carrots_on_field_val);
        TextView tvCarrotsSeedsVal = findViewById(R.id.tv_carrot_seeds_val);
        Button btnNext = findViewById(R.id.btn_next);



        tvMoneyVal.setText("" + player.getMoney());
        tvWheatVal.setText("" + player.getWheatCollected());
        tvWheatFieldVal.setText("" + player.getWheatField());
        tvWheatSeedsVal.setText("" + player.getWheatSeeds());
        tvCarrotsVal.setText("" + player.getCarrotsCollected());
        tvCarrotsFieldVal.setText("" + player.getCarrotField());
        tvCarrotsSeedsVal.setText("" + player.getCarrotSeeds());

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseOption();
            }
        });


    }

    private void chooseOption()
    {
        setContentView(R.layout.activity_kanbonita_options);

        TextView tvMoneyVal = findViewById(R.id.tv_money_val);
        Button btnStats = findViewById(R.id.btn_stats);
        Button btnHarvest = findViewById(R.id.btn_harvest);
        Button btnPlant = findViewById(R.id.btn_plant);
        Button btnSell = findViewById(R.id.btn_sell);
        Button btnShop = findViewById(R.id.btn_shop);

        tvMoneyVal.setText("" + player.getMoney());

        btnStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayStats();
            }
        });

        btnHarvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                harvest();
            }
        });

        btnPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                plantCrops();
            }
        });

        btnSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sell();
            }
        });

        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shop();
            }
        });


        int option = Util.enterInt(1,5);
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
            runFarm();
        }

    }

    private void harvest()
    {
        setContentView(R.layout.activity_kanbonita_you_sold_crops);

        TextView tvText = findViewById(R.id.tv_text);
        Button btnNext = findViewById(R.id.btn_next);
        tvText.setText("You made $" + player.getMoney() + "!");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseOption();
            }
        });
    }



    public void plantCrops()
    {
        setContentView(R.layout.activity_kanbonita_plant);

        TextView tvCarrot = findViewById(R.id.tv_text);
        TextView tvWheat = findViewById(R.id.tv_text);

        Button btnPlantCarrotSeeds = findViewById(R.id.btn_plant_carrots);
        Button btnPlantWheatSeeds = findViewById(R.id.btn_plant_wheat);
        Button btnDone = findViewById(R.id.btn_done);

        tvCarrot.setText("" + player.getCarrotSeeds());
        tvWheat.setText("" + player.getWheatSeeds());

        btnPlantCarrotSeeds.setClickable(true);
        btnPlantWheatSeeds.setClickable(true);

        if (player.getWheatSeeds() <= 0)
        {
            btnPlantWheatSeeds.setClickable(false);
        }
        if (player.getCarrotSeeds() <= 0)
        {
            btnPlantCarrotSeeds.setClickable(false);
        }
        btnPlantCarrotSeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

    private void shop()
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