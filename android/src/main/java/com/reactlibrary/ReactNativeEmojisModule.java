
package com.reactlibrary;

import android.app.Application;
import android.graphics.Paint;
import android.support.text.emoji.bundled.BundledEmojiCompatConfig;
import android.support.text.emoji.EmojiCompat;

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

public class ReactNativeEmojisModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private static Paint paint = new Paint();
  private static final String MODULE_NAME = "EmojiChecker";

  public ReactNativeEmojisModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    initializeEmojiCompat();
  }

  @Override
  public String getName() {
    return MODULE_NAME;
  }

  /**
   * ❤️ Returns a promise that resolves to Boolean value to determine, whether a single
   * emoji is supported or not
   *
   *
   * @param emoji         String that includes the emoji, i.e. 'U+1F631'
   * @param promise       communication with RN happens either by promises or callbacks -
   *                      in this case promises were used
   * @return the boolean value that states whether the emoji is renderable or not
   */
  @ReactMethod
  public void canShowEmoji(String emoji, final Promise promise) {
    Paint paint = new Paint();

    try {
      boolean result = isSupportedEmoji(emoji);
      promise.resolve(result);
    } catch (NoSuchMethodError e) {
      promise.reject("Error", e);
    }
  }

  /**
   * ❤️ Returns a promise that resolves to WritableArray object,
   * that has field named "visible" added. It's value is determined from
   * isSupportedEmoji method and is truthy when emoji exists or falsey
   * when it does not
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


  /**
   * ❤️ Returns a promise that resolves to String emoji object, converted to the supported emoji
   *
   *
   * @param emoji         String that includes the emoji, i.e. 'U+1F631'
   * @param promise       communication with RN happens either by promises or callbacks -
   *                      in this case promises were used
   * @return the supported emoji
   */
  @ReactMethod
  public void convertToSupportedEmoji(String emoji, final Promise promise) {
    try {
      CharSequence processed = EmojiCompat.get().process(emoji);
      promise.resolve(processed);
    } catch (NoSuchMethodError e) {
      promise.reject("Error", e);
    }
  }

  private boolean isSupportedEmoji(String emoji) {
    return paint.hasGlyph(emoji);
  }

  private void initializeEmojiCompat() {
    final EmojiCompat.Config config;
    config = new BundledEmojiCompatConfig(this.reactContext.getApplicationContext());
    EmojiCompat.init(config);
  }
}
