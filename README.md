<h1 align="center">

<p align="center">
  <img src="https://github.com/Ramotion/fluid-slider/raw/master/fluid-slider.gif"/>
</p>

<p align="center">
  <a href="https://www.npmjs.com/package/react-native-fluidic-slider"><img src="http://img.shields.io/npm/v/react-native-fluidic-slider.svg?style=flat" /></a>
  <a href="https://github.com/prscX/react-native-fluidic-slider/pulls"><img alt="PRs Welcome" src="https://img.shields.io/badge/PRs-welcome-brightgreen.svg" /></a>
  <a href="https://github.com/prscX/react-native-fluidic-slider#License"><img src="https://img.shields.io/npm/l/react-native-fluidic-slider.svg?style=flat" /></a>
</p>


    ReactNative: Native Fluidic Slider (Android/iOS): Deprecated

Due to time constraint, this library is deprecated and not maintained anymore, You can still use this library.

If this project has helped you out, please support us with a star 🌟
</h1>
This library is a React Native bridge around native fluid slider libraries. It allows you select value from a range of values:


## 📖 Getting started

`$ npm install react-native-fluidic-slider --save`

`$ react-native link react-native-fluidic-slider`

* Android
  * Please add below script in your build.gradle

```
buildscript {
    repositories {
        google()
        maven { url "https://maven.google.com" }
        jcenter()
        ...
    }
}

allprojects {
    repositories {
        google()
        mavenLocal()
        maven { url 'https://jitpack.io' }
        maven {
            url 'https://maven.google.com/'
            name 'Google'
        }
        jcenter()
        ...
    }
}
```

> **Note:** Android SDK 27 > is supported

* iOS
    > **iOS Prerequisite:** Please make sure CocoaPods is installed on your system

  * After `react-native link react-native-fluidic-slider`, please verify `node_modules/react-native-fluidic-slider/ios/` contains `Pods` folder. If does not exist please execute `pod install` command on `node_modules/react-native-fluidic-slider/ios/`, if any error => try `pod repo update` then `pod install`
  * After verification, open your project and create a folder 'RNFluidicSlider' under Libraries.
  * Drag `node_modules/react-native-fluidic-slider/ios/pods/Pods.xcodeproject` into RNFluidicSlider, as well as the RNFluidicSlider.xcodeproject if it does not exist.
  * Add the `fluid_slider.framework` & `pop.framework` into your project's `Embedded Binaries` and make sure the framework is also in linked libraries.
  * Go to your project's `Build Settings -> Frameworks Search Path` and add `${BUILT_PRODUCTS_DIR}/fluid_slider` non-recursive.
  * Now build your iOS app through Xcode

## 💻 Usage

```
import { RNFluidicSlider } from 'react-native-fluidic-slider'

<RNFluidicSlider></RNFluidicSlider>

```


## 💡 Props

- **General(iOS & Android)**

| Prop                   | Type                | Default | Note                                             |
| ---------------------- | ------------------- | ------- | ------------------------------------------------ |
| `min`     | `number`            |    `0`     | Specify min range value of the slider                 |
| `max`     | `number`            |    `100`     | Specify max range value of the slider                 |
| `initialPosition`     | `number - 0 to 1`            |    `.5`     | Specify initial position of slider indicator                 |
| `barColor`     | `string: HEX_COLOR`            |    `#6168e7`     | Specify bar color                 |
| `bubbleColor`     | `string: HEX_COLOR`            |    `#FFFFFF`     | Specify bubble color                 |
| `barTextColor`     | `string: HEX_COLOR`            |    `#FFFFFF`     | Specify bar text color                 |
| `bubbleTextColor`     | `string: HEX_COLOR`            |    `#000000`     | Specify bubble text color                 |
| `beginTracking`     | `func (position)`            |         | Specify callback function for begin tracking                 |
| `endTracking`     | `func (position)`            |         | Specify callback function for end tracking                 |


> **Note:**
> * Initial Position: Sepcify initial position in fraction from 0 to 1
> * beginTracking & endTracking: It will provide fraction value of position ranging from 0 to 1. Please use below formulate to calculate numerical value of selected position:
> __min + ((max - min) * position)__

## ✨ Credits

- Android Fluid Slider: [Ramotion/fluid-slider-android](https://github.com/Ramotion/fluid-slider-android)
- iOS Fluid Slider: [Ramotion/fluid-slider](https://github.com/Ramotion/fluid-slider)

## 🤔 How to contribute
Have an idea? Found a bug? Please raise to [ISSUES](https://github.com/prscX/react-native-fluidic-slider/issues).
Contributions are welcome and are greatly appreciated! Every little bit helps, and credit will always be given.

## 💫 Where is this library used?
If you are using this library in one of your projects, add it in this list below. ✨


## 📜 License
This library is provided under the Apache 2 License.

RNFluidicSlider @ [prscX](https://github.com/prscX)

## 💖 Support my projects
I open-source almost everything I can, and I try to reply everyone needing help using these projects. Obviously, this takes time. You can integrate and use these projects in your applications for free! You can even change the source code and redistribute (even resell it).

However, if you get some profit from this or just want to encourage me to continue creating stuff, there are few ways you can do it:
* Starring and sharing the projects you like 🚀
* If you're feeling especially charitable, please follow [prscX](https://github.com/prscX) on GitHub.

  <a href="https://www.buymeacoffee.com/prscX" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: auto !important;width: auto !important;" ></a>

  Thanks! ❤️
  <br/>
  [prscX.github.io](https://prscx.github.io)
  <br/>
  </ Pranav >
