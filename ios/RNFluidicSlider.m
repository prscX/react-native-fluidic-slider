
#import "RNFluidicSlider.h"

@implementation RNFluidicSlider

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

- (Slider *)view {
    Slider *slider = [[Slider alloc] init];
    
//    [slider setMinimumLabelAttributedText: [[NSMutableAttributedString alloc] initWithString:@"100"]];
//    [slider setMaximumLabelAttributedText: [[NSMutableAttributedString alloc] initWithString:@"500"]];
//    slider.fraction = 0.5;
//    slider.shadowOffset = CGSizeMake(0, 10);
//    slider.shadowBlur = 50;
//    slider.shadowColor = UIColor.whiteColor;
//    slider.contentViewColor = UIColor.blueColor;
//    slider.valueViewColor = UIColor.whiteColor;
    
    return slider;
}


RCT_CUSTOM_VIEW_PROPERTY(min, NSNumber *, Slider) {
    self._min = json;

    if (self._barTextColor != nil) {
        NSDictionary *attrs = @{ NSForegroundColorAttributeName : self._barTextColor };
        
        [view setMinimumLabelAttributedText: [[NSMutableAttributedString alloc] initWithString: [self._min stringValue] attributes:attrs]];
    }
}
RCT_CUSTOM_VIEW_PROPERTY(max, NSNumber *, Slider) {
    self._max = json;

    if (self._barTextColor != nil) {
        NSDictionary *attrs = @{ NSForegroundColorAttributeName : self._barTextColor };
        
        [view setMaximumLabelAttributedText: [[NSMutableAttributedString alloc] initWithString: [self._min stringValue] attributes:attrs]];
    }

    if (self._initialPosition != nil) {
        [view setAttributedTextForFraction:^NSAttributedString * _Nonnull(CGFloat fraction) {
            NSNumberFormatter *formatter = [[NSNumberFormatter alloc] init];
            formatter.maximumIntegerDigits = 3;
            formatter.maximumFractionDigits = 0;
            
            NSNumber *value = [NSNumber numberWithFloat: fraction * [json integerValue]];
            NSString *string = [formatter stringFromNumber: value];
            return [[NSMutableAttributedString alloc] initWithString:string];
        }];
        
        view.fraction = [self._initialPosition floatValue];
    }
}

RCT_CUSTOM_VIEW_PROPERTY(initialPosition, NSNumber *, Slider) {
    self._initialPosition = json;
    
    if (self._max != nil) {
        [view setAttributedTextForFraction:^NSAttributedString * _Nonnull(CGFloat fraction) {
            NSNumberFormatter *formatter = [[NSNumberFormatter alloc] init];
            formatter.maximumIntegerDigits = 3;
            formatter.maximumFractionDigits = 0;
            
            NSNumber *value = [NSNumber numberWithFloat: fraction * [json integerValue]];
            NSString *string = [formatter stringFromNumber: value];
            return [[NSMutableAttributedString alloc] initWithString:string];
        }];
        
        view.fraction = [self._initialPosition floatValue];
    }
}

RCT_CUSTOM_VIEW_PROPERTY(barColor, NSString *, Slider) {
    view.contentViewColor = [RNFluidicSlider ColorFromHexCode: json];
}

RCT_CUSTOM_VIEW_PROPERTY(bubbleColor, NSString *, Slider) {
    view.valueViewColor = [RNFluidicSlider ColorFromHexCode: json];
}

RCT_CUSTOM_VIEW_PROPERTY(barTextColor, NSString *, Slider) {
    self._barTextColor = json;
    
    if (self._min != nil && self._max != nil) {
        UIColor *color = [RNFluidicSlider ColorFromHexCode: json];
        NSDictionary *attrs = @{ NSForegroundColorAttributeName : color };
        
        [view setMinimumLabelAttributedText: [[NSMutableAttributedString alloc] initWithString: [self._min stringValue] attributes:attrs]];
        [view setMaximumLabelAttributedText: [[NSMutableAttributedString alloc] initWithString: [self._max stringValue] attributes:attrs]];
    }
}

RCT_CUSTOM_VIEW_PROPERTY(bubbleTextColor, NSString *, Slider) {
    self._bubbleTextColor = json;
}

+ (UIColor *) ColorFromHexCode:(NSString *)hexString {
    NSString *cleanString = [hexString stringByReplacingOccurrencesOfString:@"#" withString:@""];
    if([cleanString length] == 3) {
        cleanString = [NSString stringWithFormat:@"%@%@%@%@%@%@",
                       [cleanString substringWithRange:NSMakeRange(0, 1)],[cleanString substringWithRange:NSMakeRange(0, 1)],
                       [cleanString substringWithRange:NSMakeRange(1, 1)],[cleanString substringWithRange:NSMakeRange(1, 1)],
                       [cleanString substringWithRange:NSMakeRange(2, 1)],[cleanString substringWithRange:NSMakeRange(2, 1)]];
    }
    if([cleanString length] == 6) {
        cleanString = [cleanString stringByAppendingString:@"ff"];
    }
    
    unsigned int baseValue;
    [[NSScanner scannerWithString:cleanString] scanHexInt:&baseValue];
    
    float red = ((baseValue >> 24) & 0xFF)/255.0f;
    float green = ((baseValue >> 16) & 0xFF)/255.0f;
    float blue = ((baseValue >> 8) & 0xFF)/255.0f;
    float alpha = ((baseValue >> 0) & 0xFF)/255.0f;
    
    return [UIColor colorWithRed:red green:green blue:blue alpha:alpha];
}


@end
  
