public class MyTest {
    public static void main(String[] args) {
        //传入一个存储图片的路径  返回验证码信息
        String s = ImageUtil.saveCodeImage("C:\\Users\\ccl02\\Desktop\\陈长磊\\垃圾桶");
        System.out.println(s);
    }
}
