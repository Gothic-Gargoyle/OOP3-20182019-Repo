public class FileProcessor {
  public static void main(final String[] arguments) {
    String incomingdata = "Dummy inkomende data";
    // Signen met SHA256
    FileSignStrategy fileSignStrategy = new SignMD5();
    String sha256SignedData = fileSignStrategy.sign(incomingdata);
    System.out.println(sha256SignedData);

    // Encrypt met AES
    FileEncryptStrategy fileEncryptStrategy = new EncryptAES();
    String encryptedData = fileEncryptStrategy.encrypt(incomingdata, "key");
    System.out.println(encryptedData);
  }
}

interface FileSignStrategy {
  public String sign(String data);
}

interface FileEncryptStrategy {
  public String encrypt(String data, String key);
}

// SHA256 implementatie
class SignSHA256 implements FileSignStrategy {
  public String sign(String data) {
    return "SHA256 hash";
  }
}

// MD5 Implementatie
class SignMD5 implements FileSignStrategy {
  public String sign(String data) {
    return "MD5 hash";
  }
}

// AES Implementatie
class EncryptAES implements FileEncryptStrategy {
  public String encrypt(String data,  String key) {
     return "AES encrypted string";
  }
}

// Blowfish implementatie
class EncryptBlowfish implements FileEncryptStrategy {
  public String encrypt(String data,  String key) {
     return "Blowfish encrypted string";
  }
}

