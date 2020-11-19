import com.babao.BabaoApplication;
import com.babao.system.domain.enums.QuestionEnum;
import com.babao.system.domain.pojo.Answer;
import com.babao.system.domain.pojo.Question;
import com.babao.system.service.impl.QuestionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName : QuestionTest
 * @Author : Administrator
 * @Date: 2020/11/4 1:04
 * @Description : 题目测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BabaoApplication.class)
public class QuestionTest {

    @Autowired
    QuestionService questionService;
    @Test
    public void insert(){
//        Question q = new Question();
        Question q = Question.builder()
                .quName("JVM核心技术")
                .quLevel(1)
                .quType(QuestionEnum.SINGLE)
                .courseId(2)
                .build();

        q.setCreateBy(1);
        q.setUpdateBy(1);
        boolean row = questionService.add(q);
        System.out.println("答案是:"+q.getAnswer().toString());
        Assert.assertTrue(row);
    }

    @Test
    public void selectAll(){
        List<Question> list = questionService.getAll();
        list.forEach((q)->{
                System.out.println(q.toString());
        });
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void del(){
        boolean flag = questionService.del(1);
        Assert.assertTrue(flag);
    }
}
