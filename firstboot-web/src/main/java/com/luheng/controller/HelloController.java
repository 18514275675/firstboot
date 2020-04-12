package com.luheng.controller;

import com.luheng.configuration.LuhengConfig;
import com.luheng.service.BookService;
import com.luheng.service.CarService;
import com.luheng.service.UserService;
import com.luheng.thread.CreateThreadPool;
import com.luheng.thread.MyThread;
import org.apache.tomcat.jni.Socket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//@RestController
@Controller
public class HelloController {


//    @Autowired
//    private ReadProperties readProperties;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    MailService mailService;

    //此处返回值为Json格式,因为本类上添加了@RestController注解,会将控制器方法的返回值自动转为json
    @RequestMapping("/log.gif")
    public void hello(String args, HttpServletResponse response) throws Exception {
        System.out.println(args);
        //日志收集
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/gif");
        OutputStream out = response.getOutputStream();
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        ImageIO.write(image, "gif", out);
        out.flush();
        System.out.println(args);
    }

    @RequestMapping("/testPool")
    @ResponseBody
    public String testPool() {
        ThreadPoolExecutor pool = CreateThreadPool.getPool();
        for (int i = 0; i < 20; i++) {
            MyThread myThread = new MyThread();
            Thread thread = new Thread(myThread);
            try {pool.submit(thread);
                BlockingQueue<Runnable> queue = pool.getQueue();
                boolean b = pool.awaitTermination(20, TimeUnit.SECONDS);

                System.out.println("----->size:" + queue.size());
            } catch (Exception e) {
                System.out.println("拒绝任务_" + i);
            }
        }
        return "ok";
    }

    public static void main(String[] args) throws Exception {
//        Phone phone = new Phone();
//        phone.sendEmail();
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(LuhengConfig.class);
//        UserService us = (UserService) context.getBean("userService");
//        String userName = us.getUserName();
//        System.out.println(userName);

//        String s = dubboService.lhMethod();
//        ClassPathXmlApplicationContext context1 =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        list.add(1213);
//        list.add(13);
//        list.forEach(HelloController::mehtod);
        // 异或是两个数的二进制数,相同为0不同为1
        int a = 3;          // 0011
        int b = 9;          // 1001
        int c = a ^ b;      // 异或后为1010  转为十进制-> 10
//        System.out.println(a ^ b);

        // >>> 是二进制数无符号右移的意思
        // 3 >>> 1 转换为二进制位是11, 即 11向右移一位
        // 位移前: 1 1
        // 位移后: 0 1
        // 位移过程:    1.在 11 前面补位一个0
        //             2.删除011 的最后一位
//        int d = 3 >>> 1;
//        HashMap<String, String> map = new HashMap<>();
//        map.put("asdhk","aaa");
//        System.gc();
//        File file = new File("test.zip");
//        RandomAccessFile raf = new RandomAccessFile(file, "rw");
//        FileChannel fileChannel = raf.getChannel();
//        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("", 1234));
//        // 直接使用了transferTo()进行通道间的数据传输
//        fileChannel.transferTo(0, fileChannel.size(), socketChannel);

//        List<Object> objList = new ArrayList<>();
//        List<String> strList = new ArrayList<>();
//        objList = strList;
    }

    @Autowired
    UserService userServiceTpl;

    @Autowired
    BookService bookService;

    @Autowired
    CarService carService;


    @RequestMapping("/testDubbo")
    @ResponseBody
    public String testDubbo() {
        String userName = userServiceTpl.getUserName();
        String bookName = bookService.getBookName();
        String carName = carService.getCarName();
        return userName + bookName + carName;
    }

}
