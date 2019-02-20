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

    private float _min;
    private float _max;
    private float _position;
    private float _initialPosition;

    @Override
    public String getName() {
        return REACT_CLASS;
    }


    @Override
    protected ConstraintLayout createViewInstance(final ThemedReactContext reactContext) {
        final ConstraintLayout layout = new ConstraintLayout(reactContext.getCurrentActivity());
        final ConstraintLayout constraintLayout = (ConstraintLayout) reactContext.getCurrentActivity().getLayoutInflater().inflate(R.layout.slider, layout, false);

        FluidSlider slider = (FluidSlider) constraintLayout.getViewById(R.id.fluidSlider);
        final FluidSlider finalSlider = slider;

        slider.setBeginTrackingListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                int id = constraintLayout.getId();
                float position = _initialPosition;

                if (_initialPosition != _position) {
                    position = _position;
                }

                reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(
                        new px.fluidicslider.RNFluidicSliderEvent(id, "beginTracking", position)
                );

                return Unit.INSTANCE;
            }
        });

        slider.setPositionListener(new Function1<Float, Unit>() {
            @Override
            public Unit invoke(Float pos) {
                _position = pos;

                finalSlider.setBubbleText(String.valueOf((int) (_min + ((_max - _min) * _position))));

                return Unit.INSTANCE;
            }
        });

        slider.setEndTrackingListener(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                int id = constraintLayout.getId();
                reactContext.getNativeModule(UIManagerModule.class).getEventDispatcher().dispatchEvent(
                        new px.fluidicslider.RNFluidicSliderEvent(id, "endTracking", _position)
                );

                return Unit.INSTANCE;
            }
        });

        return constraintLayout;
    }

    @ReactProp(name = "min")
    public void setMin(ConstraintLayout layout, int min) {
        _min = min;

        FluidSlider slider = (FluidSlider) layout.getViewById(R.id.fluidSlider);
        slider.setStartText(String.valueOf(min));

        if (_initialPosition != 0) {
            slider.setPosition(_initialPosition);
        }
    }

    @ReactProp(name = "max")
    public void setMax(ConstraintLayout layout, int max) {
        _max = max;

        FluidSlider slider = (FluidSlider) layout.getViewById(R.id.fluidSlider);
        slider.setEndText(String.valueOf(max));

        if (_initialPosition != 0) {
            slider.setPosition(_initialPosition);
        }
    }


    @ReactProp(name = "initialPosition")
    public void setInitialPosition(ConstraintLayout layout, float initialPosition) {
        FluidSlider slider = (FluidSlider) layout.getViewById(R.id.fluidSlider);
        slider.setPosition(initialPosition);

        _position = initialPosition;
        _initialPosition = initialPosition;
    }


    @ReactProp(name = "barColor")
    public void setBarColor(ConstraintLayout layout, String barColor) {
        FluidSlider slider = (FluidSlider) layout.getViewById(R.id.fluidSlider);
        slider.setColorBar(Color.parseColor(barColor));
    }

    @ReactProp(name = "bubbleColor")
    public void setBubbleColor(ConstraintLayout layout, String bubbleColor) {
        FluidSlider slider = (FluidSlider) layout.getViewById(R.id.fluidSlider);
        slider.setColorBubble(Color.parseColor(bubbleColor));
    }

    @ReactProp(name = "barTextColor")
    public void setBarTextColor(ConstraintLayout layout, String barTextColor) {
        FluidSlider slider = (FluidSlider) layout.getViewById(R.id.fluidSlider);
        slider.setColorBarText(Color.parseColor(barTextColor));
    }

    @ReactProp(name = "bubbleTextColor")
    public void setBubbleTextColor(ConstraintLayout layout, String bubbleTextColor) {
        FluidSlider slider = (FluidSlider) layout.getViewById(R.id.fluidSlider);
        slider.setColorBubbleText(Color.parseColor(bubbleTextColor));
    }

    @ReactProp(name = "textSize")
    public void setTextSize(ConstraintLayout layout, int textSize) {
        FluidSlider slider = (FluidSlider) layout.getViewById(R.id.fluidSlider);
        slider.setTextSize(textSize);
    }
}
