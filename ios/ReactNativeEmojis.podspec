
Pod::Spec.new do |s|
  s.name          = "ReactNativeEmojis"
  s.version       = "1.0.4"
  s.summary       = "ReactNativeEmojis"
  s.description   = <<-DESC
                     ReactNativeEmojis
                    DESC
  s.homepage      = ""
  s.license       = "MIT"
  s.author        = { "author" => "stoklosama@gmail.com" }
  s.platform      = :ios, "7.0"
  s.source        = { :git => "https://github.com/marysieek/react-native-emojis.git", :tag => "master" }
  s.source_files  = "ReactNativeEmojis/**/*.{h,m}"
  s.requires_arc  = true
  s.dependency "React"
end

