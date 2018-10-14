import React, { Component } from "react";
import { StyleSheet, ViewPropTypes, Platform } from "react-native";
import PropTypes from "prop-types";

import { requireNativeComponent } from "react-native";

class RNFluidicSlider extends Component {
  static propTypes = {
    ...ViewPropTypes
  };

  static defaultProps = {};

  render() {
    return <FluidicSlider style={{width: 500, height: 50, backgroundColor: '#000000'}} />;
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
