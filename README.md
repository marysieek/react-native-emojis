
# react-native-react-native-emojis

## Getting started

`$ npm install react-native-react-native-emojis --save`

### Mostly automatic installation

`$ react-native link react-native-react-native-emojis`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-react-native-emojis` and add `RNReactNativeEmojis.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeEmojis.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNReactNativeEmojisPackage;` to the imports at the top of the file
  - Add `new RNReactNativeEmojisPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-react-native-emojis'
  	project(':react-native-react-native-emojis').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-react-native-emojis/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-react-native-emojis')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNReactNativeEmojis.sln` in `node_modules/react-native-react-native-emojis/windows/RNReactNativeEmojis.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using React.Native.Emojis.RNReactNativeEmojis;` to the usings at the top of the file
  - Add `new RNReactNativeEmojisPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNReactNativeEmojis from 'react-native-react-native-emojis';

// TODO: What to do with the module?
RNReactNativeEmojis;
```
  