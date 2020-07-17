package demo02classLayout;

import org.openjdk.jol.info.ClassLayout;

/**
 -XX:-UseCompressedOops 关闭JVM开启的klass pointer的 指针压缩

 OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
 0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
 4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
 8     4        (object header)                           d8 34 42 17 (11011000 00110100 01000010 00010111) (390214872)
 12     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
 16     4    int LayoutLock.obj    int占4个字节             0
 20     4        (loss due to the next object alignment) 总共20个字节，不是8的整数倍，会加4个填充数据
 Instance size: 24 bytes

 d8 34 42 17 00 00 00 00  后八个存的类的信息

 */
public class Demo01 {
    public static void main(String[] args) {
        LayoutLock obj = new LayoutLock();
        System.out.println(obj.hashCode());
        System.out.println(Integer.toHexString(obj.hashCode()));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }
}
