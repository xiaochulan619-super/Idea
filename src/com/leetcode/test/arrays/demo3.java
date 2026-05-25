package com.leetcode.test.arrays;

public class demo3 {
    public static void main(String[] args) {
        
        // ============================================
        // 什么是数组？
        // ============================================
        // 数组是一种数据结构，用于在连续的内存空间中存储相同类型的多个元素
        // 特点：
        // 1. 长度固定，创建后不能改变
        // 2. 元素类型必须一致
        // 3. 可以通过索引（下标）快速访问任意元素
        // 4. 索引从0开始
        
        // ============================================
        // 1. 数组的声明和创建
        // ============================================
        
        // 方式1：先声明，再创建
        int[] numbers;              // 声明一个整型数组
        numbers = new int[5];       // 创建长度为5的数组，默认值为0
        
        // 方式2：声明的同时创建
        int[] scores = new int[10]; // 创建长度为10的整型数组
        
        // 方式3：声明时直接初始化
        int[] ages = {18, 20, 22, 25, 30}; // 创建并初始化，长度为5
        
        // 方式4：使用new关键字初始化
        String[] names = new String[]{"张三", "李四", "王五"};
        
        // ============================================
        // 2. 访问数组元素
        // ============================================
        
        System.out.println("=== 访问数组元素 ===");
        
        // 通过索引访问元素（索引从0开始）
        System.out.println("第一个年龄: " + ages[0]);   // 输出: 18
        System.out.println("第二个年龄: " + ages[1]);   // 输出: 20
        System.out.println("最后一个年龄: " + ages[ages.length - 1]); // 输出: 30
        
        // 修改数组元素
        ages[0] = 19;
        System.out.println("修改后的第一个年龄: " + ages[0]); // 输出: 19
        
        // ============================================
        // 3. 遍历数组
        // ============================================
        
        System.out.println("\n=== 遍历数组 ===");
        
        // 方式1：普通for循环
        System.out.print("普通for循环: ");
        for (int i = 0; i < ages.length; i++) {
            System.out.print(ages[i] + " ");
        }
        System.out.println();
        
        // 方式2：增强for循环（foreach）
        System.out.print("增强for循环: ");
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
        
        // ============================================
        // 4. 数组的常用操作
        // ============================================
        
        System.out.println("\n=== 数组常用操作 ===");
        
        // 获取数组长度
        System.out.println("数组长度: " + ages.length);
        
        // 查找最大值
        int[] data = {23, 67, 12, 89, 45, 34, 56};
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        System.out.println("最大值: " + max);
        
        // 计算总和和平均值
        int sum = 0;
        for (int num : data) {
            sum += num;
        }
        double average = (double) sum / data.length;
        System.out.println("总和: " + sum);
        System.out.println("平均值: " + average);
        
        // 查找特定元素
        int target = 89;
        boolean found = false;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                found = true;
                index = i;
                break;
            }
        }
        if (found) {
            System.out.println("找到元素 " + target + "，索引为: " + index);
        } else {
            System.out.println("未找到元素 " + target);
        }
        
        // ============================================
        // 5. 多维数组（二维数组示例）
        // ============================================
        
        System.out.println("\n=== 二维数组 ===");
        
        // 创建3行4列的二维数组
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        
        // 访问二维数组元素
        System.out.println("第一行第二列: " + matrix[0][1]); // 输出: 2
        System.out.println("第三行第四列: " + matrix[2][3]); // 输出: 12
        
        // 遍历二维数组
        System.out.println("遍历二维数组:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        
        // ============================================
        // 6. 数组的注意事项
        // ============================================
        
        System.out.println("\n=== 注意事项 ===");
        
        // 注意1：数组越界异常
        try {
            int value = ages[10]; // 这会抛出 ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("错误: 数组索引越界！数组长度为" + ages.length + "，但尝试访问索引10");
        }
        
        // 注意2：数组长度不可变
        System.out.println("数组一旦创建，长度固定为: " + ages.length);
        // 如果需要可变长度的集合，应该使用 ArrayList 等数据结构
        
        // 注意3：数组是引用类型
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;  // arr2和arr1指向同一个数组
        arr2[0] = 100;
        System.out.println("arr1[0] = " + arr1[0]); // 输出: 100，因为指向同一个数组
        
        // ============================================
        // 7. 数组的应用场景
        // ============================================
        
        System.out.println("\n=== 应用场景示例：学生成绩管理 ===");
        
        String[] students = {"小明", "小红", "小刚", "小丽"};
        int[] studentScores = {85, 92, 78, 95};
        
        // 打印所有学生成绩
        System.out.println("学生成绩列表:");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i] + ": " + studentScores[i] + "分");
        }
        
        // 统计最高分和最低分
        int maxScore = studentScores[0];
        int minScore = studentScores[0];
        String topStudent = students[0];
        String bottomStudent = students[0];
        
        for (int i = 1; i < studentScores.length; i++) {
            if (studentScores[i] > maxScore) {
                maxScore = studentScores[i];
                topStudent = students[i];
            }
            if (studentScores[i] < minScore) {
                minScore = studentScores[i];
                bottomStudent = students[i];
            }
        }
        
        System.out.println("最高分: " + topStudent + " (" + maxScore + "分)");
        System.out.println("最低分: " + bottomStudent + " (" + minScore + "分)");
    }
}
