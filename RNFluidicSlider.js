import React, { Component } from "react";
import { StyleSheet, ViewPropTypes, Platform } from "react-native";
import PropTypes from "prop-types";

import { requireNativeComponent } from "react-native";

class RNFluidicSlider extends Component {
  static propTypes = {
    ...ViewPropTypes,

    min: PropTypes.number,
    max: PropTypes.number,

    initialPosition: PropTypes.number,

    barColor: PropTypes.string,
    bubbleColor: PropTypes.string,
    barTextColor: PropTypes.string,
    bubbleTextColor: PropTypes.string
  };

  static defaultProps = {
    min: 0,
    max: 100,

    initialPosition: .5,

    barColor: '#6168e7',
    bubbleColor: '#FFFFFF',
    barTextColor: '#FFFFFF',
    bubbleTextColor: '#000000'
  };

  _onChange = (event, position) => {
    console.log('Event: ' + event.nativeEvent.event + ', Position: ' + event.nativeEvent.value)
    // this.props.onChange && this.props.onChange(event.nativeEvent.value);
  };

  render() {
    return <FluidicSlider style={{width: '100%', height: '100%'}}
      onChange={this._onChange}
      {...this.props}
    />;
  }
}

const FluidicSlider = requireNativeComponent(
  "RNFluidicSlider",
    RNFluidicSlider,
  {
    nativeOnly: { onChange: true }
  }
);

export { RNFluidicSlider };
