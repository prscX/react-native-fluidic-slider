package px.fluidicslider;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.UIManagerModule;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.ramotion.fluidslider.FluidSlider;

import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;


public class RNFluidicSlider extends ViewGroupManager<ViewGroup> {

    public static final String REACT_CLASS = "RNFluidicSlider";
    private float position;

    @Override
    public String getName() {
        return REACT_CLASS;
    }


    @Override
    protected ConstraintLayout createViewInstance(final ThemedReactContext reactContext) {
        final ConstraintLayout layout = new ConstraintLayout(reactContext.getCurrentActivity());
        final ConstraintLayout constraintLayout = (ConstraintLayout) reactContext.getCurrentActivity().getLayoutInflater().inflate(R.layout.slider, layout, false);

        FluidSlider slider = (FluidSlider) constraintLayout.getViewById(R.id.fluidSlider);

//        int id = constraintLayout.getId();
//        reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(
//                new RNFluidicSliderEvent(id, selection)
//        );

        slider.setBeginTrackingListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                int id = constraintLayout.getId();
                reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(
                        new px.fluidicslider.RNFluidicSliderEvent(id, "beginTrackingListener", 0)
                );

                return Unit.INSTANCE;
            }
        });

        slider.setPositionListener(new Function1<Float, Unit>() {
            @Override
            public Unit invoke(Float pos) {
                position = pos;

                return Unit.INSTANCE;
            }
        });

        slider.setEndTrackingListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                int id = constraintLayout.getId();
                reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(
                        new px.fluidicslider.RNFluidicSliderEvent(id, "endTrackingListener", position)
                );

                return Unit.INSTANCE;
            }
        });



        return constraintLayout;
    }

    @ReactProp(name = "min")
    public void setMin(ConstraintLayout layout, int min) {
        FluidSlider slider = (FluidSlider) layout.getChildAt(0);
        slider.setStartText(String.valueOf(min));
    }

    @ReactProp(name = "max")
    public void setMax(ConstraintLayout layout, int max) {
        FluidSlider slider = (FluidSlider) layout.getChildAt(0);
        slider.setEndText(String.valueOf(max));
    }


    @ReactProp(name = "initialPosition")
    public void setInitialPosition(ConstraintLayout layout, float initialPosition) {
        FluidSlider slider = (FluidSlider) layout.getChildAt(0);
        slider.setPosition(initialPosition);

        position = initialPosition;
    }


    @ReactProp(name = "barColor")
    public void setBarColor(ConstraintLayout layout, String barColor) {
        FluidSlider slider = (FluidSlider) layout.getChildAt(0);
        slider.setColorBar(Color.parseColor(barColor));
    }

    @ReactProp(name = "bubbleColor")
    public void setBubbleColor(ConstraintLayout layout, String bubbleColor) {
        FluidSlider slider = (FluidSlider) layout.getChildAt(0);
        slider.setColorBubble(Color.parseColor(bubbleColor));
    }

    @ReactProp(name = "barTextColor")
    public void setBarTextColor(ConstraintLayout layout, String barTextColor) {
        FluidSlider slider = (FluidSlider) layout.getChildAt(0);
        slider.setColorBarText(Color.parseColor(barTextColor));
    }

    @ReactProp(name = "bubbleTextColor")
    public void setBubbleTextColor(ConstraintLayout layout, String bubbleTextColor) {
        FluidSlider slider = (FluidSlider) layout.getChildAt(0);
        slider.setColorBubbleText(Color.parseColor(bubbleTextColor));
    }
}
