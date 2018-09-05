
#import "ReactNativeEmojis.h"
#import <React/RCTLog.h>

@implementation ReactNativeEmojis

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE(EmojiChecker)

RCT_REMAP_METHOD(canShowEmojis,
                 resolver:(RCTPromiseResolveBlock)resolve
                 rejecter:(RCTPromiseRejectBlock)reject)
{
    RCTLogInfo(@"Pretending to show emojis");
    dispatch_async(dispatch_get_main_queue(), ^{
        resolve(nil);
    });
}

@end
