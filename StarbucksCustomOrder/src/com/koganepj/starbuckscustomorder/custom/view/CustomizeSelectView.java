package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.custom.view.base.BaseCustomizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.espresso.EspressoCustomizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.jelly.JellyCustomizeSelectView;
import com.koganepj.starbuckscustomorder.custom.view.milk.MilkCustomizeSelectView;
import com.koganepj.starbuckscustomorder.model.Base;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.Espresso;
import com.koganepj.starbuckscustomorder.model.Jelly;
import com.koganepj.starbuckscustomorder.model.Milk;

public class CustomizeSelectView extends LinearLayout {
    
    private LayoutInflater mInflater;
    
    private EspressoCustomizeSelectView mEspressoView;
    private BaseCustomizeSelectView mBaseView;
    private JellyCustomizeSelectView mJellyView;
    private MilkCustomizeSelectView mMilkView;
    
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
        if (mBaseView == null) {
            return;
        }
        mJellyView.setSelectedJelly(jelly);
    }
    
    public void changeSelectedMilk(Milk milk) {
        if (mBaseView == null) {
            return;
        }
        mMilkView.setSelectedMilk(milk);
    }
}
