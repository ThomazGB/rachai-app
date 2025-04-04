import React, { useState, useEffect } from "react";
import { SafeAreaView, Text, Button, View } from "react-native";
import { getItem, setItem, removeItem } from "@/constants/storage";
import { useRouter } from "expo-router";

export default function HomeScreen() {
  const [user, setUser] = useState<{ name: string; } | null>(null);
  const router = useRouter();

  const getUser = async () => {
    setUser(JSON.parse(await getItem("user") || "null"));
  } 
  useEffect(() => {
    getUser()
  }, [])

  return (
    <SafeAreaView style={{ flex: 1 }}>
      {
        user && (
          <View>
            <Text>{user.name}</Text>
            <Button
              title="Desconectar"
              onPress={async () => {
                await removeItem("user");
                // await removeItem("accessToken");
                // await removeItem("refreshToken");
                router.replace("/home");
              }}
            />
          </View>
        )
      }
      {
        !user && <Text>Carregando...</Text>
      }
    </SafeAreaView>
  );
}

