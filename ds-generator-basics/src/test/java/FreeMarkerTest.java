import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerTest {
    @Test
    public void test() throws IOException, TemplateException {
        // 新建Configuration对象，参数为版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        configuration.setNumberFormat("0.######");
        // 设置模板使用字符集
        configuration.setDefaultEncoding("utf-8");
        // 创建模板对象，加载指定模板
        Template template = configuration.getTemplate("myweb.html.ftl");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2023);

        ArrayList<Map<String, Object>> menuItems = new ArrayList<>();
        Map<String, Object> menuItems1 = new HashMap<>();
        menuItems1.put("url", "https://codefather.com");
        menuItems1.put("label", "编程导航");

        Map<String, Object> menuItems2 = new HashMap<>();
        menuItems2.put("url", "https://laoyujianli.com");
        menuItems2.put("label", "老鱼简历");

        menuItems.add(menuItems1);
        menuItems.add(menuItems2);
        dataModel.put("menuItems", menuItems);

        // 指定生成的文件路径跟名称
        FileWriter out = new FileWriter("myweb.html");

        // 生成文件
        template.process(dataModel, out);
        out.close();
    }
}
