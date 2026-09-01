import React from 'react';
import { StyleSheet, Text, View, SafeAreaView, StatusBar } from 'react-native';

export default function App() {
  return (
    <SafeAreaView style={styles.container}>
      <StatusBar barStyle="light-content" backgroundColor="#121212" />
      <View style={styles.card}>
        <Text style={styles.title}>MyInstaApp</Text>
        <Text style={styles.subtitle}>System Online 🚀</Text>
      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#121212',
    alignItems: 'center',
    justifyContent: 'center',
  },
  card: {
    padding: 24,
    borderRadius: 16,
    backgroundColor: '#1E1E1E',
    alignItems: 'center',
    borderWidth: 1,
    borderColor: '#2A2A2A',
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#FFFFFF',
    marginBottom: 8,
  },
  subtitle: {
    fontSize: 14,
    color: '#A0A0A0',
  },
});
