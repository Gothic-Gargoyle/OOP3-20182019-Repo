public class Test {
  public static void main(String[] args) {
  xMethod(1234567);
  }
  public static void xMethod(int n) {
    if (n > 0) {
      System.out.print(n % 10);
      xMethod(n / 10);
    }
  }
}
