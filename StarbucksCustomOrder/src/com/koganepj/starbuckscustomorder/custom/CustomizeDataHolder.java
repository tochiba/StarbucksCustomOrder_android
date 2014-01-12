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
    private Base mBase;
    private Jelly mJelly;
    private Milk mMilk;
    private Powder mPowder;
    private Sauce mSauce;
    private Syrup mSyrup;
    private WhippedCream mWhippedCream;
    private Size mSize;
    
    public CustomizeDataHolder(Coffee coffee, PriceFinder priceFinder, CalorieFinder calorieFinder) {
        mCoffee = coffee;
        mPriceFinder = priceFinder;
        mCalorieFinder = calorieFinder;
        
        mCurrentPrice = coffee.price.getPrice();
        mCurrentCalorie = coffee.calorie.getCalorie();
    }
    
    void calcCalorieAndPrice(String prevName, String name) {
        if (prevName != null) {
            Price prevPrice = mPriceFinder.getPrice(prevName);
            Calorie prevCalorie = mCalorieFinder.getCalorie(prevName);
            
            mCurrentPrice -= prevPrice.getPrice();
            mCurrentCalorie -= prevCalorie.getCalorie();
        }
        
        Price price = mPriceFinder.getPrice(name);
        Calorie calorie = mCalorieFinder.getCalorie(name);
        
        mCurrentPrice += price.getPrice();
        mCurrentCalorie += calorie.getCalorie();
    }
    
    public void changeEspresso(Espresso espresso) {
        String prevName = (mEspresso == null) ? null : mEspresso.getEspresso();
        calcCalorieAndPrice(prevName, espresso.getEspresso());
        mEspresso = espresso;
    }
    
    public void changeBase(Base base) {
        String prevName = (mBase == null) ? null : mBase.getBase();
        calcCalorieAndPrice(prevName, base.getBase());
        mBase = base;
    }
    
    public void changeJelly(Jelly jelly) {
        String prevName = (mJelly == null) ? null : mJelly.getJelly();
        calcCalorieAndPrice(prevName, jelly.getJelly());
        mJelly = jelly;
    }
    
    public void changeMilk(Milk milk) {
        String prevName = (mMilk == null) ? null : mMilk.getMilk();
        calcCalorieAndPrice(prevName, milk.getMilk());
        mMilk = milk;
    }
    
    public void changePowder(Powder powder) {
        String prevName = (mPowder == null) ? null : mPowder.getPowder();
        calcCalorieAndPrice(prevName, powder.getPowder());
        mPowder = powder;
    }
    
    public void changeSauce(Sauce sauce) {
        String prevName = (mSauce == null) ? null : mSauce.getSauce();
        calcCalorieAndPrice(prevName, sauce.getSauce());
        mSauce = sauce;
    }
    
    public void changeSyrup(Syrup syrup) {
        String prevName = (mSyrup == null) ? null : mSyrup.getSyrup();
        calcCalorieAndPrice(prevName, syrup.getSyrup());
        mSyrup = syrup;
    }
    
    public void changeWhippedCream(WhippedCream whippedCream) {
        String prevName = (mWhippedCream == null) ? null : mWhippedCream.getWhippedCream();
        calcCalorieAndPrice(prevName, whippedCream.getWhippedCream());
        mWhippedCream = whippedCream;
    }

    public void changeSize(Size size) {
        if (mSize != null) {
            Price prevPrice = mPriceFinder.getSizePrice(mCoffee, mSize);
            Calorie prevCalorie = mCalorieFinder.getCoffeeSizeCalorie(mCoffee, mSize);
            
            mCurrentPrice -= prevPrice.getPrice();
            mCurrentCalorie -= prevCalorie.getCalorie();
        }
        Price price = mPriceFinder.getSizePrice(mCoffee, size);
        Calorie calorie = mCalorieFinder.getCoffeeSizeCalorie(mCoffee, size);
        
        mCurrentPrice = price.getPrice();
        mCurrentCalorie = calorie.getCalorie();
        mSize = size;
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
