 public static int GCD(int a, int b) {
        if(a%b==0)
        {
            return b;
        }else {
            return GCD(b%a, a);
        }
    }