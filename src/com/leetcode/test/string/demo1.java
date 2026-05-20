package com.leetcode.test.string;

public class demo1 {
    public static void main(String[] args) {
        
        System.out.println("=== 1. 字符串的基本定义 ===");
        
        String str1 = "Hello World";
        System.out.println("直接赋值: " + str1);
        
        String str2 = new String("Hello World");
        System.out.println("new对象: " + str2);
        
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        String str3 = new String(charArray);
        System.out.println("从字符数组创建: " + str3);
        
        System.out.println("\n=== 2. 字符串是不可变的 ===");
        String s1 = "Hello";
        System.out.println("原始字符串: " + s1);
        System.out.println("内存地址: " + System.identityHashCode(s1));
        
        s1 = s1 + " World";
        System.out.println("拼接后: " + s1);
        System.out.println("内存地址: " + System.identityHashCode(s1));
        System.out.println("注意: 这是创建了新字符串,原字符串仍在内存中");
        
        System.out.println("\n=== 3. 字符串常量池 ===");
        String a = "Java";
        String b = "Java";
        System.out.println("a = \"Java\"");
        System.out.println("b = \"Java\"");
        System.out.println("a == b (比较引用): " + (a == b));
        System.out.println("a.equals(b) (比较内容): " + a.equals(b));
        System.out.println("原因: a和b都指向常量池中的同一个\"Java\"对象");
        
        String c = new String("Java");
        System.out.println("\nc = new String(\"Java\")");
        System.out.println("a == c (比较引用): " + (a == c));
        System.out.println("a.equals(c) (比较内容): " + a.equals(c));
        System.out.println("原因: c在堆内存中创建了新对象");
        
        System.out.println("\n=== 4. 常用字符串操作方法 ===");
        String text = "Hello, Java World!";
        
        System.out.println("原始字符串: " + text);
        System.out.println("长度 length(): " + text.length());
        System.out.println("charAt(0): " + text.charAt(0));
        System.out.println("charAt(7): " + text.charAt(7));
        System.out.println("substring(7): " + text.substring(7));
        System.out.println("substring(7, 11): " + text.substring(7, 11));
        System.out.println("indexOf('Java'): " + text.indexOf("Java"));
        System.out.println("contains('Java'): " + text.contains("Java"));
        System.out.println("toUpperCase(): " + text.toUpperCase());
        System.out.println("toLowerCase(): " + text.toLowerCase());
        System.out.println("replace('Java', 'Python'): " + text.replace("Java", "Python"));
        
        String[] parts = "apple,banana,orange".split(",");
        System.out.print("split(\",\"): [");
        for (int i = 0; i < parts.length; i++) {
            System.out.print(parts[i]);
            if (i < parts.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        
        System.out.println("\n=== 5. 字符串比较 ===");
        String strA = "abc";
        String strB = "abd";
        System.out.println("\"abc\".compareTo(\"abd\"): " + strA.compareTo(strB));
        System.out.println("\"abc\".equals(\"abc\"): " + strA.equals("abc"));
        System.out.println("\"ABC\".equalsIgnoreCase(\"abc\"): " + "ABC".equalsIgnoreCase("abc"));
        
        System.out.println("\n=== 6. StringBuilder (可变字符串) ===");
        StringBuilder sb = new StringBuilder();
        System.out.println("初始容量: " + sb.capacity());
        
        sb.append("Hello");
        System.out.println("append后: " + sb);
        
        sb.append(", ");
        sb.append("World");
        System.out.println("继续append: " + sb);
        
        sb.insert(5, " Java");
        System.out.println("insert后: " + sb);
        
        sb.delete(5, 10);
        System.out.println("delete后: " + sb);
        
        sb.reverse();
        System.out.println("reverse后: " + sb);
        
        String result = sb.toString();
        System.out.println("转String: " + result);
        
        System.out.println("\n=== 7. 字符串与基本类型转换 ===");
        String numStr = "123";
        int num = Integer.parseInt(numStr);
        System.out.println("String转int: \"" + numStr + "\" -> " + num);
        
        double doubleNum = Double.parseDouble("3.14");
        System.out.println("String转double: \"3.14\" -> " + doubleNum);
        
        String fromInt = String.valueOf(456);
        System.out.println("int转String: 456 -> \"" + fromInt + "\"");
        
        String fromDouble = String.valueOf(2.718);
        System.out.println("double转String: 2.718 -> \"" + fromDouble + "\"");
        
        System.out.println("\n=== 8. 字符串遍历 ===");
        String word = "Java";
        System.out.print("方式1 - charAt遍历: ");
        for (int i = 0; i < word.length(); i++) {
            System.out.print(word.charAt(i) + " ");
        }
        System.out.println();
        
        System.out.print("方式2 - toCharArray遍历: ");
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }
}
