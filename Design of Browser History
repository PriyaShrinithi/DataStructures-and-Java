class BrowserHistory 
{
    List <String> browse = new ArrayList<>();
    int length = 0;
    int rank = 0;
    public BrowserHistory(String homepage) 
    {
        browse.add(homepage);
    }
    
    public void visit(String url) 
    {
        while(rank-length<0)
        {
            browse.remove(length--);
        }
        browse.add(++length, url);
        rank = length;
    }
    
    public String back(int steps)
    {
        rank = rank - steps < 0 ? 0: rank - steps; 
        return browse.get(rank);
    }
    
    public String forward(int steps)
    {
        rank = rank + steps > length ? length: rank+steps;
        return browse.get(rank);    
    }
}
