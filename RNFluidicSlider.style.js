import { Platform, StyleSheet } from "react-native";

const style = StyleSheet.create({
  container: {
    width: "100%",
    height: Platform.OS === "ios" ? 32 : 100
  }
});

export default style;
