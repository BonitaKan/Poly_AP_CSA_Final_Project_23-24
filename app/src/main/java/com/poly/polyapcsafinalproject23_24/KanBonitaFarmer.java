package com.poly.polyapcsafinalproject23_24;
public class KanBonitaFarmer {

    private String name;

    private int wheatCollected;

    private int carrotsCollected;

    private int wheatSeeds;

    private int carrotSeeds;

    private int money;

    private int totalCost;

    private int wheatField;

    private int carrotField;






    public KanBonitaFarmer(String name)
    {
        this.name = name;
        this.wheatCollected = 0;
        this.carrotsCollected = 0;
        this.wheatSeeds = 0;
        this.carrotSeeds = 0;
        this.wheatField = 0;
        this.carrotField = 0;
        this.money = 20;

    }

    public KanBonitaFarmer(String name, int wheatCollected, int carrotsCollected, int wheatSeeds, int carrotSeeds, int wheatField, int carrotField, int money)
    {
        this.name = name;
        this.wheatCollected = wheatCollected;
        this.carrotsCollected = carrotsCollected;
        this.wheatSeeds = wheatSeeds;
        this.carrotSeeds = carrotSeeds;
        this.wheatField = wheatField;
        this.carrotField = carrotField;
        this.money = money;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public int getWheatCollected()
    {
        return wheatCollected;
    }

    public void setWheatCollected(int numWheatCollected)
    {
        this.wheatCollected = numWheatCollected;
    }

    public int getCarrotsCollected()
    {
        return carrotsCollected;
    }

    public void setCarrotsCollected(int numCarrotsCollected)
    {
        this.carrotsCollected = numCarrotsCollected;
    }

    public int getWheatSeeds()
    {
        return wheatSeeds;
    }

    public void setWheatSeeds(int quantity)
    {
        this.wheatSeeds = quantity;
    }

    public int getCarrotSeeds()
    {
        return carrotSeeds;
    }

    public void setCarrotSeeds(int quantity)
    {
        this.carrotSeeds = quantity;
    }

    public int getWheatField()
    {
        return wheatField;
    }

    public void setWheatField(int quantity)
    {
        this.wheatField = quantity;
    }

    public int getCarrotField()
    {
        return carrotField;
    }

    public void setCarrotField(int quantity)
    {
        this.carrotField = quantity;
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int numMoney)
    {
        this.money = numMoney;
    }

    public int gettotalCost()
    {
        return totalCost;
    }

    public void setTotalCost(int numTotalCost)
    {
        this.totalCost = numTotalCost;
    }

    public void harvestFields()
    {
        wheatCollected += wheatField;
        carrotsCollected += carrotField;
        wheatField = 0;
        carrotField = 0;
    }

    public void sellAllWheat()
    {
        int wheatEarnings = wheatCollected * 10;
        money += wheatEarnings;
        wheatCollected = 0;
        System.out.println("Sold all wheat for $" + wheatEarnings);
        Util.pauseConsole();

    }

    public void sellAllCarrots()
    {
        int carrotEarnings = carrotsCollected * 20;
        money += carrotEarnings;
        carrotsCollected = 0;
        System.out.println("Sold all carrots for $" + carrotEarnings);
        Util.pauseConsole();

    }



    public String toString()
    {
        return
                "KanBonitaFarmer name:\t" + name +
                        "\nWheat collected:\t\t" + wheatCollected +
                        "\nCarrots collected:\t\t" + carrotsCollected +
                        "\nWheat seeds:\t" + wheatSeeds +
                        "\nCarrot seeds:\t" + carrotSeeds +
                        "\nWheatField:\t" + wheatField +
                        "\nCarrotField:\t" + carrotField +
                        "\nMoney:\t\t" + money;
    }

    public  boolean equals(KanBonitaFarmer anotherFarmer)
    {
        if (this.name.equals(anotherFarmer.name) &&
                this.wheatCollected == anotherFarmer.wheatCollected &&
                this.carrotsCollected == anotherFarmer.carrotsCollected &&
                this.wheatSeeds == anotherFarmer.wheatSeeds &&
                this.carrotSeeds == anotherFarmer.carrotSeeds &&
                this.money == anotherFarmer.money &&
                this.totalCost == anotherFarmer.totalCost &&
                this.wheatField == anotherFarmer.wheatField &&
                this.carrotField == anotherFarmer.carrotField
        )
        {
            return true;
        }
        return false;
    }
}