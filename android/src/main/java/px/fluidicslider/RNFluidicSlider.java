package px.fluidicslider;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.ramotion.fluidslider.FluidSlider;

public class RNFluidicSlider extends ViewGroupManager<ViewGroup> {

    public static final String REACT_CLASS = "RNFluidicSlider";

    @Override
    public String getName() {
        return REACT_CLASS;
    }


    @Override
    protected FrameLayout createViewInstance(final ThemedReactContext reactContext) {

        final FrameLayout frameLayout = new FrameLayout(reactContext.getCurrentActivity());

        FluidSlider slider = new FluidSlider(reactContext.getCurrentActivity());
        slider.setPosition(0.3f);
        slider.setStartText("45");
        slider.setEndText("100");
        slider.setBubbleText("500");
        slider.setColorBar(Color.BLUE);
        slider.setColorBubble(500);
        slider.setTextSize(50);
        slider.setScrollBarSize(10);

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT);


        frameLayout.addView(slider, layoutParams);

        return frameLayout;
    }
}
