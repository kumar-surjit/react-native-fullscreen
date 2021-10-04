import * as React from 'react';

import { StyleSheet, View, Button } from 'react-native';
import Fullscreen from '@surjit_kumar/react-native-fullscreen';

export default function App() {
  const enterFullScreenMode = () => {
    Fullscreen.enableFullScreen();
  };

  const exitFullScreenMode = () => {
    Fullscreen.disableFullScreen();
  };
  return (
    <View style={styles.container}>
      <View style={{ marginBottom: 16 }}>
        <Button onPress={enterFullScreenMode} title="Enable FullScreen Mode" />
      </View>
      <Button onPress={exitFullScreenMode} title="Exit FullScreen Mode" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    paddingTop: 50,
  },
});
