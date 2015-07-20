package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.koganepj.starbuckscustomorder.custom.view.base.BaseCustomizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.espresso.EspressoCustomizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.jelly.JellyCustomizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.milk.MilkCustomizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.powder.PowderCustomizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.sauce.SauceCustomizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.syrup.SyrupCustomizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.whippedCream.WhippedCreamCustomizeSelectView;
import com.koganepj.starbuckscustomorder.free.R;
import com.koganepj.starbuckscustomorder.model.Base;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.Espresso;
import com.koganepj.starbuckscustomorder.model.Jelly;
import com.koganepj.starbuckscustomorder.model.Milk;
import com.koganepj.starbuckscustomorder.model.Powder;
import com.koganepj.starbuckscustomorder.model.Sauce;
import com.koganepj.starbuckscustomorder.model.Syrup;
import com.koganepj.starbuckscustomorder.model.WhippedCream;

public class CustomizeSelectView extends LinearLayout {
    
    private LayoutInflater mInflater;
    
    private EspressoCustomizeSelectView mEspressoView;
    private BaseCustomizeSelectView mBaseView;
    private JellyCustomizeSelectView mJellyView;
    private MilkCustomizeSelectView mMilkView;
    private PowderCustomizeSelectView mPowderView;
    private SauceCustomizeSelectView mSauceView;
    private SyrupCustomizeSelectView mSyrupView;
    private WhippedCreamCustomizeSelectView mWhippedCreamView;
    
    public CustomizeSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mInflater = LayoutInflater.from(context);
        mInflater.inflate(R.layout.layout_custom_customize_select_view, this, true);
    }
    
    public void setCoffeeToCreateView(Coffee coffee) {
        ArrayList<ViewGroup> frameViews = getFrameViews();
        int currentFrameIndex = 0;
        
        if (coffee.base.size() != 0) {
            mBaseView = new BaseCustomizeSelectView(getContext());
            mBaseView.setText("Base");
            mBaseView.setBases(coffee.base);
            frameViews.get(currentFrameIndex).addView(mBaseView);
            currentFrameIndex++;
        }
        
        if (coffee.espresso.size() != 0) {
            mEspressoView = new EspressoCustomizeSelectView(getContext());
            mEspressoView.setText("Espresso");
            mEspressoView.setEspressos(coffee.espresso);
            frameViews.get(currentFrameIndex).addView(mEspressoView);
            currentFrameIndex++;
        }
        
        if (coffee.jelly.size() != 0) {
            mJellyView = new JellyCustomizeSelectView(getContext());
            mJellyView.setText("Jelly");
            mJellyView.setJellies(coffee.jelly);
            frameViews.get(currentFrameIndex).addView(mJellyView);
            currentFrameIndex++;
        }
        
        if (coffee.milk.size() != 0) {
            mMilkView = new MilkCustomizeSelectView(getContext());
            mMilkView.setText("Milk");
            mMilkView.setMilks(coffee.milk);
            frameViews.get(currentFrameIndex).addView(mMilkView);
            currentFrameIndex++;
        }
        
        if (coffee.powder.size() != 0) {
            mPowderView = new PowderCustomizeSelectView(getContext());
            mPowderView.setText("Powder");
            mPowderView.setPowders(coffee.powder);
            frameViews.get(currentFrameIndex).addView(mPowderView);
            currentFrameIndex++;
        }
        
        if (coffee.sauce.size() != 0) {
            mSauceView = new SauceCustomizeSelectView(getContext());
            mSauceView.setText("Sauce");
            mSauceView.setSauces(coffee.sauce);
            frameViews.get(currentFrameIndex).addView(mSauceView);
            currentFrameIndex++;
        }
        
        if (coffee.syrup.size() != 0) {
            mSyrupView = new SyrupCustomizeSelectView(getContext());
            mSyrupView.setText("Syrup");
            mSyrupView.setSyrups(coffee.syrup);
            frameViews.get(currentFrameIndex).addView(mSyrupView);
            currentFrameIndex++;
        }
        
        if (coffee.whippedCream.size() != 0) {
            mWhippedCreamView = new WhippedCreamCustomizeSelectView(getContext());
            mWhippedCreamView.setText("Whipped\nCream");
            mWhippedCreamView.setWhippedCreams(coffee.whippedCream);
            frameViews.get(currentFrameIndex).addView(mWhippedCreamView);
            currentFrameIndex++;
        }
    }
    
    ArrayList<ViewGroup> getFrameViews() {
        ArrayList<ViewGroup> frameViews = new ArrayList<ViewGroup>();
        
        ViewGroup topGroup = (ViewGroup)findViewById(R.id.LayoutCustomizeDetailZone);
        int childCount = topGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewGroup subViewGroup = (ViewGroup)topGroup.getChildAt(i);
            int subChildCount = subViewGroup.getChildCount();
            for (int j = 0; j < subChildCount; j++) {
                frameViews.add((ViewGroup)subViewGroup.getChildAt(j));
            }
        }
        return frameViews;
    }
    
    public void changeSelectedEspresso(Espresso espresso) {
        if (mEspressoView == null) {
            return;
        }
        mEspressoView.setSelectedEspresso(espresso);
    }
    
    public void changeSelectedBase(Base base) {
        if (mBaseView == null) {
            return;
        }
        mBaseView.setSelectedBase(base);
    }
    
    public void changeSelectedJelly(Jelly jelly) {
        if (mJellyView == null) {
            return;
        }
        mJellyView.setSelectedJelly(jelly);
    }
    
    public void changeSelectedMilk(Milk milk) {
        if (mMilkView == null) {
            return;
        }
        mMilkView.setSelectedMilk(milk);
    }
    
    public void changeSelectedSauce(Sauce sauce) {
        if (mSauceView == null) {
            return;
        }
        mSauceView.setSelectedSauce(sauce);
    }
    
    public void changeSelectedPowder(Powder powder) {
        if (mPowderView == null) {
            return;
        }
        mPowderView.setSelectedPowder(powder);
    }
    
    public void changeSelectedSyrup(Syrup syrup) {
        if (mSyrupView == null) {
            return;
        }
        mSyrupView.setSelectedSyrup(syrup);
    }
    
    public void changeSelectedWhippedCream(WhippedCream whippedCream) {
        if (mWhippedCreamView == null) {
            return;
        }
        mWhippedCreamView.setSelectedWhippedCream(whippedCream);
    }
}
