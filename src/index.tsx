import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-fullscreen' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const Fullscreen = NativeModules.FullScreenModule
  ? NativeModules.FullScreenModule
  : new Proxy(
      {},
      {
        get() {
          if (Platform.OS === 'android') throw new Error(LINKING_ERROR);
        },
      }
    );

interface FullScreenInterface {
  enableFullScreen(): void;
  disableFullScreen(): void;
}
export default Fullscreen as FullScreenInterface;
