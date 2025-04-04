import FontAwesome from '@expo/vector-icons/FontAwesome';
import { DarkTheme, DefaultTheme, ThemeProvider } from '@react-navigation/native';
import { useFonts } from 'expo-font';
import { Stack } from 'expo-router';
import * as SplashScreen from 'expo-splash-screen';
import { useEffect } from 'react';
import 'react-native-reanimated';

import { useRouter, usePathname } from 'expo-router';
import { useColorScheme } from '@/components/useColorScheme';
import { getItem } from '@/constants/storage';

export {
  ErrorBoundary,
} from 'expo-router';

SplashScreen.preventAutoHideAsync();

export default function RootLayout() {
  const [loaded, error] = useFonts({
    SpaceMono: require('../assets/fonts/SpaceMono-Regular.ttf'),
    ...FontAwesome.font,
  });

  useEffect(() => {
    if (error) throw error;
  }, [error]);

  useEffect(() => {
    if (loaded) {
      SplashScreen.hideAsync();
    }
  }, [loaded]);

  if (!loaded) {
    return null;
  }

  return <RootLayoutNav />;
}

function RootLayoutNav() {
  const colorScheme = useColorScheme();

  const router = useRouter();
  const pathname = usePathname();

  const checkAuth = async () => {
    console.log("teste");
    const user = JSON.parse(await getItem("user") || "null");
    if (!user) {
      if (
        pathname !== "/auth/login" &&
        !pathname.startsWith("/auth")
      ) {
        router.replace("/auth/login");
      }
    } else if (pathname !== "/home") {
      router.replace("/home");
    }
  };
  
  useEffect(() => {
    checkAuth();
  }, [pathname]);

  return (
    <ThemeProvider value={colorScheme === 'dark' ? DarkTheme : DefaultTheme}>
      <Stack>
        <Stack.Screen name="/" options={{ headerShown: false }} />
        <Stack.Screen name="/auth/loading" options={{ headerShown: false }} />
        <Stack.Screen name="/auth/login" options={{ headerShown: false }} />
        <Stack.Screen name="/home" options={{ headerShown: false }} />
      </Stack>
    </ThemeProvider>
  );
}
