using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace React.Native.Emojis.RNReactNativeEmojis
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNReactNativeEmojisModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNReactNativeEmojisModule"/>.
        /// </summary>
        internal RNReactNativeEmojisModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNReactNativeEmojis";
            }
        }
    }
}
