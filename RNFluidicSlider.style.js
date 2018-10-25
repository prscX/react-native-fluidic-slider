import { Platform, StyleSheet } from "react-native";

const style = StyleSheet.create({
    container: {
        width: '90%',
        height: Platform.OS === 'ios' ? 60 : 100
    }
});

export default style;