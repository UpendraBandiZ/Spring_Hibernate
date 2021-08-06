public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkOut() {
        return "track coach";
    }

        public void initMethod(){
            System.out.println("track ball coach init methhod");
        }
    public  void destroyMethod(){
        System.out.println("base ball destory method");
    }


}
