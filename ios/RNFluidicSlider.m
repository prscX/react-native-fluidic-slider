
#import "RNFluidicSlider.h"

@implementation RNFluidicSlider

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()


- (Slider *)view {
    Slider *slider = [[Slider alloc] init];
    
    [slider setAttributedTextForFraction:^NSAttributedString * _Nonnull(CGFloat fraction) {
        NSNumberFormatter *formatter = [[NSNumberFormatter alloc] init];
        formatter.maximumIntegerDigits = 3;
        formatter.maximumFractionDigits = 0;

        NSNumber *value = [NSNumber numberWithFloat: fraction * 500];
        NSString *string = [formatter stringFromNumber: value];
        return [[NSMutableAttributedString alloc] initWithString:string];
    }];
    
    [slider setMinimumLabelAttributedText: [[NSMutableAttributedString alloc] initWithString:@"100"]];
    [slider setMaximumLabelAttributedText: [[NSMutableAttributedString alloc] initWithString:@"500"]];
    slider.fraction = 0.5;
    slider.shadowOffset = CGSizeMake(0, 10);
    slider.shadowBlur = 5;
    slider.shadowColor = UIColor.whiteColor;
    slider.contentViewColor = UIColor.blueColor;
    slider.valueViewColor = UIColor.whiteColor;

    return slider;
}

@end
  
