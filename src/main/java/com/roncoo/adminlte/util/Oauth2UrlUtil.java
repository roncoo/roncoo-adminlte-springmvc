package com.roncoo.adminlte.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 类功能说明：读取授权登录配置<br/>
 * 类修改者：<br/>
 * 修改日期：<br/>
 * 修改说明：<br/>
 * 公司名称：广州市领课科技有限公司 <br/>
 * 作者：roncoo-lrx <br/>
 * 创建时间：2016年8月25日 下午3:19:28 <br/>
 * 版本：V1.0 <br/>
 */
public class Oauth2UrlUtil {

	private static final Log LOG = LogFactory.getLog(Oauth2UrlUtil.class);

    /**
     * 通过静态代码块读取上传文件的验证格式配置文件,静态代码块只执行一次(单例)
     */
    private static Properties properties = new Properties();

    private Oauth2UrlUtil() {
    }

    // 通过类装载器装载进来
    static {
        try {
            // 从类路径下读取属性文件
            properties.load(Oauth2UrlUtil.class.getClassLoader().getResourceAsStream("oauth2_url.properties"));
        } catch (IOException e) {
            LOG.error(e);
        }
    }

    /**
     * 函数功能说明 ： 读取Url路径<br/>
     * 修改者名字： <br/>
     * 修改日期： <br/>
     * 修改内容：<br/>
     * 作者：roncoo-lrx <br/>
     * 参数：@param key
     * 参数：@return <br/>
     * return：String <br/>
     */
    public static String readUrl(String key) {
        return (String) properties.get(key);
    }
}
