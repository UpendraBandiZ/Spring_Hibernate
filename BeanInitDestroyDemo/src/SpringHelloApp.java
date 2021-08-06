import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHelloApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach baseBallCoach1=context.getBean("myBaseBallCoach",Coach.class);
        System.out.println(baseBallCoach1.getDailyWorkOut());
        Coach trackCoach1=context.getBean("myTrackCoach",Coach.class);
        System.out.println(trackCoach1.getDailyWorkOut());
        context.close();
    }
}
