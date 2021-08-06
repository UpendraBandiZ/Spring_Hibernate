public class BaseBallCoach  implements Coach {
    @Override
    public String getDailyWorkOut() {
        return " base ball";
    }
    public void initMethod(){
        System.out.println("base ball coach init methhod");
    }
    public  void destroyMethod(){
        System.out.println("base ball destory method");
    }

}
