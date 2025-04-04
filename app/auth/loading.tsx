import { StyleSheet, Alert } from "react-native";

import { useRouter, useLocalSearchParams } from "expo-router";
import { useEffect, useState } from "react";
import { Text, View } from "@/components/Themed";
import { setItem } from "@/constants/storage";

const styles = StyleSheet.create({
  container: {
    alignItems: "center",
    flex: 1,
    flexDirection: "column",
    gap: 16,
    justifyContent: "center"
  },
  title: {
    color: "#FFFFFF",
    fontSize: 20,
    fontWeight: "bold"
  }
});

export default function AuthLoadingScreen() {
  // const [isLoading, setIsLoading] = useState(false);
  // const router = useRouter();
  const params = useLocalSearchParams();
  // console.log("bbb")
  // Alert.alert("socorro")

  // const handleProviderSignin = async () => {
  //   console.log("bbb")
  //   Alert.alert("bbb")

  //   if (isLoading) return;
  //   setIsLoading(true)

  //   const token = params.token as string;
  //   console.log(token)
  //   Alert.alert(token)

  //   if (!token) {
  //     router.replace("/auth/login");
  //     return;
  //   }

  //   const res = await fetch(`${process.env.EXPO_PUBLIC_API_URL}/login`, {
  //     headers: { 'Content-Type': 'application/json' },
  //     body: JSON.stringify({
  //       token
  //     })
  //   })
  //   console.log(res)
  //   Alert.alert(res.status.toString())

  //   const data = await res.json()

  //   if (!data) {
  //     router.replace("/auth/login");
  //     return;
  //   }

  //   await setItem("user", JSON.stringify(data.user));
  //   // await setItem("accessToken", data.accessToken);
  //   // await setItem("refreshToken", data.refreshToken);
  //   router.replace("/home");
  //   setIsLoading(false)
  // };

  // useEffect(() => {
  //   console.log("aaaa")
  //   Alert.alert("aaaaa")
  //   handleProviderSignin();
  // }, []);

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Carregando...</Text>
      <Text style={styles.title}>{params.token}</Text>
    </View>
  );
}
