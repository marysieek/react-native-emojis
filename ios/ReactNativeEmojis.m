
#import "ReactNativeEmojis.h"

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
        emoji[@"visible"] = @YES;
        [emojisMapped addObject:  emoji];
    }

    return [emojisMapped copy];
}

@end
