
package px.fluidicslider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

public class RNFluidicSliderEvent extends Event<RNFluidicSliderEvent> {

    public static final String EVENT_NAME = "topChange";

    private final float mSelection;
    private final String mEvent;

    public RNFluidicSliderEvent(int viewId, String event, float selection) {
        super(viewId);
        mSelection = selection;
        mEvent = event;
    }

    public float getSelection() {
        return mSelection;
    }
    public String getEvent() {
        return mEvent;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public short getCoalescingKey() {
        // All switch events for a given view can be coalesced.
        return 0;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap eventData = Arguments.createMap();
        eventData.putInt("target", getViewTag());
        eventData.putDouble("value", getSelection());
        eventData.putString("event", getEvent());

        return eventData;
    }
}