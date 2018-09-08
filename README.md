
# react-native-emojis

## Getting started

`$ npm install react-native-emojis --save`

### Mostly automatic installation

`$ react-native link react-native-emojis`

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.ReactNativeEmojisPackage;` to the imports at the top of the file
  - Add `new ReactNativeEmojisPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-emojis'
  	project(':react-native-emojis').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-emojis/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
	compile project(':react-native-emojis')
  	```

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-emojis` and add `RNReactNativeEmojis.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNReactNativeEmojis.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)

## Usage
```javascript
import EmojiChecker from 'react-native-emojis';

// Both platforms
const emojisList = [{ char: 'U+1F631' }]
const result = await EmojiChecker.canShowEmojis(emojisList);
// result => [{ char: 'U+1F631', visible: true }]

// Android only
const emoji = 'U+1F631'
const result = await EmojiChecker.canShowEmoji(emoji);
// result => true
const result = await EmojiChecker.convertToSupportedEmoji(emoji);
// result => 'U+1F632'
```

## License
[MIT](LICENSE)

