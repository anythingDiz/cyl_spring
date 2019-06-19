package ioc;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;


/**
 * @Description spring提供的Resource类的测试
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/6/18
 */
public class ResourceTest {

    /**
     * 测试Resource的子类 classPathResource
     */
    @Test
    public void testClassPathResource() throws IOException {
        //使用ClassPathResource 加载文件
        Resource resource = new ClassPathResource("resources_test.txt");

        InputStream in = resource.getInputStream();
        byte[] buf = new byte[1024];
        int read = in.read(buf);

        StringBuffer sb = new StringBuffer();
        while (read != -1){

            String res = new String(buf,"UTF-8");
            sb.append(res);

            read = in.read(buf);
        }

        System.out.println(sb.toString());

        in.close();
    }


    /**
     * 测试ResourcePatternResolver
     */
    @Test
    public void testPatternResolver() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        Resource[] resources = resolver.getResources("classpath:resources_test.txt");
        if (resources != null){
            for (Resource resource : resources) {
                System.out.println(resource.getDescription());
            }
        }
    }


}
