public class human implements Animal
{

    @Override
    public void talk()
    {
        System.out.println("hello world");
    }

    @Override
    public void walk()
    {
        System.out.println("im walking on 2 legs");
    }

    @Override
    public void eat()
    {
        System.out.println("i eat anything");
    }

    public void work()
    {
        System.out.println("i have to do a job");
    }

}
