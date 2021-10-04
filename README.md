# @surjit_kumar/react-native-fullscreen

This package helps developers to easily toggle between android full screen and normal mode by providing js methods to enable/disable full screen on android. It is specifically for android and has nothing to do with ios full screen.

## Installation

```sh
npm install @surjit_kumar/react-native-fullscreen
```

## Usage

```js
import Fullscreen from '@surjit_kumar/react-native-fullscreen';

// ...
export default function App() {
  const enterFullScreenMode = () => {
    Fullscreen.enableFullScreen();
  };
// ...
return (
    <View style={styles.container}>
      <View style={{ marginBottom: 16 }}>
        <Button onPress={enterFullScreenMode} title="Enable FullScreen Mode" />
      </View>
      <Button onPress={exitFullScreenMode} title="Exit FullScreen Mode" />
    </View>
  );
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
