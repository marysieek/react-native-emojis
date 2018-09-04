
package com.reactlibrary;

import android.graphics.Paint;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

public class RNReactNativeEmojisModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private static Paint paint = new Paint();
  private static final String MODULE_NAME = "EmojiChecker";

  public RNReactNativeEmojisModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @ReactMethod
  public void canShowEmoji(String emoji, final Promise promise) {
    Paint paint = new Paint();

    try {
      boolean result = paint.hasGlyph(emoji);
      promise.resolve(result);
    } catch (NoSuchMethodError e) {
      promise.reject("Error", e);
    }
  }

  private boolean isSupportedEmoji(String emoji) {
    return paint.hasGlyph(emoji);
  }

  /**
   * ❤️ Returns a WritableArray object that has field named "visible" added. It's
   * value is determined from isSupportedEmoji method and is truthy when emoji
   * exists or falsey when it does not.
   *
   *
   * @param readableArray array of emojis that need to be checked in
   *                      [{ char: 'U+1F631' }] format
   * @param promise       communication with RN happens either by promises or callbacks -
   *                      in this case promises were used
   * @return the modified readableArray with extra field determining the emoji visibility
   */
  @ReactMethod
  public void canShowEmojis(ReadableArray readableArray, final Promise promise) {
    WritableArray array = Arguments.createArray();
    for (int i = 0; i < readableArray.size(); i++) {
      final WritableMap writableMap = Arguments.createMap();
      ReadableMap entry = readableArray.getMap(i);
      writableMap.merge(entry);
      String value = entry.getString("char");

      if (value != null) {
        writableMap.putBoolean("visible", isSupportedEmoji(value));
      } else {
        writableMap.putBoolean("visible", false);
      }
      array.pushMap(writableMap);
    }
    promise.resolve(array);
  }

  @Override
  public String getName() {
    return MODULE_NAME;
  }
}
