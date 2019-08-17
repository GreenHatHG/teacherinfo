package team.weacsoft.teacherinfo.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
public class SwaggerTest extends Junit5Factory{

    private final static Logger logger = LoggerFactory.getLogger(SwaggerTest.class);

    @Test
    public void createSwaggerJson() throws Exception {
        logger.info("------ 获取用于生成自动文档的swagger.json文件 ------");
        String swaggerJson = this.mockMvc
                                .perform(get("/v2/api-docs")
                                .accept(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                                .andReturn()
                                .getResponse()
                                .getContentAsString();

        //对应pom.xml中 <systemPropertyVariables> 设置的属性值
        //String outputDir = System.getProperty("io.springfox.staticdocs.outputDir");
        String outputDir = "target/swagger";
        Files.createDirectories(Paths.get(outputDir));

        try (BufferedWriter writer  = Files.newBufferedWriter(Paths.get(outputDir, "swagger.json")
                                                                            , StandardCharsets.UTF_8)) {
            writer.write(swaggerJson);
        }
    }
}