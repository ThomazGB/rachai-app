import React, { useState } from "react";
import { View, StyleSheet, Alert } from "react-native";
import { TextInput, Button } from "react-native";
import { GoogleLogin } from "@/components/GoogleLogin";

export default function LoginScreen() {
  return (
    <View style={styles.container}>
      <GoogleLogin />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    padding: 20,
    backgroundColor: "#f4f4f4",
  },
  card: {
    padding: 20,
    borderRadius: 10,
  },
  title: {
    fontSize: 24,
    fontWeight: "bold",
    marginBottom: 20,
    textAlign: "center",
  },
  input: {
    marginBottom: 15,
  },
  button: {
    marginTop: 10,
  },
});
