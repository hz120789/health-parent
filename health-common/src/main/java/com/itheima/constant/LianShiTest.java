package com.itheima.constant;

public class LianShiTest {
    public static void main(String[] args) {
        LianShi lianShi = new LianShi();
        lianShi.setCatchZ("1");
        lianShi.setThen("2");

        System.out.println(lianShi);
        lianShi.then("11").catchZ("22");
        System.out.println(lianShi);

    }
}
