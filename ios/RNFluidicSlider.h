
#if __has_include("RCTBridgeModule.h")
#import "RCTViewManager.h"
#else
#import <React/RCTViewManager.h>
#endif

#import <fluid_slider/fluid_slider-Swift.h>

@interface RNFluidicSlider : RCTViewManager

@property (assign) NSNumber *_initialPosition;
@property (assign) NSNumber *_min;
@property (assign) NSNumber *_max;
@property (assign) NSNumber *_textSize;
@property (assign) UIColor *_barTextColor;
@property (assign) UIColor *_bubbleTextColor;

@property (assign) CGFloat _fraction;

@end
  
