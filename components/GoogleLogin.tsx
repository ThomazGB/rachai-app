import { generateCodeVerifier, generateCodeChallenge } from "@/utils/pcke";
import * as WebBrowser from "expo-web-browser";
import { Pressable, Text } from "react-native";

export function GoogleLogin() {
  const handleAuth = async () => {
    let codeChallenge;
    let codeVerifier;
  
    try {
      codeVerifier = await generateCodeVerifier();
      codeChallenge = await generateCodeChallenge({ codeVerifier });
    } catch (err) {
      // eslint-disable-next-line no-console
      console.log(err);
    }
  
    const authUrl = `https://accounts.google.com/o/oauth2/v2/auth?client_id=${
      process.env.EXPO_PUBLIC_GOOGLE_CLIENT_ID
    }&redirect_uri=${
      process.env.EXPO_PUBLIC_API_URL
    }/callback&response_type=code&scope=profile%20email&prompt=consent&access_type=offline&code_challenge=${
      codeChallenge
    }&code_challenge_method=S256&state=${
      encodeURIComponent(codeVerifier || "")
    }`
  
    await WebBrowser.openAuthSessionAsync(authUrl);
  }

  return (
    <Pressable
      onPress={handleAuth}
      style={{
        backgroundColor: "#4285F4",
        paddingVertical: 12,
        paddingHorizontal: 20,
        borderRadius: 8,
        alignItems: "center",
        justifyContent: "center",
      }}
    >
      <Text style={{ color: "white", fontWeight: "bold", fontSize: 16 }}>
        Login com o Google
      </Text>
    </Pressable>
  );
}