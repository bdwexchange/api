package com.example.demo.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class demo {


    private static final String API_HOST = "39.100.79.158";
    private static final String SIGNATURE_METHOD = "HmacSHA256";
    private static final String SIGNATURE_VERSION = "2";

    private static final ZoneId ZONE_GMT = ZoneId.of("Z");

    private static final DateTimeFormatter DT_FORMAT = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss");


    private static String createSignature(String method, String path, String apiKey, String timeStamp,
                                          Map map, String secretKey) {
        StringBuilder sb = new StringBuilder(1024);
        // GET
        sb.append(method.toUpperCase()).append('\n')
                // Host
                .append(API_HOST.toLowerCase()).append('\n')
                // path
                .append(path).append('\n');



        StringJoiner joiner = new StringJoiner("&");
        joiner.add("accessKeyId=" + apiKey)
                .add("signatureMethod=" + SIGNATURE_METHOD)
                .add("signatureVersion=" + SIGNATURE_VERSION)
                .add("timestamp=" + encode(timeStamp));


        //拼接 遍历map
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<String, String> entry = entries.next();
            joiner.add(entry.getKey()+"="+entry.getValue());
        }
        String sign = HmacSHA256Signer.sign(sb.toString() + joiner.toString(), secretKey);

        return sign;
    }

    private static String encode(String code) {
        try {
            return URLEncoder.encode(code, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 查询个人 id
     *
     */

   /* public static void main(String[] args)throws Exception {

        String s = Instant.now().atZone(ZONE_GMT).format(DT_FORMAT);
        String timeStamp = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
        System.out.println( timeStamp);
        Map map = new TreeMap();
        String sin = createSignature("get","/open-api/user/get/account",
                "fa922d49-****-****-****-3bfd95392918",timeStamp,
                map,
                "a4d1bb15-****-****-****-1bb11360af81");
        System.out.println(sin);
        Map<String, String> params = new TreeMap<>() ;
        params.put("accessKeyId","fa922d49-****-****-****-3bfd95392918");
        params.put("signatureMethod",SIGNATURE_METHOD);
        params.put("signatureVersion",SIGNATURE_VERSION);
        params.put("timestamp",timeStamp);
        params.put("signature",sin);
        String ss = HttpRequestUtil.URLGet("https://api.nr3d.cn/open-api/user/get/account",params,"utf-8");
        System.out.println(ss);
    }*/

    /**
     * 查询个人账户信息
     *
     */

    /*public static void main(String[] args) throws Exception {

        String s = Instant.now().atZone(ZONE_GMT).format(DT_FORMAT);
        String timeStamp = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
        System.out.println( timeStamp);
        Map map = new TreeMap();
        map.put("memberId","127");
        String sin = createSignature("get","/open-api/user/account",
                "fa922d49-****-****-****-3bfd95392918",timeStamp,
                map,
                "a4d1bb15-****-****-****-1bb11360af81");
        System.out.println(sin);
        Map<String, String> params = new TreeMap<>() ;
        params.put("accessKeyId","fa922d49-****-****-****-3bfd95392918");
        params.put("signatureMethod",SIGNATURE_METHOD);
        params.put("signatureVersion",SIGNATURE_VERSION);
        params.put("timestamp",timeStamp);
        params.put("signature",sin);
        params.put("memberId","127");
        String ss = HttpRequestUtil.URLGet("https://api.nr3d.cn/open-api/user/account",params,"utf-8");
        System.out.println(ss);
    }*/

    /*
    *
    * 下单
    * */

   /* public static void main(String[] args)throws Exception {

        String s = Instant.now().atZone(ZONE_GMT).format(DT_FORMAT);
        String timeStamp = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
        System.out.println( timeStamp);
        Map map = new TreeMap();
        map.put("memberId","127");
        map.put("direction","BUY");
        map.put("symbol","eth/usdt");
        map.put("price","500");
        map.put("amount","1");
        map.put("type","LIMIT_PRICE");
        String sin = createSignature("POST","/open-api/user/add_order",
                "fa922d49-****-****-****-3bfd95392918",timeStamp,
                map,
                "a4d1bb15-****-****-****-1bb11360af81");
        System.out.println(sin);
        Map<String, String> params = new TreeMap<>() ;
        params.put("accessKeyId","fa922d49-****-****-****-3bfd95392918");
        params.put("signatureMethod",SIGNATURE_METHOD);
        params.put("signatureVersion",SIGNATURE_VERSION);
        params.put("timestamp",timeStamp);
        params.put("signature",sin);
        params.put("memberId","127");
        params.put("direction","BUY");
        params.put("symbol","eth/usdt");
        params.put("price","500");
        params.put("amount","1");
        params.put("type","LIMIT_PRICE");
        String ss = HttpRequestUtil.URLPost("https://api.nr3d.cn/open-api/user/add_order",params,"utf-8");
        System.out.println(ss);
    }*/

    /*
     * 根据订单Id查询订单详情
     * */

    /*public static void main(String[] args)throws Exception {

        String s = Instant.now().atZone(ZONE_GMT).format(DT_FORMAT);
        String timeStamp = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
        System.out.println( timeStamp);
        Map map = new TreeMap();
        map.put("orderId","E156030921685859");
        String sin = createSignature("GET","/open-api/user/query/order_detail",
                "fa922d49-****-****-****-3bfd95392918",timeStamp,
                map,
                "a4d1bb15-****-****-****-1bb11360af81");
        System.out.println(sin);
        Map<String, String> params = new TreeMap<>() ;
        params.put("accessKeyId","fa922d49-****-****-****-3bfd95392918");
        params.put("signatureMethod",SIGNATURE_METHOD);
        params.put("signatureVersion",SIGNATURE_VERSION);
        params.put("timestamp",timeStamp);
        params.put("signature",sin);
        params.put("orderId","E156030921685859");
        String ss = HttpRequestUtil.URLGet("https://api.nr3d.cn/open-api/user/query/order_detail",params,"utf-8");
        System.out.println(ss);
    }*/

    /*
     * 根据用户id和交易对查询当前委托订单列表
     * */

   /* public static void main(String[] args)throws Exception {

        String s = Instant.now().atZone(ZONE_GMT).format(DT_FORMAT);
        String timeStamp = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
        System.out.println( timeStamp);
        Map map = new TreeMap();
        map.put("memberId","127");
        map.put("pageNum","1");
        map.put("pageSize","2");
        String sin = createSignature("POST","/open-api/user/query/order",
                "fa922d49-****-****-****-3bfd95392918",timeStamp,
                map,
                "a4d1bb15-****-****-****-1bb11360af81");
        System.out.println(sin);
        Map<String, String> params = new TreeMap<>() ;
        params.put("accessKeyId","fa922d49-****-****-****-3bfd95392918");
        params.put("signatureMethod",SIGNATURE_METHOD);
        params.put("signatureVersion",SIGNATURE_VERSION);
        params.put("timestamp",timeStamp);
        params.put("signature",sin);
        params.put("memberId","127");
        params.put("pageNum","1");
        params.put("pageSize","2");
        String ss = HttpRequestUtil.URLPost("https://api.nr3d.cn/open-api/user/query/order",params,"utf-8");
        System.out.println(ss);
    }*/

    /*
     * 根据订单号取消订单
     * */

    /*public static void main(String[] args)throws Exception {

        String s = Instant.now().atZone(ZONE_GMT).format(DT_FORMAT);
        String timeStamp = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
        System.out.println(timeStamp);
        Map map = new TreeMap();
        map.put("orderId", "E156031055002212");
        map.put("memberId", "127");
        String sin = createSignature("GET", "/open-api/user/cancel_order",
                "fa922d49-****-****-****-3bfd95392918", timeStamp,
                map,
                "a4d1bb15-****-****-****-1bb11360af81");
        System.out.println(sin);
        Map<String, String> params = new TreeMap<>();
        params.put("accessKeyId", "fa922d49-****-****-****-3bfd95392918");
        params.put("signatureMethod", SIGNATURE_METHOD);
        params.put("signatureVersion", SIGNATURE_VERSION);
        params.put("timestamp", timeStamp);
        params.put("signature", sin);
        params.put("orderId", "E156031055002212");
        params.put("memberId", "127");
        String ss = HttpRequestUtil.URLGet("https://api.nr3d.cn/open-api/user/cancel_order", params, "utf-8");
        System.out.println(ss);
    }*/

    /*
    *查询用户历史委托
    * */
    public static void main(String[] args)throws Exception {

        /*
        * period
        * 0-week
        * 1-month
        * 2-2month
        * */
        String s = Instant.now().atZone(ZONE_GMT).format(DT_FORMAT);
        String timeStamp = URLEncoder.encode(s, "UTF-8").replaceAll("\\+", "%20");
        System.out.println(timeStamp);
        Map map = new TreeMap();
        map.put("memberId", "48");
        map.put("symbol", "QTUM/BC");
        map.put("period", "0");
        map.put("pageSize", "100");
        String sin = createSignature("POST", "/open-api/user/exchange/personal/history",
                "3cee3126-****-****-****-1b244db57f22", timeStamp,
                map,
                "a6caf627-****-****-****-1306dd84b79c");
        System.out.println(sin);
        Map<String, String> params = new TreeMap<>();
        params.put("accessKeyId", "3cee3126-****-****-****-1b244db57f22");
        params.put("signatureMethod", SIGNATURE_METHOD);
        params.put("signatureVersion", SIGNATURE_VERSION);
        params.put("timestamp", timeStamp);
        params.put("signature", sin);
        params.put("memberId", "48");
        params.put("symbol", "QTUM/BC");
        params.put("period", "0");
        params.put("pageSize", "100");
        String ss = HttpRequestUtil.URLPost("https://api.nr3d.cn/open-api/user/exchange/personal/history", params, "utf-8");
        System.out.println(ss);
    }

   /**
    *
    *  获取历史K线图
    * */

    /*public static void main(String[] args)throws Exception {
        Map<String, String> params = new TreeMap<>();
        params.put("symbol", "ETH/USDT");
        params.put("period", "1min");
        params.put("size", "100");
        String ss = HttpRequestUtil.URLPost("https://api.nr3d.cn/open-api/open/history/kline", params, "utf-8");
        System.out.println(ss);
    }*/

    /**
     * 获取支持交易对symbol_thumb讯息
     * */
    /*public static void main(String[] args) {
        Map<String, String> params = new TreeMap<>();
        String ss = HttpRequestUtil.URLGet("https://api.nr3d.cn/open-api/open/symbol_thumb", params, "utf-8");
        System.out.println(ss);
    }*/

    /**
     *  获取盘口信息
     * */
    /*public static void main(String[] args) {
        Map<String, String> params = new TreeMap<>();
        params.put("symbol", "ETH/USDT");
        params.put("size", "100");
        String ss = HttpRequestUtil.URLPost("https://api.nr3d.cn/open-api/open/trade_plate", params, "utf-8");
        System.out.println(ss);
    }*/

    /**
     *获取成交历史信息
     * */
    /*public static void main(String[] args) {
        Map<String, String> params = new TreeMap<>();
        params.put("symbol", "ETH/USDT");
        params.put("size", "100");
        String ss = HttpRequestUtil.URLPost("https://api.nr3d.cn/open-api/open/trade_history", params, "utf-8");
        System.out.println(ss);
    }*/


}












