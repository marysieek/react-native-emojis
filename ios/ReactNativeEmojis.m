
#import "ReactNativeEmojis.h"
#import <CoreText/CoreText.h>

@implementation ReactNativeEmojis

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE(EmojiChecker)

RCT_REMAP_METHOD(canShowEmojis,
                 params:(NSArray *)emojis
                 canShowEmojisWithResolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        resolve([self canShowEmojis:emojis]);
    });
}

- (NSArray *) canShowEmojis:(NSArray *)emojis
{
    NSMutableArray *emojisMapped = [NSMutableArray array];
    for (NSMutableDictionary *emoji in emojis) {
        NSString *code = emoji[@"char"];
        emoji[@"visible"] = [self canShowEmoji:code] ? @YES : @NO;
        [emojisMapped addObject:emoji];
    }

    return [emojisMapped copy];
}

- (BOOL) canShowEmoji:(NSString *)emoji
{
    NSData *data = [emoji dataUsingEncoding:NSUTF32LittleEndianStringEncoding];
    UTF32Char emojiValue;
    [data getBytes:&emojiValue length:sizeof(emojiValue)];

    UniChar characters[2] = { };
    CFIndex length = (CFStringGetSurrogatePairForLongCharacter(emojiValue, characters) ? 2 : 1);

    CGGlyph glyphs[2] = { };
    CTFontRef ctFont = CTFontCreateWithName((CFStringRef)@"AppleColorEmoji", 0.0, NULL);

    BOOL ret = CTFontGetGlyphsForCharacters(ctFont, characters, glyphs, length);
    CFRelease(ctFont);
    return ret;
}

@end
