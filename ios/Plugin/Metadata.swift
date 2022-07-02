import Foundation

@objc public class Metadata: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
