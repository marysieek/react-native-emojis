
# react-native-react-native-emojis

## Getting started

`$ npm install react-native-react-native-emojis --save`

### Mostly automatic installation

`$ react-native link react-native-react-native-emojis`

### Manual installation

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

## Usage
```javascript
import EmojiChecker from 'react-native-react-native-emojis';

const emojisList =[{ char: 'U+1F631' }]
const result = await EmojiChecker.canShowEmojis(emojisList);
// result => [{ char: 'U+1F631', visible: true }]

```
  
