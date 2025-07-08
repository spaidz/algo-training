public class cat implements Animal
{
    @Override
    public void talk()
    {
        System.out.println("Meow");
    }

    @Override
    public void walk()
    {
        System.out.println("i walk on 4 paws");
    }

    @Override
    public void eat()
    {
        System.out.println("i eat meat");
    }

    public boolean wag()
    {
        System.out.println("i have a tail");
        return false;
    }
}
