public class URLify {
    public static String urlify(String s, int n) {
        char []urlified = s.toCharArray();
        
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i)==' ') {
                urlified[i]=urlified[n-i];
            }
        }
        return "";
    }
    public static void main(String[] args) {
        String s="Mr John Smity    ";
        int n=13;
        System.out.println("urlified:"+urlify(s, n));

        s="hello world  ";
        n=11;
        System.out.println("urlified:"+urlify(s, n));
    }
}