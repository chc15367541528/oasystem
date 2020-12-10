package com.hunguigu.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDW+zvXBIVnnNfBBc+Af2BmCt0X7ACjP8EjG8sQd+SD3zc0SttORPV8Vrtap7CN2/ytddJ4mLfzIKqDvnJAQ/MVKN2i3A+4MGL3BxL7I19ZMvve/X8qArv0kT4TZLqAdYbfaVLoPlEcW5ePaNqdqKp2R39crh4lp/UgVIz1e2gB6+emmgq7qWqb/CnCdMtIC1QKsi5PcU+m/U0INvhEb1oExwcaGCv5zCOIdhhuifiIuBQ/lKowqRAKMo/gsQBR55tG5Ga6v+Ej4t1/iE0Lc8lGG89YOgA0lAyU6FPGtNa06/0AJYdtHDW0eA9w/WYgfzkWMmQabbvQInwVyDfD9c6PAgMBAAECggEBAKDgQwiFzpsZ6O7+PSjIqUfTa15icpu3sv1l6BD711rD6JjOR80Ll7UjZnLRuDKAZFceK5Gpn0ZmtJOAKhljf/3epfUgvvaz5us7NP4Qm2Kx34AgrU+v2h2LrytuHo7Q5Ew9khhPwfz5obJk4exHcsCugmXFurOtO6ek/hMZ9VwxYBDmFRWuAzlQshUmgxLStv2a8ly5SR/3FHjOTn+IYh3cC2SYks8SvuG330oM/7L1wcn0Q5QdBN2ym8SIzgoLXkAl3kE157G+QgZbQmT/jjdXwkYQ7E97NrPCol1LschyoRV1HfOBrODE4Ysfae4ccgxwFZ8Nrrj99icWgzwBsrECgYEA/DkEth81jjH07ZU4mmGFhw5hdgM6tU15IjJ9g7Z3kivWQtoYEOPr+zVIgN3D4r9b6S4Y7ib9R0szNfVBGKFiNPKvXRJZ4917g6KULo/qAIbdplngYMy3oK2Hr0nlEgQz6NVSaUGh6thDpXfoyeGwG1PqtIL0oOK09dnBOpgFG2cCgYEA2jNwH4KfvB3sIu3GCYZjgcPaFP1GQhsVyOufhBcAZoq1eOsL6+uSEWLe1CyeLMvPnkdGM5phI7sHIbdW5g/MR4IFjiovdRw8z1rV3vnO3lj5d9dYjPYvL/q52EumcnXYxgUCt1BBAH1kPgrNZRQft02ampYH4Z1TIw+o6gBdYpkCgYBYyzn9Y79W7/9qJL5omyyG/2kQQtLIQR4EDAJj/DjcHNKxdlZCm/rX1UpRE8GCchvJW5ErRk6karT8qfrg0O/h9A4Ilg1PSwnQrcu9GK0owlIF3l4/tdJvnqfF7h3W2ePsdC0vIQv/wWMPPceWSv3UoRZftjqo6ScL5j1Ag4RIwQKBgQDUBKct9v6/C1QnnGKRXsPRkzyUqIVcNnU0hb652p/JA37Rv5IV6xBDVI6wG6qWXHOgmCDeg2NgFJsZZ8xIP5F+6hf7y4HRiV6NHPYzcwhPhKTijZy9W3j+ZeGvCdLx5RB9WOEKvjBrCWwd3OE3Fha7ReyzyJRf5T6jEtROi4wyAQKBgQDXYchlZMZH5fmgYHrIw1jy09/XtzO1EBdeCJGom8xafkY6bOTPgkSVbU0Kn00ndqn5nSe0X4oXifJINy+0RStvANgEG1wQJ+DlzRDgTckirGkEP+R0XxVfc8SzOQwzSz832AOOttF4XKRgGS+GgHFM6KzxkVf+q55WfdN/+X3fDQ==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy1u1OIOFySPp+VHduR8vDdAWYNSWnGLkLzzAngNGalPuN0pcJabPNm5hGOXjODxQg1mjPPRXvMoR3qtlK+bsXQ8lnME70jvYH40h+/0HNK3OmHFFRev1YjOOiILH7kZiBeM+F0EygJF0rqNyFTaFVsP8C6Q0UBqGWypJ4Gwr5in1Hzy5BxUev8O2B+QE+pE9oktL+tsdPHnLb5JkPujPEjXzxkSct5dAIPNFOpBwVqQTgX42vW51Jf9pTOeYVwqkuk4JsOoLr61qIw8JmUWQCfTKlKueuORFnidh53Rj3u5BTswn3o3/d/EOGTW3wqtHvGG9uO2PlVvDF2hR5DxU0QIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/oasystem_web_war_exploded/main.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

