package com.koganepj.starbuckscustomorder.custom;

import com.koganepj.starbuckscustomorder.model.Base;
import com.koganepj.starbuckscustomorder.model.Calorie;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.CustomizeCoffee;
import com.koganepj.starbuckscustomorder.model.Espresso;
import com.koganepj.starbuckscustomorder.model.Jelly;
import com.koganepj.starbuckscustomorder.model.Milk;
import com.koganepj.starbuckscustomorder.model.Powder;
import com.koganepj.starbuckscustomorder.model.Price;
import com.koganepj.starbuckscustomorder.model.Sauce;
import com.koganepj.starbuckscustomorder.model.Size;
import com.koganepj.starbuckscustomorder.model.Syrup;
import com.koganepj.starbuckscustomorder.model.WhippedCream;
import com.koganepj.starbuckscustomorder.parse.CalorieFinder;
import com.koganepj.starbuckscustomorder.parse.PriceFinder;

class CustomizeDataHolder {
    
    private Coffee mCoffee;
    private PriceFinder mPriceFinder;
    private CalorieFinder mCalorieFinder;
    
    private int mCurrentPrice;
    private int mCurrentCalorie;
    
    private Espresso mEspresso;
    
    public CustomizeDataHolder(Coffee coffee, PriceFinder priceFinder, CalorieFinder calorieFinder) {
        mCoffee = coffee;
        mPriceFinder = priceFinder;
        mCalorieFinder = calorieFinder;
        
        mCurrentPrice = coffee.price.getPrice();
        mCurrentCalorie = coffee.calorie.getCalorie();
    }
    
    public void changeEspresso(Espresso espresso) {
        if (mEspresso != null) {
            Price mPrevPrice = mPriceFinder.getPrice(mEspresso.getEspresso());
            Calorie mPrevCalorie = mCalorieFinder.getCalorie(mEspresso.getEspresso());
            
            mCurrentPrice -= mPrevPrice.getPrice();
            mCurrentCalorie -= mPrevCalorie.getCalorie();
        }
        
        Price price = mPriceFinder.getPrice(espresso.getEspresso());
        Calorie calorie = mCalorieFinder.getCalorie(espresso.getEspresso());
        
        mCurrentPrice += price.getPrice();
        mCurrentCalorie += calorie.getCalorie();
        mEspresso = espresso;
    }
    
    public void changeBase(Base base) {
    }
    
    public void changeJelly(Jelly jelly) {
    }
    
    public void changeMilk(Milk milk) {
    }
    
    public void changePowder(Powder powder) {
    }
    
    public void changeSauce(Sauce sauce) {
    }
    
    public void changeSyrup(Syrup syrup) {
    }
    
    public void changeWhippedCream(WhippedCream whippedCream) {
    }

    public void changeSize(Size size) {
    }
    
    public int getCalorie() {
        return mCurrentCalorie;
    }
    
    public int getPrice() {
        return mCurrentPrice;
    }
    
    public CustomizeCoffee getCustomizeCoffe() {
        return null;
    }
}
