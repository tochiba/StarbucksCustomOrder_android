package com.koganepj.starbuckscustomorder.custom.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.koganepj.starbuckscustomorder.R;
import com.koganepj.starbuckscustomorder.custom.view.espresso.EspressoCustomizeSelectView;
import com.koganepj.starbuckscustomorder.model.Coffee;
import com.koganepj.starbuckscustomorder.model.Espresso;

public class CustomizeSelectView extends LinearLayout {
    
    private LayoutInflater mInflater;
    
    public CustomizeSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mInflater = LayoutInflater.from(context);
        mInflater.inflate(R.layout.layout_custom_customize_select_view, this, true);
    }
    
    public void setCoffeeToCreateView(Coffee coffee) {
        ArrayList<ViewGroup> frameViews = getFrameViews();
        int currentFrameIndex = 0;
        
//        if (coffee.base.size() != 0) {
//            setSingleItem(frameViews, currentFrameIndex, "Base"/*, coffee.base*/);
//            currentFrameIndex++;
//        }
//        
        if (coffee.espresso.size() != 0) {
//            setSingleItem(frameViews, currentFrameIndex, "Espresso"/*, coffee.espresso*/);
            setEspressoItem(frameViews, currentFrameIndex, "Espresso", coffee.espresso);
            currentFrameIndex++;
        }
//
//        if (coffee.jelly.size() != 0) {
//            setSingleItem(frameViews, currentFrameIndex, "Jelly"/*, coffee.jelly*/);
//            currentFrameIndex++;
//        }
//
//        if (coffee.milk.size() != 0) {
//            setSingleItem(frameViews, currentFrameIndex, "Milk"/*, coffee.milk*/);
//            currentFrameIndex++;
//        }
//
//        if (coffee.powder.size() != 0) {
//            setSingleItem(frameViews, currentFrameIndex, "Powder"/*, coffee.powder*/);
//            currentFrameIndex++;
//        }
//
//        if (coffee.sauce.size() != 0) {
//            setSingleItem(frameViews, currentFrameIndex, "Sauce"/*, coffee.sauce*/);
//            currentFrameIndex++;
//        }
//
//        if (coffee.syrup.size() != 0) {
//            setSingleItem(frameViews, currentFrameIndex, "Syrup"/*, coffee.syrup*/);
//            currentFrameIndex++;
//        }
//
//        if (coffee.whippedCream.size() != 0) {
//            setSingleItem(frameViews, currentFrameIndex, "Whipped\nCream"/*, coffee.whippedCream*/);
//            currentFrameIndex++;
//        }
    }
    
//    void setSingleItem(List<ViewGroup> frameViews, int currentFrameIndex, String text/*, ArrayList<String> detailItems*/) {
//        SingleCustomizeSelectView view = (SingleCustomizeSelectView)mInflater.inflate(R.layout.layout_custom_customize_select, null);
//        view.setText(text);
//        //view.setSelectItems(detailItems);
//        frameViews.get(currentFrameIndex).addView(view);
//    }
    
    void setEspressoItem(List<ViewGroup> frameViews, int currentFrameIndex, String text, ArrayList<Espresso> detailItems) {
        EspressoCustomizeSelectView view = new EspressoCustomizeSelectView(getContext());
        view.setText(text);
        view.setSelectEspressos(detailItems);
        frameViews.get(currentFrameIndex).addView(view);
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
    
}
