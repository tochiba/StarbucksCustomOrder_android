package com.koganepj.starbuckscustomorder.view.like.matrix;


public class CoffeeSteamVisibilityChanger {
    
    private CoffeeIcon mCoffeeIcon;
    
    public CoffeeSteamVisibilityChanger(CoffeeIcon coffeeIcon) {
        mCoffeeIcon = coffeeIcon;
    }
    
    public void changeVisivility(int backgroundHeight, int nextY) {
        if (backgroundHeight / 2 <= nextY) {
            mCoffeeIcon.stopSteamAnimation();
            return;
        }
        mCoffeeIcon.startSteamAnimation();
    }
    
}
