package umbcs680.observer;

public class FamilyMember implements Observer<String>{

    private final String name;
    private String lastMessage;

    public FamilyMember(String name){
        this.name = name;
    }

    public String getLastMessage(){

        return lastMessage;
    }

     @Override
     public void update(Observable<String> sender,String event) {

        this.lastMessage= event;
        System.out.println(name + " is notified: " + event);

    }



}

