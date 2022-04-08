package ali;
// 请用熟悉的语言实现一个函数 parseUrl(url)，假设 URL 规范，不使用正则表达式，将一段 URL 字符串解析为 Object
// Object 包含protocol，domain，path，query，hash等常用属性
// parseUrl(“http://www.alibole.com/test/list?id=123456&sort=discount#title”)

import java.util.HashMap;

public class Main{

    private static class UrlObject{
        String protocol;
        String domain;
        String path;
        HashMap<String, String> query;
        String anchor;

        public UrlObject() {
            query = new HashMap<>();
        }

        @Override
        public String toString() {
            return "UrlObject{" +
                    "protocol='" + protocol + '\'' +
                    ", domain='" + domain + '\'' +
                    ", path='" + path + '\'' +
                    ", query=" + query +
                    ", anchor='" + anchor + '\'' +
                    '}';
        }
    }

    private static UrlObject parseUrl(String url){
        String[] elems = url.split(":");
        UrlObject urlObject = new UrlObject();
        urlObject.protocol = elems[0];
        elems = elems[1].split("\\?");
        // 解析域名和路由
        String domainAndPath = elems[0].substring(2);
        String[] domainAndPaths = domainAndPath.split("/");
        urlObject.domain = domainAndPaths[0];
        StringBuilder pathBuilder = new StringBuilder();
        for (int i = 1; i < domainAndPaths.length; i++){
            pathBuilder.append("/").append(domainAndPaths[i]);
        }
        urlObject.path = pathBuilder.toString();
        // 解析query
        String queries = elems[1].split("#")[0];
        for (String query : queries.split("&")){
            urlObject.query.put(query.split("=")[0], query.split("=")[1]);
        }
        // 解析anchor锚点
        urlObject.anchor = elems[1].split("#")[1];
        return urlObject;
    }

    public static void main(String[] args){
        System.out.println(parseUrl("http://www.alibole.com/test/list?id=123456&sort=discount#title"));
    }

}