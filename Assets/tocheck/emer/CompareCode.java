public class CompareCode {
 private String string1;
 private String string2;
 private int pointer;

 public void compare(String str1, String str2)
 {
    for(int i=0;i<str1.length();i++)
    {
        if(i>=str2.length()){
            pointer++;
        }
        else if(str1.charAt(i)==str2.charAt(i))
        {
            pointer--;
        }
        else pointer++;
    }

    System.out.println(pointer);

    if(pointer<0)
    {
        System.out.println("Same Code");
    }
    else
    {
        System.out.println("Different Code");
    }
 }
}
