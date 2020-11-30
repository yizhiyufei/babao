import com.babao.BabaoApplication;
import com.babao.system.domain.enums.LevelEnum;
import com.babao.system.domain.enums.QuestionEnum;
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
        Question q = new Question();
                q.setQuName("测试是否莫仍");
                q.setQuLevel(LevelEnum.FIRST_LEVEL);
                q.setQuType(QuestionEnum.SINGLE);
                q.setCourseId(2);

//        q.setCreateBy(1);
////        q.setUpdateBy(1);
        boolean row = questionService.add(q);
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
